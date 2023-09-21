package com.authentication.app.Controller;
import com.authentication.app.model.User;
import com.authentication.app.model.Orders;
import com.authentication.app.dto.Req;

import com.authentication.app.service.FiltersSpecification;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.authentication.app.dao.UserRepository;
import com.authentication.app.dao.OrderRepo;

@RestController
@RequestMapping("/v1")
public class CustOrderController {
    @Autowired
    OrderRepo orepo;
    UserRepository crepo;
    //specifications

    public CustOrderController(OrderRepo orepo, UserRepository crepo) {
        this.orepo = orepo;
        this.crepo = crepo;
    }
    
    //add operations
    @PostMapping("/customers/add")
    public User addUser(@RequestBody User User){
        return crepo.save(User);
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
    private FiltersSpecification<User> UserFiltersSpecification;

    @PostMapping("/customers")
    public List<User> searchUsers(@RequestBody Req request) {
        Specification<User> searchSpecification = UserFiltersSpecification
                .getSearchSpecification(request.getSearch(), request.getOperator());
            return crepo.findAll(searchSpecification);
    }
}
