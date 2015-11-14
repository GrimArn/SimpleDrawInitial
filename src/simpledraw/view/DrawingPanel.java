package simpledraw.view;

import simpledraw.controller.LineTool;
import simpledraw.controller.CircleTool;
import simpledraw.controller.DrawingTool;
import simpledraw.controller.SelectionTool;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JPanel;
import simpledraw.model.DrawingModel;
import simpledraw.model.Shape;

/**
 * A Panel that displays a Drawing, and maintains a current DrawingTool<BR>
 * Uses the "State" design pattern
 *
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Drawing
 * @see simpledraw.DrawingTool
 */
public class DrawingPanel
        extends JPanel implements DrawingViewInterface {

    private DrawingModel model;
    private DrawingTool myCurrentTool;
    public DrawingPanel(DrawingModel model) {
        super();
        this.model = model;
        model.registerView(this);
        setBackground(java.awt.Color.white);
        myCurrentTool = new SelectionTool(model, this);
        activate(myCurrentTool);
        setFocusable(true);
    }

    public DrawingTool getMyCurrentTool() {
        return myCurrentTool;
    }


    public void activateSelectionTool() {
        terminate(myCurrentTool);
        myCurrentTool = new SelectionTool(model, this);
        activate(myCurrentTool);
    }

    public void activateCircleTool() {
        terminate(myCurrentTool);
        myCurrentTool = new CircleTool(model, this);
        activate(myCurrentTool);
        repaint();
    }

    public void activateLineTool() {
        terminate(myCurrentTool);
        myCurrentTool = new LineTool(model, this);
        activate(myCurrentTool);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(qualityHints);
        List<Shape> shapeList = model.getMyShapes();
        for (Shape s : shapeList) {
            s.draw(g2);
           
        }
       myCurrentTool.draw(g2);
        
    }

    private void terminate(DrawingTool t) {
        removeKeyListener(t);
        removeMouseListener(t);
        removeMouseMotionListener(t);
    }

    private void activate(DrawingTool t) {
        addKeyListener(t);
        for (KeyListener k : getKeyListeners()) {
            System.out.println(k.toString());
        }
        addMouseListener(t);
        addMouseMotionListener(t);
    }

    @Override
    public void notifyView() {
        draw();
    }

    @Override
    public void draw() {
        repaint();
    }
}
