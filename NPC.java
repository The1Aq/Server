
public class NPC
{
    double locationX = 0, locationY = 0, locationZ = 0;
    double dir = 0.1;
    double size = 1.0;
    public NPC()
    {
        locationX= 0.0;
        locationY=1.002f;
        locationZ=0.0;
    }
    public void randomizeLocation(int seedX, int seedZ)
    {
        locationX = ((double)seedX)/4.0 - 5.0;
        locationY = 1.002f;
        locationZ = ((double)seedZ)/4.0 - 5.0;
    }
    public double getX() { return locationX; }
    public double getY() { return locationY; }
    public double getZ() { return locationZ; }
    public String[] getP(){
        String[] x = {String.valueOf(getX()), String.valueOf(getY()), String.valueOf(getZ())};
        return x;
    }
    public void getBig() { size=2.0; }
    public void getSmall() { size=1.0; }
    public double getSize() { return size; }
    public void updateLocation()
    {
        if (locationX > 10) dir=-0.01;
        if (locationX < -10) dir=0.01;
        locationX = locationX + dir;
    }
}