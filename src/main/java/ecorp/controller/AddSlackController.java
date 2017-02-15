package ecorp.controller;

import ecorp.domain.AddSlackControllerRequest;
import ecorp.domain.SlackResponse;
import ecorp.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddSlackController {

    @Autowired
    private MessageService messageService;

    private static Logger logger = Logger.getLogger(AddSlackController.class);
    //V1 use postObject for send Request
    @RequestMapping(value = "/v1/addslack",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public @ResponseBody
    SlackResponse addSlackMsg(@RequestBody AddSlackControllerRequest slackRequest) {
        logger.info("Sending Slack Notification");
        return messageService.addSlackNoti(slackRequest);
    }
    //V2 use exchange for send Request
    @RequestMapping(value = "/v2/addslack",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)

    public String addSlackMsg2(@RequestBody AddSlackControllerRequest slackRequest) {
        logger.info("Sending Slack Notification");
        return messageService.addSlackNoti2(slackRequest);
    }
}
