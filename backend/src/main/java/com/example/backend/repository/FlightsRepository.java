package com.example.backend.repository;

import com.example.backend.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsRepository extends JpaRepository<Flights, String> {

}
