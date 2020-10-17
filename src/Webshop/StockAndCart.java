public class StockAndCart {

    private Stock stock;
    private Cart cart;

    public StockAndCart(Stock stock, Cart cart) {
        this.stock = stock;
        this.cart = cart;
    }

    public Stock getStock() {
        return stock;
    }

    public Cart getCart() {
        return cart;
    }
}
