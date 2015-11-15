package model;

/**
 * Drawing, a collection of Shapes
 *
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Shape
 */
import composit.Shape;
import java.util.*;

import java.awt.Graphics2D;
import java.awt.Point;
import views.DrawingView;

public class Drawing implements DrawingModel {

    /**
     * A drawing is a collection of shapes
     */
    private final List<Shape> myShapes;

    /**
     * A collection of views
     */
    private final List<DrawingView> myViews;
    
    public Drawing() {
        myShapes = new LinkedList<>();
        myViews = new ArrayList<>();
    }

    @Override
    public void addView(DrawingView drawingView) {
        myViews.add(drawingView);
    }

    @Override
    public void removeView(DrawingView drawingView) {
        myViews.remove(drawingView);
    }

    @Override
    public List<Shape> getShapes() {
        return myShapes;
    }

    @Override
    public Shape pickShapeAt(int x, int y){
        return pickShapeAt(new Point(x,y));
    }
    
    @Override
    public Shape pickShapeAt(Point p) {
        Shape result = null;
        for (Shape s : myShapes) {
            if (s.isPickedBy(p)) {
                result = s;
                break;
            }
        }
        return result;
    }

    @Override
    public void createShape(Shape shape) {
        myShapes.add(shape);
        notifyViews();
    }

    @Override
    public void deleteShape(Shape s) {
        myShapes.remove(s);
        notifyViews();
    }
    
    @Override
    public void selectShape(Shape shape, boolean isSelected) {
        shape.setSelected(isSelected);
        notifyViews();
    }

    @Override
    public void translateShape(Shape shape, int dx, int dy) {
        shape.translateBy(dx, dy);
        notifyViews();
    }
    
    @Override
    public void notifyViews(){
        for(DrawingView dv : myViews){
            dv.update(this);
        }
    }
}
