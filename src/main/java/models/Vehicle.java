package models;

import models.Enums.VehicleType;

public class
Vehicle extends BaseModel {
    private String vehicleNumber;
    private String ownerName;
    private VehicleType vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Vehicle setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Vehicle setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }
}