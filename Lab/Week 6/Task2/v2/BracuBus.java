public class BracuBus {

    private String route;
    private int maxPsgCount;
    public int passengerCount = 0;
    // Store passenger names in a single String (no arrays per constraint)
    private String passengerNames = "";

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
        // default capacity is 2
        setMaxPsgCount(2);
    }

    public BracuBus(String loc, int num) {
        setRoute(loc);
        setMaxPsgCount(num);
    }

    public void showDetails() {
        System.out.println("Bus Route: " + getRoute());
        System.out.println("Passenger Count: " + passengerCount + " (Max: " + getMaxPsgCount() + ")");
        System.out.println("Passengers on Board: ");
        if (passengerCount > 0) {
            System.out.println(passengerNames);
        }
    }

    public void board() {
        System.out.println("No passengers");
    }

    public void board(BracuStudent obj1, BracuStudent obj2) {
        if (passengerCount >= maxPsgCount) {
            System.out.println("Bus is full!");
            return;
        }
        // Try first student
    if (!obj1.hasBusPass()) {
            System.out.println("You don't have a bus pass!");
        } else if (!obj1.getHomeLocation().equals(route)) {
            System.out.println("You got on the wrong bus!");
        } else {
            System.out.println(obj1.getName() + " boarded the bus.");
            if (passengerCount == 0) {
                passengerNames = obj1.getName();
            } else {
                passengerNames = passengerNames + " " + obj1.getName();
            }
            passengerCount++;
        }
        // Try second student or show full message
        if (passengerCount < maxPsgCount) {
            if (!obj2.hasBusPass()) {
                System.out.println("You don't have a bus pass!");
            } else if (!obj2.getHomeLocation().equals(route)) {
                System.out.println("You got on the wrong bus!");
            } else {
                System.out.println(obj2.getName() + " boarded the bus.");
                if (passengerCount == 0) {
                    passengerNames = obj2.getName();
                } else {
                    passengerNames = passengerNames + " " + obj2.getName();
                }
                passengerCount++;
            }
        } else if (passengerCount >= maxPsgCount) {
            System.out.println("Bus is full!");
        }
    }

    public void board(BracuStudent obj1) {
        if (passengerCount >= maxPsgCount) {
            System.out.println("Bus is full!");
            return;
        }
    if (!obj1.hasBusPass()) {
            System.out.println("You don't have a bus pass!");
            return;
        }
        if (!obj1.getHomeLocation().equals(route)) {
            System.out.println("You got on the wrong bus!");
            return;
        }
        System.out.println(obj1.getName() + " boarded the bus.");
        if (passengerCount == 0) {
            passengerNames = obj1.getName();
        } else {
            passengerNames = passengerNames + " " + obj1.getName();
        }
        passengerCount++;
    }

}
