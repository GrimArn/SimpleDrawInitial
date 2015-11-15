package controllers;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import model.DrawingModel;
import views.DrawingPanel;

/**
 * A Drawing tool in the drawing panel
 */
public abstract class DrawingTool extends DrawingController {

    protected DrawingPanel myPanel;
    
    public DrawingTool(DrawingModel drawingModel, DrawingPanel drawingPanel) {
        super(drawingModel);
        myPanel = drawingPanel;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        myPanel.requestFocus();
    }
    
    public abstract void draw(Graphics2D g);
}
