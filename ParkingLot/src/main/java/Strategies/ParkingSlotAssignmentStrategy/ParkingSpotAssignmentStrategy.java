package Strategies.ParkingSlotAssignmentStrategy;

import Enums.ParkingSlotAssignmentStrategyType;
import Models.ParkingSpot;

public interface ParkingSpotAssignmentStrategy {
    ParkingSpot getSpot(ParkingSlotAssignmentStrategyType type);
}
