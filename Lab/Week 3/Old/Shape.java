public class Shape {
    public String type;
    public double area;

    public String setParameters(String shapeType, int radius) {
        this.area = Math.PI * radius * radius;
        this.type = shapeType;
        return details();
    }

    public String setParameters(String shapeType, int base, int height) {
        this.type = shapeType;
        this.area = 0.5 * base * height;
        return details();
    }

    public String setParameters(String shapeType, double length, double wide) {
        this.type = shapeType;
        this.area = length * wide;
        return details();
    }

    public String details() {
        String formattedArea;
        if (area % 1 == 0) {
            // If the number is a whole number (ends with .0), show 1 decimal place
            formattedArea = String.format("%.1f", area);
        } else {
            // For all other numbers, show 2 decimal places
            formattedArea = String.format("%.2f", area);
        }
        return ("Shape Name: " + type + "\nArea: " + formattedArea);
    }

}