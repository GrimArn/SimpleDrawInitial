package controllers;

import composit.GroupShape;
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

    private GroupShape mySelectedShapes = null;
    private Point myLastPoint;

    private boolean controlPressed = false;

    public SelectionTool(DrawingModel drawingModel, DrawingPanel drawingPanel) {
        super(drawingModel, drawingPanel);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            controlPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            if (mySelectedShapes != null) {
                for (Shape s : mySelectedShapes.getShapes()){
                    myModel.deleteShape(s);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            controlPressed = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Shape pickedBy = myModel.pickShapeAt(e.getPoint());
        myLastPoint = e.getPoint();
        if (controlPressed) {
            if (mySelectedShapes != null) {
                if (pickedBy != null) {
                    if (mySelectedShapes.isAlreadyGrouped(pickedBy)) {
                        mySelectedShapes.removeShape(pickedBy);
                        myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                        myModel.selectShape(pickedBy, false);
                    } else {
                        mySelectedShapes.addShape(pickedBy);
                        myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                        myModel.selectShape(mySelectedShapes, true);
                    }
                }
            } else {
                if (pickedBy != null) {
                    mySelectedShapes = new GroupShape();
                    mySelectedShapes.addShape(pickedBy);
                    myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                    myModel.selectShape(mySelectedShapes, true);
                }
            }
        } else {
            if (mySelectedShapes != null) {
                if (pickedBy != null) {
                    myModel.selectShape(mySelectedShapes, false);
                    mySelectedShapes = new GroupShape();
                    mySelectedShapes.addShape(pickedBy);
                    myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                    myModel.selectShape(mySelectedShapes, true);
                } else {
                    myModel.selectShape(mySelectedShapes, false);
                    mySelectedShapes = null;
                }
            } else {
                if (pickedBy != null) {
                    mySelectedShapes = new GroupShape();
                    mySelectedShapes.addShape(pickedBy);
                    myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                    myModel.selectShape(mySelectedShapes, true);
                }
            }
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
        if (mySelectedShapes != null) {
            myModel.translateShape(mySelectedShapes,
                    e.getX() - myLastPoint.x,
                    e.getY() - myLastPoint.y
            );
            myLastPoint = e.getPoint();
        }
    }

    @Override
    public void draw(Graphics2D g) {
    }
    
    public void unselectAll(){
        if(mySelectedShapes != null){
            myModel.selectShape(mySelectedShapes, false);
            mySelectedShapes = null;
            controlPressed = false;
        } else {
            controlPressed = false;
        }
    }

}
