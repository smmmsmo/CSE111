package Task2;

public class BracuStudent {
    private String name;
    private String homeLocation;
    public boolean pass = false;

    public String getName() {
        return name;
    }

    public void setName(String nm) {
        this.name = nm;
    }

    public String getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(String location) {
        this.homeLocation = location;
    }

    public BracuStudent(String newName, String newLocation) {
        setName(newName);
        setHomeLocation(newLocation);
    }

    public void collectPass() {
        this.pass = true;
    }

    public void showDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Lives in " + getHomeLocation());
        System.out.println("Have Bus Pass? " + pass);

    }

    public void setLocation(String newLoc) {
        setHomeLocation(newLoc);
    }

}
