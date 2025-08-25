
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