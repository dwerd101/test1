package com.mywebapp.pizza.service.impl;

import com.mywebapp.pizza.model.Shift;
import com.mywebapp.pizza.repository.ShiftRepository;
import com.mywebapp.pizza.service.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftService implements ServiceCrud<Shift> {
    private final ShiftRepository shiftRepository;
    @Override
    public void create(Shift model) {
        shiftRepository.save(model);
    }

    @Override
    public void delete(Shift model) {

    }

    @Override
    public List<Shift> get() {
        return null;
    }

    @Override
    public void read(Shift model) {

    }

    @Override
    public void update(Shift model) {

    }
}
