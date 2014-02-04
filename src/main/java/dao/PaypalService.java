package dao;

import org.apache.log4j.Logger;
import urn.ebay.api.PayPalAPI.*;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaypalService {

    static Logger logger = Logger.getLogger(PaypalService.class);

    private static final int itemQuantity = 1;
    private static final String itemName = "Booking villas";
    private static final String currency = "THB";
    private static final String paymentAction = "Sale";
    private static final String successUrl = "http://codekomilfo.jelasticloud.com/success";
    private static final String cancelUrl = "http://codekomilfo.jelasticloud.com/cancel";
    private static final String version = "104.0";

    //API Credential
    private static final String mode = "sandbox";
    private static final String userName = "villas-test1_api1.gmail.com";
    private static final String password = "1391109341";
    private static final String signature = "AiPC9BjkCyDFQXbSkoZcgqH3hpacAziyMGD13Qf.ly2ssP2yLnUqsYCz";


    public static SetExpressCheckoutResponseType setExpressCheckout(double price) {
        logger.info("In SetExpressCheckout()");
        PaymentDetailsType paymentDetails = new PaymentDetailsType();
        paymentDetails.setPaymentAction(PaymentActionCodeType.fromValue(paymentAction));
        PaymentDetailsItemType item = new PaymentDetailsItemType();
        BasicAmountType amt = new BasicAmountType();
        amt.setCurrencyID(CurrencyCodeType.fromValue(currency));
        amt.setValue(String.valueOf(price));
        item.setQuantity(itemQuantity);
        item.setName(itemName);
        item.setAmount(amt);


        List<PaymentDetailsItemType> lineItems = new ArrayList<PaymentDetailsItemType>();
        lineItems.add(item);
        paymentDetails.setPaymentDetailsItem(lineItems);
        BasicAmountType orderTotal = new BasicAmountType();
        orderTotal.setCurrencyID(CurrencyCodeType.fromValue(currency));
        orderTotal.setValue(String.valueOf(price * itemQuantity));
        paymentDetails.setOrderTotal(orderTotal);
        List<PaymentDetailsType> paymentDetailsList = new ArrayList<PaymentDetailsType>();
        paymentDetailsList.add(paymentDetails);

        //SetExpressCheckout
        SetExpressCheckoutRequestDetailsType setExpressCheckoutRequestDetails = new SetExpressCheckoutRequestDetailsType();
        setExpressCheckoutRequestDetails.setReturnURL(successUrl);
        setExpressCheckoutRequestDetails.setCancelURL(cancelUrl);

        setExpressCheckoutRequestDetails.setPaymentDetails(paymentDetailsList);

        SetExpressCheckoutRequestType setExpressCheckoutRequest = new SetExpressCheckoutRequestType(setExpressCheckoutRequestDetails);
        setExpressCheckoutRequest.setVersion(version);

        SetExpressCheckoutReq setExpressCheckoutReq = new SetExpressCheckoutReq();
        setExpressCheckoutReq.setSetExpressCheckoutRequest(setExpressCheckoutRequest);

        Map<String, String> sdkConfig = new HashMap<String, String>();
        sdkConfig.put("mode", mode);
        sdkConfig.put("acct1.UserName", userName);
        sdkConfig.put("acct1.Password", password);
        sdkConfig.put("acct1.Signature",signature);
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(sdkConfig);
        SetExpressCheckoutResponseType setExpressCheckoutResponse = null;
        try {
            setExpressCheckoutResponse = service.setExpressCheckout(setExpressCheckoutReq);
        } catch (Exception e) {
            logger.info("Paypal SetExpressCheckoutPayment exception:" + e);
        }
        return setExpressCheckoutResponse;
    }

    public static GetExpressCheckoutDetailsResponseType getExpressCheckout( String token) {
        //GetExpressCheckout
        //token =   "EC-9J558947V9072782A";
        logger.info("In GetExpressCheckout()");
        GetExpressCheckoutDetailsRequestType getExpressCheckoutDetailsRequest = new GetExpressCheckoutDetailsRequestType(token);
        getExpressCheckoutDetailsRequest.setVersion(version);

        GetExpressCheckoutDetailsReq getExpressCheckoutDetailsReq = new GetExpressCheckoutDetailsReq();
        getExpressCheckoutDetailsReq.setGetExpressCheckoutDetailsRequest(getExpressCheckoutDetailsRequest);

        Map<String, String> sdkConfig = new HashMap<String, String>();
        sdkConfig.put("mode", mode);
        sdkConfig.put("acct1.UserName", userName);
        sdkConfig.put("acct1.Password", password);
        sdkConfig.put("acct1.Signature",signature);
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(sdkConfig);
        GetExpressCheckoutDetailsResponseType getExpressCheckoutDetailsResponse = null;
        try {
            getExpressCheckoutDetailsResponse = service.getExpressCheckoutDetails(getExpressCheckoutDetailsReq);
        } catch (Exception e) {
            logger.info("Paypal GetExpressCheckout exception:" + e);
        }
        return getExpressCheckoutDetailsResponse;
    }

    public static DoExpressCheckoutPaymentResponseType doExpressCheckout(String token, String payerId, double price) {
        //DoExpressCheckout
        logger.info("In DoExpressCheckout()");
        PaymentDetailsType paymentDetail = new PaymentDetailsType();
        paymentDetail.setNotifyURL("http://replaceIpnUrl.com");
        BasicAmountType orderTotal = new BasicAmountType();
        orderTotal.setValue(String.valueOf(price));
        orderTotal.setCurrencyID(CurrencyCodeType.fromValue(currency));
        paymentDetail.setOrderTotal(orderTotal);
        paymentDetail.setPaymentAction(PaymentActionCodeType.fromValue(paymentAction));
        List<PaymentDetailsType> paymentDetails = new ArrayList<PaymentDetailsType>();
        paymentDetails.add(paymentDetail);

        DoExpressCheckoutPaymentRequestDetailsType doExpressCheckoutPaymentRequestDetails = new DoExpressCheckoutPaymentRequestDetailsType();
        doExpressCheckoutPaymentRequestDetails.setToken(token);
        doExpressCheckoutPaymentRequestDetails.setPayerID(payerId);
        doExpressCheckoutPaymentRequestDetails.setPaymentDetails(paymentDetails);

        DoExpressCheckoutPaymentRequestType doExpressCheckoutPaymentRequest = new DoExpressCheckoutPaymentRequestType(doExpressCheckoutPaymentRequestDetails);
        doExpressCheckoutPaymentRequest.setVersion(version);

        DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq = new DoExpressCheckoutPaymentReq();
        doExpressCheckoutPaymentReq.setDoExpressCheckoutPaymentRequest(doExpressCheckoutPaymentRequest);

        Map<String, String> sdkConfig = new HashMap<String, String>();
        sdkConfig.put("mode", mode);
        sdkConfig.put("acct1.UserName", userName);
        sdkConfig.put("acct1.Password", password);
        sdkConfig.put("acct1.Signature", signature);
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(sdkConfig);
        DoExpressCheckoutPaymentResponseType doExpressCheckoutPaymentResponse = null;
        try {
            doExpressCheckoutPaymentResponse = service.doExpressCheckoutPayment(doExpressCheckoutPaymentReq);
        } catch (Exception e) {
            logger.info("Paypal DoExpresCheckout Exception:" + e);
        }
        return doExpressCheckoutPaymentResponse;
    }
}
