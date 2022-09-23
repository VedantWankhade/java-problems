package oop.inheritance;

import java.util.Date;

public abstract class GenericObject {
    private String color;
    private boolean filled;
    private Date dateCreated;

    public GenericObject(String color, boolean filled) {
        this.dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public abstract double getArea();

    public GenericObject() {
        this("white", false);
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    @Override
    public String toString() {
        return "GenericObject {\n\tdateCreated: " + this.dateCreated + "\n\tcolor: " + this.color + "\n\tfilled: " + this.filled + "\n}";
    }
}
