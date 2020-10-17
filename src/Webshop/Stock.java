import java.util.HashSet;
import java.util.Set;

public class Stock extends Products {

    private final int minAmount;

    public Stock(int minAmount) {
        this.minAmount = minAmount;
    }

    public Stock(Products products) {
        super(products);
        this.minAmount = 10;
    }

    public Set<Product> lowOnStock() {
        Set<Product> ps = new HashSet<>();
        for (Product p : products()) {
            if (isLowOnStock(p)) {
                ps.add(p);
            }
        }
        return ps;
    }

    private boolean isLowOnStock(Product p) {
        return getCount(p) < minAmount;
    }


}
