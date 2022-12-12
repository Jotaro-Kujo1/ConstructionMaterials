package com.vmlebedev.lab3.dao;

import com.vmlebedev.lab3.models.Concrete;
import com.vmlebedev.lab3.models.Metal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetalRepository extends CrudRepository<Metal, String> {
    Metal findAllByName(String name);
}
