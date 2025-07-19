public class TaxiLagbe {

    public String taxiNumber;
    public String location;
    public int totalPassenger;
    public String name[] = new String[100];
    int i = 0;
    int sum = 0;

    public void storeInfo(String name, String location) {
        this.taxiNumber = name;
        this.location = location;

    }

    public void printDetails() {
        System.out.println("Taxi number: " + this.taxiNumber);
        System.out.println("This taxi can cover " + this.location + " area");
        System.out.println("Total Passenger: " + this.totalPassenger);
        System.out.println("Passenger Lists: ");
        for (int i = 0; i < name.length; i++) {
            if (name[i] != null) {
                System.out.print(name[i] + " ");
            }

        }
        System.out.println();
        System.out.println("Total collected fare: " + this.sum + " Taka");

    }

    public void addPassenger(String passengerName, int fare) {
        if (totalPassenger < 4) {
            totalPassenger++;
            name[this.i] = passengerName;
            this.i++;
            sum += fare;
            System.out.println("Dear " + passengerName + "! Welcome to TaxiLagbe");
        } else {
            System.out.println("Taxi Full! No more passengers can be added");
        }
    }

    public void addPassenger(String passengerName, int fare, String secondPassengerName, int secondFare) {
        if (totalPassenger < 4) {
            totalPassenger++;
            name[this.i] = passengerName;
            this.i++;
            sum += fare;
            System.out.println("Dear " + passengerName + "! Welcome to TaxiLagbe");
        }
        
        if (totalPassenger < 4) {
            totalPassenger++;
            name[this.i] = secondPassengerName;
            this.i++;
            sum += secondFare;
            System.out.println("Dear " + secondPassengerName + "! Welcome to TaxiLagbe");
        }
    }

}
