package stock.demo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Stock extends SuperEntity{

    @Id
    private String code;
    private String userID;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    private String file_upload;

    public Stock() {
    }

    public Stock(String file_upload, String code, String description, double unitPrice, int qtyOnHand, String userID) {
        this.file_upload = file_upload;
        this.code = code;
        this.userID = userID;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getFile_upload() {
        return file_upload;
    }

    public void setFile_upload(String file_upload) {
        this.file_upload = file_upload;
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
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                "file_upload='" + file_upload +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", userID=" + userID +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }

}
