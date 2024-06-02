package Repositories;

import Models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {

    private Map<Integer, Vehicle> map = new HashMap<>();

    public Optional<Vehicle> getVehicleByNum(long vehicleNum) {

        if(map.containsKey(vehicleNum)) {
            return Optional.of(map.get(vehicleNum));
        }

        return Optional.empty();
    }

    public void saveVehicle(Vehicle vehicle) {
        map.put(vehicle.getVehicleNum(), vehicle);

    }
}
