package screen;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import main.Facade;
import model.Board;
import model.Card;
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
	private Card cards[];
	private Card answers[];
	
		private BoardScreen(String s, int width, int height){
		
		super(s);
		
		Facade f = Facade.getInstance();
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
	
	public void setCards(){

		initializeCards();
		giveCards();
	}
	
	public Player[] getPlayers(){
		
		return players;
	}
	
	public Card[] getCards(){
		return cards;
	}
	
	private void initializeCards(){
		
		cards = new Card[21];

		// inicializando as cartas dos suspeitos
		cards[0] = new Card("Green", "Green.jpg", 1);
		cards[1] = new Card("Mustard", "Mustard.jpg", 1);
		cards[2] = new Card("Peacock", "Peacock.jpg", 1);
		cards[3] = new Card("Plum", "Plum.jpg", 1);
		cards[4] = new Card("Scarlet", "Scarlet.jpg", 1);
		cards[5] = new Card("White", "White.jpg", 1);
		
		// inicializando as cartas das armas
		cards[6] = new Card("Cano", "Cano.jpg", 2);
		cards[7] = new Card("Castiçal", "Castical.jpg", 2);
		cards[8] = new Card("Chave inglesa", "ChaveInglesa.jpg", 2);
		cards[9] = new Card("Corda", "Corda.jpg", 2);
		cards[10] = new Card("Faca", "Faca.jpg", 2);
		cards[11] = new Card("Revólver", "Revolver.jpg", 2);
		
		// inicializando os cartas dos comodos
		cards[12] = new Card("Biblioteca", "Biblioteca.jpg", 0);
		cards[13] = new Card("Cozinha", "Cozinha.jpg", 0);
		cards[14] = new Card("Entrada", "Entrada.jpg", 0);
		cards[15] = new Card("Escritório", "Escritorio.jpg", 0);
		cards[16] = new Card("Jardim de Inverno", "JardimInverno.jpg", 0);
		cards[17] = new Card("Sala de Estar", "SalaDeEstar.jpg", 0);
		cards[18] = new Card("Sala de Jantar", "SalaDeJantar.jpg", 0);
		cards[19] = new Card("Sala de Música", "SalaDeMusica.jpg", 0);
		cards[20] = new Card("Salão de Jogos", "SalaoDeJogos.jpg", 0);
	}
	
	private void giveCards (){
		
		int playersCount = players.length;
		
		boolean cardsBool[] = new boolean[21];
		answers = new Card[3];
		
		for(int i = 0; i<21; i++){
			cardsBool[i] = true;
		}
		
		int aux=0;
		Random randomGenerator = new Random();
		int randomNumber;
		
		while(aux<3){
			randomNumber = randomGenerator.nextInt(21);
			
			if(aux == 0){	
				if(cards[randomNumber].getType() == Card.Type.comodo){
					answers[0] = cards[randomNumber];
					cardsBool[randomNumber] = false;
					aux++;
				}
			}
			else if(aux == 1){
				if(cards[randomNumber].getType() == Card.Type.suspeito){
					answers[0] = cards[randomNumber];
					cardsBool[randomNumber] = false;
					aux++;
				}
			}
			else if(aux == 2){
				if(cards[randomNumber].getType() == Card.Type.arma){
					answers[0] = cards[randomNumber];
					cardsBool[randomNumber] = false;
					aux++;
				}
			}
		}
		System.out.println("deu as cartas de resposta");
		Card playersCards[][] = new Card[6][6];
		
		int cardsGiven = 3;
		int turn = 0;
		aux = 0;
		
		while(cardsGiven < 21){
			
			randomNumber = randomGenerator.nextInt(21);
			while(cardsBool[randomNumber] == false){
				randomNumber = randomGenerator.nextInt(21);
			}
			
			cardsBool[randomNumber] = false;
			playersCards[turn][aux] = cards[randomNumber];
			turn++;
			cardsGiven++;
			
			if (turn == playersCount){
				turn = 0;
				aux++;
			}
		}
		
		for (aux = 0; aux<playersCount; aux++){
			
			if (playersCount == 3){
				players[aux].setCardsQuantity(6);
				players[aux].setCard(playersCards[aux]);
			}
			else if (playersCount == 4){
				if (aux == 0 || aux == 1){
					players[aux].setCardsQuantity(5);
				}
				else {
					players[aux].setCardsQuantity(4);
				}
				players[aux].setCard(playersCards[aux]);
			}
			else if (playersCount == 5){
				if (aux == 0 || aux == 1 || aux == 2){
					players[aux].setCardsQuantity(4);
				}
				else {
					players[aux].setCardsQuantity(3);
				}
				players[aux].setCard(playersCards[aux]);
			}
			else {
				players[aux].setCardsQuantity(3);
				players[aux].setCard(playersCards[aux]);
			}
		}
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
			Facade f = Facade.getInstance();
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
