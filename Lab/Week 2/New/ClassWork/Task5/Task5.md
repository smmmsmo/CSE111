# Task 5

## Human Class

```java
public class Human{
    public int age;
    public double height;
}
```

## HumanTester Class

```java
public class HumanTester {
  public static void main(String[] args) {
    Human h1 = new Human();
    Human h2 = new Human();
    h1.age = 21;
    h1.height = 5.5;
    System.out.println(h1.age);
    System.out.println(h1.height);
    h2.height = h1.height - 3;
    System.out.println(h2.height);
    h2.age = h1.age++;
    System.out.println(h1.age);
    h2 = h1;
    System.out.println(h2.age);
    System.out.println(h2.height);
    h2.age++;
    h2.height++;
    System.out.println(h1.age);
    System.out.println(h1.height);
    h1.age = ++h2.age;
    System.out.println(h2.age);
    System.out.println(h2.height);
  }
}
```

## Output

| Line | Output |
|------|--------|
| 1    | 21     |
| 2    | 5.5    |
| 3    | 2.5    |
| 4    | 22     |
| 5    | 22     |
| 6    | 5.5    |
| 7    | 23     |
| 8    | 6.5    |
| 9    | 24     |
| 10   | 6.5    |
