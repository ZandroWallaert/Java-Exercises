import java.util.HashMap;
import java.util.Map;

public class Shop {

    private Stock stock;

    private Map<Customer, Cart> activeCarts;

    private double revenue = 0.0;

    public Shop() {
        stock = new Stock(5);
        activeCarts = new HashMap<>();
    }

    public Stock getStock() {
        return new Stock(stock);
    }

    private Cart getCart(Customer customer) {
        if (!hasActiveCart(customer)) {
            createCart(customer);
        }
        return activeCarts.get(customer);
    }

    private boolean hasActiveCart(Customer customer) {
        return activeCarts.containsKey(customer);
    }

    private void createCart(Customer customer) {
        activeCarts.put(customer, new Cart());
    }

    public StockAndCart getStockAndCart(Customer customer) {
        return new StockAndCart(getStock(), getCart(customer));
    }

    public Cart buy(Customer customer) {
        Cart cart = activeCarts.remove(customer);

        revenue += cart.getPrice();

        return cart;
    }

    public void dropCartOf(Customer customer) {
        Products cart = activeCarts.remove(customer);
        stock.add(cart);
    }

    public void addToCart(Customer customer, Product product) {
        try {
            stock.remove(product);
            getCart(customer).add(product);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(String.format("%s is no longer available.", product));
        }
    }

    public void removeFromCart(Customer customer, Product product) {
        try {
            getCart(customer).remove(product);
            stock.add(product);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(String.format("%s has no %s it his/her cart.", customer, product));
        }

    }

    public void restock(Products stock) {
        this.stock.add(stock);
    }
}
