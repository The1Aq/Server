package tage.actions;

import a3.MyGame;
import net.java.games.input.Event;
import org.joml.Vector3f;
import tage.Camera;
import tage.input.action.AbstractInputAction;

public class CameraOut extends AbstractInputAction {
    private MyGame g ;
    private Camera c;


    public CameraOut(MyGame game){
        g = game;
        c = g.getEngine().getRenderSystem().getViewport("RIGHT").getCamera();


    }
    @Override

    public void performAction(float time, Event evt) {


        c.setLocation(new Vector3f(c.getLocation().x,c.getLocation().y +.02f,c.getLocation().z));
    }
}
