package screen;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Board;
import model.Card;
import model.Observable;
import model.Observer;
import model.Player;

public class PNBoard extends JPanel implements MouseListener,Observable{
	
	private Image i;
	public static PNBoard instancia = null;
	private static Board board;
	private static BoardScreen boardScreen;
	
	private Player players[];
	private JPanel playerPanel[];
	private Player.Character player;
	private int x1 = 20, y1 = 20;
	private int turn = 0;
	private List<Observer> observers = new ArrayList<Observer>();
	
	private PNBoard(int width, int height){
		
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
		
		int coordPlayer[] = board.getInstance().checkIsInRoom(players[turn].getFila(), players[turn].getColuna());
		
		// Caso o jogador nÃ£o esteja preso num comodo por outro jogador
		if (coordPlayer[0] != -1) {

			players[turn].setColuna(coordPlayer[1]);
			players[turn].setFila(coordPlayer[0]);
			
			
			int diffx = Math.abs(coordPlayer[1] - novaColuna);
			int diffy = Math.abs(coordPlayer[0] - novaLinha);
			
			System.out.println("turn: " + turn);
			
			if ((diffx+diffy) <= diceNumber) {
				
				System.out.println("entrei primeiro if");
				
				int updateFB = board.getInstance().updateBoard(coordPlayer[0], coordPlayer[1], novaLinha, novaColuna);
				
				// Se move para uma casa livre
				if(updateFB == 0){
					System.out.println("Se movendo para uma casa livre");
					players[turn].setColuna(coord[1]);
					players[turn].setFila(coord[0]);
			    
					turn++;
			    
					if (turn==players.length)
						turn=0;
			    
					repaint();
				}
				
				// Tenta entrar num comodo
				else if( updateFB == 1){

					System.out.println("tentando entrar num comodo");
					int novaCoord[] = board.getInstance().enterRoom(coord[0], coord[1]);
					
					// caso tenha conseguido entrar num comodo aqui chama a funÃ§Ã£o do palpite
					if (novaCoord[0] != coord[0] || novaCoord[1] != coord[1]){
						//System.out.println("Hora do palpite!!");
						this.notifyObservers();
					}
					
					players[turn].setColuna(novaCoord[1]);
					players[turn].setFila(novaCoord[0]);
					
					turn++;
				    
					if (turn==players.length)
						turn=0;
			    
					System.out.println(players[turn].getColuna() + ", " + players[turn].getFila());
					repaint();
				}
				
				// Movimento invalido
				else if(updateFB == -1){
					System.out.println("MOVIMENTO INVÃ�LIDO TENTE NOVAMENTE");
				}
			}
		}
		else {

			turn++;
		    
			if (turn==players.length)
				turn=0;
	    
			System.out.println(players[turn].getColuna() + ", " + players[turn].getFila());
			repaint();
		}
	}
	
	public Card checkGuess(String weapon, String suspect){
		
		for (int i = 0; i < players.length; i++){
			
			int turn = this.turn;
			turn++;
			
			if (turn==players.length)
				turn=0;
			
			Card card = players[turn].checkCards(weapon);
			if (card != null){
				players[this.turn].getAnotations().checkAnotation(card);
				return card;
			}
			card = players[turn].checkCards(suspect);
			if (card != null){
				players[this.turn].getAnotations().checkAnotation(card);
				return card;
			}
		}
		
		return null;
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
		    
		    isValidMove(coords, DiceScreen.getInstance().getDice());
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

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if(index > -1){
			observers.remove(o);
		}
		
	}

	@Override
	public void notifyObservers() {
		for(Observer o:observers){
			//System.out.println("NOTIFICANDO OBSERVERS");
			o.update();
		}
		
	}

	
}
