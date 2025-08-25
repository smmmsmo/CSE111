public class Vehicle {
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