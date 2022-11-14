import java.util.Objects;

/**
 * Contains segment, its extreme points, length k-factor and b-factor
 */

public class Segment {

    /** length of the segment*/
    private Double segLength;

    /** k-factor(slope) of the line on which the segment lies */
    private Double lineK;

    /** b-factor(absolute term) of the line on which the segment lies */
    private Double lineB;
    /** segment start point*/
    private Point A;
    /** segment end point*/
    private Point B;

    public Segment(Point A, Point B) {
        try {
            this.A = A;
            this.B = B;
            this.lineK = (A.getY() - B.getY()) / (A.getX() - B.getX());
            this.segLength = Math.sqrt((A.getY() - B.getY()) * (A.getY() - B.getY())
                    + (A.getX() - B.getX()) * (A.getX() - B.getX()));
            this.lineB = A.getY() - this.lineK*A.getX();
            if(this.lineK.equals(Double.NEGATIVE_INFINITY)){
                this.lineK = Double.POSITIVE_INFINITY;
            }
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public Double getFactorK() {
        return lineK;
    }

    public Point getPointB() {
        return B;
    }

    public Point getPointA() {
        return A;
    }

    public Double length() {
        return segLength;
    }

    public Double getFactorB() {
        return lineB;
    }

    @Override
    public String toString() {
        return   "{" + A.toString() + ", " + B.toString() + "}";
    }
    /** returns true if segment is parallel to this segment, otherwise - false */
    public boolean isParallel(Segment segment){
        return this.lineK.equals(segment.lineK);
    }

    /** returns true if segment is on the same line with this segment, otherwise - false */
    public boolean isOnTheSameLine(Segment segment){
        return this.isParallel(segment) & (this.lineB.equals(segment.lineB));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segment segment)) return false;
        return Objects.equals(A, segment.A) && Objects.equals(B, segment.B);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A.hashCode(), B.hashCode());
    }
}
