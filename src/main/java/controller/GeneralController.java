package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController extends AbstractController {
    @RequestMapping(value = "/about")
    public String aboutView() {
        return "about";
    }

    @RequestMapping(value = "/contact-us")
    public String contactUsView() {
        return "contact-us";
    }

    @RequestMapping(value = "/fastfood")
    public String fastfoodView() {
        return "fastfood";
    }

    @RequestMapping(value = "/location")
    public String locationView() {
        return "location";
    }

    @RequestMapping(value = "photo")
    public String photoView() {
        return "photo";
    }

    @RequestMapping(value = "phuket")
    public String phuketView() {
        return "phuket";
    }

    @RequestMapping(value = "price")
    public String priceView() {
        return "price";
    }

    @RequestMapping(value = "service")
    public String serviceView() {
        return "service";
    }
}
