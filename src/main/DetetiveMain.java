package main;
import screen.FirstScreen;

public class DetetiveMain {

	public static void main(String[] args) {
		
		FirstScreen f = FirstScreen.getInstance();
//		FirstScreen f = new FirstScreen("Detetive", 600, 600);
		
		f.setSize(600, 600);
		
		f.setVisible(true);

	}

}
