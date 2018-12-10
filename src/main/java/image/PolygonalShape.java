package image;

import javafx.scene.paint.Color;



public class PolygonalShape implements Shape{

    /**
     * A small double used to bound the precision of the comparison of doubles.
     */
    final static double EPSILON = 1e-9;
    private Point[] points ;
    private double[] angles ;
    Color color ;


    public PolygonalShape(Point[] points , Color color ) {
        this.points = points.clone();
        this.color = color ;

    }

    /**
     *
     *  Given a @param point , calculate all the angles between this point and two other points of the Polygonal shape.
     *  The formula is extract from the AL-KACHI theorem . where angle = arccos(a²+c²-b²/2ac)
     */
    public void calculateAngles(Point point){


        this.angles = new double[points.length];
        for (int i = 0 ; i < this.points.length ; i++){

          this.angles[i] = Math.pow(distanceTo(this.points[i],point),2)+
                  Math.pow(distanceTo(point,this.points[i+1 < this.points.length ? i+1 : 0]),2)
                    -Math.pow(distanceTo(this.points[i],this.points[i+1 < this.points.length ? i+1 : 0]),2);

          this.angles[i] /= 2*distanceTo(this.points[i],point)*distanceTo(point,this.points[i+1 < this.points.length ? i+1 : 0]);

        }

    }

    /**
     * Given two points a and b
     * @param a
     * @param b
     * @return the distance from a to b .
     */
    public double distanceTo(Point a , Point b){
        return Math.sqrt(Math.pow(a.x - b.x,2)+Math.pow(a.y-b.y,2));
    }

    /**
     * Check if a point is in the shape or not
     * @param point
     * @return true if the point is in the shape
     */
    @Override
    public boolean contains(Point point) {
        calculateAngles(point);
        double sumAngle = 0;
        for ( int i = 0 ; i < this.angles.length ; i++){
            sumAngle+= this.angles[i];
        }
        return doubleCompare(sumAngle,360.0) == 0 ;
    }

    /**
     * Comparison of doubles (up to <code>EPSILON</code>)
     * <p>
     * Please note that floating-point comparison is very tricky, this function
     * is not suited to compare small floating-point numbers.
     *
     * @param d1 an arbitrary double
     * @param d2 an arbitrary double
     * @return the result of comparing <code>d1</code> and <code>d2</code>.
     */
    static int doubleCompare(double d1, double d2) {
        double diff = d1 - d2;
        return
                (diff > EPSILON) ? 1 :
                        (diff < -EPSILON) ? -1 :
                                0;
    }
    /**
     *
     * @return the color of the shape
     */
    @Override
    public Color getColor() {
        return this.color ;
    }
}
