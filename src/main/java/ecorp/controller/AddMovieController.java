package ecorp.controller;

import ecorp.domain.AddMovieControllerRequest;
import ecorp.repository.entity.Movie;
import ecorp.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

@RestController
public class AddMovieController {

    @Autowired
    private CinemaService cinemaService;

    private static Logger logger = Logger.getLogger(AddMovieController.class);

    @RequestMapping(value = "/addmovie",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public Movie addMovieController(@RequestBody AddMovieControllerRequest movieRequest) {
        logger.info("ADD Movie to Database ");
        return cinemaService.addMovie(movieRequest);
    }
}
