public class Student {

    public static int total_students = 0;
    public static int cse_students = 0;
    public static int non_cse_students = 0;
    public static int id = 0;

    public String name;
    public double cgpa;
    public String department;

    public Student(String newName, double newCgpa, String newDepartment) {
        this.name = newName;
        this.cgpa = newCgpa;
        this.department = newDepartment;
        id++;
        total_students++;
        non_cse_students++;
    }

    public Student(String newName, double newCgpa) {
        this.name = newName;
        this.cgpa = newCgpa;
        this.department = "CSE";
        id++;
        total_students++;
        cse_students++;
    }

    public static void printDetails() {
        System.out.println("Total Students: " + total_students);
        System.out.println("CSE Students: " + cse_students);
        System.out.println("Non-CSE Students: " + non_cse_students);
    }

    public void individualDetail() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Department: " + department);
    }
}
