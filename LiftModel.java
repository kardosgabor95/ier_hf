import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

public class LiftModel extends GridWorldModel {

    // constants for the grid objects
    public static final int NEGYEDIK  = 16;
    public static final int HARMADIK  = 32;
    public static final int MASODIK   = 64;
    public static final int ELSO      = 128;
    public static final int FOLDSZINT = 256;
    public static final int PARKOLO   = 512;

    Location lNegyedik  = new Location(0,0);
    Location lHarmadik  = new Location(0,1);
    Location lMasodik   = new Location(0,2);
    Location lElso      = new Location(0,3);
    Location lFoldszint = new Location(0,4);
    Location lParkolo   = new Location(0,5);

    public LiftModel() {

        super(1,6,4);

        setAgPos(1, 0, 3);

        add(NEGYEDIK, lNegyedik);
        add(HARMADIK, lHarmadik);
        add(MASODIK, lMasodik);
        add(ELSO, lElso);
        add(FOLDSZINT, lFoldszint);
        add(PARKOLO, lParkolo);
    }

    boolean move_to(Location dest) {
        Location lift = getAgPos(1);
        if (lift.y < dest.y)        lift.y++;
        else if (lift.y > dest.y)   lift.y--;

        setAgPos(1, lift); // move the robot in the grid

        // repaint the fridge and owner locations
        /*if (view != null) {
            view.update(lFridge.x,lFridge.y);
            view.update(lOwner.x,lOwner.y);
        }*/
        return true;
    }
}
