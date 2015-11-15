package controllers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import views.DrawingPanel;
import composit.Line;
import model.DrawingModel;

/**
 * The tool to create Lines
 * @author Rémi Bastide
 * @version 1.0
 * @see composit.Line
 */

public class LineTool
	extends DrawingTool {
	private boolean iAmActive = false;
	private Point myInitialPoint;
	private Point myFinalPoint;

	public LineTool(DrawingModel drawingModel, DrawingPanel drawingPanel) {
		super(drawingModel, drawingPanel);
	}

        @Override
	public void mousePressed(MouseEvent e) {
		if (!iAmActive) {
			// First point
			iAmActive = true;
			myInitialPoint = e.getPoint();
			myFinalPoint = myInitialPoint;
			myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.
				MOVE_CURSOR));
			myPanel.repaint();
		} else {
			// Second point
			iAmActive = false;
			myPanel.setCursor(Cursor.getDefaultCursor());
			myModel.createShape(
				new Line(myInitialPoint, myFinalPoint)
				);
		}
	}

        @Override
	public void mouseDragged(MouseEvent e) {
		if (iAmActive) {
			myFinalPoint = e.getPoint();
			myPanel.repaint();
		}
	}

        @Override
	public void mouseMoved(MouseEvent e) {
            mouseDragged(e);
        }
        
        @Override
	public void draw(Graphics2D g) {
		if (iAmActive) {
			g.setColor(Color.red);
			g.drawLine(
				myInitialPoint.x,
				myInitialPoint.y,
				myFinalPoint.x,
				myFinalPoint.y
				);
		}
	}
}