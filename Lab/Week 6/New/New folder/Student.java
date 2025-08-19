public class Student {
    private String name;
    private int id;
    private double cgpa;
    
    public Student(String name, int id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public double getCgpa() {
        return cgpa;
    }
    
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    
    public void showInfo() {
        System.out.println("Student info:");
        System.out.println("Student Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("CGPA:  " + cgpa);
    }
}
