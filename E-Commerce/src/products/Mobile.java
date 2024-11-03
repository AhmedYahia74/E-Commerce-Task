package products;

public class Mobile implements Product, Shipping{
    private String name;
    private int quantity;
    private double price;
    private double weight;

    public Mobile(int quantity, double price, double weight) {
        name=getClass().getSimpleName();
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
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
