package simpledraw.controller;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import simpledraw.model.DrawingModel;
import simpledraw.view.DrawingPanel;

/**
 * A Drawing tool in the drawing panel
 */
public abstract class DrawingTool
        implements KeyListener, MouseListener, MouseMotionListener {

 
    //private final Drawing myDrawing;
    protected final DrawingModel myModel;
    protected final DrawingPanel myPanel;

    public DrawingTool(DrawingModel m, DrawingPanel dp) {
       // myDrawing = panel.getMyDrawing();
        myModel = m;
        myPanel = dp;

    }

    public abstract void draw(Graphics2D g);
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
            System.out.println("ciou");
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
