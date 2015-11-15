package simpledraw;

import controllers.CircleTool;
import controllers.LineTool;
import controllers.SelectionTool;
import views.DrawingPanel;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import model.Drawing;
import model.DrawingModel;
import views.InfoPanel;
import visitors.XmlSaver;

/**
 * Main Frame of SimpleDraw
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class MainFrame
        extends JFrame {

    JToggleButton mySelectButton = new JToggleButton("Select");
    JToggleButton myLineButton = new JToggleButton("Line");
    JToggleButton myCircleButton = new JToggleButton("Circle");
    JButton myXMLSaverButton = new JButton("XML Saver");
    XmlSaver myXmlSaver;
    DrawingModel myDrawingModel;
    InfoPanel myInfoPanel;
    DrawingPanel myDrawingPanel;
    CircleTool myCircleTool;
    LineTool myLineTool;
    SelectionTool mySelectionTool;
    /**
     * Construct the frame
     */
    public MainFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        myDrawingModel = new Drawing();
        myDrawingPanel = new DrawingPanel();
        myInfoPanel = new InfoPanel();
        myXmlSaver = new XmlSaver(myDrawingModel);
        myDrawingModel.addView(myDrawingPanel);
        myDrawingModel.addView(myInfoPanel);
        myCircleTool = new CircleTool(myDrawingModel, myDrawingPanel);
        myLineTool = new LineTool(myDrawingModel, myDrawingPanel);
        mySelectionTool = new SelectionTool(myDrawingModel, myDrawingPanel);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Component initialization
     */
    private void jbInit() throws Exception {
        getContentPane().setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        mySelectButton.setSelected(true);
        mySelectButton.setToolTipText("Select and move shapes");
        myCircleButton.setToolTipText("Draw a Circle");
        myLineButton.setToolTipText("Draw a Line");

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.add(mySelectButton, null);
        buttonPanel.add(myLineButton, null);
        buttonPanel.add(myCircleButton, null);
        buttonPanel.add(myXMLSaverButton, null);
        getContentPane().add(myDrawingPanel, BorderLayout.CENTER);
        getContentPane().add(myInfoPanel, BorderLayout.SOUTH);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(mySelectButton);
        buttonGroup.add(myLineButton);
        buttonGroup.add(myCircleButton);

        setSize(new Dimension(400, 300));
        setTitle("Simple Draw");

        mySelectButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myDrawingPanel.setDrawingTool(mySelectionTool);
                    }
                }
        );

        myLineButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myDrawingPanel.setDrawingTool(myLineTool);
                        mySelectionTool.unselectAll();
                    }
                }
        );

        myCircleButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myDrawingPanel.setDrawingTool(myCircleTool);
                        mySelectionTool.unselectAll();
                    }
                }
        );
        
        myXMLSaverButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myXmlSaver.saveMyModel();
            }
        });
    }

    /**
     * Overridden so we can exit when window is closed
     */
    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
}
