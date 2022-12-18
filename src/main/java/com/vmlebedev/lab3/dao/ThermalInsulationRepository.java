package com.vmlebedev.lab3.dao;

import com.vmlebedev.lab3.models.Solution;
import com.vmlebedev.lab3.models.ThermalInsulation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ThermalInsulationRepository extends CrudRepository<ThermalInsulation, String> {
    ThermalInsulation findAllByName(String name);
    @Transactional
    void deleteByName(String name);
}
