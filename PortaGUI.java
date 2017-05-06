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
public class PortaGUI extends AgArch {

	
	GridLayout grid;
	JTextField name;
	JTextField teremszam;
    JFrame f;
	JPanel form;
	JPanel gombok;
    JButton kulcs_ki_button;
	JButton kulcs_be_button;


    public PortaGUI() {
        kulcs_ki_button = new JButton("Kulcsot kiker");
        kulcs_ki_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try {
                Literal goal = ASSyntax.createLiteral("kulcs_ki", ASSyntax.createString(name.getText()),
					ASSyntax.parseTerm(teremszam.getText()));
                getTS().getC().addAchvGoal(goal, null);
				}
				catch (Exception ex){}
            }
        });
		
		kulcs_be_button = new JButton("Kulcsot visszaad");
		kulcs_be_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try {
                Literal goal = ASSyntax.createLiteral("kulcs_be", ASSyntax.createString(name.getText()),
					ASSyntax.parseTerm(teremszam.getText()));
                getTS().getC().addAchvGoal(goal, null);
				}
				catch (Exception ex){}
            }
        });
		
		name = new JTextField();
		teremszam = new JTextField();
		
		grid = new GridLayout(0, 2);
		grid.setVgap(20);
		
        form = new JPanel(grid);
		gombok = new JPanel(new GridLayout(0, 1));
		
		gombok.add(kulcs_ki_button);
		gombok.add(kulcs_be_button);
		
		form.add(new JLabel("Nev:"));
		form.add(name);
		form.add(new JLabel("Teremszam:"));
        form.add(teremszam);
		
		f = new JFrame("Porta agens");
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
