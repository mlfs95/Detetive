package main;
import model.Anotations;
import model.Board;
import model.Card;
import model.Player;
import screen.*;

public class Facade {
	private static Facade instancia = null; 
	private Board board;
	private BoardScreen boardscreen;
	private DiceScreen dicescreen;
	private Player player;
	private FirstScreen firstscreen;
	private NewGameScreen newgamescreen;
	private GameOverScreen gameoverscreen;
	private Anotations anotations;
	private AnotationsScreen notescreen;
	
	public Facade(){
		
	}

	public void startFirstScreen(){
		firstscreen = FirstScreen.getInstance();
		firstscreen.setSize(600, 600);
		firstscreen.setVisible(true);
	}
	
	public void startNewGameScreen(){
		newgamescreen = NewGameScreen.getInstance();
		newgamescreen.setSize(600, 600);
		newgamescreen.setVisible(true);
	}
	
	public void startBoardScreen(){
		boardscreen = BoardScreen.getInstance();
		boardscreen.setSize(700, 725);
		boardscreen.setVisible(true);
	}
	
	public void startBoard(){
		board = Board.getInstance();
	}
	
	public void startDiceScreen(){
		dicescreen = DiceScreen.getInstance();
		dicescreen.setSize(300,300);
		dicescreen.setVisible(true);
	}
	
	public void startGameOverScreen(String s){
		gameoverscreen = GameOverScreen.getInstance(s);
		gameoverscreen.setSize(300,300);
		gameoverscreen.setVisible(true);
	}
	
/*	public void getPlayerNotes(Card[] cards, int cardsqtd){
		anotations = Anotations.getInstance(cards, cardsqtd);
	}
	
	public void getAnotationsScreen(String s){
		notescreen = AnotationsScreen.getInstance(s);
		notescreen.setSize(300,500);
		notescreen.setVisible(true);
	} */
	
	public static Facade getInstance(){
		if(instancia == null){
			instancia = new Facade();
		} 
		return instancia;
	}
}
