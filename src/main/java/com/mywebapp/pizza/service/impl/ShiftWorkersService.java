package com.mywebapp.pizza.service.impl;

import com.mywebapp.pizza.model.ShiftWorkers;
import com.mywebapp.pizza.repository.ShiftWorkersRepository;
import com.mywebapp.pizza.service.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftWorkersService implements ServiceCrud<ShiftWorkers> {
    private final ShiftWorkersRepository shiftWorkersRepository;

    @Override
    public void create(ShiftWorkers model) {
        shiftWorkersRepository.save(model);
    }

    @Override
    public void delete(ShiftWorkers model) {
        shiftWorkersRepository.delete(model);
    }

    @Override
    public List<ShiftWorkers> get() {
        return shiftWorkersRepository.findAll();
    }

    @Override
    public void read(ShiftWorkers model) {

    }

    @Override
    public void update(ShiftWorkers model) {
        shiftWorkersRepository.save(model);
    }
}
