
public class Vehicle2010User {
    public static void main(String[] args) {
        Vehicle2010 car1 = new Vehicle2010();
        System.out.println(car1);
        car1.moveLowerLeft();
        System.out.println(car1);
        Vehicle2010 car2 = new Vehicle2010();
        System.out.println(car2);
        car2.moveUpperRight();
        System.out.println(car2);
        car2.moveLowerRight();
        System.out.println(car2);
    }
}

class Vehicle {
    public int x;
    public int y;

    public void moveUp() {
        y = y + 1;
    }

    public void moveDown() {
        y = y - 1;
    }

    public void moveLeft() {
        x = x - 1;
    }

    public void moveRight() {
        x = x + 1;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Vehicle2010 extends Vehicle {
    public void moveUpperRight() {
        moveUp();
        moveRight();
    }

    public void moveLowerRight() {
        moveDown();
        moveRight();
    }

    public void moveLowerLeft() {
        moveDown();
        moveLeft();
    }

}