## Main Method Execution

```java
Student s1 = new Student();
```
- Creates a `Student` object `s1` with default instance variable values (no constructor defined):
  - `s1.name = null` (default for `String`)
  - `s1.cgpa = 0.0` (default for `double`)

**State after creation:**
- `s1.name = null`
- `s1.cgpa = 0.0`

```java
Student s2 = new Student();
```
- Creates a `Student` object `s2` with:
  - `s2.name = null`
  - `s2.cgpa = 0.0`

**State after creation:**
- `s1.name = null`
- `s1.cgpa = 0.0`
- `s2.name = null`
- `s2.cgpa = 0.0`

```java
Student s3 = null;
```
- Initializes `s3` as `null` (no object reference).

**State:**
- `s1.name = null`
- `s1.cgpa = 0.0`
- `s2.name = null`
- `s2.cgpa = 0.0`
- `s3 = null`

```java
s1.name = "Student One";
```
- Assigns `s1.name = "Student One"`

**State:**
- `s1.name = "Student One"`
- `s1.cgpa = 0.0`
- `s2.name = null`
- `s2.cgpa = 0.0`
- `s3 = null`

```java
s1.cgpa = 2.3;
```
- Assigns `s1.cgpa = 2.3`

**State:**
- `s1.name = "Student One"`
- `s1.cgpa = 2.3`
- `s2.name = null`
- `s2.cgpa = 0.0`
- `s3 = null`

```java
s3 = s1;
```
- Assigns `s3` to reference the same object as `s1`. Now `s3` and `s1` point to the same `Student` object.

**State:**
- `s1.name = "Student One"` (same object as `s3`)
- `s1.cgpa = 2.3`
- `s2.name = null`
- `s2.cgpa = 0.0`
- `s3.name = "Student One"` (references `s1`’s object)
- `s3.cgpa = 2.3`

```java
s2.name = "Student Two";
```
- Assigns `s2.name = "Student Two"`

**State:**
- `s1.name = "Student One"`
- `s1.cgpa = 2.3`
- `s2.name = "Student Two"`
- `s2.cgpa = 0.0`
- `s3.name = "Student One"`
- `s3.cgpa = 2.3`

```java
s2.cgpa = s3.cgpa + 1;
```
- `s2.cgpa = 2.3 + 1 = 3.3` (`s3.cgpa` is from the object `s3` references, same as `s1`)

**State:**
- `s1.name = "Student One"`
- `s1.cgpa = 2.3`
- `s2.name = "Student Two"`
- `s2.cgpa = 3.3`
- `s3.name = "Student One"`
- `s3.cgpa = 2.3`

```java
s3.name = "New Student";
```
- Assigns `s3.name = "New Student"`. Since `s3` and `s1` reference the same object, this updates `s1.name` as well.

**State:**
- `s1.name = "New Student"`
- `s1.cgpa = 2.3`
- `s2.name = "Student Two"`
- `s2.cgpa = 3.3`
- `s3.name = "New Student"`
- `s3.cgpa = 2.3`

```java
System.out.println(s1.name);
```
- Prints `"New Student"`

**Output so far:**
```
New Student
```

```java
System.out.println(s2.name);
```
- Prints `"Student Two"`

**Output so far:**
```
New Student
Student Two
```

```java
System.out.println(s3.name);
```
- Prints `"New Student"` (same object as `s1`)

**Output so far:**
```
New Student
Student Two
New Student
```

```java
System.out.println(s1.cgpa);
```
- Prints `2.3`

**Output so far:**
```
New Student
Student Two
New Student
2.3
```

```java
System.out.println(s2.cgpa);
```
- Prints `3.3`

**Output so far:**
```
New Student
Student Two
New Student
2.3
3.3
```

```java
System.out.println(s3.cgpa);
```
- Prints `2.3` (same object as `s1`)

**Output so far:**
```
New Student
Student Two
New Student
2.3
3.3
2.3
```

```java
s3 = s2;
```
- Assigns `s3` to reference the same object as `s2`. The original object referenced by `s3` (same as `s1`) is still referenced by `s1`. Now `s3` and `s2` point to the same `Student` object.

**State:**
- `s1.name = "New Student"`
- `s1.cgpa = 2.3`
- `s2.name = "Student Two"` (same object as `s3`)
- `s2.cgpa = 3.3`
- `s3.name = "Student Two"`
- `s3.cgpa = 3.3`

```java
s1.name = "old student";
```
- Assigns `s1.name = "old student"`

**State:**
- `s1.name = "old student"`
- `s1.cgpa = 2.3`
- `s2.name = "Student Two"`
- `s2.cgpa = 3.3`
- `s3.name = "Student Two"`
- `s3.cgpa = 3.3`

```java
s2.name = "older student";
```
- Assigns `s2.name = "older student"`. Affects `s3.name` (same object).

**State:**
- `s1.name = "old student"`
- `s1.cgpa = 2.3`
- `s2.name = "older student"`
- `s2.cgpa = 3.3`
- `s3.name = "older student"`
- `s3.cgpa = 3.3`

```java
s3.name = "oldest student";
```
- Assigns `s3.name = "oldest student"`. Affects `s2.name` (same object).

**State:**
- `s1.name = "old student"`
- `s1.cgpa = 2.3`
- `s2.name = "oldest student"`
- `s2.cgpa = 3.3`
- `s3.name = "oldest student"`
- `s3.cgpa = 3.3`

```java
s2.cgpa = s1.cgpa - s3.cgpa + 4.5;
```
- `s2.cgpa = 2.3 - 3.3 + 4.5 = 3.5`. Affects `s3.cgpa` (same object).

**State:**
- `s1.name = "old student"`
- `s1.cgpa = 2.3`
- `s2.name = "oldest student"`
- `s2.cgpa = 3.5`
- `s3.name = "oldest student"`
- `s3.cgpa = 3.5`

```java
System.out.println(s1.name);
```
- Prints `"old student"`

**Output so far:**
```
New Student
Student Two
New Student
2.3
3.3
2.3
old student
```

```java
System.out.println(s2.name);
```
- Prints `"oldest student"`

**Output so far:**
```
New Student
Student Two
New Student
2.3
3.3
2.3
old student
oldest student
```

```java
System.out.println(s3.name);
```
- Prints `"oldest student"` (same object as `s2`)

**Output so far:**
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
```

```java
System.out.println(s1.cgpa);
```
- Prints `2.3`

**Output so far:**
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
```

```java
System.out.println(s2.cgpa);
```
- Prints `3.5`

**Output so far:**
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
```

```java
System.out.println(s3.cgpa);
```
- Prints `3.5` (same object as `s2`)

**Output:**
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
- **s1**:
  - `s1.name = "old student"`
  - `s1.cgpa = 2.3`
- **s2/s3** (same object):
  - `s2.name = "oldest student"`
  - `s2.cgpa = 3.5`
  - `s3.name = "oldest student"`
  - `s3.cgpa = 3.5`