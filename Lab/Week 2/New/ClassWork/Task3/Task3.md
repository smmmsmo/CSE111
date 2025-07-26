# Task 3

## Course Class

```java
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
```

## CourseTester Class

```java
public class CourseTester {
    public static void main(String[] args) {
        Course c1 = new Course();
        Course c2 = new Course();
        c1.updateDetails("Programming Language I", "CSE110", 3);
        System.out.println("========== 1 ==========");
        c1.displayCourse();
        c2.updateDetails("Data Structures", "CSE220", 3);
        System.out.println("========== 2 ==========");
        c2.displayCourse();
        c1.updateDetails("Programming Language II", "CSE111", 3);
        System.out.println("========== 3 ==========");
        c1.displayCourse();
    }

}
```

## Output

```
========== 1 ==========
Course name :Programming Language I
Course code :CSE110
Credit :3
========== 2 ==========
Course name :Data Structures
Course code :CSE220
Credit :3
========== 3 ==========
Course name :Programming Language II
Course code :CSE111
Credit :3
```
