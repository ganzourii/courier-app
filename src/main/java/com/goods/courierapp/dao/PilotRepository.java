package com.goods.courierapp.dao;

import com.goods.courierapp.models.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PilotRepository extends JpaRepository<Pilot,Integer> {
    @Query("SELECT p FROM Pilot p JOIN p.user u WHERE u.username = :username")
    Optional<Pilot> findByUsername(@Param("username")String username);
}
