package controllers;

/**
 * The tool to create circles
 *
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import composit.Circle;
import model.DrawingModel;
import views.DrawingPanel;

public class CircleTool
        extends DrawingTool {

    private boolean iAmActive;
    private Point myCenter;
    private int myRadius;

    public CircleTool(DrawingModel drawingModel, DrawingPanel drawingPanel) {
        super(drawingModel, drawingPanel);
        iAmActive = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!iAmActive) {
            // Center
            iAmActive = true;
            myCenter = e.getPoint();
            myRadius = 0;
            myPanel.setCursor(
                    Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)
            );
            myPanel.repaint();
        } else {
            // Radius
            iAmActive = false;
            myPanel.setCursor(Cursor.getDefaultCursor());
            myModel.createShape(
                    new Circle(myCenter, myRadius)
            );
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (iAmActive) {
            myRadius = (int) (myCenter.distance(e.getPoint()));
            myPanel.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public void draw(Graphics2D g) {
        if (iAmActive) {
            g.setColor(Color.red);
            g.drawOval(
                    myCenter.x - myRadius,
                    myCenter.y - myRadius,
                    myRadius * 2,
                    myRadius * 2
            );
        }
    }
}
