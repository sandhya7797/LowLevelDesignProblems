package Repositories;

import Models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    private Map<Integer, Gate> map = new HashMap<>();

    public Optional<Gate> getGateById(int gateNum) {

        if(map.containsKey(gateNum)) {
            return Optional.of(map.get(gateNum));
        }
        return Optional.empty();
    }

    public void save(Gate gate) {
        map.put(gate.getGateNum(), gate);
    }
}
