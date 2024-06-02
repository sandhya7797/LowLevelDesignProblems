package Repositories;

import Models.Gate;
import Models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Integer, ParkingLot> map = new HashMap<>();

    public ParkingLot getParkingLotByGate(int gateId) {
        for(ParkingLot pl : map.values()) {
            for(Gate gate : pl.getGates()) {
                if(gate.getGateNum()==gateId) {
                    return pl;
                }
            }
        }
        return null;
    }

    public void save(ParkingLot parkingLot) {
        map.put(parkingLot.getId(), parkingLot);
    }
}
