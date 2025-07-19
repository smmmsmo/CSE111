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
