public class Triangle {

    public int side1;
    public int side2;
    public int side3;

    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public void triangleDetails() {
        System.out.println("Three sides of the triangle are: " + side1 + "," + side2 + "," + side3 + "\nPerimeter: "
                + (side1 + side2 + side3));
    }

    public String printTriangleType() {
        if (side1 == side2 && side2 == side3) {
            return "This is an Equilateral Triangle.";
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            return "This is an Isosceles Triangle.";
        } else {
            return "This is a Scalene Triangle.";
        }
    }

    public void compareTriangles(Triangle newLocation) {

        if (this == newLocation) {
            System.out.println("These two triangle objects have the same address.");
            return;
        }

        boolean sidesEqual = (this.side1 == newLocation.side1 && this.side2 == newLocation.side2
                && this.side3 == newLocation.side3);

        int thisPerimeter = this.side1 + this.side2 + this.side3;
        int locationPerimeter = newLocation.side1 + newLocation.side2 + newLocation.side3;
        boolean perimeterEqual = (thisPerimeter == locationPerimeter);

        if (sidesEqual) {
            System.out.println("Addresses are different but the sides of the triangles are equal.");
        } else if (perimeterEqual) {
            System.out.println("Only the perimeter of both triangles is equal.");
        } else {
            System.out.println("Addresses, length of the sides and perimeter all are different.");
        }
    }

}