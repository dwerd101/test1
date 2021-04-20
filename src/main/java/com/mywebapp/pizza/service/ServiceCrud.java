package com.mywebapp.pizza.service;

import java.util.List;

public interface ServiceCrud<T> {
    void create(T model);

    void delete(T model);

    List<T> get();

    void read(T model);

    void update(T model);
}
