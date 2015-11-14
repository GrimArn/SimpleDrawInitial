package simpledraw.controller;

import simpledraw.model.Shape;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import simpledraw.model.DrawingModel;
import simpledraw.view.DrawingPanel;

/**
 * The tool to select, move and delete Shapes in the Drawing
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class SelectionTool
        extends DrawingTool {

    private Integer myIndexSelectedShape = null;
    private Point myLastPoint;

    public SelectionTool(DrawingModel model, DrawingPanel panel) {
        super(model, panel);
      //  panel.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("DEBIUG");
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {
            if (myIndexSelectedShape != null) {
                myModel.deleteShape(myIndexSelectedShape);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Integer indexShape = myModel.pickIndiceShapeAt(e.getPoint());
        myLastPoint = e.getPoint();
        if (myIndexSelectedShape != null) {
            myModel.setSelected(myIndexSelectedShape, false);
        }
        myIndexSelectedShape = indexShape;
        if (myIndexSelectedShape != null) {
            myModel.setSelected(indexShape, true);
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Integer pickedShape = myModel.pickIndiceShapeAt(e.getPoint());
        if (pickedShape != null) {
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            myPanel.setCursor(Cursor.getDefaultCursor());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (myIndexSelectedShape != null) {
            myModel.translateShape(myIndexSelectedShape,
                    e.getX() - myLastPoint.x,
                    e.getY() - myLastPoint.y
            );
            myLastPoint = e.getPoint();
            myPanel.repaint();
        }
    }

    @Override
    public void draw(Graphics2D g) {
    }

    @Override
    public String toString() {
        return "Ceci est un message de debug";
    }
    
    

}
