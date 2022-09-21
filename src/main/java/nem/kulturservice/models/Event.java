package nem.kulturservice.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data //laver bl.a. hashCode()
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    private Date dateTime;

    @ManyToOne
    @JsonBackReference //pga. cirkulær reference i @RestController (Så man ikke beder om eventets band igen - man undgår cirkulær metodekald)
    @EqualsAndHashCode.Exclude //pga. hashCode() fra @Data
    private Band band; //bandID i event-tabel

    @OneToMany (mappedBy = "event")
    private Set<Review> reviews = new HashSet<>();
}
