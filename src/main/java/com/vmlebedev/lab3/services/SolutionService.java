package com.vmlebedev.lab3.services;

import com.vmlebedev.lab3.dao.NaturalRepository;
import com.vmlebedev.lab3.dao.SolutionRepository;
import com.vmlebedev.lab3.models.Natural;
import com.vmlebedev.lab3.models.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolutionService {

    private final SolutionRepository repository;

    @Autowired
    public SolutionService(SolutionRepository repository) {
        this.repository = repository;
    }

    public Solution saveSolution(Solution solution) {
        return repository.save(solution);
    }

    public void deleteSolution(Solution solution) {
        repository.delete(solution);
    }

    public List<Solution> findAll() {
        return (List<Solution>) repository.findAll();
    }

    public Solution findByName(String name) {
        return repository.findAllByName(name);
    }

    public List<Solution> ascByNameSort() {
        return findAll().stream()
                .sorted((o1,o2) -> o2.getName().compareTo(o1.getName()))
                .collect(Collectors.toList());
    }
}
