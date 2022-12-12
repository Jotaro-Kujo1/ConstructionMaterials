package com.vmlebedev.lab3.dao;

import com.vmlebedev.lab3.models.Concrete;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcreteRepository extends CrudRepository<Concrete, String> {
    Concrete findAllByName(String name);

}
