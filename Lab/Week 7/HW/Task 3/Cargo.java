public class Cargo {
    private static double totalCapacity = 10.0;
    private static int uniqueId = 1;

    private int id;
    private String contents;
    private double weight;
    private boolean loaded;

    public Cargo(String contents, double weight) {
        this.id = uniqueId++;
        this.contents = contents;
        this.weight = weight;
        this.loaded = false;
    }

    public static double capacity() {
        return totalCapacity;
    }

    public void details() {
        System.out.println("Cargo ID: " + this.id + ", Contents: " + this.contents + ", \nWeight: " + this.weight
                + ", Loaded: " + this.loaded);
    }

    public void load() {
        if (!this.loaded && this.weight <= totalCapacity) {
            this.loaded = true;
            totalCapacity -= this.weight;
            System.out.println("Cargo " + this.id + " loaded for transport.");
        } else {
            System.out.println("Cannot load cargo, exceeds weight capacity.");
        }
    }

    public void unload() {
        if (this.loaded) {
            this.loaded = false;
            totalCapacity += this.weight;
            System.out.println("Cargo " + this.id + " unloaded.");
        }
    }
}
