package co.com.poli.servicebookings.service;

import co.com.poli.servicebookings.entities.Booking;
import java.util.List;

public interface BookingService {

    public Booking createBooking(Booking booking);

    public List<Booking> listAllBooking();

    public Booking getBookingById(Long id);

    public Booking updateBooking(Booking booking);
    public void deleteBooking(Long id);

}
