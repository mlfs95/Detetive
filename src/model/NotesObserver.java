package model;

import screen.BoardScreen;
import screen.PNBoard;

public class NotesObserver implements Observer {

	@Override
	public void update() {
		
		BoardScreen.getInstance().setAnotationsScreen(PNBoard.getInstance().getTurn());
	}

}
