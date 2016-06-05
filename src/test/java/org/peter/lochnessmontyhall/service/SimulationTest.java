package org.peter.lochnessmontyhall.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.peter.lochnessmontyhall.domain.Lake;
import org.peter.lochnessmontyhall.domain.SimulationResult;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SimulationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testSetupAndRunSimulation100rounds() {
        SimulationResult result = Simulation.setupAndRunSimulation(100);
        assertEquals(100, result.getRoundsCount());
        assertEquals(100, result.getStaySuccessCount() + result.getSwitchSuccessCount());
    }

    @Test
    public void testSetupAndRunSimulation1round() {
        SimulationResult result = Simulation.setupAndRunSimulation(1);
        assertEquals(1, result.getRoundsCount());
        assertEquals(1, result.getStaySuccessCount() + result.getSwitchSuccessCount());
    }

    @Test
    public void testSetupAndRunSimulation0rounds() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Number of rounds must be greater than zero.");
        Simulation.setupAndRunSimulation(0);
    }

    @Test
    public void testChooseOtherLakeWithThreeLakes() {
        Lake lake1 = new Lake(1);
        Lake lake2 = new Lake(2);
        Lake lake3 = new Lake(3);
        List<Lake> lakes = Arrays.asList(lake1, lake2, lake3);
        Lake chosenLake = Simulation.chooseOtherLake(lakes, lake1, lake2);
        assertEquals(lake3, chosenLake);
    }

    @Test
    public void testChooseOtherLakeWithFiveLakes() {
        Lake lake1 = new Lake(1);
        Lake lake2 = new Lake(2);
        Lake lake3 = new Lake(3);
        Lake lake4 = new Lake(4);
        Lake lake5 = new Lake(5);
        List<Lake> lakes = Arrays.asList(lake1, lake2, lake3, lake4, lake5);
        Lake chosenLake = Simulation.chooseOtherLake(lakes, lake5, lake2);
        assertTrue(chosenLake.equals(lake1) || chosenLake.equals(lake3) || chosenLake.equals(lake4));
    }

    @Test
    public void testChooseOtherLakeWithTwoLakes() {
        Lake lake1 = new Lake(1);
        Lake lake2 = new Lake(2);
        List<Lake> lakes = Arrays.asList(lake1, lake2);
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("There must be at least three lakes.");
        Simulation.chooseOtherLake(lakes, lake1, lake2);

    }
}
