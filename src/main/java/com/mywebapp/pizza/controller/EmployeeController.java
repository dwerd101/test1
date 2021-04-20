package com.mywebapp.pizza.controller;

import com.mywebapp.pizza.model.Employee;
import com.mywebapp.pizza.service.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> employeeList() {
        return employeeService.get();
    }

    @PostMapping("/security")
    public ResponseEntity<?> checkUser(@RequestBody Employee unknown) {

        AtomicInteger status = new AtomicInteger();
        List<Employee> employeeList = employeeService.get();
        employeeList.stream()
                .filter(employee -> employee.getPhone().equals(unknown.getPhone())
                        && employee.getPassword().equals(unknown.getPassword()))
                .findAny()
                .ifPresentOrElse(
                        o -> status.set(200),
                        Optional::empty
                );
       if(status.get()==200) {
           Optional <Employee> employeeOptional =
                   employeeService.findByPasswordAndPhone(unknown.getPassword(),unknown.getPhone());

           Employee employee = null;
           if(employeeOptional.isPresent()) {
               employee = employeeOptional.get();
           }
           return new ResponseEntity<>(employee.getJobName(),HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(HttpStatus.FORBIDDEN);
       }
    }


  /*  @PutMapping("update/shift-workers")
    public ResponseEntity<?> checkUser(@RequestBody Employee unknown)*/
}
