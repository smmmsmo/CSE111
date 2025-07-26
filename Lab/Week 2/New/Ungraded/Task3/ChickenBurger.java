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
