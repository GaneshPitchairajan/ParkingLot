package repositories;

import models.Enums.VehicleType;
import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;

import java.util.*;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap;

    //for our understanding we need to enter list of parking lot like below parking lot
    //Example Design of the parking lot
    // 1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
    //ENTRY                                    EXIT
    // 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
    public ParkingLotRepository(){
        parkingLotMap=new HashMap<>();
        // need to add a parking lot in this map
        ParkingLot lot1=new ParkingLot();
        lot1.setAddress("X street, Y city");
        List<Gate> gates=new ArrayList<>();
        lot1.setGates(gates);
        List<ParkingFloor> floors=new ArrayList<ParkingFloor>();
        floors.add(new ParkingFloor());
        lot1.setParkingFloors(floors);
        List<VehicleType> supportedVehicle=new ArrayList<>();
        supportedVehicle.add(VehicleType.CYCLE);
        supportedVehicle.add(VehicleType.SMALL);
        supportedVehicle.add(VehicleType.MEDIUM);
        lot1.setSupportedVehicles(supportedVehicle);
        lot1.setCreatedAt(new Date());
        lot1.setUpdatedAt(new Date());
        lot1.setId(1L);
        lot1.getFeeCalculationStrategyType(Fee);
        parkingLotMap.put(1L,lot1);
    }

    public Optional<ParkingLot> findParkingLotByGateId(Long gateId) {
        return null;
    }
}