package dev.michaelong.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies() , HttpStatus.OK);
    }
//    public ResponseEntity<List<String>>
//    getAllMovies() {
//        return new ResponseEntity<List<String>>(movieService.allMovieTitles(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    // PathVariable lets the framework know that the id from ObjectId will be parsed as info for getMapping
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") ObjectId id) throws MovieNotFoundException {
        return new ResponseEntity<Movie>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Movie>getMovieById(@PathVariable String imdbId) throws MovieNotFoundException {
        return new ResponseEntity<Movie>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }

}
