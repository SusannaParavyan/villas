package dao;

public class OrderInfo {
    private String name;
    private String email;
    private String startDate;
    private String finishDate;
    private int guestCount;
    private int childrenCount;
    private String promoCode;
    private double fullPrice;
    private double payPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(double payPrice) {
        this.payPrice = payPrice;
    }

    public OrderInfo() {
        super();
    }

    public OrderInfo(String name, String email, String startDate,
                     String finishDate, int guestCount, int childrenCount,
                     String promoCode, double fullPrice, double payPrice) {
        super();
        this.name = name;
        this.email = email;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.guestCount = guestCount;
        this.childrenCount = childrenCount;
        this.promoCode = promoCode;
        this.fullPrice = fullPrice;
        this.payPrice = payPrice;
    }


    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("OrderInfo: ");
        result.append("name = ").append(name);
        result.append("/t email = ").append(email);
        result.append("/t startDate = ").append(startDate);
        result.append("/t finishDate = ").append(finishDate);
        result.append("/t guestCount = ").append(guestCount);
        result.append("/t childrenCount = ").append(childrenCount);
        result.append("/t promoCode = ").append(promoCode);
        result.append("/t fullPrice = ").append(fullPrice);
        result.append("/t payPrice = ").append(payPrice);
        return result.toString();
    }
}
