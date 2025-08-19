public class Travel {
    public static int x = 0;
    
    public String a;
    public String b;
    public int t;
    
    public Travel(String src, String dst) {
        this.a = src;
        this.b = dst;
        this.t = 1;
        x++;
    }
    
    public static int getCount() {
        return x;
    }
    
    public void setTime(int h) {
        this.t = h;
    }
    
    public void setSource(String s) {
        this.a = s;
    }
    
    public void setDestination(String d) {
        this.b = d;
    }
    
    public String displayTravelInfo() {
        return "Source: " + a + "\n" +
                "Destination: " + b + "\n" +
                "Flight Time: " + t + ":00";
    }
}