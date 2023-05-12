package tage.actions;

import a2.MyGame;
import net.java.games.input.Event;
import tage.Camera;
import tage.GameObject;
import tage.input.action.AbstractInputAction;

public class RotateLeft extends AbstractInputAction {
    private MyGame game;
    private GameObject obj;

    private Camera c;

    private double frameRate;
    public RotateLeft(MyGame g){
        game = g;
        c = game.getEngine().getRenderSystem().getViewport("MAIN").getCamera();
        obj = game.getDol();


    }

    @Override
    public void performAction(float time, Event evt) {

        obj.yawLeft(game.getFrameRate());


    }


}
