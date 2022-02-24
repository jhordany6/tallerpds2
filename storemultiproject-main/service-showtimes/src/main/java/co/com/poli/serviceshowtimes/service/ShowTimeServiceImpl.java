package co.com.poli.serviceshowtimes.service;

import co.com.poli.serviceshowtimes.client.MovieClient;
import co.com.poli.serviceshowtimes.entities.ShowTime;
import co.com.poli.serviceshowtimes.entities.ShowTimeMovie;
import co.com.poli.serviceshowtimes.model.Movie;
import co.com.poli.serviceshowtimes.repository.ShowtimeMovieRepository;
import co.com.poli.serviceshowtimes.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService {
    
    private final ShowtimeRepository showTimeRepository;
    @Autowired
    ShowtimeMovieRepository showtimeMovieRepository;
    MovieClient movieClient;

    @Override
    public ShowTime createShowTime(ShowTime showTime) {
        return showTimeRepository.save(showTime);
    }

    @Override
    public List<ShowTime> listAllShowTime() {
        return showTimeRepository.findAll();
    }

    @Override
    public ShowTime getShowTimeById(Long id) {
        ShowTime showtime= showTimeRepository.findById(id).orElse(null);
        if (null != showtime ){
            List<ShowTimeMovie> listItem=showtime.getMovies().stream().map(movieItem -> {
                Movie movie = movieClient.getMovie(movieItem.getMovieId()).getBody();
                movieItem.setMovie(movie);
                return movieItem;
            }).collect(Collectors.toList());
            showtime.setMovies(listItem);
        }
        return showtime;
    }

    @Override
    public void deleteShowTime(Long id) {
        showTimeRepository.deleteById(id);
    }

    @Override
    public ShowTime updateShowTime(ShowTime showTime) {

        ShowTime showTimeDB = getShowTimeById(showTime.getId());
        if (showTimeDB == null){
            return  null;
        }
        showTimeDB.setId(showTime.getId());
        showTimeDB.setDate(showTime.getDate());
        showTimeDB.getMovies().clear();
        showTimeDB.setMovies(showTime.getMovies());

        return showTimeRepository.save(showTimeDB);
    }


}
