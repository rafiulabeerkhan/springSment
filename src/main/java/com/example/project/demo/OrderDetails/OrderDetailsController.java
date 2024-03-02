package com.example.project.demo.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class OrderDetailsController {
    @Autowired
    public OrderDetailsService service;

    @GetMapping("/getAll")
    public List<OrderDetailsEntity> getAllOrderDetails(){
        return service.getAllOrderDetails();
    }
    @PostMapping
    public OrderDetailsEntity addOrderDetails( @RequestBody OrderDetailsEntity orderDetails ){
        return service.saveOrderDetails(orderDetails);
    }

    @GetMapping("/{id}")
    public OrderDetailsEntity getOrderDetailsById(@PathVariable("id")Long id){
        return service.getOrderDetailsId(id);
    }

    @PutMapping("/{id}")
    public OrderDetailsEntity updateOrderDetails(@RequestBody OrderDetailsEntity orderDetails){
        return service.saveOrderDetails(orderDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteOrderDetailsById(@PathVariable("id")Long id){
        service.deleteOrderDetails(id);
    }
}
