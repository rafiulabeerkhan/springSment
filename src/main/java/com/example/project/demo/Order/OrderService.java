package com.example.project.demo.Order;

import com.example.project.demo.OrderDetails.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderRepository repo;
    @Autowired
    public OrderDetailsRepository orderDetailsRepositorypo;
    public List<OrderEntity> getAllOrder() {

        List<OrderEntity> orderEntities = repo.findAll();
        orderEntities.forEach(orderEntity -> {
            orderEntity.setClientEntity(null);
            orderEntity.setProductEntity(null);
        });

        return repo.findAll();
    }

    public OrderEntity getOrderId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public OrderEntity saveOrder(OrderEntity order) {

//        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setId(repo.save(order).getId()); ;
//
//        order.getOrderDetailsEntity().forEach(orderDetails -> {
//            orderDetails.setOrderEntity(orderEntity);
//            orderDetailsRepositorypo.save(orderDetails);
//        });

        return repo.save(order);
    }

    public Boolean deleteOrder(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Long countOrder() {
        return repo.count();
    }
}
