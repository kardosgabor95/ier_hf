import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

public class LiftModel extends GridWorldModel {
    public static final int negyedik  = 4;
    public static final int harmadik  = 3;
    public static final int masodik   = 2;
    public static final int elso      = 1;
    public static final int foldszint = 0;
    public static final int parkolo   =-1;

    Location lNegyedik  = new Location(0,0);
    Location lHarmadik  = new Location(0,1);
    Location lMasodik   = new Location(0,2);
    Location lElso      = new Location(0,3);
    Location lFoldszint = new Location(0,4);
    Location lParkolo   = new Location(0,5);

    public LiftModel() {

        super(1,6,4);

        setAgPos(1, 0, 4);

        add(negyedik, lNegyedik);
        add(harmadik, lHarmadik);
        add(masodik, lMasodik);
        add(elso, lElso);
        add(foldszint, lFoldszint);
        add(parkolo, lParkolo);
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
