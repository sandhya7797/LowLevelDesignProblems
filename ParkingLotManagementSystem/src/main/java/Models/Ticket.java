package Models;

import Enums.VehicleType;

import java.util.Date;

public class Ticket extends BaseModel {
    private String num;
    private Date entryTime;
    private VehicleType vehicleType;
    private ParkingSpot assignedSpot;
    private Gate generatedAt;
    private Operator generatedBy;
    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    public ParkingSpot getAssignedSpot() {
        return assignedSpot;
    }

    public void setAssignedSpot(ParkingSpot assignedSpot) {
        this.assignedSpot = assignedSpot;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "num='" + num + '\'' +
                ", entryTime=" + entryTime +
                ", vehicleType=" + vehicleType +
                ", assignedSpot=" + assignedSpot +
                ", generatedAt=" + generatedAt +
                ", generatedBy=" + generatedBy +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
