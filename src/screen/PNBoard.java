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

import main.Facade;
import model.Board;
import model.Card;
import model.Observable;
import model.Observer;
import model.Player;
import model.SuggestionObserver;

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
	private boolean canMove = true;
	private List<Observer> observers = new ArrayList<Observer>();
	private SuggestionObserver suggestionobserver;
	private CardScreen cardscreen;
	
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
	
	public int getTurn() {
		return turn;
	}
	
	public void setCanMove(boolean canMove){
		this.canMove = canMove;
	}
	
	public void canMoveAgain(){
		
		canMove = true;
		
		switchTurn();
	}
	
	private void isValidMove(int coord[], int diceNumber){
		
		int novaColuna = coord[1];
		int novaLinha = coord[0];
		suggestionobserver = BoardScreen.getInstance().getSuggestionObserver();
		if (novaColuna == -1){
			
			System.out.println("MOVIMENTO INVÁLIDO");
			
			return;
		}
		
		if (!canMove){
			
			return;
		}
		
		// caso o jogador esteja tentando usar um atalho
		if (Board.getInstance().getCasa(coord[1], coord[0]) == Board.Casa.fora){
			
			if (players[turn].getColuna() == 4 && 
				players[turn].getFila() == 6){
				
				System.out.println("CozinhaO atalho");
				
				if (novaColuna >= 17 && novaLinha >= 21){
					
					if ( Board.getInstance().getCasa(17, 21) == Board.Casa.escritorioL){
						
						Board.getInstance().setCasa(players[turn].getColuna(), players[turn].getFila(), Board.Casa.cozinhaL);
						
						players[turn].setColuna(17);
						players[turn].setFila(21);
						
						Board.getInstance().setCasa(players[turn].getColuna(), players[turn].getFila(), Board.Casa.escritorioO);
						
						this.notifyObservers(suggestionobserver);
						
						canMove = false;
						
						repaint();
						
						return;
					}
				}
			}
			else if (players[turn].getColuna() == 17 && 
					players[turn].getFila() == 21){

				System.out.println("CozinhaO atalho");

				if (novaColuna <= 4 && novaLinha <= 6){

					if ( Board.getInstance().getCasa(4, 6) == Board.Casa.cozinhaL){

						Board.getInstance().setCasa(players[turn].getColuna(), players[turn].getFila(), Board.Casa.escritorioL);

						players[turn].setColuna(4);
						players[turn].setFila(6);

						Board.getInstance().setCasa(players[turn].getColuna(), players[turn].getFila(), Board.Casa.cozinhaO);

						this.notifyObservers(suggestionobserver);
						
						canMove = false;
						
						repaint();
						
						return;
					}
				}
			}

			else if (players[turn].getColuna() == 19 && 
					players[turn].getFila() == 5){

				System.out.println("CozinhaO atalho");

				if (novaColuna <= 6 && novaLinha >= 19){

					if ( Board.getInstance().getCasa(6, 19) == Board.Casa.salaDeEstarL){

						Board.getInstance().setCasa(players[turn].getColuna(), players[turn].getFila(), Board.Casa.jardimL);

						players[turn].setColuna(6);
						players[turn].setFila(19);

						Board.getInstance().setCasa(players[turn].getColuna(), players[turn].getFila(), Board.Casa.salaDeEstarO);
						
						this.notifyObservers(suggestionobserver);
						
						canMove = false;

						repaint();

						return;
					}
				}
			}

			else if (players[turn].getColuna() == 6 && 
					players[turn].getFila() == 19){

				System.out.println("CozinhaO atalho");

				if (novaColuna >= 19 && novaLinha <= 5){

					if ( Board.getInstance().getCasa(19, 5) == Board.Casa.jardimL){

						Board.getInstance().setCasa(players[turn].getColuna(), players[turn].getFila(), Board.Casa.salaDeEstarL);

						players[turn].setColuna(19);
						players[turn].setFila(5);

						Board.getInstance().setCasa(players[turn].getColuna(), players[turn].getFila(), Board.Casa.jardimO);
					
						this.notifyObservers(suggestionobserver);
						canMove = false;
						
						repaint();
						
						return;
					}
				}
			}
		}
		
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
			    
					switchTurn();

					repaint();
				}
				
				// Tenta entrar num comodo
				else if( updateFB == 1){

					System.out.println("tentando entrar num comodo");
					int novaCoord[] = board.getInstance().enterRoom(coord[0], coord[1]);
					
					// caso tenha conseguido entrar num comodo aqui chama a função do palpite
					if (novaCoord[0] != coord[0] || novaCoord[1] != coord[1]){
						this.notifyObservers(suggestionobserver);
						
						canMove = false;
						
						repaint();
							
						//this.notifyObservers(suggestionobserver);
					}
					
					players[turn].setColuna(novaCoord[1]);
					players[turn].setFila(novaCoord[0]);
					
					//	this.notifyObservers(BoardScreen.getInstance().getCardsObserver());
					//	BoardScreen.getInstance().setCardScreen(turn);
					
				}
				
				// Movimento invalido
				else if(updateFB == -1){
					System.out.println("MOVIMENTO INVALIDO TENTE NOVAMENTE");
				}
			}
		}
		else {

			switchTurn();
			//this.notifyObservers(BoardScreen.getInstance().getCardsObserver());
			//BoardScreen.getInstance().setCardScreen(turn);
			System.out.println(players[turn].getColuna() + ", " + players[turn].getFila());
			repaint();
		}
	}
	
	public void switchTurn(){
		BoardScreen.getInstance().getCardScreen().dispose();
		
	
		turn++;
		
		if (turn==players.length)
			turn=0;
		
		int i = 0;
		
		while (!players[turn].getIsInGame()){
			
			i++;
			turn++;
		    
			if (turn==players.length)
				turn=0;
			
			if(players.length-1 == i){
				
				int t;
				
				for (t = 0; !players[t].getIsInGame(); t++);
					
				BoardScreen.getInstance().gameOver(players[t]);
			}
		}
		
		this.notifyObservers(BoardScreen.getInstance().getCardsObserver());
		this.notifyObservers(BoardScreen.getInstance().getNotesObserver());
	}
	
	public Card checkGuess(String weapon, String suspect){
		
		System.out.println("entrei na CheckGuess");
		for (int i = 0, t = turn; i < players.length; i++, t++){
			
			if (t==players.length)
				t=0;
			
			Card card = players[t].checkCards(weapon);
			if (card != null){
				players[t].getAnotations().checkAnotation(card);
				System.out.println("Achei arma na mão de: " + t);
				return card;
			}
			card = players[t].checkCards(suspect);
			if (card != null){
				players[t].getAnotations().checkAnotation(card);
				System.out.println("Achei suspeito na mão de: " + t);
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
		
		if (canMove){
			
		 	int x=e.getX();
		    int y=e.getY();
		    int coords[] = Board.getInstance().getLinhaColuna(x, y);
		    
		    isValidMove(coords, DiceScreen.getInstance().getDice());
		}
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
	public void notifyObservers(Observer o) {
		for(Observer p:observers){
			if(p == o){
				p.update();
			}
		}
			//	o.update();
	}

	
}
