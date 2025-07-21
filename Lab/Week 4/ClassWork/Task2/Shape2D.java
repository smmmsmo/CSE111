public class Shape2D {

    public String type;
    public int length;
    public double area;
    public int weidth;
    public int base;
    public int height;

    public Shape2D() {
        this.type = "Square";
        this.length = 5;
        System.out.println("A " + this.type + " has been created with length: " + this.length);
        this.area = length * length;

    }

    public Shape2D(int length, int weidth) {
        this.type = "rectangle";
        this.length = length;
        this.weidth = weidth;
        System.out.println(
                "A " + this.type + " has been created with length: " + this.length + " and breadth: " + this.weidth);
        area = length * weidth;

    }

    public Shape2D(int length, int weidth, int base) {
        this.type = "triangle";
        this.length = length;
        this.weidth = weidth;
        this.base = base;
        System.out.println("A " + this.type + " has been created with the following sides: " + this.length + " ,"
                + this.weidth + "," + this.base);
        double s = (((double) length + weidth + base) / 2);
        area = Math.sqrt(s*(s-length)*(s-weidth)*(s-base));
    }

    public Shape2D(int height, int base, String type) {
        this.type = type;
        this.height = height;
        this.base = base;
        System.out.println(
                "A " + this.type + " has been created with hright: " + this.height + " and base: " + this.base);
        area = 0.5 * height * base;
    }

    public void area() {
        System.out.println("The area of the " + this.type + " is: " + this.area);
    }

}
