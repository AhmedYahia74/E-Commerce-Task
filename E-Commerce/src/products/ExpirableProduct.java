package products;

import java.time.LocalDate;

public class ExpirableProduct{
    LocalDate expirationDate;
    public ExpirableProduct(LocalDate expirationDate){
        this.expirationDate=expirationDate;
    }
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}
