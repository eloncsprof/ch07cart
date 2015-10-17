/*
 * ProductIO.java 1.0  17/10/2015
 *
 * Murach (c) Copyright 2015
*/
package murach.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import murach.business.Product;


/**
 * Class with static methods to get a specific product or all products from 
 * a file. The file file in in WEB-INF folder. Since read only it is accessible
 * to local Tomcat and OpenShift
 * 
 * @author dpowell2
 */
public class ProductIO {

  /**
   * Retrieves a specific product with the provided code or null if not
   * found
   * 
   * @param code String uniquely identifying a product
   * @param filepath - Full path of location of file containing product info
   * @return  Product with the given code or null
   */
  public static Product getProduct(String code, String filepath) {
    try {
      File file = new File(filepath);
      BufferedReader in = new BufferedReader(
        new FileReader(file));

      String line = in.readLine();
      while (line != null) {
        StringTokenizer t = new StringTokenizer(line, "|");
        String productCode = t.nextToken();
        if (code.equalsIgnoreCase(productCode)) {
          String description = t.nextToken();
          double price = Double.parseDouble(t.nextToken());
          Product p = new Product();
          p.setCode(code);
          p.setDescription(description);
          p.setPrice(price);
          in.close();
          return p;
        }
        line = in.readLine();
      }
      in.close();
      return null;
    } catch (IOException e) {
      System.err.println(e);
      return null;
    }
  }

  /**
   * Returns List of all Products in the supplied file address.
   * 
   * @param filepath String representing a  fully qualified file name
   * @return  ArrayList of Product with 0 or more Products.
   */
  public static ArrayList<Product> getProducts(String filepath) {
    ArrayList<Product> products = new ArrayList<Product>();
    File file = new File(filepath);
    try {
      BufferedReader in = new BufferedReader(
        new FileReader(file));

      String line = in.readLine();
      while (line != null) {
        StringTokenizer t = new StringTokenizer(line, "|");
        String code = t.nextToken();
        String description = t.nextToken();
        String priceAsString = t.nextToken();
        double price = Double.parseDouble(priceAsString);
        Product p = new Product();
        p.setCode(code);
        p.setDescription(description);
        p.setPrice(price);
        products.add(p);
        line = in.readLine();
      }
      in.close();
      return products;
    } catch (IOException e) {
      System.err.println(e);
      return null;
    }
  }
}
