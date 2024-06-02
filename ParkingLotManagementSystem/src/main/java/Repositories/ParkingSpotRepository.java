package Repositories;

import Models.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpotRepository {
    private Map<Integer, ParkingSpot> map = new HashMap<>();

    public List<ParkingSpot> getParkingSpots() {
        List<ParkingSpot> lis = new ArrayList<>();
        for(ParkingSpot ps : map.values()) {
            lis.add(ps);
        }
        return lis;
    }

    public void save(ParkingSpot parkingSpot) {
        map.put(parkingSpot.getSlotNum(),parkingSpot);
    }
}
