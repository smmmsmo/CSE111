public class Cart {

    public int cartId;
    public String itemNames[] = new String[4];
    public double itemPrices[] = new double[4];
    public int itemCount = 0;
    public double discount = 0.0;

    public void create_cart(int id) {
        this.cartId = id;
    }

    public void addItem(String name, double price) {
        if (itemCount < 3) {
            itemNames[itemCount] = name;
            itemPrices[itemCount] = price;
            itemCount++;
            System.out.println(name + " added to cart " + cartId + ".");
            System.out.println("You have " + itemCount + " item(s) in your cart now.");
        } else {
            System.out.println("You already have 3 items on your cart");
        }
    }

    public void addItem(double price, String name) {
        addItem(name, price);
    }

    public void giveDiscount(double discount) {
        this.discount = discount;
    }

    public void cartDetails() {
        System.out.println("Your cart(c" + cartId + ") : ");
        double total = 0.0;

        for (int i = 0; i < itemCount; i++) {
            System.out.println(itemNames[i] + " - " + itemPrices[i]);
            total += itemPrices[i];
        }

        System.out.println("Discount Applied: " + discount + "%");
        double discountedTotal = total - (total * (discount / 100.0));
        System.out.println("Total price: " + discountedTotal);
    }
}