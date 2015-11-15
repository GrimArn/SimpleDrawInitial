package composit;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import visitors.ShapeVisitor;

/**
 * A circle
 *
 */
public class Circle
        extends Shape {

    private final Point myCenter;
    private final int myRadius;

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

    public Point getMyCenter() {
        return myCenter;
    }

    public int getMyRadius() {
        return myRadius;
    }
    
    @Override
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
    
    @Override
    public void translateBy(int dx, int dy) {
        myCenter.translate(dx, dy);
    }
    
    @Override
    public boolean isPickedBy(Point p) {
        return (Math.abs(myCenter.distance(p) - myRadius) <= 2);
    }
    
    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visit(this);
    }
}
