package nem.kulturservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Band {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany (mappedBy = "band") //event-klassen (modtageren) har allerede mappet til denne band-klasse.
    // Derfor behøver JPA ikke at mappe fra band til event.
    private Set<Event> events = new HashSet<>();

}
