package everymatrix.java.test.repository;
import everymatrix.java.test.entity.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<Preferences, Integer> {
}
