package ecorp.service;

import ecorp.dao.SlackDaoRestImpl;
import ecorp.domain.AddSlackControllerRequest;
import ecorp.domain.SlackResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class MessageService {

    @Autowired
    private SlackDaoRestImpl slackDaoRest;

    private static Logger logger = Logger.getLogger(MessageService.class);

    public @ResponseBody
    SlackResponse addSlackNoti(AddSlackControllerRequest slackRequest) {

        String response = slackDaoRest.send(slackRequest);
        logger.info("Send slack notification Successful");

        return new SlackResponse(response);
    }

    public String addSlackNoti2(AddSlackControllerRequest slackRequest) {

        String response = slackDaoRest.sendExchange(slackRequest);
        logger.info("Send slack notification Successful");

        return response;
    }


}
