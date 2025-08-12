class Encapsulate {
    // private variables declared
    // these can only be accessed by
    // public methods of class
    private String geekName;
    private int geekRoll;
    private int geekAge;

    // get method for age to access
    // private variable geekAge
    public int getAge() {
        return geekAge;
    }

    // get method for name to access
    // private variable geekName
    public String getName() {
        return geekName;
    }

    // get method for roll to access
    // private variable geekRoll
    public int getRoll() {
        return geekRoll;
    }

    // set method for age to access
    // private variable geekage
    public void setAge(int newAge) {
        geekAge = newAge;
    }

    // set method for name to access
    // private variable geekName
    public void setName(String newName) {
        geekName = newName;
    }

    // set method for roll to access
    // private variable geekRoll
    public void setRoll(int newRoll) {
        geekRoll = newRoll;
    }
}

// Main Class
public class Geeks4 {
    public static void main(String[] args) {
        Encapsulate o = new Encapsulate();

        // setting values of the variables
        o.setName("Geeky");
        o.setAge(19);
        o.setRoll(51);

        // Displaying values of the variables
        System.out.println("Geek's name: " + o.getName());
        System.out.println("Geek's age: " + o.getAge());
        System.out.println("Geek's roll: " + o.getRoll());

        // Direct access of geekRoll is not possible
        // due to encapsulation
        // System.out.println("Geek's roll: " +
        // obj.geekName);
    }
}