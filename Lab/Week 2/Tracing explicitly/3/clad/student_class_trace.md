# Java Code Trace - Student Class

## Student Class

```java
public class Student{ 
    public String name; 
    public double cgpa; 
}
```

## Test Sequence

```java
Student s1 = new Student();
Student s2 = new Student();
Student s3 = null;     
s1.name = "Student One";
s1.cgpa = 2.3;
s3 = s1;
s2.name = "Student Two";
s2.cgpa = s3.cgpa + 1;
s3.name = "New Student";
System.out.println(s1.name);
System.out.println(s2.name);
System.out.println(s3.name);
System.out.println(s1.cgpa);
System.out.println(s2.cgpa);
System.out.println(s3.cgpa);
s3 = s2;
s1.name = "old student";
s2.name = "older student";
s3.name = "oldest student";
s2.cgpa = s1.cgpa - s3.cgpa + 4.5;
System.out.println(s1.name);
System.out.println(s2.name);
System.out.println(s3.name);
System.out.println(s1.cgpa);
System.out.println(s2.cgpa);
System.out.println(s3.cgpa);
```

---

## **Statement Execution**

### Object Creation

```java
Student s1 = new Student();
```
- Creates `Student` object `s1` with default values:
  - `s1.name = null` (default String value)
  - `s1.cgpa = 0.0` (default double value)

```java
Student s2 = new Student();
```
- Creates `Student` object `s2` with default values:
  - `s2.name = null` (default String value)
  - `s2.cgpa = 0.0` (default double value)

```java
Student s3 = null;
```
- `s3` reference variable is initialized to `null`

### Initial Assignments

```java
s1.name = "Student One";
```
- `s1.name = "Student One"`

```java
s1.cgpa = 2.3;
```
- `s1.cgpa = 2.3`

**Current State:**
- `s1.name = "Student One"`
- `s1.cgpa = 2.3`
- `s2.name = null`
- `s2.cgpa = 0.0`
- `s3 = null`

### Reference Assignment

```java
s3 = s1;
```
- `s3` now references the same object as `s1`

**Current State:**
- `s1` and `s3` both reference the same object:
  - `name = "Student One"`
  - `cgpa = 2.3`
- `s2` references separate object:
  - `name = null`
  - `cgpa = 0.0`

### More Assignments

```java
s2.name = "Student Two";
```
- `s2.name = "Student Two"`

```java
s2.cgpa = s3.cgpa + 1;
```
- `s2.cgpa = 2.3 + 1 = 3.3` (s3 refers to same object as s1)

```java
s3.name = "New Student";
```
- Since `s3` references the same object as `s1`, this changes `s1.name` as well
- `s1.name = "New Student"` (modified through s3 reference)

**Current State:**
- `s1` and `s3` both reference the same object:
  - `name = "New Student"`
  - `cgpa = 2.3`
- `s2` references separate object:
  - `name = "Student Two"`
  - `cgpa = 3.3`

### First Set of Print Statements

```java
System.out.println(s1.name);
```
**Output:** `New Student`

```java
System.out.println(s2.name);
```
**Output:** `Student Two`

```java
System.out.println(s3.name);
```
**Output:** `New Student` (same object as s1)

```java
System.out.println(s1.cgpa);
```
**Output:** `2.3`

```java
System.out.println(s2.cgpa);
```
**Output:** `3.3`

```java
System.out.println(s3.cgpa);
```
**Output:** `2.3` (same object as s1)

### Reference Reassignment

```java
s3 = s2;
```
- `s3` now references the same object as `s2`
- `s1` now references its object alone

**Current State:**
- `s1` references object:
  - `name = "New Student"`
  - `cgpa = 2.3`
- `s2` and `s3` both reference the same object:
  - `name = "Student Two"`
  - `cgpa = 3.3`

### Final Assignments

```java
s1.name = "old student";
```
- `s1.name = "old student"`

```java
s2.name = "older student";
```
- `s2.name = "older student"`

```java
s3.name = "oldest student";
```
- Since `s3` references the same object as `s2`, this overwrites s2.name
- Both `s2.name` and `s3.name` are now `"oldest student"`

```java
s2.cgpa = s1.cgpa - s3.cgpa + 4.5;
```
- `s2.cgpa = 2.3 - 3.3 + 4.5 = 3.5`
- Since `s3` references the same object as `s2`, `s3.cgpa` also becomes `3.5`

**Final State:**
- `s1` references object:
  - `name = "old student"`
  - `cgpa = 2.3`
- `s2` and `s3` both reference the same object:
  - `name = "oldest student"`
  - `cgpa = 3.5`

### Second Set of Print Statements

```java
System.out.println(s1.name);
```
**Output:** `old student`

```java
System.out.println(s2.name);
```
**Output:** `oldest student`

```java
System.out.println(s3.name);
```
**Output:** `oldest student` (same object as s2)

```java
System.out.println(s1.cgpa);
```
**Output:** `2.3`

```java
System.out.println(s2.cgpa);
```
**Output:** `3.5`

```java
System.out.println(s3.cgpa);
```
**Output:** `3.5` (same object as s2)

## Final Output
The program produces the following output:
```
New Student
Student Two
New Student
2.3
3.3
2.3
old student
oldest student
oldest student
2.3
3.5
3.5
```

## Final State Summary
**Object 1 (referenced by s1):**
- `name = "old student"`
- `cgpa = 2.3`

**Object 2 (referenced by both s2 and s3):**
- `name = "oldest student"`
- `cgpa = 3.5`