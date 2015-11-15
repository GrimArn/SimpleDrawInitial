/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composit;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dimitri
 */
public abstract class CompositeShape extends Shape {
    
    protected final List<Shape> componantShapes;
    
    public CompositeShape(){
        componantShapes = new ArrayList<>();
    }
    
    public void addShape(Shape shape){
        componantShapes.add(shape);
    }
    
    public void removeShape(Shape shape){
        componantShapes.remove(shape);
    }
    
    public List<Shape> getShapes(){
        return componantShapes;
    }
}
