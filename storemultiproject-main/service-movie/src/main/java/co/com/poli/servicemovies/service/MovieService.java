package co.com.poli.servicemovies.service;

import co.com.poli.servicemovies.entities.Movie;

import java.util.List;

public interface MovieService {

    public Movie createMovie(Movie movie);

    public List<Movie> listAllMovies();

    public Movie getMovieById(Long id);

    public void deleteMovie(Long id);

}
