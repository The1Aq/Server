package tage.actions;

import a2.MyGame;
import net.java.games.input.Event;
import tage.input.action.AbstractInputAction;
import tage.*;

public class PitchDown extends AbstractInputAction {

    private MyGame game;
    private GameObject obj;

   private Camera c;


    public PitchDown(MyGame g){

        game=g;
        c = game.getEngine().getRenderSystem().getViewport("MAIN").getCamera();
        obj = g.getDol();






    }
    @Override
    public void performAction(float time, Event evt) {
        obj.pitchDown(game.getFrameRate());

    }




}
