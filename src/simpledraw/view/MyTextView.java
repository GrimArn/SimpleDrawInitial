/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw.view;

import java.util.List;
import javax.swing.JLabel;
import simpledraw.model.Circle;
import simpledraw.model.DrawingModel;
import simpledraw.model.Line;
import simpledraw.model.PolyLine;
import simpledraw.model.Shape;

/**
 *
 * @author nonau
 */
public class MyTextView extends JLabel implements DrawingViewInterface{
    
    DrawingModel myModel;
    
    public MyTextView(DrawingModel model) {
        myModel = model;
        myModel.registerView(this);
    }

    @Override
    public void notifyView() {
        draw();
    }

    @Override
    public void draw() {
        List<Shape> shapes = myModel.getMyShapes();
        int circle = 0 ,line = 0, polyline = 0;
        for (Shape s : shapes) {
            switch (s.getType()) {
                case Circle.TYPE:
                    ++circle;
                    break;
                case Line.TYPE:
                    ++line;
                    break;
                case PolyLine.TYPE:
                    ++polyline;
            }
        }
        setText("Il y a "+ circle + " cercle(s), " 
                + line + " ligne(s), " + polyline + " polyligne(s)");
    }
}
