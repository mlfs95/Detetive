package screen;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FRDice extends JFrame {
	
	public FRDice(int die1, int die2){
		super();
		
		PNDice p = new PNDice(die1,die2);
		
		getContentPane().add(p);
		
		
	}

}
