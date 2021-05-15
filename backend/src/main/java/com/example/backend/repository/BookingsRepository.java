package com.example.backend.repository;

import com.example.backend.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    Bookings findTopByOrderByUserIdNrDesc();

    @Query(value = "SELECT * from bookings WHERE bookings.api_id IS NOT NULL ORDER BY user_id_nr desc ;", nativeQuery = true)
    List<Bookings> findAllWhereNotNull();

    @Query(value = "select * from bookings order by user_id_nr desc limit 10;", nativeQuery = true)
    List<Bookings> findLast10Bookings();

    // increase somethings goes wrong, I will only count valid fields
    @Query(value = "SELECT user_id_nr, count(*), api_id from bookings WHERE bookings.api_id IS NOT NULL group by user_id_nr order by user_id_nr desc;", nativeQuery = true)
    List<Bookings> findAllValidUsers();

}

