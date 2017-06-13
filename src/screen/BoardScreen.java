package screen;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import main.Facade;
import model.Board;
import model.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardScreen extends JFrame implements ActionListener{
	
	private static BoardScreen instancia = null;
	private Player players[];
	private Board board;
	private int diceMinX = 316;
	private int diceMinY = 359;
	private JLabel diceImage = new JLabel();
	private JButton b1;
	private JLabel diceLabel;
	
		private BoardScreen(String s, int width, int height){
		
		super(s);
		
		Facade f = new Facade();
		f.startBoard();
		//board = Board.getInstance();
		
		PNBoard p = PNBoard.getInstance();
		getContentPane().add(p);
		
		diceImage.setBounds(diceMinX, diceMinY, 95, 106);
		p.add(diceImage);
		
		b1 = new JButton("Rolar os dados");
		p.add(b1);
		
		b1.setSize(200, 50);
		b1.setLocation(width/2-b1.getSize().width/2, height*14/16-b1.getSize().height/2);
		
		b1.addActionListener(this);
		
		diceLabel = new JLabel();
		p.add(diceLabel);
		
		diceLabel.setSize(300, 50);
		diceLabel.setLocation(width/3-diceLabel.getSize().width/2, height*14/16-b1.getSize().height/2);
	}
	
	public static BoardScreen getInstance(){
		if(instancia == null){
			instancia = new BoardScreen("Detetive", 700, 725);
		} 
		return instancia;
	}
	
	public void setPlayers(Player players[]){
		
		this.players = players;
	}
	
	public Player[] getPlayers(){
		
		return players;
	}
	
	public void paintComponent(Graphics g, Player player) {
		System.out.println(player.getColuna());
		System.out.println(board.getCasa(1,1));
		int[] coord = board.getXY(player.getFila(), player.getColuna());
		
        g.drawOval(coord[0], coord[1], 12, 12);
    }
	
	public void turnLabel(String turnLabel){
		
		diceLabel.setText(turnLabel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1 ){
			Facade f = new Facade();
			f.startDiceScreen();
			/*DiceScreen f = DiceScreen.getInstance();
			f.setSize(300,300);
			f.setVisible(true); */
			
		}
		else{
			System.exit(1);
		}
		
	}

}
