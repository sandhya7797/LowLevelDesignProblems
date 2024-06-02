package DTOS;

import Enums.VehicleType;

public class IssueTicketRequestDTO {
    private int vehicleNum;
    private String ownerNameOfVehicle;
    private VehicleType vehicleType;
    private int gateNum;

    public IssueTicketRequestDTO(int vehicleNum, String ownerNameOfVehicle, VehicleType vehicleType, int gateNum) {
        this.vehicleNum = vehicleNum;
        this.ownerNameOfVehicle = ownerNameOfVehicle;
        this.vehicleType = vehicleType;
        this.gateNum = gateNum;
    }

    public int getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(int vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getOwnerNameOfVehicle() {
        return ownerNameOfVehicle;
    }

    public void setOwnerNameOfVehicle(String ownerNameOfVehicle) {
        this.ownerNameOfVehicle = ownerNameOfVehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getGateId() {
        return gateNum;
    }

    public void setGateId(int gateId) {
        this.gateNum = gateNum;
    }
}
