import products.ExpirableProduct;
import products.Shipping;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart(){
        items=new ArrayList<>();
    }
    public Cart(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if (item.getProduct().getQuantity() < item.getQuantity()) {
            throw new RuntimeException(STR."amount of \{item.getProduct().getName()} not enough");
        } else if (item.getProduct() instanceof ExpirableProduct && ((ExpirableProduct) item.getProduct()).isExpired()) {
            throw new RuntimeException(item.getProduct().getName()+" is expired");
        } else {
            item.getProduct().setQuantity(-1*item.getQuantity());
            items.add(item);
        }
    }
    public void removeItem(Item item) {
        item.getProduct().setQuantity(item.getQuantity());
        items.remove(item);
    }
    public double getTotalPrice() {
        double price = 0;
        for (Item item : items) {
            price += item.getProduct().getPrice()*item.getQuantity();
        }
        return price;
    }
    public double getShippingFees() {
        double price = 0;
        for (Item item : items) {
            if (item instanceof Shipping) {
                price += ((Shipping) item).getWeight() * 2;
            }
        }
        return price;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }

    public List<Item> getItems() {
        return items;
    }
}
