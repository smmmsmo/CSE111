public class Travel {

    private static int count = 0;
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Travel.count = count;
    }


    private String source;
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }


    private String destination;
    public String getDestination() {
        return destination;
    }
    public void setDestination(String newDestination) {
        this.destination = newDestination;
    }


    private int time = 1;
    public int getTime() {
        return time;
    }
    public void setTime(int newTime) {
        this.time = newTime;
    }


    public Travel(String source, String destination) {
        setSource(source);
        setDestination(destination);
        count++;
    }

    public String displayTravelInfo() {
        return ("Source: " + getSource() + "\n"+
                "Destination: " + getDestination() + "\n" +
                "Flight Time: " + getTime()+":00");
    }
}