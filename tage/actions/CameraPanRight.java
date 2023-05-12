package tage.actions;

import a3.MyGame;
import net.java.games.input.Event;
import org.joml.Vector3f;
import tage.Camera;
import tage.input.action.AbstractInputAction;

public class CameraPanRight extends AbstractInputAction {
    private MyGame g;
    private Camera c ;

    public CameraPanRight(MyGame game){
        g = game;
        c =g.getEngine().getRenderSystem().getViewport("RIGHT").getCamera();
    }
    /// X componenet left or right
    @Override
    public void performAction(float time, Event evt) {


        c.setLocation(new Vector3f(c.getLocation().x+.02f,c.getLocation().y,c.getLocation().z));



    }
}
