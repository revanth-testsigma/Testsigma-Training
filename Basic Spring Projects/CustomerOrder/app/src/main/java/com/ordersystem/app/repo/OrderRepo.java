package com.ordersystem.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ordersystem.app.Model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>, JpaSpecificationExecutor<Orders>{
    
}
