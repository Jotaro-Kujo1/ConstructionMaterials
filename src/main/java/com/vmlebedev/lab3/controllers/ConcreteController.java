package com.vmlebedev.lab3.controllers;

import com.vmlebedev.lab3.models.Concrete;
import com.vmlebedev.lab3.services.ConcreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/concrete")
@CrossOrigin
public class ConcreteController {

    private final ConcreteService service;

    @Autowired
    public ConcreteController(ConcreteService service) {
        this.service = service;
    }

    @PostMapping(value = "/saveConcrete")
    public ResponseEntity<?> saveConcrete(@RequestBody Concrete concrete){
        Concrete newConcrete = service.saveConcrete(concrete);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(newConcrete.getId())
                .buildAndExpand(newConcrete.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/deleteConcrete/{name}")
    public ResponseEntity<Concrete> deleteConcrete(@PathVariable String name){
        service.deleteConcreteByName(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/getConcrete/{name}")
    public ResponseEntity<Concrete> getConcrete(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Iterable<Concrete>> getAllConcretes() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/getAllSort")
    public ResponseEntity<Iterable<Concrete>> getAllConcretesSort() {
        return ResponseEntity.ok(service.ascByNameSort());
    }
}
