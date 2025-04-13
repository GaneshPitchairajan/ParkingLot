package repositories;

import models.Enums.GateStatus;
import models.Enums.GateType;
import models.Gate;
import models.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Date;

public class GateRepository {
    private Map<Long, Gate> gateMap;
    private Long id;

    public GateRepository() {
        gateMap = new HashMap<>();
        id = 0L;

        Gate gate1 =new Gate() ;
        gate1.setGateNumber(1);
        gate1.setGateType(GateType.ENTRY);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setOperator(new Operator());
        gate1.setId(1L);
        this.save(gate1);

        Gate gate2 =new Gate() ;
        gate1.setGateNumber(2);
        gate1.setGateType(GateType.EXIT);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setOperator(new Operator());
        gate1.setId(2L);
        this.save(gate1);

    }

    public Gate save(Gate gate) {
        // Update + insert => Upsert
        if(gate.getId() == 0){
            // insert
            id = id + 1;
            gate.setId(id);
            gate.setCreatedAt(new Date());
            gate.setUpdatedAt(new Date());
            gateMap.put(id, gate);
            return gate;
        }
        gate.setUpdatedAt(new Date());
        gateMap.put(gate.getId(), gate);
        return gate;
    }

    public Optional<Gate> findById(Long gateID){
        if(gateMap.containsKey(gateID)){
            return Optional.of(gateMap.get(gateID));
        }
        return Optional.empty();
    }
}

// Gate Object ->
// Gate status -> open, Operator -> {}, gateType -> entry, gate number -> 1
// 1 -> Gate1
// 2 -> Gate2
// 3 -> Gate3