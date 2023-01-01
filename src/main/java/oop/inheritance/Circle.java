package oop.inheritance;

public class Circle extends GenericObject {
    private double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * this.radius;
    }

    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }
  

    @Override
    public String toString() {
        return "Circle {\n\tradius: " + this.radius + "\n\tdateCreated: " + this.getDateCreated() + "\n\tcolor: " + this.getColor() + "\n\tfilled: " + this.isFilled() + "\n}";
//        return "Circle {\n\tradius: "+ this.radius + "\n\t" + super.toString() + "}";
    }
}
