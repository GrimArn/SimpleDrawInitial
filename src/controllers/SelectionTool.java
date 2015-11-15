package controllers;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import views.DrawingPanel;
import composit.Shape;
import model.DrawingModel;

/**
 * The tool to select, move and delete Shapes in the Drawing
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class SelectionTool
        extends DrawingTool {

    private Shape mySelectedShape = null;
    private Point myLastPoint;

    public SelectionTool(DrawingModel drawingModel, DrawingPanel drawingPanel) {
        super(drawingModel, drawingPanel);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {
            if (mySelectedShape != null) {
                myModel.deleteShape(mySelectedShape);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Shape pickedShape = myModel.pickShapeAt(e.getPoint());
        myLastPoint = e.getPoint();
        if (mySelectedShape != null) {
            myModel.selectShape(mySelectedShape, false);
        }
        mySelectedShape = pickedShape;
        if (mySelectedShape != null) {
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            myModel.selectShape(mySelectedShape, true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Shape pickedShape = myModel.pickShapeAt(e.getPoint());
        if (pickedShape != null) {
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            myPanel.setCursor(Cursor.getDefaultCursor());
        }
        myPanel.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mySelectedShape != null) {
            myModel.translateShape(mySelectedShape,
                    e.getX() - myLastPoint.x,
                    e.getY() - myLastPoint.y
            );
            myLastPoint = e.getPoint();
        }
    }

    @Override
    public void draw(Graphics2D g) {}

}
