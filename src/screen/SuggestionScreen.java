package screen;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Card;

public class SuggestionScreen extends JFrame implements ActionListener {
	private JTextField text1,text2,text3;
	private JLabel label1,label2,label3;
	private JButton button;
	private Container screen;
	private String suspect;
	private String weapon;
	
	
	public SuggestionScreen(String s){
		super(s);
		screen = getContentPane();
		screen.setLayout(null);
		label1 = new JLabel("Suspeito:");
		label1.setBounds(50, 40, 100, 30);
		label2 = new JLabel("Arma:");
		label2.setBounds(50, 80, 100, 20);
		
		text1 = new JTextField();
		text2 = new JTextField();
		text1.setBounds(120, 40, 60, 20);
		text2.setBounds(120, 80, 60, 20);
	
		screen.add(label1);
		screen.add(label2);
		screen.add(text1);
		screen.add(text2);
		screen.add(button = new JButton("OK"));
		button.setBounds(100,130,60,60);
		text1.addActionListener(this);
		text2.addActionListener(this);
		button.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getWeapon(){
		return weapon;
	}
	
	public String getSuspect(){
		return suspect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button){
			weapon = text2.getText();
			suspect = text1.getText();
			
			Card card = PNBoard.getInstance().checkGuess(weapon, suspect);
			
			PNBoard.getInstance().setCanMove(true);
			dispose();
		}
		else{
			System.exit(1);
		}
	}
}
