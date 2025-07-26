public class Course {

    public String courseName;
    public String courseCode;
    public int credit;

    public void updateDetails(String courseName, String courseCode, int credit) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credit = credit;
    }

    public void displayCourse() {

        System.out.println("Course name :" + courseName);
        System.out.println("Course code :" + courseCode);
        System.out.println("Credit :" + credit);

    }

}