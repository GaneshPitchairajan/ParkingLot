package services;

import dtos.CreateGateRequestDto;
import models.Gate;
import models.Operator;
import repositories.GateRepository;

public class GateService {
    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate createGate(CreateGateRequestDto createGateRequestDto) {
        Gate gate = new Gate();
        gate.setGateNumber(createGateRequestDto.getGateNumber());
        gate.setGateType(createGateRequestDto.getGateType());
        gate.setGateStatus(createGateRequestDto.getGateStatus());
        gate.setOperator(new Operator());
        gate.setId(0L);
        return gateRepository.save(gate);
    }
}
