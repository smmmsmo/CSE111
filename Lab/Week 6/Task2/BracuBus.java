package Task2;
public class BracuBus {

    private String route;
    private int maxPsgCount;
    public int passengerCount = 0;

    public String getRoute() {
        return route;
    }

    public void setRoute(String newRoute) {
        this.route = newRoute;
    }

    public int getMaxPsgCount() {
        return maxPsgCount;
    }

    public void setMaxPsgCount(int num) {
        this.maxPsgCount = num;
    }

    public BracuBus(String loc) {
        setRoute(loc);
    }

    public BracuBus(String loc, int num) {
        setRoute(loc);
        setMaxPsgCount(num);
    }

    public void showDetails() {
        System.out.println("Bus Route: " + getRoute());
        System.out.println("Passenger Count:" + passengerCount + "(Max: " + getMaxPsgCount() + ")");
        System.out.println("Passenger on board:");
    }

    public void board() {

        System.out.println("No passengers");

    }

    public void board(BracuStudent obj1, BracuStudent obj2) {

        if (passengerCount >= 2) {
            System.out.println("Bus is full!");
            return;
        }

        if (obj1.pass == !true) {
            System.out.println("You don't have a bus pass!");
        } else {
            System.out.println(obj1.getName() + "boarded the bus");
            passengerCount++;
        }
        if (obj2.pass == !true) {
            System.out.println("You don't have a bus pass!");
        } else {
            System.out.println(obj2.getName() + "boarded the bus");
            passengerCount++;
        }
    }

    public void board(BracuStudent obj1) {

        if (passengerCount >= 2) {
            System.out.println("Bus is full!");
            return;
        }

        if (obj1.pass == !true) {
            System.out.println("You don't have a bus pass!");
        } else {
            System.out.println(obj1.getName() + "boarded the bus");
            passengerCount++;
        }
    }

}
