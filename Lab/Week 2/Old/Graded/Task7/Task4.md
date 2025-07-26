# Task 4

## CellPhone Class

```java
public class CellPhone {

    public String model;
    public int contactCount = 0;
    public String ContactStore;
    public String contactSave;
    
    public void printDetails() {
      if(model == null){
        System.out.println("Phone Model unknown");
      } else {
        System.out.println("Phone Model " + model);
      } 
      
      if(contactCount == 0){
          System.out.println("Contacts Stored 0");
      } else if (contactCount == 4){
          System.out.println("Memory full. New contact can't be stored.");
      } else {
          System.out.println("Contacts Stored "+ contactCount);
      }
        
        
      if(contactSave != null){
          System.out.println(contactSave);  
      }
    }

    public void storeContact(String contact){
        System.out.println("Contact Stored");
        contactCount++;
        contactSave = contact;
    }

}
```

## CellPhoneTester Class

```java
public class CellPhoneTester {
  public static void main(String[] args) {
    CellPhone phone1 = new CellPhone();
    phone1.printDetails();
    phone1.model = "Nokia 1100";
    System.out.println("1##################");
    phone1.storeContact("Joy - 01834");
    System.out.println("===================");
    phone1.printDetails();
    System.out.println("2##################");
    phone1.storeContact("Toya - 01334");
    phone1.storeContact("Aayan - 01135");
    System.out.println("===================");
    phone1.printDetails();
    System.out.println("3##################");
    phone1.storeContact("Sani - 01441");
    System.out.println("===================");
    phone1.printDetails();
  }
}
```

## Output

```
Phone Model unknown
Contacts Stored 0
1##################
Contact Stored
===================
Phone Model Nokia 1100
Contacts Stored 1
Joy - 01834
2##################
Contact Stored
Contact Stored
===================
Phone Model Nokia 1100
Contacts Stored 3
Aayan - 01135
3##################
Contact Stored
===================
Phone Model Nokia 1100
Memory full. New contact can't be stored.
Sani - 01441
```
