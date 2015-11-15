/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import composit.Circle;
import composit.Line;
import composit.Shape;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.DrawingModel;

/**
 *
 * @author Dimitri
 */
public class InfoPanel extends JPanel implements DrawingView {

    private static final String NO_SHAPE_TEXT = "There is no shape in this Drawing.";
    private JLabel infoLabel;

    public InfoPanel() {
        infoLabel = new JLabel(NO_SHAPE_TEXT);
        add(infoLabel);
    }

    @Override
    public void update(DrawingModel drawingModel) {
        List<Shape> shapes = drawingModel.getShapes();
        int circleCpt = 0,
                lineCpt = 0;
        if (shapes.isEmpty()) {
            infoLabel.setText(NO_SHAPE_TEXT);
        } else {
            String text = "There is ";
            for (Shape s : shapes) {
                if (s instanceof Circle) {
                    circleCpt++;
                } else if (s instanceof Line) {
                    lineCpt++;
                }
            }
            
            if (lineCpt == 0) text += "no line and ";
            else if (lineCpt == 1) text += lineCpt + " line and ";
            else text += lineCpt + " lines and ";
            
            if (circleCpt == 0) text += "no circle.";
            else if (circleCpt == 1) text += circleCpt + " circle.";
            else text += circleCpt + " circles.";
            infoLabel.setText(text);
        }

    }

}
