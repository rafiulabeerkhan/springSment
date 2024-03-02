package com.example.project.demo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderRepository repo;

    public List<OrderEntity> getAllOrder() {
        return repo.findAll();
    }

    public OrderEntity getOrderId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public OrderEntity saveOrder(OrderEntity order) {
        return this.repo.save(order);
    }

    public Boolean deleteOrder(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
