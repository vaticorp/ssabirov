package ru.job4j.condition;

/**
 * My first point-class.
 * @author Svytoslav Sabirov
 * @since 23.01.2018 23:17
 * @version 1.0
 */
public class Point {

    private int x;
    private int y;

    /**
     * My first constructor.
     * @param x - first argument.
     * @param y - second argument.
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance between two points.
     * @param that - point-object.
     * @return - distance value.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * Test main.
     * @param args - default.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }

}