package everymatrix.java.test.controller;
import everymatrix.java.test.entity.User;
import everymatrix.java.test.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Api(value = "User API")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @GetMapping(value = "/{email}")
    public ResponseEntity<?> getUserWithTag(@PathVariable("email") String email) throws Exception {
        try {
            Optional<User> user = userRepository.findWithEmail(email);
            if (user.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(user.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found with email : " + email);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }
}
