package com.vmlebedev.lab3.services;

import com.vmlebedev.lab3.dao.SolutionRepository;
import com.vmlebedev.lab3.dao.ThermalInsulationRepository;
import com.vmlebedev.lab3.models.Solution;
import com.vmlebedev.lab3.models.ThermalInsulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThermalInsulationService {

    private final ThermalInsulationRepository repository;

    @Autowired
    public ThermalInsulationService(ThermalInsulationRepository repository) {
        this.repository = repository;
    }

    public ThermalInsulation saveThermalInsulation(ThermalInsulation thermalInsulation) {
        return repository.save(thermalInsulation);
    }

    public void deleteThermalInsulation(ThermalInsulation thermalInsulation) {
        repository.delete(thermalInsulation);
    }

    public List<ThermalInsulation> findAll() {
        return (List<ThermalInsulation>) repository.findAll();
    }

    public ThermalInsulation findByName(String name) {
        return repository.findAllByName(name);
    }

    public List<ThermalInsulation> ascByNameSort() {
        return findAll().stream()
                .sorted((o1,o2) -> o2.getName().compareTo(o1.getName()))
                .collect(Collectors.toList());
    }
}
