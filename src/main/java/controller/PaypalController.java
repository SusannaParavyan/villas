package controller;

import dao.PaypalService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentStatusCodeType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PaypalController extends AbstractController {

    Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "/paypal", method = RequestMethod.GET)
    public String paypalRedirect(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        //Get orderInfo
        //OrderInfo orderInfo = OrderInfoService.getOrderInfoFromRequest(request);
        //logger.info("Get orderInfo from request: orderInfo=" + orderInfo.toString());
        //model.put("orderInfo", orderInfo);

        logger.info("In paypalRedirect method");

        //get price value from request
        double price = Double.parseDouble(request.getParameter("price"));
        logger.info("Get price value from request: price = " + price);


        //setExpressCheckout();
        SetExpressCheckoutResponseType setExpressCheckoutResponse = PaypalService.setExpressCheckout(price);
        logger.info("In paypalRedirect method: setExpressCheckout finished");

        //get token
        String token = setExpressCheckoutResponse.getToken();
        logger.info("SetExpressCheckoutResponse: token = " + token);

        return "redirect:https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=" + token;
    }

    /*
 @RequestMapping(value="/success", method = RequestMethod.POST)
 public String successPayPost(HttpServletRequest request, HttpServletResponse response){
     logger.info("in successPayPost()");
     logger.info("Request:"+request.getRequestURI());
     return "success";
 }
                              */
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String successPay(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("In successPay()");

        String token = request.getParameter("token");
        logger.info("Get token from URL: token = " + token);

        String payerId = request.getParameter("PayerId");
        logger.info("Get PayerId from URL: PayerId = " + payerId);

        //getExpressCheckout();
        GetExpressCheckoutDetailsResponseType getExpressCheckoutDetailsRequest = PaypalService.getExpressCheckout(token);
        logger.info("getExpressCheckout finished");

        //get tokenAfter and payerId and doExpressCheckout();
        String tokenAfter = getExpressCheckoutDetailsRequest.getGetExpressCheckoutDetailsResponseDetails().getToken();
        logger.info("GetExpressCheckout: tokenAfter = " + tokenAfter);

        String payerIdAfter = getExpressCheckoutDetailsRequest.getGetExpressCheckoutDetailsResponseDetails().getPayerInfo().getPayerID();
        logger.info("GetExpressCheckout: payerIdAfter = " + payerIdAfter);

        //get price
        PaymentDetailsType paymentDetailsType = getExpressCheckoutDetailsRequest.getGetExpressCheckoutDetailsResponseDetails().getPaymentDetails().get(0);
        double itemPrice = Double.parseDouble(paymentDetailsType.getItemTotal().getValue());
        model.put("price", itemPrice);

        //doExpressCheckout();
        DoExpressCheckoutPaymentResponseType doExpressCheckout = PaypalService.doExpressCheckout(tokenAfter, payerIdAfter, itemPrice);
        logger.info("doExpressCheckout finished");

        DoExpressCheckoutPaymentResponseDetailsType type = doExpressCheckout.getDoExpressCheckoutPaymentResponseDetails();

        //check if payment was completed succesfully
        if (type != null) {
            PaymentInfoType paymentInfo = type.getPaymentInfo().get(0);
            if (paymentInfo.getPaymentStatus().equals(PaymentStatusCodeType.COMPLETED) ||
                    paymentInfo.getPaymentStatus().equals(PaymentStatusCodeType.PENDING)) {
                logger.info("Payment completed.");
                return "success";
            } else {
                logger.info("Payment not completed.. (" + paymentInfo.getPaymentStatus() + ")");
                return "cancel";
            }
        } else {
            logger.info("Problem executing DoExpressCheckoutPayment.. Maybe you tried to process an ExpressCheckout that has already been processed.");
            return "cancel";
        }
    }


    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancelPay(ModelMap model) {
        return "cancel";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmPay(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("In confirmPay()");

        return "confirm";
    }
}

