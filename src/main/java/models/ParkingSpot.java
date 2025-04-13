package models;

import models.Enums.ParkingFloorStatus;
import models.Enums.ParkingSpotStatus;
import models.Enums.VehicleType;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private int parkingSpotNumber;
    private ParkingFloorStatus parkingSpotStatus;
    private List<VehicleType> supportedVehicleTypes;

    public ParkingSpot(int number){
        this.parkingSpotNumber=number;
        this.parkingSpotStatus= ParkingFloorStatus.AVAILABLE;
        supportedVehicleTypes.add(VehicleType.CYCLE);
        supportedVehicleTypes.add(VehicleType.SMALL);
        supportedVehicleTypes.add(VehicleType.MEDIUM);
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }
}
