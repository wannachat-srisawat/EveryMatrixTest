package everymatrix.java.test.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String phoneNumber;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "favMovie" , referencedColumnName = "id")
    private Movie favMovie;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "preferences" , referencedColumnName = "id")
    private Preferences preferences;
}
