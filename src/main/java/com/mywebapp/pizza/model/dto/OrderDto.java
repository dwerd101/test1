package com.mywebapp.pizza.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mywebapp.pizza.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
    private Long id;
    private Double summ;
    private Boolean isReady;
    private Boolean isActive;
    private String name;
    private Long employeeId;
}
