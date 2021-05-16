package com.example.backend.service;

import com.example.backend.controller.BackendController;
import com.example.backend.entity.Bookings;
import com.example.backend.entity.Flights;
import com.example.backend.model.Booking;
import com.example.backend.repository.BookingsRepository;
import com.example.backend.repository.FlightsRepository;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@EnableScheduling
public class BookingService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private FlightsRepository flightsRepository;
    @Autowired
    private BookingsRepository bookingsRepository;

    @SneakyThrows
    public List<Booking> getLatestBookings() {

        LOG.info("{GET latest bookings data}");

        // get all unique api ID's in descending order
        List<Flights> last15ApiIdDesc = flightsRepository.findApiIdUniqueDesc();

        // get last 10 bookings
        List <Bookings> last10Bookings = bookingsRepository.findLast10Bookings();

        // return data list
        List <Booking> returnBookings = new ArrayList<>();

        for (int i = 0; i < last10Bookings.size();i++){

            Booking lastBooking = new Booking();
            lastBooking.setUserIdNr(last10Bookings.get(i).getUserIdNr());
            lastBooking.setBookingId(last10Bookings.get(i).getBookingId());
            lastBooking.setApiId(last10Bookings.get(i).getApiId());
            lastBooking.setFirstName(last10Bookings.get(i).getFirstName());
            lastBooking.setLastName(last10Bookings.get(i).getLastName());
            lastBooking.setDateTime(last10Bookings.get(i).getDateTime());

            //check if this booking is in last 15 API ID's, set default to false
            lastBooking.setIsValidPrice("false");
            for (int j = 0; j < last15ApiIdDesc.size();j++){
                if (Objects.equals(last10Bookings.get(i).getApiId(), last15ApiIdDesc.get(j).getId())){
                    lastBooking.setIsValidPrice("true");
                }
            }
            returnBookings.add(lastBooking);
        }

        // find all unique API ID's
        LOG.info("{Unique API list size is:} " + last15ApiIdDesc.size());

        // return last 10 bookings
        return returnBookings;
    }

    public void saveBooking(Booking booking) {

        LOG.info("Saving booking" + booking.getFirstName() + " " + booking.getFirstName() + " to db.");
        Bookings bookingEntity = new Bookings();
        bookingEntity.setApiId(booking.getApiId());
        bookingEntity.setFirstName(booking.getFirstName());
        bookingEntity.setLastName(booking.getLastName());
        bookingEntity.setBookingId(booking.getBookingId());
        bookingEntity.setDateTime(booking.getDateTime());
        bookingEntity.setTravelTime(booking.getTravelTime());
        bookingEntity.setProviderFlightEnd(booking.getProviderFlightEnd());
        bookingEntity.setProviderFlightStart(booking.getProviderFlightStart());
        bookingEntity.setProviderPrice(booking.getProviderPrice());
        bookingEntity.setProviderCompanyName(booking.getProviderCompanyName());

        bookingsRepository.save(bookingEntity);

    }
}
