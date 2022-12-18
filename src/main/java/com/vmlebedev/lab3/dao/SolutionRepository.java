package com.vmlebedev.lab3.dao;

import com.vmlebedev.lab3.models.Natural;
import com.vmlebedev.lab3.models.Solution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SolutionRepository extends CrudRepository<Solution, String> {
    Solution findAllByName(String name);
    @Transactional
    void deleteByName(String name);
}
