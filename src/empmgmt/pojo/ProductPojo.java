/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author saumy
 */
public class ProductPojo {

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ProductPojo(String productId, String productName, String productCompany, double productPrice, double ourPrice, int tax, int quantity, double total) {
        this.productId = productId;
        this.productName = productName;
        this.productCompany = productCompany;
        this.productPrice = productPrice;
        this.ourPrice = ourPrice;
        this.tax = tax;
        this.quantity = quantity;
        this.total=total;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     private String productId;
       private String productName;
         private String  productCompany;
         private double productPrice;
         private double ourPrice;
         private int tax;
         private int quantity;
         private double total;
         
    
}
