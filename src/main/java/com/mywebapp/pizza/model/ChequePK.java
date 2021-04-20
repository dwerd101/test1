package com.mywebapp.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ChequePK implements Serializable {

    @OneToOne(cascade= CascadeType.ALL)
    // @PrimaryKeyJoinColumn(name = "dish_id")
    @JoinColumn(name = "dish_id")
    private Dish dishId;


    @OneToOne(cascade= CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //  @PrimaryKeyJoinColumn(name = "order_id")
    @JoinColumn(name = "order_id")
    private Order orderId;
}
