package com.example.backend.service;

import com.example.backend.controller.BackendController;
import com.example.backend.entity.Bookings;
import com.example.backend.entity.Flights;
import com.example.backend.model.Booking;
import com.example.backend.repository.BookingsRepository;
import com.example.backend.repository.FlightsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@EnableScheduling
public class BookingService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private FlightsRepository flightsRepository;
    @Autowired
    private BookingsRepository bookingsRepository;

    public List<Booking> getLatestBookings() {

        LOG.info("GET latest bookings data");

        // TODO use Set to avoid dupes or better query
        List<Flights> lastApiList = flightsRepository.findAll();
        LOG.info("Last API list size is: " + lastApiList.size());


        long lastRow = bookingsRepository.findTopByOrderByUserIdNrDesc().getUserIdNr();
        List<Bookings> bookingEntity = bookingsRepository.findAll();
        LOG.info("Found booking records. List size is: " + bookingEntity.size());


        // where to save all latest results
        List<Booking> bookingDataList = new ArrayList<>();

        // find last 10 records
        for (int i = (int) (lastRow - 10); i < lastRow; i++) {

            // create obj in loop
            Booking bookingData = new Booking();

            bookingData.setUserIdNr(bookingEntity.get(i).getUserIdNr());
            bookingData.setBookingId(bookingEntity.get(i).getBookingId());
            bookingData.setFirstName(bookingEntity.get(i).getFirstName());
            bookingData.setLastName(bookingEntity.get(i).getLastName());
            bookingData.setApiId(bookingEntity.get(i).getApiId());
            bookingData.setIsValidPrice("false");

            // if booking is in last 15 api list then price is valid (booking expires after 15 API refreshes)
            for (int j = 0; j < lastApiList.size(); j++) {
                if (bookingEntity.get(i).getApiId().equals(lastApiList.get(j).getId())) {
                    bookingData.setIsValidPrice("true");
                }
            }
            bookingDataList.add(bookingData);
        }

        // return last 10 bookings
        return bookingDataList;
    }

    public void saveBooking(Booking booking) {

        LOG.info("Saving booking" + booking.getFirstName() + " " + booking.getFirstName() + " to db.");
        Bookings bookingEntity = new Bookings();
        bookingEntity.setApiId(booking.getApiId());
        bookingEntity.setFirstName(booking.getFirstName());
        bookingEntity.setLastName(booking.getLastName());
        bookingEntity.setBookingId(booking.getBookingId());
        bookingsRepository.save(bookingEntity);

    }

}
