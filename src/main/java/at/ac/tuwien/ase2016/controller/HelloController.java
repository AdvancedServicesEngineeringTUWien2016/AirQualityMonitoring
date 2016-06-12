package at.ac.tuwien.ase2016.controller;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DanielHofer on 12.06.2016.
 */


@RestController
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getCounter() throws Exception {

        return new String("hello");
    }



}
