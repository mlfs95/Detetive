package model;

import screen.BoardScreen;
import screen.CardScreen;
import screen.PNBoard;

public class CardsObserver implements Observer {
	
	//private CardScreen screen;

	@Override
	public void update() {
		BoardScreen.getInstance().setCardScreen(PNBoard.getInstance().getTurn());
	
	}

}
