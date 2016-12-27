package ecorp.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
@Table(name="Movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue
    private int movieId;

    @Column(name = "movie_name")
    @JsonProperty("movie_name")
    private String movieName;

    @Column(name = "movie_rate")
    @JsonProperty("movie_rate")
    private String movieRate;

    @Column(name = "movie_type")
    @JsonProperty("movie_type")
    private String movieType;

    @Column(name = "movie_time")
    @JsonProperty("movie_time")
    private int movieTime;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(String movieRate) {
        this.movieRate = movieRate;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public int getMovieTime() { return movieTime; }

    public void setMovieTime(int movieTime) { this.movieTime = movieTime; }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }
}

