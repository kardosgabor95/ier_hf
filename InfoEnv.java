import jason.asSyntax.*;
import jason.environment.Environment;
import jason.environment.grid.Location;
import java.util.logging.Logger;

public class InfoEnv extends Environment {

    // common literals
    public static final Literal ap = Literal.parseLiteral("at(lift,parkolo)");
    public static final Literal a0 = Literal.parseLiteral("at(lift,foldszint)");
    public static final Literal a1 = Literal.parseLiteral("at(lift,elso)");
    public static final Literal a2 = Literal.parseLiteral("at(lift,masodik)");
    public static final Literal a3 = Literal.parseLiteral("at(lift,harmadik)");
    public static final Literal a4 = Literal.parseLiteral("at(lift,negyedik)");


    static Logger logger = Logger.getLogger(InfoEnv.class.getName());

    LiftModel liftModel; // the model of the lift

    @Override
    public void init(String[] args) {
        liftModel = new LiftModel();

        if (args.length == 1 && args[0].equals("gui")) {
            LiftView liftView  = new LiftView(liftModel);
            liftModel.setView(liftView);
        }

        updatePercepts();
    }

    /** creates the agents percepts based on the HouseModel */
    void updatePercepts() {
        // clear the percepts of the agents
        clearPercepts("lift");

        // get the robot location
        Location lLift = liftModel.getAgPos(1);

        // add agent location to its percepts
        if (lLift.equals(liftModel.lParkolo)) {
            addPercept("lift", ap);
        }
        if (lLift.equals(liftModel.lFoldszint)) {
            addPercept("lift", a0);
        }
        if (lLift.equals(liftModel.lElso)) {
            addPercept("lift", a1);
        }
        if (lLift.equals(liftModel.lMasodik)) {
            addPercept("lift", a2);
        }
        if (lLift.equals(liftModel.lHarmadik)) {
            addPercept("lift", a3);
        }
        if (lLift.equals(liftModel.lNegyedik)) {
            addPercept("lift", a4);
        }

        // add beer "status" the percepts
        /*if (model.fridgeOpen) {
            addPercept("robot", Literal.parseLiteral("stock(beer,"+model.availableBeers+")"));
        }
        if (model.sipCount > 0) {
            addPercept("robot", hob);
            addPercept("owner", hob);
        }*/
    }


    @Override
    public boolean executeAction(String ag, Structure action) {
        System.out.println("["+ag+"] doing: "+action);
        boolean result = false;

        if (action.getFunctor().equals("move_to")) {
            String l = action.getTerm(0).toString();
            Location dest = new Location(0,Integer.parseInt(l));
            try {
                result = liftModel.move_to(dest);
            }
            catch (Exception ex) {
                ex.printStackTrace();;
            }

        } else {
            logger.info("Failed to execute action "+action);
        }

        if (result) {
            updatePercepts();
            try { Thread.sleep(100); } catch (Exception e) {}
        }
        return result;
    }
}
