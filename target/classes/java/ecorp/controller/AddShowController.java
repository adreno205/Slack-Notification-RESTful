package ecorp.controller;

import ecorp.domain.AddMovieControllerRequest;
import ecorp.domain.AddShowcontrollerRequest;
import ecorp.repository.entity.Movie;
import ecorp.repository.entity.Show;
import ecorp.service.CinemaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.InvalidParameterException;

@RestController
public class AddShowController {

    @Autowired
    private CinemaService cinemaService;

    private static Logger logger = Logger.getLogger(AddShowController.class);

    @RequestMapping(value = "/addshow",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public Show addShowController(@RequestBody AddShowcontrollerRequest showRequest) throws InvalidParameterException {
        logger.info("ADD Show to Database ");
        return cinemaService.addShow(showRequest);
    }
}
