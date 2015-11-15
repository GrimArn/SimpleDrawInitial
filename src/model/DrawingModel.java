/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import composit.Shape;
import java.awt.Point;
import java.util.List;
import views.DrawingView;

/**
 *
 * @author Dimitri
 */
public interface DrawingModel {

    /**
     * Add a view to the model
     * @param drawingView 
     */
    void addView(DrawingView drawingView);

    /**
     * Remove a view to the model
     * @param drawingView 
     */
    void removeView(DrawingView drawingView);

    /**
     * Notify all views every time the model change
     */
    void notifyViews();
    
    /**
     * Gets the list of shapes
     * @return the list of shapes in the drawing
     */
    List<Shape> getShapes();

    /**
     * Determines whether the given Point lies whithin a Shape
     *
     * @param x The x coordinate to test
     * @param y The y coordinate to test
     * @return A Shape selected by this Point or null if no Shape is there
     *
     */
    Shape pickShapeAt(int x, int y);

    /**
     * Determines whether the given Point lies whithin a Shape
     *
     * @param p The Point to test
     * @return A Shape selected by this Point or null if no Shape is there
     *
     */
    Shape pickShapeAt(Point p);

    /**
     * Create a shape from the Drawing
     *
     * @param shape The Shape to create
     */
    void createShape(Shape shape);

    /**
     * Delete a shape from the Drawing
     *
     * @param shape The Shape to delete
     *
     */
    void deleteShape(Shape shape);

    /**
     * Select or unselect a shape from the Drawing
     *
     * @param shape The Shape to select or unselect
     * @param isSelected select or unselect
     */
    void selectShape(Shape shape, boolean isSelected);

    /**
     * Translate a shape from Drawing
     *
     * @param shape The Shape to translate
     * @param dx The X vector
     * @param dy The Y vector
     */
    void translateShape(Shape shape, int dx, int dy);
}
