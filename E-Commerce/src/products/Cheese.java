package products;

import java.time.LocalDate;

public class Cheese extends ExpirableProduct implements Shipping, Product {
    private String name;
    private int quantity;
    private double price;
    private double weight;

    public Cheese(int quantity, double price, double weight,LocalDate expirationDate) {
        super(expirationDate);
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        name=getClass().getSimpleName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }

  public void setQuantity(int amount){
        quantity+=amount;
  }

}
