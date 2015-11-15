/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import model.DrawingModel;

public interface DrawingView {
    
    /**
     * Update the View when a model change
     * @param drawingModel the model that has changed
     */
    void update(DrawingModel drawingModel);
}
