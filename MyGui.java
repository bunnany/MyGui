import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * Making some sliders and responding to mouse events
 *
 * @author NYB
 * @version 07/03/23
 */
public class MyGui
{
    // instance variables
    private double speed;
    
    // fields to remember "pressed" position
    private double startX, startY;

    // Remember the colour
    private Color currentColor = Color.black;
    
    /**
     * Constructor for objects of class MyGui
     */
    public MyGui()
    {
        // initialise instance variables
        speed = 0;
        
        // setup buttons
        UI.addButton("Quit", UI::quit);
        
        // Colour Buttons
        UI.addButton("Colour", this::chooseColour);
        UI.addButton("Random Colour", this::changeColour);
        
        // setup slider
        UI.addSlider("Speed", 0, 100, 20, this::setSpeed);
        
        // Setup mouse listener
        UI.setLineWidth(10);
        UI.setMouseListener(this::doMouse);
    }

    /**
     * Callback method for speed slider
     */
    public void setSpeed(double km) {
        // check if it is greater or less than last speed
        if (speed < km) {
            UI.println("Accelerating");
        } else if (speed > km) {
            UI.println("Deccelerating");
        } else {
            UI.println("Stationary");
        }
        
        // Set the speed to the new speed
        this.speed = km;
    }
    
    /**
     * Callback method to mouse listener
     * Only make one callback method to the mouse listener!
     */
    public void doMouse(String action, double x, double y) {
        double width = 50;
        double height = 50;
        if (action.equals("clicked")) {
            UI.fillOval(x-width/2, y-height/2, width, height);
        } else if (action.equals("pressed")) {
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released")) {
            UI.drawLine(this.startX, this.startY, x, y);
        }
    }
    
    /**
     * Change to a random Colour
     */
    public void changeColour() {
        //RGB values
        Color col = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        UI.setColor(col);
    }
    
    /**
     * Allows the user to choose a colour using the swing library
     */
    public void chooseColour() {
        this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
        UI.setColor(this.currentColor);
    }
}
