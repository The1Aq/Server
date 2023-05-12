package tage.actions;

import a2.MyGame;
import net.java.games.input.Event;
import tage.Camera;
import tage.GameObject;
import tage.input.action.AbstractInputAction;

public class ControllerYaw extends AbstractInputAction {

    MyGame g;
    Camera c;

    private double frameRate;

    GameObject obj;

    public ControllerYaw(MyGame game){

        g = game;
        obj = g.getDol();
        c = game.getEngine().getRenderSystem().getViewport("MAIN").getCamera();



    }

    @Override
    public void performAction(float time, Event evt) {
        float keyValue = evt.getValue();
        if (keyValue > -.2 && keyValue < .2) return;
        if(keyValue>0){
            obj.yawRight(g.getFrameRate());
        }else{
            obj.yawLeft(g.getFrameRate());
        }

    }


}
