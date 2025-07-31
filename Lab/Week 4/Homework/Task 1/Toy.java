public class Toy {

    String name;
    int price;

    public Toy(String name, int price) {
        this.name = name;
        this.price = price;
        System.out.println("A new toy has been made!");
    }

    public void updatePrice(int newPrice) {
        this.price = newPrice;
    }

    public void updateName(String newName) {
        System.out.println("Changing old name : " + this.name);
        this.name = newName;
        System.out.println("New name: " + this.name);
    }

    public void showPrice() {
        System.out.println("price: " + this.price + " Taka");
    }

}