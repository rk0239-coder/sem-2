/*
 * ASSIGNMENT PROBLEM 5: The Shopping Cart
 *
 * Scenario:
 * An online store's cart holds the prices of items you're about to buy.
 *
 * Problem Statement:
 * Design a Cart class that stores item prices internally but only exposes
 * the total and item count - never direct access to the prices themselves.
 *
 * Requirements:
 * - Store item prices in a private array (assume a fixed maximum number of
 *   items).
 * - Provide a method to add an item's price to the cart.
 * - Provide a read-only total (sum of all prices) and a read-only item
 *   count - computed on request, not stored separately.
 * - Give the cart a final cart ID, fixed when it's created.
 *
 * Sample:
 *   Cart cart = new Cart("CART-5", 20);
 *   cart.addItem(250); cart.addItem(99); cart.addItem(151);
 *   cart.getTotal() -> 500
 *   cart.getItemCount() -> 3
 */
public class Cart {

    private final String cartId;
    private final double[] prices;
    private int itemCount;

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
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    // Deliberately no method returns the prices array itself.

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("getTotal() -> " + cart.getTotal() + " (expected 500.0)");
        System.out.println("getItemCount() -> " + cart.getItemCount() + " (expected 3)");
    }
}
