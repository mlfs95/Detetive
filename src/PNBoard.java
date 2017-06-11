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
	private static Board board;
	private static BoardScreen boardScreen;
	
	private Player players[];
	private JPanel playerPanel[];
	private Player.Character player;
	private int x1 = 20, y1 = 20;
	private int turn = 0;
	
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
	}
	
	public static PNBoard getInstance(){
		if(instancia == null){
			instancia = new PNBoard(0,0);
		} 
		return instancia;
	}
	
	private void isValidMove(int coord[], int diceNumber){
		
		int novaColuna = coord[1];
		int novaLinha = coord[0];
		int diffx = Math.abs(players[turn].getColuna() - novaColuna);
		int diffy = Math.abs(players[turn].getFila() - novaLinha);
		
		System.out.println("turn: " + turn);
		
		if ((diffx+diffy) <= diceNumber) {
			System.out.println("entrei primeiro if");
			if(board.getInstance().setCasa(players[turn].getFila(), players[turn].getColuna(), novaLinha, novaColuna) == 0){
				System.out.println("entrei segundo if");
				players[turn].setColuna(coord[1]);
				players[turn].setFila(coord[0]);
		    
				turn++;
		    
				if (turn==players.length)
					turn=0;
		    
				repaint();
			}
		}
	}
	
	
	 @Override
	    protected void paintComponent(Graphics g) {

	        super.paintComponent(g);
	        g.drawImage(i, 0, 0, null);
	        Graphics2D g2d  = (Graphics2D) g;
	        
	       // BoardScreen.getInstance().turnLabel("Vez de: " + players[turn].getNome());
	       
	        players = BoardScreen.getInstance().getPlayers();
	        System.out.println(players.length);
	       
	        for (int i = 0; i<players.length; i++){

	        	int coord[] = board.getInstance().getXY(players[i].getFila(), players[i].getColuna());
	        	g2d.setColor(players[i].getColor());
	        	g2d.fillOval(coord[1],coord[0], 10, 10);
	        }
	    }

	@Override
	public void mouseClicked(MouseEvent e) {
		
		 	int x=e.getX();
		    int y=e.getY();
		    int coords[] = Board.getInstance().getLinhaColuna(x, y);
		    
		    isValidMove(coords, 6);
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
