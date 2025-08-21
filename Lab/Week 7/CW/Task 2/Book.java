public class Book {

    public static int total_books_sold = 0;
    public static double total_revenue = 0.0;

    public String title;
    public double price;

    public Book(String title, int discount) {
        this.title = title;
        this.price = 150 - (150 * (discount / (double)100));
        total_books_sold++;
        total_revenue += this.price;
    }

    public void bookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Price after discount: " + this.price + " TK");
    }

}