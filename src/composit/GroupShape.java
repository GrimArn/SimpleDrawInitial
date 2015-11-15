/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composit;

import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Dimitri
 */
public class GroupShape extends CompositeShape {
    
    @Override
    public void draw(Graphics2D g) {
        for(Shape s : componantShapes){
            s.draw(g);
        }
    }

    @Override
    public void setSelected(boolean isSelected){
        for(Shape s : componantShapes){
            s.setSelected(isSelected);
        }
    }
    
    @Override
    public void translateBy(int dx, int dy) {
        for(Shape s : componantShapes){
            s.translateBy(dx, dy);
        }
    }

    @Override
    public boolean isPickedBy(Point p) {
        for(Shape s : componantShapes){
            if (s.isPickedBy(p)) return true;
        }
        return false;
    }
    
    public boolean isAlreadyGrouped(Shape shape){
        for (Shape s : componantShapes){
            if(s.equals(shape)){
                return true;
            }
        }
        return false;
    }
}
