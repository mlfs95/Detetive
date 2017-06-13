package main;
import screen.FirstScreen;

public class DetetiveMain {

	public static void main(String[] args) {
		
		Facade NewGame = Facade.getInstance();
		NewGame.startFirstScreen();
		
/*		FirstScreen f = FirstScreen.getInstance();		
		f.setSize(600, 600);		
		f.setVisible(true); */

	}

}
