package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class AbstractController {
    protected Logger logger = Logger.getLogger(getClass());

}
