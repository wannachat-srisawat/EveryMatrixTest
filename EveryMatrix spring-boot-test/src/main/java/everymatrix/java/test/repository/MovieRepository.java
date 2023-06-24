package everymatrix.java.test.repository;
import everymatrix.java.test.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM Movie m where m.tags = :tag", nativeQuery = true)
    List<Movie> findWithTag(String tag);
}
