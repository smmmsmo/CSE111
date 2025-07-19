public class Library {

    public int bookCapacity = 0;
    public String books[] = new String[100];
    public int bookCount = 0;

    public void setBookCapacity(int capacity) {
        this.bookCapacity = capacity;
    }

    public void addBook(String bookName) {
        if (bookCount < bookCapacity) {

            books[bookCount] = bookName;
            bookCount++;
            System.out.println("Book '" + bookName + "' added to the library.");
        } else {
            System.out.println("Exceeded maximum capacity.You cannot add more than " + bookCapacity + " books.");
        }

    }

    public void printDetail() {
        System.out.println("Maximum capacity: " + this.bookCapacity);
        System.out.println("Total books: " + this.bookCount);
        System.out.println("Books List: ");
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(books[i]);
            }
        }
    }

}
