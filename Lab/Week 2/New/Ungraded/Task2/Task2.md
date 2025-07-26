# Task 2

## Bird Class

```java
public class Bird {

    public String name;
    public int land = 0;
    public int up = 0;

    public void flyUp(int number) {

        System.out.println(name + " has flown up " + number + " feet");
        this.up = number;
    }

    public void makeNoise() {

        if (name.equals("Parrot")) {
            System.out.println("Squawk!");
        } else
            System.out.println("Squee");
    }

    public void flyDown(int number) {
        if (up - number < land) {
            System.out.println(name + " cannot fly down " + number + " feet.");
        } else if (up - number > land) {
            System.out.println(name + " has flown down " + number + " feet.");
            up = up - number;
        } else {
            System.out.println(name + " has flown down " + number + " feet and landed.");
            up = land;
        }

    }

}
```

## BirdTester Class

```java
public class BirdTester{

    public static void main(String args[]) {

        Bird b1 = new Bird();

        b1.name = "Parrot";

        b1.flyUp(3);

        b1.makeNoise();

        b1.flyDown(5);

        b1.flyDown(2);

        b1.flyDown(1);

        Bird b2 = new Bird();

        b2.name = "Eagle";

        b2.flyUp(5);

        b2.flyDown(5);

        b2.makeNoise();

    }  

}
```

## Output

```
Parrot has flown up 3 feet
Squawk!
Parrot cannot fly down 5 feet.
Parrot has flown down 2 feet.
Parrot has flown down 1 feet and landed.
Eagle has flown up 5 feet
Eagle has flown down 5 feet and landed.
Squee
```
