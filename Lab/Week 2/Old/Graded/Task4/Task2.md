# Task 2

## ImaginaryNumber Class

```java
public class ImaginaryNumber {

    public int realPart = 0;
    public int imaginaryPart = 0;

    public String printNumber() {
        return (realPart + " " + "+" + " " + imaginaryPart + "i");
    }

}
```

## ImaginaryNumberTester Class

```java
public class ImaginaryNumberTester {
  public static void main(String[] args) {
    ImaginaryNumber num1 = new ImaginaryNumber();
    String p = num1.printNumber();
    System.out.println(p);
    System.out.println("1********");
    num1.realPart = 3;
    num1.imaginaryPart = 7;
    System.out.println(num1.printNumber());
    System.out.println("2********");
    ImaginaryNumber num2 = new ImaginaryNumber();
    num2.realPart = 1;
    num2.imaginaryPart = 9;
    System.out.println(num2.printNumber());
  }
}
```

## Output

```
0 + 0i
1********
3 + 7i
2********
1 + 9i
```
