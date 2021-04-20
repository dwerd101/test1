package com.mywebapp.pizza.service.impl;

import com.mywebapp.pizza.model.Employee;
import com.mywebapp.pizza.model.Order;
import com.mywebapp.pizza.model.dto.OrderDto;
import com.mywebapp.pizza.repository.OrderRepository;
import com.mywebapp.pizza.service.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService implements ServiceCrud<OrderDto> {
    private final OrderRepository orderRepository;

    @Override
    public void create(OrderDto model) {
        orderRepository.save(toModel(model));
    }

    @Override
    public void delete(OrderDto model) {
        orderRepository.delete(toModel(model));
    }

    @Override
    public List<OrderDto> get() {
      return orderRepository.findAll()
               .stream()
               .map(this::orderDto)
               .collect(Collectors.toList());
    }

    @Override
    public void read(OrderDto model) {

    }

    @Override
    public void update(OrderDto model) {
        orderRepository.save(toModel(model));
    }

    private OrderDto orderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .name(order.getName())
                .summ(order.getSumm())
                .isActive(order.getIsActive())
                .employeeId(order.getEmployeeId().getId())
                .isReady(order.getIsReady())
                .build();

    }
    private Order toModel(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .isActive(orderDto.getIsActive())
                .name(orderDto.getName())
                .isReady(orderDto.getIsReady())
                .summ(orderDto.getSumm())
                .employeeId(
                        Employee.builder()
                        .id(orderDto.getEmployeeId())
                        .build()
                )
                .build();

    }
}
