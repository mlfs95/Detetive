import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PNBoard extends JPanel implements MouseListener{
	
	private Image i;
	public static PNBoard instancia = null;
	static Board board;
	
	public Player players[];
	private JPanel playerPanel[];
	private Player.Character player;
	private int x1 = 20, y1 = 20;
	
	public PNBoard(int width, int height){
		
		this.setSize(width, height);
		try
		{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Tabuleiro-Clue-A.jpg");
			i = ImageIO.read(input);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		addMouseListener(this);
/*		this.players = players;
		playerPanel = new JPanel[players.length];
		for (int i=0; i<players.length; i++){
			playerPanel[i] = new JPanel();
		} */
//		drawPlayers();
	}
	
	public static PNBoard getInstance(){
		if(instancia == null){
			instancia = new PNBoard(0,0);
		} 
		return instancia;
	}
	
/*	private void drawPlayers(){
		int i;
		for ( i=0; i<players.length; i++){
			System.out.println(players[i].personagem);
			
			//paintComponent(playerPanel[i].getGraphics(), players[i]);
		}
	} */
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(i, 0, 0, null);
	        Graphics2D g2d  = (Graphics2D) g;
	        
	        g2d.setColor(Color.BLACK);
	        g2d.fillOval(x1, y1, 10, 10);
	       addMouseListener(this);
	       /* System.out.println(player.coluna);
			System.out.println(board.Board[1][1]);
			int[] coord = board.getXY(player.fila, player.coluna);
			
	        g.drawOval(coord[0], coord[1], 12, 12); */
	    }

	@Override
	public void mouseClicked(MouseEvent e) {
		 	int x=e.getX();
		    int y=e.getY();
		    
		    x1 = x; y1 = y;
		    //System.out.println("x: " + x + " y: " + y);
//		    board.getCasa(x, y);
		    System.out.println("x: " + x + " y: " + y);
		   // repaint();
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} 
}
