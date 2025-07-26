# Task 3

## ChickenBurger Class

```java
public class ChickenBurger {

    public String bun = "Sesame";
    public int price = 200;
    public String sauceOption = "Less";
    public String spiceLevel = "Not Set";

    public void customizeSpiceLevel(String spice) {
        this.spiceLevel = spice;

        if (spice.equals("Mild")) {
            System.out.println("Spice level is set to Mild.");
        } else if (spice.equals("Spicy")) {
            System.out.println("Spice level is set to Spicy.");
        } else if (spice.equals("Naga")) {
            System.out.println("Spice level is set to Naga.");
        } else if (spice.equals("Extreme")) {
            System.out.println("Spice level is set to Extreme.");
        } else {
            System.out.println("This spice level is unavailable.");
        }
    }

    public String serveBurger() {
        if (spiceLevel.equals("Not Set")) {
            System.out.println("Cannot serve now. Customize Spice level first.");
            return "";
        } else {
            return ("The burger is being served:- \n" +
                    "Bun Type: " + bun + "\n" +
                    "Price: " + price + "\n" +
                    "Sauce Option: " + sauceOption + "\n" +
                    "Spice Level: " + spiceLevel + "\n");
        }
    }

}
```

## ChickenBurgerTester Class

```java
public class ChickenBurgerTester {
  public static void main(String[] args) {

    ChickenBurger b1 = new ChickenBurger();

    System.out.println(b1.bun);

    System.out.println(b1.price);

    System.out.println(b1.sauceOption);

    System.out.println(b1.spiceLevel);

    System.out.println("----------1----------");

    System.out.println(b1.serveBurger());

    System.out.println("----------2----------");

    b1.customizeSpiceLevel("Extreme Jhaal");

    b1.customizeSpiceLevel("Spicy");

    System.out.println("----------3----------");

    System.out.println(b1.serveBurger());

    System.out.println("----------4----------");

    ChickenBurger b2 = new ChickenBurger();

    b2.bun = "Brioche";

    b2.price += 50;

    b2.sauceOption = "Regular";

    b2.customizeSpiceLevel("Naga");

    System.out.println("----------5----------");

    System.out.println(b2.serveBurger());

  }

}
```

## Output

```
Sesame
200
Less
Not Set
----------1----------
Cannot serve now. Customize Spice level first.

----------2----------
This spice level is unavailable.
Spice level is set to Spicy.
----------3----------
The burger is being served:- 
Bun Type: Sesame
Price: 200
Sauce Option: Less
Spice Level: Spicy

----------4----------
Spice level is set to Naga.
----------5----------
The burger is being served:- 
Bun Type: Brioche
Price: 250
Sauce Option: Regular
Spice Level: Naga
```
