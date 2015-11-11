/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import simpledraw.Circle;
import simpledraw.Line;
import simpledraw.PolyLine;

/**
 * 
 */
public interface ShapeVisitor {
    
    void visit(Circle c);
    void visit(Line l);
    void visit(PolyLine p);
    
}
