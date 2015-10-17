/*
 * Product.java 1.0  17/10/2015
 *
 * Murach (c) Copyright 2015
*/
package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *  JavaBean models a product with a unique product code, description and price.
 * 
 *  Provides accessor for getting a price.
 * 
 * @author dpowell2
 */
public class Product implements Serializable {

    private String code;
    private String description;
    private double price;

    /**
     * Initialize product with empty strings and 0 price.
     */
    public Product() {
        code = "";
        description = "";
        price = 0;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Provided by developer to allow EL to grab and display in currency format
     * the product price
     * 
     * @return String in currency format 
     */
    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}