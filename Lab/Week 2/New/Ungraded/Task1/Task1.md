# Task 1

## Cat Class

```java
public class Cat {
    public String color = "White";
    public String action = "sitting";

    public void printCat(){
        System.out.println(color + " cat is " + action);
    }
    
}
```

## CatTester Class

```java
public class CatTester {
    public static void main(String[] args) {
        Cat c1 = new Cat();
        System.out.println("===================");
        c1.printCat();
        c1.color = "Black";
        System.out.println("===================");
        c1.printCat();
        c1.color = "Brown";
        c1.action = "jumping";
        System.out.println("===================");
        c1.printCat();
    }
}
```

## Output

```
===================
White cat is sitting
===================
Black cat is sitting
===================
Brown cat is jumping
```
