package products;

public class ScratchCard implements Product{
    private String name;
    private double price;
    private int quantity;

    public ScratchCard(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        name=getClass().getSimpleName();
    }

    @Override
    public String getName() {
        return name;
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
