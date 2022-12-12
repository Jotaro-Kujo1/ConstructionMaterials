package com.vmlebedev.lab3.controllers;

import com.vmlebedev.lab3.models.Metal;
import com.vmlebedev.lab3.models.Natural;
import com.vmlebedev.lab3.services.MetalService;
import com.vmlebedev.lab3.services.NaturalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/natural")
@CrossOrigin
public class NaturalController {

    private final NaturalService service;

    @Autowired
    public NaturalController(NaturalService service) {
        this.service = service;
    }

    @PostMapping(value = "/saveNatural")
    public ResponseEntity<?> saveNatural(@RequestBody Natural natural){
        Natural newNatural = service.saveNatural(natural);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(newNatural.getId())
                .buildAndExpand(newNatural.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/deleteNatural")
    public ResponseEntity<Metal> deleteNatural(@RequestBody Natural natural){
        service.deleteNatural(natural);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/getNatural")
    public ResponseEntity<Natural> getNatural(@RequestParam String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Iterable<Natural>> getAllNaturals() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/getAllSort")
    public ResponseEntity<Iterable<Natural>> getAllNaturalsSort() {
        return ResponseEntity.ok(service.ascByNameSort());
    }
}
