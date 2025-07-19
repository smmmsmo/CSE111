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
