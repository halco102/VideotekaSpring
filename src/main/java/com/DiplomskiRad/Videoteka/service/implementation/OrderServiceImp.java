package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Order;
import com.DiplomskiRad.Videoteka.repositories.OrderRepository;
import com.DiplomskiRad.Videoteka.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    private OrderRepository orderRepository;

    public  OrderServiceImp(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @Override
    public List<Order> findAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        System.out.println("Saved order ID =" + order.getId());
        this.orderRepository.save(order);
    }
}
