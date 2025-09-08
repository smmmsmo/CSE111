public class StudentTester {
    public static void main(String args[]) {
        CSEStudent.details();
        System.out.println("1--------------");
        CSEStudent s1 = new CSEStudent("Bob", 23);
        s1.info();
        System.out.println("2--------------");
        CSEStudent s2 = new CSEStudent("Don", 33);
        s2.info();
        System.out.println("3--------------");
        s1.addLabBasedCourse("CSE220");
        s1.addLabBasedCourse("CSE221");
        System.out.println("4--------------");
        s1.info();
        System.out.println("5--------------");
        CSEStudent.details();
        System.out.println("6--------------");
        s1.addLabBasedCourse("CSE230");
        System.out.println("7--------------");
        s1.info();
        System.out.println("8--------------");
        s2.addLabBasedCourse("CSE110");
        s2.info();
    }
}

class Student {
    public String name;
    public int id;
    public String courses = "";

    public Student(String n, int i) {
        name = n;
        id = i;
    }

    public void info() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Courses: " + courses);
    }
}

class CSEStudent extends Student {
    private static int totalStudents = 0;
    private static String[] labBasedCourses = {"CSE110", "CSE111", "CSE220", "CSE221"};

    public CSEStudent(String n, int i) {
    super(n, i);
        totalStudents++;
    }

    public static void details() {
        System.out.println("Total CSE Students: " + totalStudents);
        System.out.println("Available Lab Based Courses: ");
        for (String c : labBasedCourses) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void addLabBasedCourse(String course) {
        boolean found = false;
        for (String c : labBasedCourses) {
            if (c.equals(course)) {
                found = true;
                break;
            }
        }
        if (found) {
            if (courses.equals("")) {
                courses = course;
            } else {
                courses += " " + course;
            }
        } else {
            System.out.println("It is not a lab based course!");
        }
    }
}

