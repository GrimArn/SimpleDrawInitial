/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import simpledraw.model.Circle;
import simpledraw.model.Line;
import simpledraw.model.PolyLine;

/**
 * 
 */
public interface ShapeVisitor {
    
    void visit(Circle c);
    void visit(Line l);
    void visit(PolyLine p);
    
}
