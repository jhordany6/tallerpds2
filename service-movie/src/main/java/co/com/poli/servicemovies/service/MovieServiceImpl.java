package co.com.poli.servicemovies.service;

import co.com.poli.servicemovies.entities.Movie;
import co.com.poli.servicemovies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
    
    private final MovieRepository movieRepository;
    
    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
