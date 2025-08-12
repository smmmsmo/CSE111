package Task1;
public class Circle {

    private double radius;
    
    public Circle(double num){
        setRadius(num);
    }

    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double rad){
        this.radius = rad;
    }
    
    public double area(){
        return Math.PI*getRadius()*getRadius();
    }    

}
