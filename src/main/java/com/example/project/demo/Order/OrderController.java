package com.example.project.demo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class OrderController {
    @Autowired
    public OrderService service;

    @GetMapping("/count")
    public Long countOrder(){
        return service.countOrder();
    }

    @GetMapping("/getAll")
    public List<OrderEntity> getAllOrder(){
        return service.getAllOrder();
    }
    @PostMapping
    public OrderEntity addOrder( @RequestBody OrderEntity order ){
        System.out.println(order);
        return service.saveOrder(order);
    }

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable("id")Long id){
        return service.getOrderId(id);
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrder(@RequestBody OrderEntity order){
        return service.saveOrder(order);
    }
    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id")Long id){
        service.deleteOrder(id);
    }
}
