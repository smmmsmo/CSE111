public class Reader{
  public String name = "New User";
  public int cap = 0;
  public String [] books;
  public int count=0;
  public void createReader(String n, int c){
    name = n;
    cap = c;
    books = new String[cap];
  }
  public void addBook(String bk){
//    for(int i =0; i < books.length; i++){
//      books[i] = bk;
//    } 
    if(count < books.length){
      books[count] = bk;
      count++;
    }
    else{
      System.out.println("No more space for new book");
    }
  }
  public void readerInfo(){
    System.out.println("Name: " + name);
    System.out.println("Capacity: " + cap);
    System.out.println("Books: ");
    if(count == 0){ 
      System.out.println("No books added yet");
    }
    else{
//      for(int i = 0; i < count; i++){
//        System.out.println(books[i]);
//      }
      for(int i = 0; i < books.length; i++){
        if(books[i] != null){
          System.out.println("Book " + (i+1) +": "+books[i]);
        }
      }
    }
  }
  public void increaseCapacity(int num){
    cap = num;
    System.out.println(name+"'s capacity increased to "+num);
    String [] temp = new String[cap];
//    temp = books;
    for(int i = 0; i < books.length; i++){
      temp[i] = books[i];
    }
//    for(int i = 0; i < count; i++){
//      temp[i] = books[i];
//    }
    books = temp;
  }
  
}















