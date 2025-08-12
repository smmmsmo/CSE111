
public class BracuStudent {
    private String name;
    private String homeLocation;
    private boolean hasBusPass = false;

    public String getName() {
        return name;
    }

    public void setName(String nameParam) {
        this.name = nameParam;
    }

    public String getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(String homeLocationParam) {
        this.homeLocation = homeLocationParam;
    }

    public BracuStudent(String studentName, String studentHomeLocation) {
        setName(studentName);
        setHomeLocation(studentHomeLocation);
    }

    public void collectPass() {
        this.hasBusPass = true;
    }

    public void showDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Lives in " + getHomeLocation());
    System.out.println("Have Bus Pass? " + hasBusPass);

    }

    public void setLocation(String newLoc) {
        setHomeLocation(newLoc);
    }

    // Minimal getter added so BracuBus can check pass status
    public boolean hasBusPass() {
        return hasBusPass;
    }

}
