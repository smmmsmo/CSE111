# Task 1

## CSECourse Class

```java
public class CSECourse {
    public String courseName = "Programming Language II";
    public String courseCode = "CSE111";
    public int credit = 3;
}
```

## CSECourseTester Class

```java
public class CSECourseTester{
  public static void main(String args []){
    CSECourse c1 = new CSECourse();
    System.out.println("Course Name: "+c1.courseName);
    System.out.println("Course Code: "+c1.courseCode);
    System.out.println("Credit: "+c1.credit);
  }
}
```

## Output

```
Course Name: Programming Language II
Course Code: CSE111
Credit: 3
```
