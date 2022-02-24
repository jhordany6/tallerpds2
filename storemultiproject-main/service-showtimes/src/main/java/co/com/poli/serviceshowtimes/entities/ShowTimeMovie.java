package co.com.poli.serviceshowtimes.entities;

import co.com.poli.serviceshowtimes.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="TBL_SHOWTIME_MOVIE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTimeMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;

    @Transient
    private Movie movie;

}
