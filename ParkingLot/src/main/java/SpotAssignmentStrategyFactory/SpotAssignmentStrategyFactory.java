package SpotAssignmentStrategyFactory;

import Enums.ParkingSlotAssignmentStrategyType;
import Repositories.ParkingSpotRepository;
import Strategies.ParkingSlotAssignmentStrategy.ParkingSpotAssignmentStrategy;
import Strategies.ParkingSlotAssignmentStrategy.RandomSpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    private static ParkingSpotRepository parkingSpotRepository;

    public SpotAssignmentStrategyFactory(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public static ParkingSpotAssignmentStrategy getSpot(ParkingSlotAssignmentStrategyType type) {
        switch(type) {
            case RANDOM :
                return new RandomSpotAssignmentStrategy(parkingSpotRepository);
        }
        return null;
    }
}
