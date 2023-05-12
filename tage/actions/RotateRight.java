package tage.actions;

import a2.MyGame;
import net.java.games.input.Event;
import org.joml.Vector3f;
import tage.*;
import tage.input.action.AbstractInputAction;

public class RotateRight extends AbstractInputAction {

    private MyGame game;
    private GameObject obj;

    private Vector3f fwdVector;
    private Vector3f upVector;
    private Vector3f rightVector;

    private Camera c;

    private double frameRate;
    public RotateRight(MyGame g){
        game = g;
        c = game.getEngine().getRenderSystem().getViewport("MAIN").getCamera();
        frameRate = game.getFrameRate();
        obj = game.getDol();
    }


    @Override
    public void performAction(float time, Event evt) {
        obj.yawRight(game.getFrameRate());

    }


}
