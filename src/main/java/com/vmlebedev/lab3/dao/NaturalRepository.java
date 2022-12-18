package com.vmlebedev.lab3.dao;

import com.vmlebedev.lab3.models.Metal;
import com.vmlebedev.lab3.models.Natural;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface NaturalRepository extends CrudRepository<Natural, String> {
    Natural findAllByName(String name);
    @Transactional
    void deleteByName(String name);
}
