package com.example.backend.repository;

import com.example.backend.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, Long> {

    Flights findByRowId(long i);

    List<Flights> findAllById (String lastestApiId);

    // get latest API ID
    Flights findTopByOrderByRowIdDesc ();


    // get latest 15 API ID's
//    Flights findAllById();

}

