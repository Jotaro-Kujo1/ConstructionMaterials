package com.vmlebedev.lab3.services;

import com.vmlebedev.lab3.dao.ConcreteRepository;
import com.vmlebedev.lab3.models.Concrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcreteService {

    private final ConcreteRepository repository;

    @Autowired
    public ConcreteService(ConcreteRepository repository) {
        this.repository = repository;
    }

    public Concrete saveConcrete(Concrete concrete) {
        return repository.save(concrete);
    }

    public void deleteConcreteByName(String name) {
        repository.deleteByName(name);
    }

    public List<Concrete> findAll() {
        return (List<Concrete>) repository.findAll();
    }

    public Concrete findByName(String name) {
        return repository.findAllByName(name);
    }

    public List<Concrete> ascByNameSort() {
        return findAll().stream()
                .sorted((o1,o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
    }
}
