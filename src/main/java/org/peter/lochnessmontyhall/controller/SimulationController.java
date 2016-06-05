package org.peter.lochnessmontyhall.controller;

import org.peter.lochnessmontyhall.domain.SimulationResult;
import org.peter.lochnessmontyhall.service.Simulation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulationController {

    @RequestMapping("/simulate")
    public SimulationResult simulate(@RequestParam(value="numberOfRounds", defaultValue="1") int numberOfRounds) {
        return Simulation.setupAndRunSimulation(numberOfRounds);
    }
}
