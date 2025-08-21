public class Passenger {

    public static int no_of_passenger = 0;
    public static double total_fare = 0.0;

    public String name;
    public double fare = 0;

    public Passenger(String name, double distance) {
        this.name = name;
        this.fare = distance * 20;
        no_of_passenger++;
        total_fare += fare;
    }

    public void storeBaggageWeight(double weight) {
        this.fare = fare + (weight * 10);
        total_fare += (weight * 10);
    }

    public void passengerDetails() {
        System.out.println("Name: " + name);
        System.out.println("Fare: " + fare + " TK");
    }
}