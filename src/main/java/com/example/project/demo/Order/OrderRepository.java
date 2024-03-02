package com.example.project.demo.Order;


import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
