package Models;

import Enums.ParkingFloorStatusType;

import java.util.List;

public class ParkingFloor {
    private int id;
    private int floorNum;
    private ParkingFloorStatusType parkingFloorStatusType;
    private List<ParkingSpot> parkingSlots;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public ParkingFloorStatusType getParkingFloorStatus() {
        return parkingFloorStatusType;
    }

    public void setParkingFloorStatus(ParkingFloorStatusType parkingFloorStatus) {
        this.parkingFloorStatusType = parkingFloorStatus;
    }

    public List<ParkingSpot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSpot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
