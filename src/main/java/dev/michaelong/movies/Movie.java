package dev.michaelong.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    // How a Movie is represented
    @Id
    private ObjectId id;

    private String imdbId;

    public String title;

    private String releaseDate;

    private String trailerLink;

    private List<String> genre;

    private String poster;

    private String backdrops;

    @DocumentReference // find out different relationships that is possible using mongodb
    private List<Review> reviewIds;

}
