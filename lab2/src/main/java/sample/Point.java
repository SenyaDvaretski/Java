package sample;

import java.util.Objects;

/**
 * Contains point with coordinates x and y
 */

public class Point  implements Comparable<Point>{

    private Double x;
    private Double y;

    public <T extends Number> Point(T x, T y) {
        setX(x);
        setY(y);
    }

    public Point() {
        this(0, 0);
    }

    public Double getX() {
        return x;
    }

    public <T extends Number> void setX(T x) {
        this.x = x.doubleValue();
    }

    public Double getY() {
        return y;
    }

    public <T extends Number> void setY(T y) {
        this.y = y.doubleValue();
    }

    @Override
    public String toString() {
        return "(" + x.toString() + ", " + y.toString() + ")";
    }

    @Override
    public int compareTo(Point point) {
        if(this.x.equals(point.x)){
            return (int)(this.y - point.y);
        }
        return (int)(this.x - point.x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        return x.equals(((Point)o).x) && y.equals(((Point)o).y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
