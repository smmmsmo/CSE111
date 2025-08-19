public class Borrower {
    public static int book_count[] = { 3, 3, 3 };
    public static String book_name[] = { "Pather Panchali", "Durgesh Nandini", "Anandmath" };

    public String name;

    public Borrower(String newName){
        this.name = newName;
    }

    public static void bookStatus() {
        System.out.println("Available Books: ");
        for (int i = 0; i < book_count.length; i++) {
            System.out.println(book_name[i] + ":" + book_count[i]);
        }
    }

public void borrowBook(String bookName){
    if(bookName == "Pather Panchali"){
        book_count[0] -= 1; 
    } else if (bookName =="Durgesh Nandini"){
        book_count[1] -= 1; 
    } else if (bookName=="Anandmath"){
        book_count[2] -= 1; }
}
public void borrowerDetails(){
    System.out.println("Name: " + this.name);
    System.out.println("Books Borrowed: 
}

}
