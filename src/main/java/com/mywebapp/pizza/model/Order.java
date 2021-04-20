package com.mywebapp.pizza.model;

import com.mywebapp.pizza.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.annotation.Priority;
import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "\"order\"")
public class Order {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "summ")
    private Double summ;

    @Column(name = "is_ready")
    private Boolean isReady;

    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employeeId;
}
