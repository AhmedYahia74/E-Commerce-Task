import java.util.Objects;

public class Customer {
    private int id;
    private String email;
    private String password;
    private String address;
    private double accountBalance;

    public Customer(int id, String email, String password, String address, double accountBalance) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.address = address;
        this.accountBalance = accountBalance;
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
