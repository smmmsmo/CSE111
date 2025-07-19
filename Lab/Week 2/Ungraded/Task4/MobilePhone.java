
public class MobilePhone {
    public int capacity = 0;
    public String[] name;
    public int[] number;
    public int contactCount = 0;

    public void setContactCapacity(int capacity) {
        this.capacity = capacity;
        name = new String[capacity];
        number = new int[capacity];
    }

    public void addContact(String contactName, int contactNumber) {
        if (contactCount < capacity) {
            name[contactCount] = contactName;
            number[contactCount] = contactNumber;
            contactCount++;
            System.out.println("The contact of " + contactName + " is added.");
        } else {
            System.out.println("Storage Full!!");
        }
    }

    public void details() {
        System.out.println("Total Contacts: " + contactCount);
        System.out.println("Contact List:");
        for (int i = 0; i < contactCount; i++) {
            System.out.println(name[i] + ":" + number[i]);
        }
    }

    public void makeCall(int phoneNumber) {
        boolean found = false;
        for (int i = 0; i < contactCount; i++) {
            if (number[i] == phoneNumber) {
                System.out.println("Calling " + name[i] + " . . .");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Calling " + phoneNumber + " . . .");
        }
    }
}
