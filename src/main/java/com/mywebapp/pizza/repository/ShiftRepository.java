package com.mywebapp.pizza.repository;

import com.mywebapp.pizza.model.Shift;
import com.mywebapp.pizza.model.ShiftWorkers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift,Long> {
}
