package strategies.spotAssignmentStrategy;

import models.Gate;
import models.ParkingSpot;
import models.Enums.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
