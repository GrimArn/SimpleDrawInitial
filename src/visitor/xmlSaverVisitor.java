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
 * @author Dimitri
 */
public class xmlSaverVisitor implements ShapeVisitor {

    @Override
    public void visit(Circle c) {
        //TODO Il faudrait parser le cercle en XML et l'ajouter au fichier
    }

    @Override
    public void visit(Line l) {
       //TODO Il faudrait parser la ligne en XML et l'ajouter au fichier 
    }

    @Override
    public void visit(PolyLine p) {
        //TODO Il faudrait parser la ligne en XML et l'ajouter au fichier
    }
    
}
