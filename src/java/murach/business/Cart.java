/*
 * Cart.java 1.0  17/10/2015
 *
 * Murach (c) Copyright 2015
 */
package murach.business;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * JavaBean models a shopping cart with ability to add and remove lineitems
 * 
 * @author dpowell2
 */
public class Cart implements Serializable {

  private ArrayList<LineItem> items;

  /**
   * Default constructor initializes an empty cart.
   */
  public Cart() {
    items = new ArrayList<LineItem>();
  }

  public ArrayList<LineItem> getItems() {
    return items;
  }

  public int getCount() {
    return items.size();
  }

  /**
   * If an item is already in the cart then update the quantity. If not in cart
   * then add it to the cart.
   * 
   * @param item  LineItem of product to be added to cart
   */
  public void addItem(LineItem item) {
    String code = item.getProduct().getCode();
    int quantity = item.getQuantity();
    for (LineItem cartItem : items) {
      if (cartItem.getProduct().getCode().equals(code)) {
        cartItem.setQuantity(quantity);
        return;
      }
    }
    items.add(item);
  }

  /**
   * Remove  Lineitem from shopping cart.
   * @param item  LineItem to remove
   * 
   */
  public void removeItem(LineItem item) {
    String code = item.getProduct().getCode();
    for (int i = 0; i < items.size(); i++) {
      LineItem lineItem = items.get(i);
      if (lineItem.getProduct().getCode().equals(code)) {
        items.remove(i);
        return;
      }
    }
  }
}
