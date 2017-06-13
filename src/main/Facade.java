package main;
import model.Board;
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
	
	public Facade(){
		//firstscreen = FirstScreen.getInstance();
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
	
	/*public void startPlayer(){
		players = 
	}*/
	
	public static Facade getInstance(){
		if(instancia == null){
			instancia = new Facade();
		} 
		return instancia;
	}
}
