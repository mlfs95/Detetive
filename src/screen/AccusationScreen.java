package screen;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Card;

public class AccusationScreen extends JFrame implements ActionListener{
	private JButton b;
	private JLabel l1,l2,l3;
	private JTextField t1,t2,t3;
	private Container screen;
	private String suspeito,arma,comodo;
	
	
	public AccusationScreen(String s){
		super(s);
		screen = getContentPane();
		screen.setLayout(null);
		
		l1 = new JLabel("Suspeito:");
		l2 = new JLabel("Arma:");
		l3 = new JLabel("Cômodo:");
		
		l1.setBounds(50,40,100,20);
		l2.setBounds(50,80,100,20);
		l3.setBounds(50,120,100,20);
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		
		t1.setBounds(150, 40, 100, 20);
		t2.setBounds(150, 80, 100, 20);
		t3.setBounds(150, 120, 100, 20);
		
		screen.add(l1);
		screen.add(l2);
		screen.add(l3);
		screen.add(t1);
		screen.add(t2);
		screen.add(t3);
		screen.add(b = new JButton("OK"));
		b.setBounds(100,180,70,70);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		t3.addActionListener(this);
		b.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public String getSuspeito(){
		return suspeito;
	}
	
	public String getArma(){
		return arma;
	}
	
	public String getComodo(){
		return comodo;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b){
			suspeito = t1.getText();
			arma = t2.getText();
			comodo = t3.getText();
			
			Card[] answers = BoardScreen.getInstance().getAnswers();
			
			if (answers[0].getName().equals(comodo) && answers[1].getName().equals(suspeito) && answers[2].getName().equals(arma)){
				
				System.out.println("ACERTOU!!!");
				BoardScreen.getInstance().gameOver(BoardScreen.getInstance().getPlayers()[PNBoard.getInstance().getTurn()]);
			}
			else {
				
				System.out.println("ERRRRRRROOOOOOOU!!!");
				BoardScreen.getInstance().wrongGuess(BoardScreen.getInstance().getPlayers()[PNBoard.getInstance().getTurn()]);
			}
			
			PNBoard.getInstance().setCanMove(true);
			
			dispose();
		}
		else{
			
			dispose();
			
			PNBoard.getInstance().setCanMove(true);
		}
		
		
	}

}
