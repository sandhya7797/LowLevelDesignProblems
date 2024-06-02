package Models;

import Enums.FeeCalculationStrategyType;
import Enums.ParkingLotStatusType;
import Enums.ParkingSlotAssignmentStrategyType;
import Enums.VehicleType;

import java.util.List;

public class ParkingLot extends BaseModel {
    private ParkingFloor floor;
    private List<Gate> gates;
    private ParkingLotStatusType statusType;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType;
    private List<VehicleType> allowedVehicleTypes;

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(ParkingLotStatusType statusType) {
        this.statusType = statusType;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public ParkingSlotAssignmentStrategyType getParkingSlotAssignmentStrategyType() {
        return parkingSlotAssignmentStrategyType;
    }

    public void setParkingSlotAssignmentStrategyType(ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType) {
        this.parkingSlotAssignmentStrategyType = parkingSlotAssignmentStrategyType;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }
}
