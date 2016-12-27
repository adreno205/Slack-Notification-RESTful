package ecorp.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name="Theatre")
public class Theatre {

    @Id
    @Column(name = "theatre_no")
    @GeneratedValue
    private int theatreNo;

    @Column(name = "theatre_type")
    @JsonProperty("theatre_type")
    private String theatreType;

    public int getTheatreNo() {
        return theatreNo;
    }

    public void setTheatreNo(int theatreNo) {
        this.theatreNo = theatreNo;
    }

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

