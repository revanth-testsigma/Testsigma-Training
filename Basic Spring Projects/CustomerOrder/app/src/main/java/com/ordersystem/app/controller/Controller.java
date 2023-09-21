package com.ordersystem.app.controller;
import com.ordersystem.app.Model.Customer;
import com.ordersystem.app.Model.Orders;
import com.ordersystem.app.dto.Req;

import com.ordersystem.app.service.FiltersSpecification;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ordersystem.app.repo.CustomerRepo;
import com.ordersystem.app.repo.OrderRepo;

@RestController
public class Controller {
    @Autowired
    OrderRepo orepo;
    CustomerRepo crepo;
    //specifications

    public Controller(OrderRepo orepo, CustomerRepo crepo) {
        this.orepo = orepo;
        this.crepo = crepo;
    }
    
    //add operations
    @PostMapping("/customers/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return crepo.save(customer);
    }
    
    @PostMapping("/orders/add")
    public Orders addOrder(@RequestBody Orders orders){
        return orepo.save(orders);
    }

    @Autowired
    private FiltersSpecification<Orders> OrdersFiltersSpecification;
    
    @PostMapping("/orders")
    public ResponseEntity<List<Orders>> index(@RequestBody Req request) {
        Specification<Orders> searchSpecification = OrdersFiltersSpecification
                .getSearchSpecification(request.getSearch(), request.getOperator());
            try {
                return ResponseEntity.ok(orepo.findAll(searchSpecification));    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
                return ResponseEntity.ok(null);
    }

    @Autowired
    private FiltersSpecification<Customer> CustomerFiltersSpecification;

    @PostMapping("/customers")
    public List<Customer> searchCustomers(@RequestBody Req request) {
        Specification<Customer> searchSpecification = CustomerFiltersSpecification
                .getSearchSpecification(request.getSearch(), request.getOperator());
            return crepo.findAll(searchSpecification);
    }
}
