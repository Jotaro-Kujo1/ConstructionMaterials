package com.vmlebedev.lab3.controllers;

import com.vmlebedev.lab3.models.Concrete;
import com.vmlebedev.lab3.models.Metal;
import com.vmlebedev.lab3.services.ConcreteService;
import com.vmlebedev.lab3.services.MetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/metal")
@CrossOrigin
public class MetalController {

    private final MetalService service;

    @Autowired
    public MetalController(MetalService service) {
        this.service = service;
    }

    @PostMapping(value = "/saveMetal")
    public ResponseEntity<?> saveMetal(@RequestBody Metal metal){
        Metal newMetal = service.saveMetal(metal);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(newMetal.getId())
                .buildAndExpand(newMetal.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/deleteMetal/{name}")
    public ResponseEntity<Metal> deleteMetal(@PathVariable String name){
        service.deleteMetalByName(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/getMetal/{name}")
    public ResponseEntity<Metal> getMetal(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Iterable<Metal>> getAllMetals() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/getAllSort")
    public ResponseEntity<Iterable<Metal>> getAllMetalsSort() {
        return ResponseEntity.ok(service.ascByNameSort());
    }
}
