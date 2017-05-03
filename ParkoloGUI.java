import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;

import javax.swing.*;

/** example of agent architecture's functions overriding */
public class ParkoloGUI extends AgArch {

	
	GridLayout grid;
	JTextField name;
	JTextField rsz;
	JTextField tel;
    JFrame f;
	JPanel form;
	JPanel gombok;
    JButton erkezett;
	JButton ertesit;


    public ParkoloGUI() {
        erkezett = new JButton("Uj ember erkezett");
        erkezett.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Literal goal = ASSyntax.createLiteral("erkezett", ASSyntax.createString(name.getText()),
					ASSyntax.createString(rsz.getText()), 
					ASSyntax.createString(tel.getText()));
                getTS().getC().addAchvGoal(goal, null);
            }
        });
		
		ertesit = new JButton("Az illeto ertesitese");
		ertesit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Literal goal = ASSyntax.createLiteral("ertesit", ASSyntax.createString(name.getText()));
                getTS().getC().addAchvGoal(goal, null);
            }
        });
		
		name = new JTextField();
		rsz = new JTextField();
		tel = new JTextField();
		
		grid = new GridLayout(0, 2);
		grid.setVgap(20);
		
        form = new JPanel(grid);
		gombok = new JPanel(new GridLayout(0, 1));
		
		gombok.add(erkezett);
		gombok.add(ertesit);
		
		form.add(new JLabel("Nev:"));
		form.add(name);
		form.add(new JLabel("Rendszam:"));
        form.add(rsz);
		form.add(new JLabel("Telefon:"));
		form.add(tel);
		
		f = new JFrame("Parkolo agens");
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(BorderLayout.CENTER, form);
        f.getContentPane().add(BorderLayout.SOUTH, gombok);
        f.setSize(300, 200);
        f.setVisible(true);
    }

    /*@Override
    public void act(ActionExec action) { //, List<ActionExec> feedback) {
        if (action.getActionTerm().getFunctor().startsWith("show_winner")) {
            jt.append("Winner of auction  " + action.getActionTerm().getTerm(0));
            jt.append(" is " + action.getActionTerm().getTerm(1) + "\n");
            action.setResult(true);
            actionExecuted(action);
            
            auction.setEnabled(true); // enable GUI button
        } else {
            super.act(action); // send the action to the environment to be performed.
        }
    }*/

    @Override
    public void stop() {
        f.dispose();
        super.stop();
    }
}
