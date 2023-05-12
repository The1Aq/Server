package tage.actions;



import a2.MyGame;
import net.java.games.input.Event;
import org.joml.Vector3f;
import tage.Camera;
import tage.input.action.AbstractInputAction;

public class CameraPanFwd extends AbstractInputAction {
    private MyGame g;
    private Camera c ;

    public CameraPanFwd(MyGame game){
        g = game;
        c =g.getEngine().getRenderSystem().getViewport("RIGHT").getCamera();
    }

    @Override
    public void performAction(float time, Event evt) {


        c.setLocation(new Vector3f(c.getLocation().x,c.getLocation().y,c.getLocation().z-.02f));



    }
}
