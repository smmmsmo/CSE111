public class Department {
    private String name;
    private Student[] students;
    private int count;
    private int capacity;
    
    public Department(String name) {
        this.name = name;
        this.capacity = 5;
        this.students = new Student[capacity];
        this.count = 0;
    }
    
    public void addStudent(Student... newStudents) {
        for (Student student : newStudents) {
            if (count < capacity) {
                boolean exists = false;
                for (int i = 0; i < count; i++) {
                    if (students[i].getId() == student.getId()) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    students[count] = student;
                    count++;
                    System.out.println("Welcome to " + name + " department, " + student.getName());
                } else {
                    System.out.println("Student with the same ID already exists, Please try with another ID");
                }
            }
        }
    }
    
    public void findStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                students[i].showInfo();
                return;
            }
        }
        System.out.println("Student with this ID doesn't exist, Please give a valid ID");
    }
    
    public void details() {
        System.out.println("Department Name: " + name);
        System.out.println("Number of student:" + count);
        System.out.println("Details of the students: ");
        for (int i = 0; i < count; i++) {
            System.out.println("Student name: " + students[i].getName() + ", ID: " + students[i].getId() + ", cgpa: " + students[i].getCgpa());
        }
    }
}
