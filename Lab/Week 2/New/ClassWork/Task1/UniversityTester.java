public class UniversityTester {
    public static void main(String[] args) {

        University uni_obj1 = new University();
        University uni_obj2 = new University();

        System.out.println("Location of the University Classes : ");

        System.out.println(" ");

        System.out.println("Location of the uni_obj1 : " + uni_obj1);
        System.out.println("Location of the uni_obj2 : " + uni_obj2);

        // Are the location of the objects the same? NO

        uni_obj1.name = "Massachusetts Institute of Technology";
        uni_obj1.country = "United States";

        uni_obj2.name = "University of Tokyo";
        uni_obj2.country = "Japan";

        System.out.println(" ");

        System.out.println("Location of the University Class Instance Variables : ");

        System.out.println(" ");

        System.out.println("Instance Variables of uni_obj1 : " + uni_obj1.name + ", " + uni_obj1.country);
        System.out.println("Instance Variables of uni_obj2 : " + uni_obj2.name + ", " + uni_obj2.country);

        // instance variables of both objects have changed or not ? YES THEY'VE CHANGED
        // whether the instance variables of both objects are of the same value or not?
        // THEY'RE NOT THE SAME

    }
}
