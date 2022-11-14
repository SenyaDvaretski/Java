import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class checkShapeTest {

    @Test
    void checkShapeRhombusResult() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 1));
        points.add(new Point(3, 4));
        points.add(new Point(6, 5));
        points.add(new Point(5, 2));
        points.add(new Point(2, 1));
        assertEquals("rhombus", Main.checkShape(points));
    }

    @Test
    void checkShapeSquareResult() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(1, 3));
        points.add(new Point(3, 3));
        points.add(new Point(3, 1));
        points.add(new Point(1, 1));
        assertEquals("square", Main.checkShape(points));
    }

    @Test
    void checkShapeParallelogramResult() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(1, 4));
        points.add(new Point(3, 5));
        points.add(new Point(3, 2));
        points.add(new Point(1, 1));
        assertEquals("parallelogram", Main.checkShape(points));
    }

    @Test
    void checkShapeTetragonResult() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 1));
        points.add(new Point(3, 4));
        points.add(new Point(4, 5));
        points.add(new Point(5, -1));
        points.add(new Point(2, 1));
        assertEquals("tetragon", Main.checkShape(points));
    }

    @Test
    void checkShapeNotTetragonResult() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(4, 4));
        points.add(new Point(5, 5));
        points.add(new Point(1, 1));
        assertEquals("not-tetragon", Main.checkShape(points));
    }

    @Test
    void checkShapeNegativeSquareResult() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(-2, -2));
        points.add(new Point(-2, -1));
        points.add(new Point(-1, -1));
        points.add(new Point(-1, -2));
        points.add(new Point(-2, -2));
        assertEquals("square", Main.checkShape(points));
    }
}