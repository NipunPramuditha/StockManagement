package stock.demo.dto;

public class StockDTO extends SuperDTO {

    private String code;
    private String description;
    private String userID;
    private double unitPrice;
    private int qtyOnHand;
    private String ImgLink;

    public StockDTO() {
    }

    public StockDTO(String ImgLink, String code, String description, double unitPrice, int qtyOnHand, String userID) {
        this.ImgLink = ImgLink;
        this.code = code;
        this.userID = userID;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getImgLink() {
        return ImgLink;
    }

    public void setImgLink(String imgLink) {
        ImgLink = imgLink;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString(){
        return "StockDTO{" +
                "code='" + code + '\'' +
                "ImgLink='" + ImgLink +
                ", unitPrice=" + unitPrice +
                ", userID=" + userID +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
