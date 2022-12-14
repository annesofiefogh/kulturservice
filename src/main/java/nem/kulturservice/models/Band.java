package nem.kulturservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Band {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany (mappedBy = "band") //The event class (receiver class) already mapped to this band class
    //Therefor JPA doesn't need to map form band to event.
    private Set<Event> events = new HashSet<>();

    @ManyToMany (mappedBy = "bandsLiked")
    @JsonBackReference (value = "Likes-from-users")
    private Set<User> userLikes = new HashSet<>();



}
