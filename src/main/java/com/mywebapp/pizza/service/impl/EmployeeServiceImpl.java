package com.mywebapp.pizza.service.impl;

import com.mywebapp.pizza.model.Employee;
import com.mywebapp.pizza.repository.EmployeeRepository;
import com.mywebapp.pizza.service.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements ServiceCrud<Employee> {
    private final EmployeeRepository employeeRepository;

    @Override
    public void create(Employee model) {

    }

    @Override
    public void delete(Employee model) {

    }

    @Override
    public List<Employee> get() {
        return employeeRepository.findAll();
    }

    @Override
    public void read(Employee model) {

    }

    @Override
    public void update(Employee employee) {

    }
  public   Optional<Employee> findByPasswordAndPhone(String password, String phone) {
        return employeeRepository.findByPasswordAndPhone(password,phone);
  }
}
