package com.mywebapp.pizza.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "shift_workers")
public class ShiftWorkers implements Serializable {
   /* @Id
    @OneToOne(cascade= CascadeType.ALL)
  //  @PrimaryKeyJoinColumn(name = "employee_id")
    @JoinColumn(name = "employee_id")
    private Employee employeeId;
    @Id
    @OneToOne(cascade= CascadeType.ALL)
  //  @PrimaryKeyJoinColumn(name = "shift_id")
    @JoinColumn(name = "shift_id")
    private Shift shiftId;*/


    @EmbeddedId
   // @JsonProperty("")
    private ShiftWorkersPK shiftWorkersPK;
}
