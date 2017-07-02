package screen;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOverScreen extends JFrame implements ActionListener{
	private JButton b;
	private Container screen;
	private JLabel label1, label2,label3;
	private static GameOverScreen instancia;
	
	public GameOverScreen(String s){
		super(s);
		screen = getContentPane();
		screen.setLayout(null);
		label1 = new JLabel("GAME OVER");
		label1.setSize(250,250);
		label1.setBounds(50,50,100,100);
		
		label2 = new JLabel("Vencedor:");
		label2.setBounds(50,300,100,100);
		
		label3 = new JLabel(s);
		label3.setBounds(300,300,100,100);
		
		screen.add(label1);
		screen.add(label2);
		screen.add(label3);
		screen.add(b = new JButton("OK"));
		b.setBounds(300,400,90,90);
		b.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static GameOverScreen getInstance(String s){
		if(instancia == null){
			instancia = new GameOverScreen(s);
		}
		return instancia;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b){
			dispose();
			System.exit(1);
		}
		else{
			System.exit(1);
		}
	}

}
