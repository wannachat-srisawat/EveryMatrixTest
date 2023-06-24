package everymatrix.java.test.model;
import everymatrix.java.test.entity.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class MovieWithCategoryResponse {
    String category;
    List<Movie> movie;
}
