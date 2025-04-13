package models;

import models.Enums.ParkingFloorStatus;
import  java.util.List;

public class ParkingFloor extends BaseModel {
    private List<ParkingSpot> parkingSpots;
    private ParkingFloorStatus parkingFloorStatus;
    private int floorNumber;

    public ParkingFloor(ParkingFloorStatus floorStatus,int floornumber){
        this.floorNumber=floornumber;
        this.parkingFloorStatus=floorStatus;
        for(int i=0;i<20;i++) parkingSpots.add(new ParkingSpot(i+1));

    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
