package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/index")
public class IndexController extends AbstractController{
    @RequestMapping(method = RequestMethod.GET)
    public String initializeView(ModelMap model) {
        //TODO get booked dates from database
        return "index";
    }


}
