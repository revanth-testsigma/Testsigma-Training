package com.authentication.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.authentication.app.model.Orders;;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>, JpaSpecificationExecutor<Orders>{
    
}
