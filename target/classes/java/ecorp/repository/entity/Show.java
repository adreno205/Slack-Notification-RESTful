package ecorp.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
@Table(name="Showtime")
public class Show {

    @Id
    @Column(name = "show_id")
    @GeneratedValue
    private int showId;

    @Column(name = "starttime")
    @JsonProperty("starttime")
    private String startTime;

    @Column(name = "endtime")
    @JsonProperty("endtime")
    private String endTime;

    @Column(name = "movie_id")
    @JsonProperty("movie_id")
    private int movieId;

    @Column(name = "theatre_no")
    @JsonProperty("theatre_no")
    private int theatreNo;

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheatreNo() {
        return theatreNo;
    }

    public void setTheatreNo(int theatreNo) {
        this.theatreNo = theatreNo;
    }

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

