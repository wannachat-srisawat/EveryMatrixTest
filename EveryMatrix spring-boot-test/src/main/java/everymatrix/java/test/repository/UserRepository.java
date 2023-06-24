package everymatrix.java.test.repository;
import everymatrix.java.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM User u where u.email = :email", nativeQuery = true)
    Optional<User> findWithEmail(String email);
}
