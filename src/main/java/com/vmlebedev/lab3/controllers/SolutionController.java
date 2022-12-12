package com.vmlebedev.lab3.controllers;

import com.vmlebedev.lab3.models.Metal;
import com.vmlebedev.lab3.models.Natural;
import com.vmlebedev.lab3.models.Solution;
import com.vmlebedev.lab3.services.NaturalService;
import com.vmlebedev.lab3.services.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/solution")
@CrossOrigin
public class SolutionController {

    private final SolutionService service;

    @Autowired
    public SolutionController(SolutionService service) {
        this.service = service;
    }

    @PostMapping(value = "/saveSolution")
    public ResponseEntity<?> saveSolution(@RequestBody Solution solution){
        Solution newSolution = service.saveSolution(solution);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(newSolution.getId())
                .buildAndExpand(newSolution.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/deleteSolution")
    public ResponseEntity<Metal> deleteSolution(@RequestBody Solution solution){
        service.deleteSolution(solution);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/getSolution")
    public ResponseEntity<Solution> getSolution(@RequestParam String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Iterable<Solution>> getAllSolutions() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/getAllSort")
    public ResponseEntity<Iterable<Solution>> getAllSolutionsSort() {
        return ResponseEntity.ok(service.ascByNameSort());
    }
}
