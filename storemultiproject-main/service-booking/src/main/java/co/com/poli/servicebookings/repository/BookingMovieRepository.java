package co.com.poli.servicebookings.repository;

import co.com.poli.servicebookings.entities.BookingMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingMovieRepository extends JpaRepository<BookingMovie,Long> {
}
