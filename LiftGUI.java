import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.text.ParseException;

import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;

import javax.swing.*;

/** example of agent architecture's functions overriding */
public class LiftGUI extends AgArch {

	
	GridLayout grid;
	JTextField name;
	JTextField teremszam;
    JFrame f;
	JPanel form;
	JPanel gombok;
    JButton button_4;
	JButton button_3;
	JButton button_2;
	JButton button_1;
	JButton button_0;
	JButton button_P;


    public LiftGUI() {
		
        button_4 = new JButton("4");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                Literal goal = ASSyntax.createLiteral("move", ASSyntax.parseTerm("lift"),
					ASSyntax.parseTerm("negyedik"),
					ASSyntax.parseTerm(name.getText())
					);
                getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex){}
            }
        });
		
		button_3 = new JButton("3");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                Literal goal = ASSyntax.createLiteral("move", ASSyntax.parseTerm("lift"),
					ASSyntax.parseTerm("harmadik"),
					ASSyntax.parseTerm(name.getText())
					);
                getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex){}
            }
        });
		
		button_2 = new JButton("2");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                Literal goal = ASSyntax.createLiteral("move", ASSyntax.parseTerm("lift"),
					ASSyntax.parseTerm("masodik"),
					ASSyntax.parseTerm(name.getText())
					);
                getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex){}
            }
        });
		
		button_1 = new JButton("1");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                Literal goal = ASSyntax.createLiteral("move", ASSyntax.parseTerm("lift"),
					ASSyntax.parseTerm("elso"),
					ASSyntax.parseTerm(name.getText())
					);
                getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex){}
            }
        });
		
		button_0 = new JButton("0");
        button_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                Literal goal = ASSyntax.createLiteral("move", ASSyntax.parseTerm("lift"),
					ASSyntax.parseTerm("foldszint"),
					ASSyntax.parseTerm(name.getText())
					);
                getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex){}
            }
        });
		
		button_P = new JButton("P");
        button_P.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try {
                Literal goal = ASSyntax.createLiteral("move", ASSyntax.parseTerm("lift"),
					ASSyntax.parseTerm("parkolo"),
					ASSyntax.parseTerm(name.getText())
					);
                getTS().getC().addAchvGoal(goal, null);
				}
				catch(Exception ex){}
            }
        });
		
		
		
		
		name = new JTextField();
		
		grid = new GridLayout(0, 2);
		grid.setVgap(20);
		
        form = new JPanel(grid);
		gombok = new JPanel(new GridLayout(0, 1));
		
		gombok.add(button_4);
		gombok.add(button_3);
		gombok.add(button_2);
		gombok.add(button_1);
		gombok.add(button_0);
		gombok.add(button_P);
		
		form.add(new JLabel("Nev:"));
		form.add(name);
		
		f = new JFrame("Porta agens");
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(BorderLayout.CENTER, form);
        f.getContentPane().add(BorderLayout.SOUTH, gombok);
        f.setSize(300, 300);
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
