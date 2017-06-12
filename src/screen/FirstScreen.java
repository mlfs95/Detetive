package screen;
import javax.swing.*;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstScreen extends JFrame implements ActionListener{
	
	public static FirstScreen instancia = null;
	private JButton b1, b2;
	//private JCheckBox cb1, cb2, cb3, cb4, cb5, cb6;

		private FirstScreen (String s, int width, int height){
		
		super(s);
		
		JPanel p = new JPanel();
			
		p.setLayout(null);
		
		p.setSize(width, height);
		
		getContentPane().add(p);
		
		b1 = new JButton("Novo Jogo");
		b2 = new JButton("Continuar jogo antigo");
		
		p.add(b1);
		p.add(b2);
		
		b1.setSize(200, 50);
		b2.setSize(200, 50);
		
		b1.setLocation(width/2-b1.getSize().width/2, height*2/6-b1.getSize().height/2);
		b2.setLocation(width/2-b2.getSize().width/2, height*4/6-b2.getSize().height/2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		/*b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				NewGameScreen f = new NewGameScreen("New Game", 600, 600);
				
				f.setSize(600, 600);
				
				f.setVisible(true);
				
				dispose();
			}
		}); */
		
		/*b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				final JFileChooser fc = new JFileChooser();
				
				fc.showOpenDialog(null);
			}
		}); */
	}
	
	public static FirstScreen getInstance(){
		if(instancia == null){
			instancia = new FirstScreen("Detetive",600,600);
		} 
		return instancia;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
			this.setVisible(false);
			NewGameScreen f = NewGameScreen.getInstance();
			f.setSize(600, 600);
			
			f.setVisible(true);
			
			dispose();
			
		} 
		else if (e.getSource() == b2){
			
			final JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(null);
			
		}
		else {
			System.exit(1);
		}
		
	}
}

