package co.com.poli.serviceshowtimes.client;

import co.com.poli.serviceshowtimes.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="movie-service")
@RequestMapping(value="/movies")
public interface MovieClient {

    @GetMapping(value = "/{idMovie}")
    public ResponseEntity<Movie> getMovie(@PathVariable("idMovie") Long idMovie);

}
