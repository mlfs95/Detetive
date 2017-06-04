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

public class BoardScreen extends JFrame implements MouseListener{
	
	public static BoardScreen instancia = null;
	public Player players[];
	public Board board;
	private int diceMinX = 316;
	private int diceMinY = 359;
	private JLabel diceImage = new JLabel();
	private Image i;
	
	public BoardScreen(String s, int width, int height){
		
		super(s);
		
		PNBoard p = new PNBoard(width,height);
		getContentPane().add(p);
		
		board = new Board();
		
		diceImage.setBounds(diceMinX, diceMinY, 95, 106);
		p.add(diceImage);
		
		addMouseListener(this);
		
		rollDices();
		
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

}
