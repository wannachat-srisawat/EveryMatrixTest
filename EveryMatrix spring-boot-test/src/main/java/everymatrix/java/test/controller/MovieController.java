package everymatrix.java.test.controller;
import everymatrix.java.test.entity.Movie;
import everymatrix.java.test.model.MovieWithCategoryResponse;
import everymatrix.java.test.repository.MovieRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/movie")
@Api(value = "Movie API")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping(value = "/all")
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    @GetMapping(value = "/category")
    public List<MovieWithCategoryResponse> getAllMovieWithCategory(){
        List<Movie> movieList = movieRepository.findAll();
        Map<String, List<Movie>> categorySet = movieList.stream().collect(groupingBy(Movie::getGenre, toList()));
        return categorySet.entrySet().stream().map(category ->
                        MovieWithCategoryResponse.builder()
                                .category(category.getValue().stream().findFirst().get().getGenre())
                                .movie(category.getValue())
                                .build())
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{tag}")
    public ResponseEntity<?> getAllMovieWithTag(@PathVariable("tag") String tag) throws Exception {
        try {
            List<Movie> movieList = movieRepository.findWithTag(tag);
            return ResponseEntity.status(HttpStatus.OK).body(movieList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

}
