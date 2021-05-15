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

    @Query(value = "SELECT * from flights order by row_id desc limit 1;", nativeQuery = true)
    Flights lastApiId ();

    @Query(value = "SELECT id, valid_until, count(*) from flights group by id, valid_until order by valid_until desc;", nativeQuery = true)
    List<Flights> findLatestApi();

    // get all unique API ID's in decending order
    @Query(value = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY id ORDER BY MAX(valid_until) DESC) AS rn FROM flights GROUP BY row_id,id, valid_until) AS t WHERE rn <= 1 ORDER BY valid_until desc limit 15;", nativeQuery = true)
    List<Flights> findApiIdUniqueDesc();
}

