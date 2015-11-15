/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitors;

import composit.Circle;
import composit.GroupShape;
import composit.Line;

/**
 *
 * @author Dimitri
 */
public interface ShapeVisitor {
    
    void visit(Line l);
    
    void visit(Circle c);
    
    void visit(GroupShape gs);
}
