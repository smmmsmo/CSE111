
public class Student {

    public int Student_id;
    public double CGPA;
    public String[] courses = new String[4];
    public int index = 0;

    public Student(int new_id) {
        Student_id = new_id;
        System.out.println("A student with ID " + Student_id + " has been created.");
    }

    public Student(int new_id, double new_cgpa) {
        Student_id = new_id;
        CGPA = new_cgpa;
        System.out.println("A student with ID " + Student_id + " and CGPA " + CGPA + " has been created.");
    }

    public void storeCG(double new_cgpa) {
        CGPA = new_cgpa;
    }

    public void showAdvisee() {
        System.out.println("Student ID: " + Student_id + ", CGPA: " + CGPA);

        if (index == 0) {
            System.out.println("No courses added.");
        } else {
            System.out.print("Added courses are:\n");
            for (int i = 0; i < index; i++) {
                System.out.print(courses[i] + " ");
            }
            System.out.println();
        }
    }

    public void addCourse(String course_name) {
        if (CGPA == 0) {
            System.out.println("Failed to add " + course_name + "\nset CGPA first");
        } else if (CGPA < 3) {
            if (index > 2) {
                System.out.println("failed to add " + course_name + "\nCG is low. Can't add more than 3 courses.");
            } else {
                courses[index] = course_name;
                index++;
            }
        } else if (CGPA >= 3) {
            if (index >= 4) {
                System.out.println("Failed to add " + course_name + "\nMaximum 4 courses allowed.");
            } else {
                courses[index] = course_name;
                index++;
            }
        }
    }

    public void removeAllCourse() {
        for (int i = 0; i < courses.length; i++) {
            courses[i] = null;
        }
        index = 0;
    }

    public void storeID(int new_id) {
        Student_id = new_id;
    }

    public void addCourse(String courses[]) {
        for (int i = 0; i < courses.length; i++) {
            addCourse(courses[i]);
        }
    }

}
