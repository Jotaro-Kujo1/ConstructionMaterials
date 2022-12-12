package com.vmlebedev.lab3.services;

import com.vmlebedev.lab3.dao.ConcreteRepository;
import com.vmlebedev.lab3.dao.MetalRepository;
import com.vmlebedev.lab3.models.Concrete;
import com.vmlebedev.lab3.models.Metal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetalService {
    private final MetalRepository repository;

    @Autowired
    public MetalService(MetalRepository repository) {
        this.repository = repository;
    }

    public Metal saveMetal(Metal metal) {
        return repository.save(metal);
    }

    public void deleteMetal(Metal metal) {
        repository.delete(metal);
    }

    public List<Metal> findAll() {
        return (List<Metal>) repository.findAll();
    }

    public Metal findByName(String name) {
        return repository.findAllByName(name);
    }

    public List<Metal> ascByNameSort() {
        return findAll().stream()
                .sorted((o1,o2) -> o2.getName().compareTo(o1.getName()))
                .collect(Collectors.toList());
    }
}
