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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.lang.Object;
import java.security.InvalidParameterException;
import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private  CalculateTimeService calculateTimeService;

    private static Logger logger = Logger.getLogger(CinemaService.class);

    public Movie addMovie(AddMovieControllerRequest movieRequest) {
        Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setMovieRate(movieRequest.getMovieRate());
        movie.setMovieType(movieRequest.getMovieType());
        movie.setMovieTime(movieRequest.getMovieTime());
        movieRepository.save(movie);

        logger.info("Save Movie Successful");

        return movie;
    }

    public Theatre addTheatre(AddTheatreControllerRequest theatreRequest) {
        Theatre theatre = new Theatre();
        theatre.setTheatreType(theatreRequest.getTheatreType());
        theatreRepository.save(theatre);

        logger.info("Save Theatre Successful");

        return theatre;
    }

    public Show addShow(AddShowcontrollerRequest showRequest) throws InvalidParameterException {
        Show thisShow = new Show();
        thisShow.setStartTime(showRequest.getStartTime());
        thisShow.setMovieId(showRequest.getMovieId());
        thisShow.setTheatreNo(showRequest.getTheatreNo());

        String endTime = calculateTimeService.getEndTime(showRequest);
        thisShow.setEndTime(endTime); //get start time and + movie time

        if(calculateTimeService.getStartTimeInMinute(thisShow)>1320||calculateTimeService.getEndTimeInMinute(thisShow,showRequest.getMovieId())>1320) {
            logger.error("Show time is out of Cinema working time");
            throw new InvalidParameterException("Show time is out of Cinema working time");
        }

        List<Show> showList = showRepository.findByTheatreNo(showRequest.getTheatreNo());
        for(Show oneShow : showList) {
            Range rng = new Range(calculateTimeService.getStartTimeInMinute(oneShow),calculateTimeService.getEndTimeInMinute(oneShow,oneShow.getMovieId()));
            if(rng.contains(calculateTimeService.getStartTimeInMinute(thisShow))) {
                logger.error("Show time has already exist and can't be added");
                throw new InvalidParameterException("Show time has already exist and can't be added");
            } else if(rng.contains(calculateTimeService.getEndTimeInMinute(thisShow,showRequest.getMovieId()))) {
                logger.error("Show time has already exist and can't be added");
                throw new InvalidParameterException("Show time has already exist and can't be added");
            } else if(Math.abs(calculateTimeService.getStartTimeInMinute(thisShow)-calculateTimeService.getEndTimeInMinute(oneShow,oneShow.getMovieId()))<15) {
                logger.error("Duration between show time must be > 15 Minutes");
                throw new InvalidParameterException("Duration between show time must be > 15 Minutes");
            } else if(Math.abs(calculateTimeService.getEndTimeInMinute(thisShow,showRequest.getMovieId())-calculateTimeService.getStartTimeInMinute(oneShow))<15) {
                logger.error("Duration between show time must be > 15 Minutes");
                throw new InvalidParameterException("Duration between show time must be > 15 Minutes");
            }
        }

        showRepository.save(thisShow);
        logger.info("Save Show Successful");

        return thisShow;
    }



}
