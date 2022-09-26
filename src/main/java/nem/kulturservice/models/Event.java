package nem.kulturservice.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Timestamp timestamp; //format: "2022-09-22T07:08:52.713+00:00"

    @ManyToOne
    @JsonBackReference //Do to circular reference  pga. cirkulær reference i @RestController (Så man ikke beder om eventets band igen - man undgår cirkulær metodekald)
    @EqualsAndHashCode.Exclude //pga. hashCode() fra @Data
    private Band band; //bandID i event-tabel

    @OneToMany (mappedBy = "event")
    private Set<Review> reviews = new HashSet<>();
}
