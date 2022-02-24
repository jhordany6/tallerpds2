package co.com.poli.servicebookings.entities;

import co.com.poli.servicebookings.model.Movie;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="BOOKING_MOVIE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;

    @Transient
    private Movie movie;

}
