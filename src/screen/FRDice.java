package screen;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FRDice extends JFrame implements ActionListener{
	private JButton b;
	
	public FRDice(int die1, int die2){
		super();
		
		b = new JButton("OK");
		getContentPane().add(b);
		
		PNDice p = new PNDice(die1,die2); 
		
		getContentPane().add(p);
		
		b.setBounds(80,110,60,40);
		b.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b){
			dispose();
		}
	}

}
