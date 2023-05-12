package tage.actions;

import a2.MyGame;
import net.java.games.input.Event;
import tage.Camera;
import tage.GameObject;
import tage.input.action.AbstractInputAction;

public class ControllerPitch extends AbstractInputAction {

    private MyGame g ;
    private GameObject obj;
    private Camera c;


    public ControllerPitch(MyGame game){

        g = game;

        c = game.getEngine().getRenderSystem().getViewport("MAIN").getCamera();

        obj = g.getDol();




    }
    @Override
    public void performAction(float time, Event evt) {
        float keyValue = evt.getValue();
        if (keyValue > -.2 && keyValue < .2) {

            return;

        }
        if (keyValue>0) {

            obj.pitchDown(g.getFrameRate());

        }else if(keyValue<0){

            obj.pitchUp(g.getFrameRate());
        }

    }

}

