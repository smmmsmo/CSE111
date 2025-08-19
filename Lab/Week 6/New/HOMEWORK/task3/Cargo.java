public class Cargo {
    public static double t = 10.0;
    public static double r = 10.0;
    public static int c = 0;
    
    public int id;
    public String x;
    public double w;
    public boolean l;
    
    public Cargo(String contents, double weight) {
        c++;
        this.id = c;
        this.x = contents;
        this.w = weight;
        this.l = false;
    }
    
    public static double capacity() {
        return r;
    }
    
    public void load() {
        if (this.l) {
            return;
        }
        
        if (r >= this.w) {
            this.l = true;
            r -= this.w;
            System.out.println("Cargo " + this.id + " loaded for transport.");
        } else {
            System.out.println("Cannot load cargo, exceeds weight capacity.");
        }
    }
    
    public void unload() {
        if (this.l) {
            this.l = false;
            r += this.w;
            System.out.println("Cargo " + this.id + " unloaded.");
        }
    }
    
    public void details() {
        System.out.println("Cargo ID: " + this.id + ", Contents: " + this.x + ", ");
        System.out.println("Weight: " + this.w + ", Loaded: " + this.l);
    }
}
