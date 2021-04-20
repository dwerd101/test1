package com.mywebapp.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShiftWorkersPK implements Serializable {

    @OneToOne(cascade= CascadeType.ALL)
    //  @PrimaryKeyJoinColumn(name = "employee_id")
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @OneToOne(cascade= CascadeType.ALL)
    //  @PrimaryKeyJoinColumn(name = "shift_id")
    @JoinColumn(name = "shift_id")
    private Shift shiftId;
}
