package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();

    void saveOrder(Order order);

}
