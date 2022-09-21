package nem.kulturservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Event event;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private User user;

}
