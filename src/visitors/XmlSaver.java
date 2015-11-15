/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitors;

import composit.Circle;
import composit.GroupShape;
import composit.Line;
import composit.Shape;
import model.DrawingModel;

/**
 *
 * @author Dimitri
 */
public class XmlSaver implements ShapeVisitor{

    private DrawingModel myDrawingModel;
    private String content;
    
    public XmlSaver(DrawingModel dm){
        myDrawingModel = dm;
    }
    
    @Override
    public void visit(Line l) {
        content += "<Line selected=\"" + l.isSelected() + "\">"
                + "\n\r    <Point type=\"begin\">"
                + "\n\r        <X>" + l.getMyStart().x + "<\\X>"
                + "\n\r        <Y>" + l.getMyStart().y + "<\\Y>"
                + "\n\r    <\\Point>"
                + "\n\r    <Point type=\"end\">"
                + "\n\r        <X>" + l.getMyEnd().x + "<\\X>"
                + "\n\r        <Y>" + l.getMyEnd().y + "<\\Y>"
                + "\n\r    <\\Point>"
                + "\n\r<\\Line>\n\r";
    }

    @Override
    public void visit(Circle c) {
        content += "<Circle selected=\"" + c.isSelected() + "\">"
                + "\n\r    <Point type=\"center\">" 
                + "\n\r        <X>" + c.getMyCenter().x + "<\\X>"
                + "\n\r        <Y>" + c.getMyCenter().y + "<\\Y>"
                + "\n\r    <\\Point>"
                + "\n\r    <Radius>" + c.getMyRadius() + "<\\Radius>"
                + "\n\r<Circle\\>\n\r";
    }

    @Override
    public void visit(GroupShape gs) {
        //TODO Transform a GroupShape in his reprensentation in XML
    }
    
    public void saveMyModel(){
        content = "";
        for (Shape s : myDrawingModel.getShapes()){
            s.accept(this);
        }
        System.out.println(content);
    }
    
}
