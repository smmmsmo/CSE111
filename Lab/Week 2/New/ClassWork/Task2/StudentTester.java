public class StudentTester {
    public static void main(String[] args) {

                Student s1 = new Student();
                
                System.out.println("Before initilization of the Student Object s1 : ");
                System.out.println(" ");
                System.out.println("Name of the Student: " + s1.name);
                System.out.println("ID of the Student: " + s1.id);

                System.out.println(" ");
                System.out.println("After initilization of the Student Object s1 : ");
                s1.name = "Bob";
                s1.id = 123;
                
                System.out.println(" ");
                System.out.println("Name of the Student: " + s1.name);
                System.out.println("ID of the Student: " + s1.id);
            }
        }
