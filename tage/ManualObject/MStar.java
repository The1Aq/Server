package tage.ManualObject;

import tage.Utils;
import tage.shapes.ManualObject;
/*star with 4 points*/
public class MStar extends ManualObject {
    private float[] vertices = new float[]{
            .5f,1f,0f   ,.5f,.5f,.125f   ,.625f,.625f,0f,
            .625f,.625f,0f   ,.5f,.5f,.125f   ,1f,.5f,0f,
            1f,.5f,0f   ,.5f,.5f,.125f   ,.625f,.375f,0f,
            .625f,.375f,0f   ,.5f,.5f,.125f   ,.5f,0f,0f,
            .5f,0f,0f   ,.5f,.5f,.125f   ,.357f,.375f,0f,
            .375f,.375f,0f   ,.5f,.5f,.125f   ,0f,.5f,0f,
            0f,.5f,0f   ,.5f,.5f,.125f   ,.375f,.625f,0f,
            .375f,.625f,0f   ,.5f,.5f,.125f   ,.5f,1f,0f,

            .5f,1f,0f   ,.5f,.5f,-.125f   ,.625f,.625f,0f,
            .625f,.625f,0f   ,.5f,.5f,-.125f   ,1f,.5f,0f,
            1f,.5f,0f   ,.5f,.5f,-.125f   ,.625f,.375f,0f,
            .625f,.375f,0f   ,.5f,.5f,-.125f   ,.5f,0f,0f,
            .5f,0f,0f   ,.5f,.5f,-.125f   ,.357f,.375f,0f,
            .375f,.375f,0f   ,.5f,.5f,-.125f   ,0f,.5f,0f,
            0f,.5f,0f   ,.5f,.5f,-.125f   ,.375f,.625f,0f,
            .375f,.625f,0f   ,.5f,.5f,-.125f   ,.5f,1f,0f,

    };
    private float[] texcoords = new float[]
            {       0f,0f,   0f,0f  ,.25f,.25f,
                    .25f,.25f,  0f,0f,    0f,0f,
                    0f,0f,   0f,0f  ,.25f,.25f,
                    .25f,.25f,  0f,0f,    0f,0f,
                    0f,0f,   0f,0f  ,.25f,.25f,
                    .25f,.25f,  0f,0f,    0f,0f,
                    0f,0f,   0f,0f  ,.25f,.25f,
                    .25f,.25f,  0f,0f,    0f,0f,
                    0f,0f,   0f,0f  ,.25f,.25f,
                    .25f,.25f,  0f,0f,    0f,0f,
                    0f,0f,   0f,0f  ,.25f,.25f,
                    .25f,.25f,  0f,0f,    0f,0f,
                    0f,0f,   0f,0f  ,.25f,.25f,
                    .25f,.25f,  0f,0f,    0f,0f,
                    0f,0f,   0f,0f  ,.25f,.25f,
                    .25f,.25f,  0f,0f,    0f,0f


            };

    private float[] normals = new float[]
            {       1f,0f,0f   ,0f,1f,0f     ,0f,-1f,0f,
                    1f,0f,0f   ,-1f,0f,0f    ,0f,-1f,0f,
                    0f,1f,0f   ,-1f,0f,0f    ,1f,0f,0f,
                    0f,1f,0f   ,0f,-1f,0f    ,1f,0f,0f,
                    -1f,0f,0f   ,0f,-1f,0f   ,0f,1f,0f,
                    -1f,0f,0f

            };
    public MStar(){
        super();
        setNumVertices(48);
        setVertices(vertices);
        setTexCoords(texcoords);
        setNormals(normals);
        setMatAmb(Utils.goldAmbient());
        setMatDif(Utils.goldDiffuse());
        setMatSpe(Utils.goldSpecular());
        setMatShi(Utils.goldShininess());

    }


}
