package tage;
import net.java.games.input.Component;
import net.java.games.input.Event;
import org.joml.Vector3f;
import tage.input.InputManager;
import tage.input.action.AbstractInputAction;
import tage.input.action.IAction;

/**  orbit  the  camera on a gameobject  without  altering  the game objects  heading. Controls include: adjust
 * the camera elevation angle zoom the camera in and out on the game object,move and turn the game object while
 * maintaining the camera’s relative position and orientation relative to the game object
 * */

public class CameraOrbit3D {
    private Engine engine;
    private Camera camera; // the camera being controlled
    private GameObject avatar; // the target avatar the camera looks at
    private float cameraAzimuth; // rotation around target Y axis
    private float cameraElevation; // elevation of camera above target
    private float cameraRadius;
    private InputManager im;
    public CameraOrbit3D(Camera cam, GameObject av,
                         InputManager input, Engine e) {
        im = input;
        engine = e;
        camera = cam;
        avatar = av;
        cameraAzimuth = 0.0f; // start BEHIND and ABOVE the target
        cameraElevation = 20.0f; // elevation is in degrees
        cameraRadius = 2.0f; // distance from camera to avatar
        setupInputs();
        updateCameraPosition();
    }

    private void setupInputs() {
        OrbitAzimuthAction azmAction = new OrbitAzimuthAction();
        OrbitAzimuthActionL azmActionL = new OrbitAzimuthActionL();
        OrbitAzimuthActionR azmActionR = new OrbitAzimuthActionR();

        OrbitRadiusAction radiusAction = new OrbitRadiusAction();
        OrbitRadiusActionIn radiusActionIn = new OrbitRadiusActionIn();
        OrbitRadiusActionOut radiusActionOut = new OrbitRadiusActionOut();


        OrbitElevationAction elevationAction = new OrbitElevationAction();
        OrbitElevationActionD elevationActionD = new OrbitElevationActionD();
        OrbitElevationActionU elevationActionU = new OrbitElevationActionU();

        // KeyBoard mapping
       im.associateActionWithAllKeyboards(Component.Identifier.Key.LEFT
                ,  azmActionL,
                InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);

       im.associateActionWithAllKeyboards( Component.Identifier.Key.RIGHT
                ,  azmActionR,
                InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);

       im.associateActionWithAllKeyboards( Component.Identifier.Key.DOWN
                ,  elevationActionD,
                InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);

       im.associateActionWithAllKeyboards( Component.Identifier.Key.UP
                ,  elevationActionU,
                InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);


       im.associateActionWithAllKeyboards( Component.Identifier.Key.Q
                , radiusActionOut,
                InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);

       im.associateActionWithAllKeyboards( Component.Identifier.Key.E
                , radiusActionIn,
                InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);


       // controller mapping







    }

    public void updateCameraPosition() {
        Vector3f avatarRot = avatar.getWorldForwardVector();
        double avatarAngle = Math.toDegrees((double)
                avatarRot.angleSigned(new Vector3f(0, 0, -1), new Vector3f(0, 1, 0)));
        float totalAz = cameraAzimuth -(float)avatarAngle;
        double theta = Math.toRadians(cameraAzimuth);
        double phi = Math.toRadians(cameraElevation);
        float x = cameraRadius * (float) (Math.cos(phi) * Math.sin(theta));
        float y = cameraRadius * (float) (Math.sin(phi));
        float z = cameraRadius * (float) (Math.cos(phi) * Math.cos(theta));
        camera.setLocation(new
                Vector3f(x, y, z).add(avatar.getWorldLocation()));
        camera.lookAt(avatar);
        }

        private class OrbitAzimuthAction extends AbstractInputAction {
            @Override
            public void performAction(float time, Event evt) {
                float rotAmount;
                if (evt.getValue() < -0.2) {
                    rotAmount = -0.2f;
                } else {
                    if (evt.getValue() > 0.2) {
                        rotAmount = 0.2f;
                    } else {
                        rotAmount = 0.0f;
                    }
                }
                cameraAzimuth += rotAmount;
                cameraAzimuth = cameraAzimuth % 360;
                updateCameraPosition();
            }


        }

        private class OrbitAzimuthActionL extends AbstractInputAction {
            @Override
            public void performAction(float time, Event evt) {
                float rotAmount;

                rotAmount = -0.2f;
                cameraAzimuth += rotAmount;
                cameraAzimuth = cameraAzimuth % 360;
                updateCameraPosition();
            }
        }

        private class OrbitAzimuthActionR extends AbstractInputAction {
            @Override
            public void performAction(float time, Event evt) {
                 float rotAmount;

                 rotAmount = 0.2f;

                cameraAzimuth += rotAmount;
                cameraAzimuth = cameraAzimuth % 360;
                updateCameraPosition();
        }
    }







    private class OrbitRadiusAction extends AbstractInputAction {

            @Override
            public void performAction(float time, Event evt) {
                float rotAmount;
                if (evt.getValue() < -0.2) {
                    rotAmount = -0.2f;
                } else {
                    if (evt.getValue() > 0.2) {
                        rotAmount = 0.2f;
                    } else {
                        rotAmount = 0.0f;
                    }
                }
                cameraRadius += rotAmount;
                cameraRadius = cameraRadius % 360;
                updateCameraPosition();
            }

    }
    private class OrbitRadiusActionIn extends AbstractInputAction {

        @Override
        public void performAction(float time, Event evt) {
            float rotAmount;

            rotAmount = -0.2f;

            cameraRadius += rotAmount;
            cameraRadius = cameraRadius % 30;
            updateCameraPosition();
        }

    }


    private class OrbitRadiusActionOut extends AbstractInputAction {

        @Override
        public void performAction(float time, Event evt) {
            float rotAmount;

            rotAmount = 0.2f;

            cameraRadius += rotAmount;
            cameraRadius = cameraRadius % 30;
            updateCameraPosition();
        }

    }


    private class OrbitElevationAction extends AbstractInputAction {

        @Override
        public void performAction(float time, Event evt) {
            float rotAmount;
            if (evt.getValue() < -0.2) {
                rotAmount = -0.2f;
            } else {
                if (evt.getValue() > 0.2) {
                    rotAmount = 0.2f;
                } else {
                    rotAmount = 0.0f;
                }
            }
            cameraElevation += rotAmount;
            cameraElevation = cameraElevation % 360;
            updateCameraPosition();
        }

    }


    private class OrbitElevationActionD extends AbstractInputAction {

        @Override
        public void performAction(float time, Event evt) {
            float rotAmount;
            rotAmount = -0.2f;
            cameraElevation += rotAmount;
            cameraElevation = cameraElevation % 360;
            updateCameraPosition();
        }

    }

    private class OrbitElevationActionU extends AbstractInputAction {

        @Override
        public void performAction(float time, Event evt) {
            float rotAmount;
            rotAmount = 0.2f;
            cameraElevation += rotAmount;
            cameraElevation = cameraElevation % 360;
            updateCameraPosition();
        }

    }




};



