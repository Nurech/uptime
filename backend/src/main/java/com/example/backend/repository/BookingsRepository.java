package com.example.backend.repository;

import com.example.backend.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    Bookings findTopByOrderByUserIdNrDesc();
}

