package com.example.project.demo.OrderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    public OrderDetailsRepository repo;

    public List<OrderDetailsEntity> getAllOrderDetails() {
        return repo.findAll();
    }

    public OrderDetailsEntity getOrderDetailsId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public OrderDetailsEntity saveOrderDetails(OrderDetailsEntity orderDetails) {
        return this.repo.save(orderDetails);
    }

    public Boolean deleteOrderDetails(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
