package ecorp.controller; /**
 * Created by ratchasit.amo on 10/11/2016.
 */

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index(){
        return "This is Default Page";
    }

    @RequestMapping("/test")
    public String test(){
        return "Welcome to Cinema World";
    }

    @RequestMapping(value="/{name}/{last}", method = RequestMethod.GET)
        String testPath(@PathVariable String name, @PathVariable("last") String l){
        return "Hail, " + name +" "+ l;
    }

}
