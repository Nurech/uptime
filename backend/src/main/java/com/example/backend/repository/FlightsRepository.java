package com.example.backend.repository;

import com.example.backend.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, String> {

    Flights findByRowId(long i);

    List<Flights> findAllById (String lastestApiId);

    // get latest API ID
    Flights findTopByOrderByRowIdDesc ();

}

