import ecs100.*;
import java.awt.Color;
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

    /**
     * Constructor for objects of class MyGui
     */
    public MyGui()
    {
        // initialise instance variables
        speed = 0;
        
        // setup buttons
        UI.addButton("Quit", UI::quit);
        
        // setup slider
        UI.addSlider("Speed", 0, 100, 20, this::setSpeed);
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
}
