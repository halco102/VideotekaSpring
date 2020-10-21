package com.DiplomskiRad.Videoteka.controller;

import com.DiplomskiRad.Videoteka.service.implementation.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(OrderController.ORDER_PATH)
public class OrderController {

    public static final String ORDER_PATH = "/api/v1/orders";
    private OrderService orderService;


    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    /*
    * na osnovu id treba kupovat filmove
    *
    * */



}
