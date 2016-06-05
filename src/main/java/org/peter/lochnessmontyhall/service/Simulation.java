package org.peter.lochnessmontyhall.service;

import org.peter.lochnessmontyhall.domain.Lake;
import org.peter.lochnessmontyhall.domain.SimulationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Simulation {

    /**
     * NUMBER_OF_LAKES must be set to at least 3.
     */
    private static final int NUMBER_OF_LAKES = 3;
    private static final Random numberGenerator = new Random();

    private static List<Lake> setupLakes() {
        List<Lake> lakes = new ArrayList<>();
        for(int i=0; i<NUMBER_OF_LAKES; i++) {
            lakes.add(new Lake(i));
        }
        return lakes;
    }

    public static SimulationResult setupAndRunSimulation(int numberOfRounds) {
        if(numberOfRounds < 1) {
            throw new IllegalArgumentException("Number of rounds must be greater than zero.");
        }

        List<Lake> lakes = setupLakes();
        return simulate(lakes, numberOfRounds);
    }

    private static SimulationResult simulate(List<Lake> lakes, int numberOfRounds) {
        SimulationResult result = new SimulationResult(numberOfRounds);

        for(int i=0; i<numberOfRounds; i++) {
            Lake initialLakeChoice = lakes.get(numberGenerator.nextInt(lakes.size()));
            Lake lakeWithMonster = lakes.get(numberGenerator.nextInt(lakes.size()));

            if(!stayStrategy(initialLakeChoice, lakeWithMonster, result)) {
                switchStrategy(initialLakeChoice, lakeWithMonster, lakes, result);
            }
        }
        return result;
    }

    private static boolean stayStrategy(Lake initialLakeChoice, Lake lakeWithMonster, SimulationResult result) {
        if(initialLakeChoice.equals(lakeWithMonster)) {
            result.incrementStaySuccessCount();
            return true;
        }
        return false;
    }

    private static boolean switchStrategy(Lake initialLakeChoice, Lake lakeWithMonster, List<Lake> lakes, SimulationResult result) {
        Lake lakeWithoutMonster = chooseOtherLake(lakes, initialLakeChoice, lakeWithMonster);
        Lake secondChoice = chooseOtherLake(lakes, initialLakeChoice, lakeWithoutMonster);
        if(secondChoice.equals(lakeWithMonster)) {
            result.incrementSwitchSuccessCount();
            return true;
        }
        return false;
    }

    protected static Lake chooseOtherLake(List<Lake> lakes, Lake lake1, Lake lake2) {
        if(lakes.size() < 3) {
            throw new IllegalArgumentException("There must be at least three lakes.");
        }

        Predicate<Lake> otherLakesPredicate = n -> !(n.equals(lake1) || n.equals(lake2));
        List<Lake> filteredLakes = lakes.stream().filter(otherLakesPredicate).collect(Collectors.toList());
        return filteredLakes.get(numberGenerator.nextInt(filteredLakes.size()));
    }
}
