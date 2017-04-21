import jason.environment.grid.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/** class that implements the View of Domestic Robot application */
public class LiftView extends GridWorldView {

    LiftModel lmodel;

    public LiftView(LiftModel model) {
        super(model, "Lift", 300);
        lmodel = model;
        defaultFont = new Font("Arial", Font.BOLD, 16); // change default font
        setVisible(true);
        repaint();
    }

    /** draw application objects */
    @Override
    public void draw(Graphics g, int x, int y, int object) {
        Location lLift = lmodel.getAgPos(0);
        super.drawAgent(g, x, y, Color.lightGray, -1);
        switch (object) {
            case LiftModel.NEGYEDIK:
                if(lLift.equals(lmodel.lNegyedik)) {
                    super.drawAgent(g, x, y, Color.yellow, -1);
                }
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "4.");
                break;
            case LiftModel.HARMADIK:
                if(lLift.equals(lmodel.lHarmadik)) {
                    super.drawAgent(g, x, y, Color.yellow, -1);
                }
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "3.");
                break;
            case LiftModel.MASODIK:
                if(lLift.equals(lmodel.lMasodik)) {
                    super.drawAgent(g, x, y, Color.yellow, -1);
                }
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "2.");
                break;
            case LiftModel.ELSO:
                if(lLift.equals(lmodel.lElso)) {
                    super.drawAgent(g, x, y, Color.yellow, -1);
                }
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "1.");
                break;
            case LiftModel.FOLDSZINT:
                if(lLift.equals(lmodel.lFoldszint)) {
                    super.drawAgent(g, x, y, Color.yellow, -1);
                }
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "0.");
                break;
            case LiftModel.PARKOLO:
                if(lLift.equals(lmodel.lParkolo)) {
                    super.drawAgent(g, x, y, Color.yellow, -1);
                }
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "-1.");
                break;
        }
        repaint();
    }

    /*@Override
    public void drawAgent(Graphics g, int x, int y, Color c, int id) {
        Location lLift = lmodel.getAgPos(1);
        c = Color.yellow;
        super.drawAgent(g, x, y, c, -1);
        g.setColor(Color.black);
        super.drawString(g, x, y, defaultFont, "Lift");
    }*/
}
