package everymatrix.java.test.repository;
import everymatrix.java.test.entity.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MataDataRepository extends JpaRepository<Metadata, Integer> {
}
