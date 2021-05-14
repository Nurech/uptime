package com.example.backend.repository;

import com.example.backend.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, String> {

    Flights findByRowId(long i);

    List<Flights> findAllById (String lastestApiId);

    // get latest API ID
    Flights findTopByOrderByRowIdDesc ();


    @Query(value = "SELECT id, valid_until, count(*) from flights group by id, valid_until order by valid_until desc;", nativeQuery = true)
    List<Flights> findLatestApi();

}

