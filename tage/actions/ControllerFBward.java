package tage.actions;

import a2.MyGame;
import net.java.games.input.Event;
import org.joml.Vector3f;
import org.joml.Vector4f;
import tage.Camera;
import tage.GameObject;
import tage.input.action.AbstractInputAction;

public class ControllerFBward extends AbstractInputAction {
    private MyGame g ;
    private GameObject obj;
    private Camera c;

    private double frameRate;

    private Vector3f oldPosition, newPosition;
    private Vector4f backDirection;

    private Vector3f newLocation,fwd,loc;
    public ControllerFBward(MyGame game){
        g = game;

        c = game.getEngine().getRenderSystem().getViewport("MAIN").getCamera();

        obj = g.getDol();

        frameRate = g.getFrameRate();


    }


    @Override
    public void performAction(float time, Event evt) {
        float keyValue = evt.getValue();
        if (keyValue > -.2 && keyValue < .2) return;
        if(keyValue>0){
            obj = g.getDol();
            oldPosition = obj.getWorldLocation();
            backDirection = new Vector4f(0f,0f,-1f,1f);
            backDirection.mul(obj.getWorldRotation());
            backDirection.mul(0.01f);
            newPosition = oldPosition.add(backDirection.x(),
                    backDirection.y(), backDirection.z());
            obj.setLocalLocation(newPosition);
        }else{

            obj = g.getDol();
            oldPosition = obj.getWorldLocation();
            backDirection = new Vector4f(0f,0f,1f,1f);
            backDirection.mul(obj.getWorldRotation());
            backDirection.mul(0.01f);
            newPosition = oldPosition.add(backDirection.x(),
                    backDirection.y(), backDirection.z());
            obj.setLocalLocation(newPosition);
        }


    }



}
