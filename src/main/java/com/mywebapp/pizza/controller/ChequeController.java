package com.mywebapp.pizza.controller;

import com.mywebapp.pizza.model.Cheque;
import com.mywebapp.pizza.model.ChequePK;
import com.mywebapp.pizza.model.Order;
import com.mywebapp.pizza.service.impl.ChequeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChequeController {
    private final ChequeServiceImpl chequeService;

    public ChequeController(ChequeServiceImpl chequeService) {
        this.chequeService = chequeService;
    }

    @GetMapping("/cheque/{id}")
    public ResponseEntity<?> getCheque(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(chequeService.findAllByOrderId(
                Cheque.builder()
                .chequeId(ChequePK
                .builder()
                .orderId(
                        Order.builder()
                        .id(id)
                        .build()
                )
                .build())
                .build()

        ), HttpStatus.OK);
    }
}
