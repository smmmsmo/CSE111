//THIS IS AN EXAMPLE CLASS INCLUDING A COMPILATION OF CODES OF POSSIBLE CASES
//THESE METHODS and VARIABLES SHOULD BE USED/MODIFIED BASED ON QUESTION
//THERE CAN BE OTHER CASES WHICH ARE NOT COVERED IN THIS CLASS FILE

public class Examples {
  public String name;
  public int id;
  public String [] items = new String[3];
  public int [] prices = new int[3];
  public int count;
  //different array case
  public String [] arr;
  int capacity;
  int count2;

  //types of constructor
  public Examples(){
    //if default values are required for non-parameterized cases
    name = "Unknown";
    id = -1;
  }
  public Examples(String name, int id){
    //setting values to instance variables
    this.name = name;
    this.id = id;
  }
  public Examples(String name, int id, int cap){
    //setting values to instance variables
    //applicable for cases where array length differs between objects
    this.name = name;
    this.id = id;
    this.capacity = cap;
    arr = new String[capacity];
  }
  public Examples(String name, int id, String itm){
    //setting values to instance variables
    this.name = name;
    this.id = id;

    //adding a pair of values to two arrays
    if(count < items.length){
      items[count] = itm;
      count++;
      System.out.println(itm + " was added.");
    }
    else {
      System.out.println("Limit exceeded.");
    }

    //ALTERNATIVE APPROACH to adding to an array
//    add(itm);
  }


  //array population
  public void add(String itm){
    //adding a value to an array
    if(count < items.length){
      items[count] = itm;
      count++;
      System.out.println(itm + " was added.");
    }
    else {
      System.out.println("Limit exceeded.");
    }
  }
  public void add(String [] itm){
    //adding values to an array from received array
    for (int i = 0; i < itm.length; i++) {
      if (count < items.length){
        items[count] = itm[i];
        count++;
      }
      else {
        System.out.println("Limit exceeded.");
        break;
      }
    }
  }
  public void add(String itm, int price){
    //adding a pair of values to two arrays
    if(count < items.length){
      items[count] = itm;
      prices[count] = price;
      count++;
      System.out.println(itm + " was added.");
    }
    else {
      System.out.println("Limit exceeded.");
    }
  }
  public void add(String itm, int price, String itm2, int price2) {
    //adding two pairs of values to two arrays
    if (count < items.length - 1) {
      items[count] = itm;
      prices[count] = price;
      count++;
      System.out.println(itm + " was added.");
      items[count] = itm2;
      prices[count] = price2;
      count++;
      System.out.println(itm2 + " was added.");
    } else if (count == items.length - 1) {
      items[count] = itm;
      prices[count] = price;
      count++;
      System.out.println(itm + " was added.");
      System.out.println("Limit exceeded.");
    } else {
      System.out.println("Limit exceeded.");
    }
    //ALTERNATIVE APPROACH
//    if (count < items.length - 1) {
//      add(itm, price);
//      add(itm2, price2);
//    }
//    else if (count == items.length - 1) {
//      add(itm, price);
//      System.out.println("Limit exceeded.");
//    } else {
//      System.out.println("Limit exceeded.");
//    }
  }


  //searching item in an array
  public int find(String itm){
    //finds the index of passed value, if not found returns -1
    int idx = -1;
    for (int i = 0; i < items.length; i++) {
      if (items[i].equals(itm)){
        idx = i;
        break;
      }
    }
    return idx;
  }

  //Removing from array
  public void remove(String itm){
    //remove an item from an array
    int idx = -1;
    for (int i = 0; i < items.length; i++) {
      if (items[i].equals(itm)){
        idx = i;
        break;
      }
    }
    if (idx == -1){
      System.out.println("Item not found");
    }
    else {
      System.out.println(itm + " was removed");
      items[idx] = null;
    }
  }
  public void removal(String itm){
    //remove a pair of items from two array
    int idx = -1;
    for (int i = 0; i < items.length; i++) {
      if (items[i].equals(itm)){
        idx = i;
        break;
      }
    }
    if (idx == -1){
      System.out.println("Item not found");
    }
    else {
      System.out.println(itm + " was removed");
      items[idx] = null;
      prices[idx] = 0;
    }
  }
  //Array population: adding to array if there is removal from random index
  public void adding(String itm, int price){
    //adding a pair of values to two arrays
    boolean added = false;
    for (int i = 0; i < items.length; i++) {
      if (items[i] == null){
        items[i] = itm;
        prices[i] = price;
        count++;
        System.out.println(itm + " was added.");
        break;
      }
    }
    if (added == false){
      System.out.println("Limit exceeded.");
    }
  }

  //printing
  public void printDetails(){
    //printing with two arrays of equal length and item count
    System.out.println("Name: "+name+", ID: "+id);
    if (count > 0){
      System.out.println("Item list: ");
      for (int i = 0; i < items.length; i++) {
        if (items[i] != null){
          System.out.println(items[i] + " : " + prices[i]);
        }
      }
    }
  }

  public String details(){
    //returns all details as a String
    String st = "Name: " + name+", ID: "+id+"\n"; //"\n" is used for line break
    if (count > 0){
      st += "Item list: \n";
      for (int i = 0; i < items.length; i++) {
        if (items[i] != null){
          st += items[i] + " : " + prices[i] +"\n";
        }
      }
    }
    return st;
  }

}
