package simpledraw.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import visitor.ShapeVisitor;

/**
 * A circle
 *
 */
public class Circle
        extends Shape {

    private Point myCenter;
    private int myRadius;
    public static final String TYPE = "CIRCLE";
    private final String myType = TYPE;
    /**
     * Construct a Circle
     *
     * @param center The center of the circle
     * @param radius The radius of the circle
	 *
     */
    public Circle(Point center, int radius) {
        myCenter = center;
        myRadius = radius;
    }

    public void draw(Graphics2D g) {
        g.setColor(
                isSelected()
                        ? Color.red
                        : Color.black
        );
        g.drawOval(myCenter.x - myRadius,
                myCenter.y - myRadius,
                myRadius * 2,
                myRadius * 2
        );
    }

    public void translateBy(int dx, int dy) {
        myCenter.translate(dx, dy);
    }

    public boolean isPickedBy(Point p) {
        return (Math.abs(myCenter.distance(p) - myRadius) <= 2);
    }

    public String getType() {
        return myType;
    }
    
    @Override
    public void accept(ShapeVisitor sv) {
        sv.visit(this);
    }
}
