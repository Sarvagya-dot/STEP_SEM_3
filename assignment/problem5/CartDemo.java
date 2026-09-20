public class CartDemo {

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("getTotal() -> " + cart.getTotal());
        System.out.println("getItemCount() -> " + cart.getItemCount());
    }
}

class Cart {
    private double[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int index = 0; index < itemCount; index++) {
            total += prices[index];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }
}
