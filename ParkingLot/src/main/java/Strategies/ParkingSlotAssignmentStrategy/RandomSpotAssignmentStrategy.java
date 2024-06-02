package Strategies.ParkingSlotAssignmentStrategy;

import Enums.ParkingSlotAssignmentStrategyType;
import Enums.ParkingSlotStatusType;
import Models.ParkingSpot;
import Repositories.ParkingSpotRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {
    private Map<Integer, ParkingSpot> map = new HashMap<>();
    private ParkingSpotRepository parkingSpotRepository;

    public RandomSpotAssignmentStrategy(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpot getSpot(ParkingSlotAssignmentStrategyType type) {

        List<ParkingSpot> spots = parkingSpotRepository.getParkingSpots();

        for(ParkingSpot p : spots) {
            if(p.getParkingSlotStatusType().equals(ParkingSlotStatusType.EMPTY)) {
                return p;
            }
        }
        return null;
    }
}
