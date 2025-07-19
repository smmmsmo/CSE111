
public class Student {

    public String name = "Not Set";
    public double cgpa = 0.0;
    public int credit = 9;
    public String scholarshipStatus = "Not Set";
    public String dept = "CSE";

    public void showDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Department: " + this.dept);
        System.out.println("CGPA: " + this.cgpa);
        System.out.println("Credit: " + this.credit);
        System.out.println("Scholarship Status: " + this.scholarshipStatus);
    }

    public void updateDetails(String name, double cgpa, int credit, String dept) {
        this.name = name;
        this.cgpa = cgpa;
        this.credit = credit;
        this.dept = dept;
    }

    public void updateDetails(String name, double cgpa, int credit) {
        this.name = name;
        this.cgpa = cgpa;
        this.credit = credit;
    }

    public void updateDetails(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    public void checkScholarshipEligibility() {
        if (this.cgpa > 3.7) {
            this.scholarshipStatus = "Eligible for Merit-based Scholarship";
        } else if (this.cgpa >= 3.5 && this.cgpa <= 3.7) {
            this.scholarshipStatus = "Eligible for Need-based Scholarship";
        } else if (this.cgpa >= 3.5 && this.credit > 10) {
            this.scholarshipStatus = "Eligible for Scholarship";
        } else {
            this.scholarshipStatus = "No Scholarship";
        }
        System.out.println(this.name + " is eligible for " + this.scholarshipStatus);
    }
}