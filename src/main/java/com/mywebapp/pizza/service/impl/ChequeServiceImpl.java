package com.mywebapp.pizza.service.impl;

import com.mywebapp.pizza.model.Cheque;
import com.mywebapp.pizza.model.ChequePK;
import com.mywebapp.pizza.repository.ChequeRepository;
import com.mywebapp.pizza.service.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChequeServiceImpl implements ServiceCrud<Cheque> {
    private final ChequeRepository chequeRepository;
    @Override
    public void create(Cheque model) {

    }

    @Override
    public void delete(Cheque model) {

    }

    @Override
    public List<Cheque> get() {
        return chequeRepository.findAll();
    }

    @Override
    public void read(Cheque model) {

    }

    @Override
    public void update(Cheque m) {

    }
    public List<Cheque> findAllByOrderId(Cheque cheque) {
       return chequeRepository.findAllByChequeIdOrderId(cheque.getChequeId().getOrderId());
    }
}
