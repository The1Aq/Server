package tage.actions;

import a2.MyGame;
import net.java.games.input.Event;
import tage.*;
import tage.input.action.AbstractInputAction;
import org.joml.*;


public class MoveForward extends AbstractInputAction{

    private GameObject object;
    private MyGame game;
    private Vector3f oldPosition, newPosition;
    private Vector4f backDirection;

    private Vector3f newLocation,fwd,loc;
    private Camera c;

    private double frameRate;



    public MoveForward(MyGame g){
        game = g;
        c = game.getEngine().getRenderSystem().getViewport("MAIN").getCamera();
        object = game.getDol();
        frameRate=game.getFrameRate();

    }

    @Override
    public void performAction(float time, Event evt) {
        oldPosition = object.getWorldLocation();
        backDirection = new Vector4f(0f,0f,1f,1f);
        backDirection.mul(object.getWorldRotation());
        backDirection.mul(0.01f);
        newPosition = oldPosition.add(backDirection.x(),
                backDirection.y(), backDirection.z());
        object.setLocalLocation(newPosition);

    }





}