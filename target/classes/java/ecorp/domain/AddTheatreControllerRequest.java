package ecorp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddTheatreControllerRequest {

    @JsonProperty("theatre_type")
    private String theatreType;

    public String getTheatreType() {
        return theatreType;
    }

    public void setTheatreType(String theatreType) {
        this.theatreType = theatreType;
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
