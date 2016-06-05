package org.peter.lochnessmontyhall.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.peter.lochnessmontyhall.Application;
import org.peter.lochnessmontyhall.domain.SimulationResult;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class SimulationControllerTest {

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testSimulateWithDefault() {
        SimulationResult result =
                restTemplate.getForObject("http://localhost:8080/simulate", SimulationResult.class);
        assertNotNull(result);
        assertEquals(1, result.getRoundsCount());
        assertEquals(1, result.getStaySuccessCount() + result.getSwitchSuccessCount());
    }

    @Test
    public void testSimulateWith1000NumberOfRounds() {
        SimulationResult result =
                restTemplate.getForObject("http://localhost:8080/simulate?numberOfRounds=10000", SimulationResult.class);
        assertNotNull(result);
        assertEquals(10_000, result.getRoundsCount());
        assertEquals(10_000, result.getStaySuccessCount() + result.getSwitchSuccessCount());
    }

    @Test
    public void testSimulateWith0NumberOfRounds() {
        ResponseEntity<SimulationResult> response =
                restTemplate.getForEntity("http://localhost:8080/simulate?numberOfRounds=0", SimulationResult.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
