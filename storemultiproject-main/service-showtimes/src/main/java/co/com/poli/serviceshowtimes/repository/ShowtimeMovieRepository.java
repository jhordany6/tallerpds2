package co.com.poli.serviceshowtimes.repository;

import co.com.poli.serviceshowtimes.entities.ShowTimeMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeMovieRepository extends JpaRepository<ShowTimeMovie,Long> {
}
