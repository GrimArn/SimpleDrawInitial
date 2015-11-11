/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw.view;

import java.util.List;
import simpledraw.model.Shape;

/**
 *
 * @author nonau
 */
public interface DrawingViewInterface {
    
    void notifyView();
    
    void draw();
    
}
