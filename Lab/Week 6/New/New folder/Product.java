public class Product {
    private String name;
    private double price;
    private int quantity;
    
    public Product() {
        this.name = "Unknown";
        this.price = 0.0;
        this.quantity = 0;
    }
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void displayInfo() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
    }
    
    public void displayInfo(boolean showQuantity) {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        if (showQuantity) {
            System.out.println("Quantity: " + quantity);
        }
    }
}
