/*
 * LineItem.java 1.0  17/10/2015
 *
 * Murach (c) Copyright 2015
*/
package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 * JavaBean models a lineitem made up of a product and quantity.
 * Method to return total price in currency format.
 * 
 * @author dpowell2
 */
public class LineItem implements Serializable {

    private Product product;
    private int quantity;

    
    public LineItem() {
      //intentionally empty
    }

    public void setProduct(Product p) {
        product = p;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        double total = product.getPrice() * quantity;
        return total;
    }

    /**
     * Getter method provided to allow EL access to total cost of line item
     * for currency format of total cost
     * 
     * @return String currency value
     */
    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}