package views;

import composit.Shape;
import controllers.DrawingTool;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import model.DrawingModel;

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
        extends JPanel implements DrawingView {

    private DrawingTool myTool;
    private List<Shape> shapesToDraw;
    
    public DrawingPanel() {
        super();
        myTool = null;
        shapesToDraw = new ArrayList<>();
        setBackground(java.awt.Color.white);
        setFocusable(true);
    }

    public void setDrawingTool(DrawingTool drawingTool){
        if (myTool != null){
            removeKeyListener(myTool);
            removeMouseListener(myTool);
            removeMouseMotionListener(myTool);
        }
        addKeyListener(drawingTool);
        addMouseListener(drawingTool);
        addMouseMotionListener(drawingTool);
        myTool = drawingTool;
    }
    
    @Override
    public void paintComponent(Graphics g){
        System.out.println("DEBUG : PAINT");
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(qualityHints);
        for (Shape s : shapesToDraw) {
            s.draw(g2);
        }
        if (myTool != null) myTool.draw(g2);
    }
    
    @Override
    public void update(DrawingModel drawingModel) {
        shapesToDraw = drawingModel.getShapes();
        repaint();
    }
}
