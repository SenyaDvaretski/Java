import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Даны координаты вершин некоторого четырёхугольника: (x1; y1), (x2; y2), (x3; y3) и (x4; y4).
 *  Определите, является ли этот четырёхугольник:
 *      а) параллелограммом;
 *      б) ромбом;
 *      в) квадратом?
 */

public class Main {

    public static List<Point> formatPoints(List<Point> points){
        Collections.sort(points);
        Collections.swap(points, points.size() - 1, points.size() - 2);
        points.add(points.get(0));
        return points;
    }
    public static String checkShape(List<Point> points){

        List<Segment> segments = new ArrayList<>();

        for(int i = 1; i < points.size(); i++){
            segments.add(new Segment(points.get(i - 1), points.get(i)));
        }


        if(segments.get(0).isOnTheSameLine(segments.get(2))) {
            System.out.println("The shape is not a tetragon!");
            return "not-tetragon";
        }
        else if (segments.get(0).length().equals(segments.get(2).length()) &&
                segments.get(0).isParallel(segments.get(2))){

            System.out.println("The shape is a parallelogram!");

            if(segments.get(0).length().equals(segments.get(1).length())){
                System.out.println("The shape is a rhombus!");

                Segment diagonal1 = new Segment(points.get(0), points.get(2));
                Segment diagonal2 = new Segment(points.get(1), points.get(3));

                if(diagonal1.length().equals(diagonal2.length())){
                    System.out.println("The shape is a square!");
                    return "square";
                }
                return "rhombus";
            }
            return "parallelogram";
        }
        else{
            System.out.println("The shape is just a tetragon!");
            return "tetragon";
        }
    }
    public static void main(String[] args) {

        List<Point> points = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            double x = Double.parseDouble(args[i * 2]);
            double y = Double.parseDouble(args[i * 2 + 1]);
            points.add(new Point(x, y));
        }

        checkShape(formatPoints(points));
    }
}