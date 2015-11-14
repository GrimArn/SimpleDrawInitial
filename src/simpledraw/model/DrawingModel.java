/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import simpledraw.view.DrawingViewInterface;

/**
 *
 * @author nonau
 */
public class DrawingModel {

    /**
     * A drawing is a collection of shapes
     */
    private List<Shape> myShapes = new LinkedList<>();

    
    private List<DrawingViewInterface> views = new ArrayList<>();
    
    /**
     * Add a shape to the Drawing
     *
     * @param s The Shape to add
     *
     */
    public void addShape(Shape s) {
        myShapes.add(s);
        notifyViews();
    }

    /**
     * Delete a shape from the Drawing
     *
     * @param i The Shape index to delete
     *
     */
    public void deleteShape(int i) {
        myShapes.remove(i);
        notifyViews();
    }

    public void registerView(DrawingViewInterface dvi){
        views.add(dvi);
    }
    
    public void unregisterView(DrawingViewInterface dvi){
        views.remove(dvi);
    }
    
    /**
     * Determines whether the given Point lies whithin a Shape
     *
     * @param p The Point to test
     * @return A Shape selected by this Point or null if no Shape is there
	 *
     */
    public Integer pickIndiceShapeAt(Point p) {
        Integer indice = null;
        int i = 0;
        for (Shape s : myShapes) {
            if (s.isPickedBy(p)) {
                indice = i;
                return indice;
            }
            i++;
        }
        return indice;
    }
    
    public void setSelected(int i, boolean select) {
        myShapes.get(i).setSelected(select);
        notifyViews();
    }
    
    public void translateShape(int i, int dx, int dy){
        Shape s = myShapes.get(i);
        if (s != null) s.translateBy(dx, dy);
        notifyViews();
    }
    
    public List<Shape> getMyShapes(){
        return myShapes;
    }

    public void notifyViews(){
        for(DrawingViewInterface dvi:views){
            dvi.notifyView();
        }
    }
}
