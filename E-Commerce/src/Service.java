import products.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<Customer> customers;
    public Cheese cheese;
    public Mobile mobile;
    public ScratchCard scratchCard;

    public void init() {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "meshahmed@gmail.com", "123", "cairo", 10000));
        customers.add(new Customer(2, "a@gmail.com", "123", "cairo", 10000));
        cheese = new Cheese(1, 34.5, .200, LocalDate.ofYearDay(2025, 4));
        mobile = new Mobile(12, 5400, .450);
        scratchCard = new ScratchCard(200, 22);
    }

    public Customer login(String email, String password) {
        Customer temp = new Customer(email, password);
        for (Customer customer : customers) {
            if (customer.equals(temp)) {
                return customer;
            }
        }
        return null;
    }

    public double getSubTotal(Cart cart) {
        return cart.getTotalPrice();
    }

    public double getShippingFees(Cart cart) {
        return cart.getShippingFees();
    }

    public List<Shipping> getShippingProducts(Cart cart) {
        List<Shipping> res = new ArrayList<>();
        for (Item item : cart.getItems()) {
            if (item.getProduct() instanceof Shipping)
                res.add((Shipping) item.getProduct());
        }
        return res;
    }

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new RuntimeException("cart is empty");
        }
        double subTotal = getSubTotal(cart);
        double shippingFees = getShippingFees(cart);
        double paidAmount = subTotal + shippingFees;
        if (paidAmount > customer.getAccountBalance()) {
            throw new RuntimeException("customer balance not enough");
        }
        customer.setAccountBalance(customer.getAccountBalance() - paidAmount);
        List<Shipping> shippingProducts = getShippingProducts(cart);

        if (!shippingProducts.isEmpty()) {
            ShippingService shippingService = new ShippingService(shippingProducts);
            System.out.println("** Shipment notice **");

            for (Item item : cart.getItems()) {
                if (item.getProduct() instanceof Shipping) {
                    System.out.println(STR."\{item.getQuantity()}X \{item.getProduct().getName()}        \{((Shipping) item.getProduct()).getWeight()}kg");
                }
            }
        }
        System.out.println("** Checkout Receipt **");
        for (Item item : cart.getItems()) {
            System.out.println(STR."\{item.getQuantity()}X \{item.getProduct().getName()}        \{item.getProduct().getPrice()}");
        }
        System.out.println("----------------------");
        System.out.println(STR."Subtotal         \{subTotal}");
        System.out.println(STR."Shipping         \{shippingFees}");
        System.out.println(STR."Amount           \{paidAmount}");
        System.out.println(STR."Customer Balance \{customer.getAccountBalance()}");
    }

    public void test1() {//happy flow
        Customer customer = login("a@gmail.com", "123");
        Cart cart = new Cart();
        cart.addItem(new Item(cheese, 1));
        cart.addItem(new Item(mobile, 1));
        cart.addItem(new Item(scratchCard, 1));
        checkout(customer, cart);
    }

    public void test2(){//Cart is empty
        Customer customer = login("a@gmail.com", "123");
        Cart cart = new Cart();
        checkout(customer, cart);
    }
    public void test3(){//The customer's balance is insufficient.
        Customer customer = login("a@gmail.com", "123");
        Cart cart = new Cart();
        cart.addItem(new Item(mobile, 2));
        checkout(customer, cart);
    }
    public void test4() {//one product is out of stock or expired.
        Customer customer = login("a@gmail.com", "123");
        Cart cart = new Cart();
        Cheese expiredCheese = new Cheese(1, 2, 43, LocalDate.of(2020,7,6));
        cart.addItem(new Item(expiredCheese, 1));
        checkout(customer, cart);
    }
}
