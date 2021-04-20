package com.mywebapp.pizza.controller;

import com.mywebapp.pizza.model.dto.OrderDto;
import com.mywebapp.pizza.service.impl.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> orderAdd(@RequestBody OrderDto orderDto) {
        orderService.create(orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<?> order() {
        return new ResponseEntity<>(orderService.get(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(name = "id") Long id) {
        orderService.delete(
                OrderDto.builder()
                .id(id)
                .build()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody OrderDto orderDto) {
        orderService.update(orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
