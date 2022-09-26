package nem.kulturservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private int rating;

    @ManyToOne
    @JsonBackReference (value = "Review-event")
    @EqualsAndHashCode.Exclude
    private Event event;

    @ManyToOne
    @JsonBackReference (value = "Review-user") //
    @EqualsAndHashCode.Exclude
    private User user;

}
