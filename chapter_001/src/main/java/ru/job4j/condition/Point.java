package ru.job4j.condition;

/**
 * Point - class.
 * @author Svyatoslav Sabirov.
 * @since 24.01.2018.
 * @version $id$.
 */
public class Point {

    private int x;
    private int y;

    /**
     * Constructor.
     * @param x - first number.
     * @param y - second number.
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method.
     * @param that - point.
     * @return - distance.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * Our main method.
     * @param args - default.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}