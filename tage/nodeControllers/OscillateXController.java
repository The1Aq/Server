package tage.nodeControllers;

import a2.MyGame;
import org.joml.Matrix4f;
import tage.Engine;
import tage.GameObject;
import tage.NodeController;

/** Is a node controller that oscillates Game object on its local x-axis with given range and speed  */

public class OscillateXController extends NodeController{

    float spd ;
    Engine e;
    MyGame game;
    Matrix4f objLocation;
    float oscRange;
    float low;
    float high;
    boolean isHLSet = false;


    public OscillateXController(){super();}


    public OscillateXController(Engine engine, MyGame g, float speed , float range){
        super();
        spd = speed;
        game = g;
        e = engine;
        oscRange = range/2;


    }

    void initHL(GameObject obj){
        high = obj.getWorldLocation().x + oscRange;
        low = obj.getWorldLocation().x - oscRange;
        isHLSet = true;

    }

    @Override
    public void apply(GameObject t) {

        if(!isHLSet){
            initHL(t);
        }


        if(t.getWorldLocation().x>=high) {

            t.setLocalTranslation(t.getWorldTranslation().translation(
                    high-1,
                    t.getWorldLocation().y,
                    t.getWorldLocation().z));

            spd = -spd;

        }else if (t.getWorldLocation().x<=low){
            t.setLocalTranslation(t.getWorldTranslation().translation(
                    low+1,
                    t.getWorldLocation().y,
                    t.getWorldLocation().z));

            spd = -spd;

        }
        objLocation= t.getWorldTranslation().translation(
                t.getWorldLocation().x + (float) (spd * game.getFrameRate()),
                t.getWorldLocation().y,
                t.getWorldLocation().z);

        t.setLocalTranslation(objLocation);

    }


}
