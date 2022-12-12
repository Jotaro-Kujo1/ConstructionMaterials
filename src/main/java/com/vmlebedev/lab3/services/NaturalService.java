package com.vmlebedev.lab3.services;

import com.vmlebedev.lab3.dao.NaturalRepository;
import com.vmlebedev.lab3.models.Metal;
import com.vmlebedev.lab3.models.Natural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NaturalService {

    private final NaturalRepository repository;

    @Autowired
    public NaturalService(NaturalRepository repository) {
        this.repository = repository;
    }

    public Natural saveNatural(Natural natural) {
        return repository.save(natural);
    }

    public void deleteNatural(Natural natural) {
        repository.delete(natural);
    }

    public List<Natural> findAll() {
        return (List<Natural>) repository.findAll();
    }

    public Natural findByName(String name) {
        return repository.findAllByName(name);
    }

    public List<Natural> ascByNameSort() {
        return findAll().stream()
                .sorted((o1,o2) -> o2.getName().compareTo(o1.getName()))
                .collect(Collectors.toList());
    }
}
