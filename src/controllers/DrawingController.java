/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import model.DrawingModel;

/**
 *
 * @author Dimitri
 */
public abstract class DrawingController implements KeyListener, MouseListener,
        MouseMotionListener {

    protected DrawingModel myModel;
    
    public DrawingController (DrawingModel drawingModel){
        myModel = drawingModel;
    }
    
    @Override
    public void mouseMoved(MouseEvent e){}

    @Override
    public void mouseDragged(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){}

    @Override
    public void keyTyped(KeyEvent e){}
}
