package com.example.backend.repository;

import com.example.backend.entity.Flights;
import com.example.backend.model.ServerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsRepository extends JpaRepository<Flights, Long> {

    ServerInfo findByRowId(long i);
}

