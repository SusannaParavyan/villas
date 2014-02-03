package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PayController extends AbstractController {

    Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "/pay")
    public String initializeViewMode(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("In PayController initializeViewMode()");

        String mode = request.getParameter("mode");
        logger.info("Get mode value from request: mode = " + mode);

        if (mode.equals("card"))
            return "forward:/paypal";
        else if (mode.equals("payment"))
            return "payment";
        return "index";
    }

    @RequestMapping(value = "/payment")
    public String initPayment() {
        return "index";
    }


}