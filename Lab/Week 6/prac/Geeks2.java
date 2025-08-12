class Person {

    // Encapsulating the name and age
    // only approachable and used using methods defined
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// Driver Class
public class Geeks2 {

    // main function
    public static void main(String[] args) {
        // person object created
        Person p = new Person();
        p.setName("Sweta");
        p.setAge(25);

        // Using methods to get the values from the
        // variables
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
    }
}