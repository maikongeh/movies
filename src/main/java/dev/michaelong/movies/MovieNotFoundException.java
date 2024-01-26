package dev.michaelong.movies;

public class MovieNotFoundException extends Exception{

    public MovieNotFoundException(String error) {
        super(error);
    }
}
