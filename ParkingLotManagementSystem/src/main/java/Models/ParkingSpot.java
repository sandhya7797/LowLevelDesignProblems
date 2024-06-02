package Models;

import Enums.ParkingSlotStatusType;
import Enums.VehicleType;

public class ParkingSpot extends BaseModel {
    private int slotNum;
    private ParkingSlotStatusType parkingSlotStatusType;
    private VehicleType vechicleType;
    private ParkingFloor floor;

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }

    public ParkingSlotStatusType getParkingSlotStatusType() {
        return parkingSlotStatusType;
    }

    public void setParkingSlotStatusType(ParkingSlotStatusType parkingSlotStatusType) {
        this.parkingSlotStatusType = parkingSlotStatusType;
    }

    public VehicleType getVechicleType() {
        return vechicleType;
    }

    public void setVechicleType(VehicleType vechicleType) {
        this.vechicleType = vechicleType;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }
}
