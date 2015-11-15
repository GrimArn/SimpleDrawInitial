/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitors;

/**
 *
 * @author Dimitri
 */
public interface ShapeVisited {
    
    void accept(ShapeVisitor shapeVisitor);
}
