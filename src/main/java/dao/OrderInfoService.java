package dao;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class OrderInfoService {
    Logger logger = Logger.getLogger(OrderInfoService.class);

    public static OrderInfo getOrderInfoFromRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("e-mail");
        String startDate = request.getParameter("start-date");
        String finishDate = request.getParameter("finish-date");
        int guestCount = Integer.parseInt(request.getParameter("guest-count"));
        int childrenCount = Integer.parseInt(request.getParameter("children-count"));
        String promoCode = request.getParameter("promo-Code");
        double fullPrice = Double.parseDouble(request.getParameter("full-price"));
        double payPrice = Double.parseDouble(request.getParameter("price"));


        if (name == null || name.isEmpty())
            name = "";
        if (email == null || email.isEmpty())
            email = "";
        if (startDate == null || startDate.isEmpty())
            startDate = "";
        if (finishDate == null || finishDate.isEmpty())
            finishDate = "";
        if (promoCode == null || promoCode.isEmpty())
            promoCode = "";



        OrderInfo orderInfo = new OrderInfo(name, email, startDate,
                finishDate, guestCount, childrenCount, promoCode, fullPrice, payPrice);
        return orderInfo;
    }

}
