package controllers;

import dtos.CreateGateRequestDto;
import models.Gate;
import services.GateService;

public class GateController {
    private GateService gateService;

    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    public Gate addGate(CreateGateRequestDto createGateRequestDto) {
        return gateService.createGate(createGateRequestDto);
    }
}
