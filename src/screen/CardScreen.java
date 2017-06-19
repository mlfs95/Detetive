package screen;

import javax.swing.JFrame;

import model.Card;

public class CardScreen extends JFrame{
	
	public CardScreen(Card[] cards){
		super();
		PNCards p = new PNCards(cards);
		getContentPane().add(p);
		
	}

}
