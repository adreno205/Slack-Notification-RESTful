package ecorp.service;

import ecorp.domain.AddMovieControllerRequest;
import ecorp.domain.AddShowcontrollerRequest;
import ecorp.domain.AddTheatreControllerRequest;
import ecorp.repository.MovieRepository;
import ecorp.repository.ShowRepository;
import ecorp.repository.TheatreRepository;
import ecorp.repository.entity.Movie;
import ecorp.repository.entity.Show;
import ecorp.repository.entity.Theatre;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateTimeService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowRepository showRepository;

    private static Logger logger = Logger.getLogger(CalculateTimeService.class);

    public String getEndTime(AddShowcontrollerRequest showRequest) {
        Movie movie = movieRepository.findOneBymovieID(showRequest.getMovieId());
        int movieTime = movie.getMovieTime();
        String[] startSplited = showRequest.getStartTime().split("\\.");
        int startHour = Integer.parseInt(startSplited[0]);
        int startMin = Integer.parseInt(startSplited[1]);
        int endTimeInMinute = (startHour*60) + startMin + movieTime;
        int endHour = endTimeInMinute/60;
        int endMin = endTimeInMinute - (endHour*60);
        String endTime = endHour+"."+endMin;
        return  endTime;
    }

    public int getStartTimeInMinute(Show oneShow) {
        String[] startSplited = oneShow.getStartTime().split("\\.");
        int startHour = Integer.parseInt(startSplited[0]);
        int startMin = Integer.parseInt(startSplited[1]);
        int startTimeInMinute = (startHour*60) + startMin;
        return  startTimeInMinute;
    }

    public int getEndTimeInMinute(Show oneShow,AddShowcontrollerRequest showRequest) {
        Movie movie = movieRepository.findOneBymovieID(showRequest.getMovieId());
        int movieTime = movie.getMovieTime();
        String[] startSplited = oneShow.getStartTime().split("\\.");
        int startHour = Integer.parseInt(startSplited[0]);
        int startMin = Integer.parseInt(startSplited[1]);
        int endTimeInMinute = (startHour*60) + startMin + movieTime;
        return  endTimeInMinute;
    }

    public int getEndTimeInMinute(Show oneShow,int movieId) {
        Movie movie = movieRepository.findOneBymovieID(movieId);
        int movieTime = movie.getMovieTime();
        String[] startSplited = oneShow.getStartTime().split("\\.");
        int startHour = Integer.parseInt(startSplited[0]);
        int startMin = Integer.parseInt(startSplited[1]);
        int endTimeInMinute = (startHour*60) + startMin + movieTime;
        return  endTimeInMinute;
    }
}
