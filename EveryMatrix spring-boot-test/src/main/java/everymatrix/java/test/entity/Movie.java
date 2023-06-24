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
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private String genre;

    private String tags;

    private String length;

    private String dateReleased;

    private String dateAvailable;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "metadata" , referencedColumnName = "id")
    private Metadata metadata;
}
