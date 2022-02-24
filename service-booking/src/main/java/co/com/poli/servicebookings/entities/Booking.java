package co.com.poli.servicebookings.entities;

import co.com.poli.servicebookings.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="BOOKING")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    @NotNull(message = "campo obligatorio")
    private Long userId;

    @Column(name = "showtime_id")
    @NotNull(message = "campo obligatorio")
    private Long showtimeId;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private List<BookingMovie> movies;

    @Transient
    Users user;

}
