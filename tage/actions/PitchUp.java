package tage.actions;

import a2.MyGame;
import net.java.games.input.Event;
import tage.Camera;
import tage.input.action.AbstractInputAction;
import tage.*;

public class PitchUp extends AbstractInputAction {
    MyGame game;
    Camera c;
    GameObject obj;




    public PitchUp(MyGame g){
        game =g;

        c =game.getEngine().getRenderSystem().getViewport("MAIN").getCamera();

        obj = g.getDol();





    }

    public void performAction(float time, Event evt) {

        obj.pitchUp(game.getFrameRate());

    }




}
