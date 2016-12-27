package ecorp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

public class AddShowcontrollerRequest {

    @JsonProperty("movie_id")
    private int movieId;

    @JsonProperty("theatre_no")
    private int theatreNo;

    @JsonProperty("starttime")
    private String startTime;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
