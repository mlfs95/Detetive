import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardScreen extends JFrame implements ActionListener,MouseListener{
	
	public static BoardScreen instancia = null;
	public Player players[];
	public Board board;
	private int diceMinX = 316;
	private int diceMinY = 359;
	private JLabel diceImage = new JLabel();
	private Image i;
	private JButton b1;
	
	public BoardScreen(String s, int width, int height){
		
		super(s);
		
		PNBoard p = PNBoard.getInstance();//new PNBoard(width,height);
		getContentPane().add(p);
		
		//board = new Board();
		
		diceImage.setBounds(diceMinX, diceMinY, 95, 106);
		p.add(diceImage);
		
		addMouseListener(this);
		
		rollDices();
		
		b1 = new JButton("Rolar os dados");
		p.add(b1);
		
		b1.setSize(200, 50);
		b1.setLocation(width/2-b1.getSize().width/2, height*14/16-b1.getSize().height/2);
		
		b1.addActionListener(this);
		
	}
	
	public static BoardScreen getInstance(){
		if(instancia == null){
			instancia = new BoardScreen("Detetive",700,725);
		} 
		return instancia;
	}
	
	private int rollDices() {
		
		Random randomGenerator = new Random();
		int diceNumber = randomGenerator.nextInt(6)+1;
		
		System.out.println(diceNumber);
		
		String dado = "dado";
		dado = dado + String.valueOf(diceNumber) + ".jpg";
		
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream(dado);
			i = ImageIO.read(input);
			diceImage.setBounds(400, 400, 95, 106);
			diceImage.setIcon( new ImageIcon(i));
		}
		catch(IOException e) {
			System.out.println("bla");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		return diceNumber;
	}
	

	private void drawPlayers(){
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	    int x=e.getX();
	    int y=e.getY();
	    
	    System.out.println("x: " + x + " y: " + y);
	    
	    board.getCasa(x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1 ){
			//this.setVisible(false);
			DiceScreen f = DiceScreen.getInstance();
			f.setSize(300,300);
			f.setVisible(true);
			
		}
		else{
			System.exit(1);
		}
		
	}

}
