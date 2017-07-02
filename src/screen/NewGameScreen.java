package screen;
import javax.swing.*;
import javax.swing.event.*;

import main.Facade;
import model.Player;
import model.Player.Character;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class NewGameScreen extends JFrame implements ActionListener, ItemListener{
	
	private static NewGameScreen instancia = null;
	private JButton b1;
	private JCheckBox cb[] = new JCheckBox[6];
	private JLabel image[] = new JLabel[6];
	private int countChecked = 0;
	private int cbCount;
	
		private NewGameScreen (String s, int width, int height){
		
		super(s);
		
		// - Set frame -
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setSize(600, 600);
		getContentPane().add(p);
		
		// - Button configuration -
		b1 = new JButton("Continuar");
		
		p.add(b1);
		
		b1.setSize(200, 50);
		b1.setLocation(width/2-b1.getSize().width/2, height*14/16-b1.getSize().height/2);
		
		b1.setEnabled(false);
		b1.addActionListener(this);
		
		// - Check Box configurations -
		cb[0] = new JCheckBox("Miss Scarlett", false);
		cb[1] = new JCheckBox("Professor Plum", false);
		cb[2] = new JCheckBox("Miss Peacock", false);
		cb[3] = new JCheckBox("Reverend Mr Green", false);
		cb[4] = new JCheckBox("Colonel Mustard", false);
		cb[5] = new JCheckBox("Mrs White", false);
		
		cb[0].setSize(200, 50);
		cb[1].setSize(200, 50);
		cb[2].setSize(200, 50);
		cb[3].setSize(200, 50);
		cb[4].setSize(200, 50);
		cb[5].setSize(200, 50);
		
		cb[0].setLocation(width/3-b1.getSize().width/2, height*5/16-b1.getSize().height/2);
		cb[1].setLocation(width/3-b1.getSize().width/2, height*6/16-b1.getSize().height/2);
		cb[2].setLocation(width/3-b1.getSize().width/2, height*7/16-b1.getSize().height/2);
		cb[3].setLocation(width/3-b1.getSize().width/2, height*8/16-b1.getSize().height/2);
		cb[4].setLocation(width/3-b1.getSize().width/2, height*9/16-b1.getSize().height/2);
		cb[5].setLocation(width/3-b1.getSize().width/2, height*10/16-b1.getSize().height/2);
		
		p.add(cb[0]);
		p.add(cb[1]);
		p.add(cb[2]);
		p.add(cb[3]);
		p.add(cb[4]);
		p.add(cb[5]);
		
		ActionListener cbAction = new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				
				cbCount = 0;
				
				for(int i = 0; i < 6; i++)
					if(cb[i].isSelected())
						cbCount += 1;
				
				if (cbCount >= 3)
					b1.setEnabled(true);
				
				else
					b1.setEnabled(false);
				
			}
		};
		
		cb[0].addActionListener(cbAction);
		cb[1].addActionListener(cbAction);
		cb[2].addActionListener(cbAction);
		cb[3].addActionListener(cbAction);
		cb[4].addActionListener(cbAction);
		cb[5].addActionListener(cbAction);
		
	}
	
	public static NewGameScreen getInstance(){
		
		if(instancia == null){
			
			instancia = new NewGameScreen("Detetive",600,600);
		}
		
		return instancia;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e){
		
			System.out.println(countChecked);
		 if(e.getSource().getClass() == JCheckBox.class)
		    {
		        if(e.getStateChange() == e.SELECTED)
		            countChecked++;
		        else if(e.getStateChange() == e.DESELECTED)
		            countChecked--;
		    }
		 
		 if(countChecked >= 3){
				b1.setEnabled(true);
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1){
			this.setVisible(false);
			
			Player players[] = new Player[cbCount];
			int i = 0;
			
			if (cb[0].isSelected()){
				players[i] = new Player(Player.Character.Scarlet);
				i++;
			}
			
			if (cb[1].isSelected()){
				players[i] = new Player(Player.Character.Plum);
				i++;
			}
			
			if (cb[2].isSelected()){
				players[i] = new Player(Player.Character.Peacock);
				i++;
			}
			
			if (cb[3].isSelected()){
				players[i] = new Player(Player.Character.Green);
				i++;
			}
			
			if (cb[4].isSelected()){
				players[i] = new Player(Player.Character.Mustard);
				i++;
			}
			
			if (cb[5].isSelected()){
				players[i] = new Player(Player.Character.White);
				i++;
			}
			System.out.println(i);
			BoardScreen f = BoardScreen.getInstance();
			f.setSize(700, 725);
			f.setVisible(true);
			f.getInstance().setPlayers(players);
			f.getInstance().setCards();
			f.getInstance().setCardScreen(0);
			System.out.println("coluna players[1]" + players[0].getColuna());
			dispose();
		}
		else{
			System.exit(1);
		}
		
	}
	
}