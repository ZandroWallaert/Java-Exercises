public class Cart extends Products {

    public double getPrice() {
        double total = 0.0;

        for (Product p : products()) {
            total += getProductPrice(p);
        }

        return total;
    }

    private double getProductPrice(Product p) {
        return p.getPrice() * getCount(p);
    }
}
