package com.vmlebedev.lab3.controllers;

import com.vmlebedev.lab3.models.Metal;
import com.vmlebedev.lab3.models.Solution;
import com.vmlebedev.lab3.models.ThermalInsulation;
import com.vmlebedev.lab3.services.SolutionService;
import com.vmlebedev.lab3.services.ThermalInsulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/thermalInsulation")
@CrossOrigin
public class ThermalInsulationController {

    private final ThermalInsulationService service;

    @Autowired
    public ThermalInsulationController(ThermalInsulationService service) {
        this.service = service;
    }

    @PostMapping(value = "/saveThermalInsulation")
    public ResponseEntity<?> saveThermalInsulation(@RequestBody ThermalInsulation thermalInsulation){
        ThermalInsulation newThermalInsulation = service.saveThermalInsulation(thermalInsulation);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(newThermalInsulation.getId())
                .buildAndExpand(newThermalInsulation.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/deleteThermalInsulation/{name}")
    public ResponseEntity<Metal> deleteThermalInsulation(@PathVariable String name){
        service.deleteThermalInsulationByName(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/getThermalInsulation/{name}")
    public ResponseEntity<ThermalInsulation> getThermalInsulation(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Iterable<ThermalInsulation>> getAllThermalInsulations() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/getAllSort")
    public ResponseEntity<Iterable<ThermalInsulation>> getAllThermalInsulationsSort() {
        return ResponseEntity.ok(service.ascByNameSort());
    }
}
