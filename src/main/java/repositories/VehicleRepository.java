package repositories;

import models.Vehicle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap;
    private Map<String, Vehicle> vehicleNumberVehicleMap;
    private Long id;

    public VehicleRepository(){
        this.id = 0L;
        this.vehicleMap = new HashMap<>();
        this.vehicleNumberVehicleMap = new HashMap<>();
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        if(vehicleNumberVehicleMap.containsKey(vehicleNumber)){
            return Optional.of(vehicleNumberVehicleMap.get(vehicleNumber));
        }
        return Optional.empty();
    }


    public Optional<Vehicle> findById(Long vehicleId){
        if(vehicleMap.containsKey(vehicleId)){
            return Optional.of(vehicleMap.get(vehicleId));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        // Update + insert => Upsert
        if(vehicle.getId() == null ){
            // insert
            this.id = id + 1L;
            vehicle.setId(id);
            vehicle.setCreatedAt(new Date());
            vehicle.setUpdatedAt(new Date());
            vehicleMap.put(id, vehicle);
            vehicleNumberVehicleMap.put(vehicle.getVehicleNumber(), vehicle);
            return vehicle;
        }
        vehicleMap.put(vehicle.getId(), vehicle);
        vehicleNumberVehicleMap.put(vehicle.getVehicleNumber(), vehicle);
        vehicle.setUpdatedAt(new Date());
        return vehicle;
    }
}

