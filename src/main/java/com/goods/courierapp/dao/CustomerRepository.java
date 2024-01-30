package com.goods.courierapp.dao;

import com.goods.courierapp.models.Customer;
import com.goods.courierapp.models.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT c FROM Customer c JOIN c.user u WHERE u.username = :username")
    Optional<Customer> findByUsername(@Param("username")String username);
}
