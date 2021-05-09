package com.example.backend.repository;

import com.example.backend.entity.Flights;
import com.example.backend.model.ValidUntil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsRepository extends JpaRepository<Flights, Long> {

    ValidUntil findByRowId(long i);
}

