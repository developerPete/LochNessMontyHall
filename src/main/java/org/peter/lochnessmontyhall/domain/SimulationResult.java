package org.peter.lochnessmontyhall.domain;

public class SimulationResult {

    private int staySuccessCount = 0;
    private int switchSuccessCount = 0;
    private int roundsCount;

    public SimulationResult() {}

    public SimulationResult(int roundsCount) {
        this.roundsCount = roundsCount;
    }

    public void incrementStaySuccessCount() {
        staySuccessCount++;
    }

    public void incrementSwitchSuccessCount() {
        switchSuccessCount++;
    }

    public int getStaySuccessCount() {
        return staySuccessCount;
    }

    public int getSwitchSuccessCount() {
        return switchSuccessCount;
    }

    public int getRoundsCount() {
        return roundsCount;
    }

    @Override
    public String toString() {
        return "SimulationResult{" +
                "staySuccessCount=" + staySuccessCount +
                ", switchSuccessCount=" + switchSuccessCount +
                ", roundsCount=" + roundsCount +
                '}';
    }
}
