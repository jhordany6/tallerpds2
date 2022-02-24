package co.com.poli.servicebookings.service;

import co.com.poli.servicebookings.client.MovieClient;
import co.com.poli.servicebookings.client.UserClient;
import co.com.poli.servicebookings.entities.Booking;
import co.com.poli.servicebookings.entities.BookingMovie;
import co.com.poli.servicebookings.model.Movie;
import co.com.poli.servicebookings.model.Users;
import co.com.poli.servicebookings.repository.BookingMovieRepository;
import co.com.poli.servicebookings.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    
    private final BookingRepository bookingRepository;

    @Autowired
    BookingMovieRepository bookingMovieRepository;
    MovieClient movieClient;
    UserClient userClient;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> listAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        Booking booking= bookingRepository.findById(id).orElse(null);
        if (null != booking ){
            Users user = userClient.getUser(booking.getUserId()).getBody();
            booking.setUser(user);
            List<BookingMovie> listItem=booking.getMovies().stream().map(movieItem -> {
                Movie movie = movieClient.getMovie(movieItem.getMovieId()).getBody();
                movieItem.setMovie(movie);
                return movieItem;
            }).collect(Collectors.toList());
            booking.setMovies(listItem);
        }
        return booking;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking updateBooking(Booking booking) {

        Booking bookingDB = getBookingById(booking.getId());
        if (bookingDB == null){
            return  null;
        }
        bookingDB.setId(booking.getId());
        bookingDB.setUserId(booking.getUserId());
        bookingDB.setShowtimeId(booking.getShowtimeId());
        bookingDB.getMovies().clear();
        bookingDB.setMovies(booking.getMovies());

        return bookingRepository.save(bookingDB);
    }


}
