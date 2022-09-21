package nem.kulturservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data //inkluderer getter, setter, toString og hashcode
@Entity
@Table (name = "User")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany (mappedBy = "user")
    private Set<Review> reviews = new HashSet<>();

}
