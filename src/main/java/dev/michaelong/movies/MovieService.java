package dev.michaelong.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public List<String> allMovieTitles() {
        return movieRepository.findAll().stream().map(x->x.title).toList();
    }

    public Movie getMovieById(ObjectId id) throws MovieNotFoundException{
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new MovieNotFoundException("No movie exists with this id in the database");
        }
    }

    public Movie getMovieByImdbId(String imdbId) throws MovieNotFoundException {
        Optional<Movie> movie = movieRepository.findByImdbId(imdbId);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new MovieNotFoundException("No Movie exists with this imdbId in the database");
        }
    }

}
