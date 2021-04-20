package com.mywebapp.pizza.controller;

import com.mywebapp.pizza.model.Employee;
import com.mywebapp.pizza.model.Shift;
import com.mywebapp.pizza.model.ShiftWorkers;
import com.mywebapp.pizza.model.ShiftWorkersPK;
import com.mywebapp.pizza.service.impl.ShiftService;
import com.mywebapp.pizza.service.impl.ShiftWorkersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shift-workers")
public class ShiftWorkersController {

    private final ShiftWorkersService shiftWorkersService;
    private final ShiftService shiftService;

    public ShiftWorkersController(ShiftWorkersService shiftWorkersService, ShiftService service) {
        this.shiftWorkersService = shiftWorkersService;
        this.shiftService = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addWorkers(@RequestBody List<ShiftWorkersPK> shiftWorkersPKList) {
        shiftWorkersPKList.forEach(shiftWorkersPK ->  shiftService.create(shiftWorkersPK.getShiftId()));
        shiftWorkersPKList.forEach(shiftWorkersPK -> {
          ShiftWorkers shiftWorkers =  ShiftWorkers.builder()
                    .shiftWorkersPK(shiftWorkersPK)
                    .build();
            shiftWorkersService.create(shiftWorkers);});
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateWorkers(@RequestBody ShiftWorkersPK shiftWorkers) {
        shiftWorkersService.update(ShiftWorkers.builder()
                .shiftWorkersPK(shiftWorkers).build());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllShiftWorkers() {
        return new ResponseEntity<>(shiftWorkersService.get(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}/{id2}")
    public ResponseEntity<?> deleteShiftWorkers(@PathVariable Long id, @PathVariable Long id2) {
        shiftWorkersService.delete(ShiftWorkers.builder()
                .shiftWorkersPK(ShiftWorkersPK.builder()
                .shiftId(Shift.builder()
                        .id(id2)
                        .build())
                        .employeeId(Employee.builder()
                                .id(id)
                                .build())
                .build())
                .build());
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
