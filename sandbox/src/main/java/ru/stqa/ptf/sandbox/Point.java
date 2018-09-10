package ru.stqa.ptf.sandbox;

public class Point {

    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public double distance(Point p2){
        return
        Math.sqrt((p2.x - this.x)*(p2.x - this.x) + (p2.y-this.y)*(p2.y-this.y));
    }
}
