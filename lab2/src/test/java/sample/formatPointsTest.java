package sample;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class formatPointsTest {

    @Test
    void formatPointsDefault() {
        List<Point> realPoints = new ArrayList<>();
        realPoints.add(new Point(2, 1));
        realPoints.add(new Point(6, 5));
        realPoints.add(new Point(3, 4));
        realPoints.add(new Point(5, 2));

        realPoints = Main.formatPoints(realPoints);

        List<Point> expectedPoints = new ArrayList<>();
        expectedPoints.add(new Point(2, 1));
        expectedPoints.add(new Point(3, 4));
        expectedPoints.add(new Point(6, 5));
        expectedPoints.add(new Point(5, 2));
        expectedPoints.add(new Point(2, 1));

        assertEquals(expectedPoints, realPoints);
    }

    @Test
    void formatPointsSegmentsParallelOY() {
        List<Point> realPoints = new ArrayList<>();
        realPoints.add(new Point(1, 1));
        realPoints.add(new Point(4, 4));
        realPoints.add(new Point(4, 2));
        realPoints.add(new Point(1, 3));

        realPoints = Main.formatPoints(realPoints);

        List<Point> expectedPoints = new ArrayList<>();
        expectedPoints.add(new Point(1, 1));
        expectedPoints.add(new Point(1, 3));
        expectedPoints.add(new Point(4, 4));
        expectedPoints.add(new Point(4, 2));
        expectedPoints.add(new Point(1, 1));

        assertEquals(expectedPoints, realPoints);
    }
}