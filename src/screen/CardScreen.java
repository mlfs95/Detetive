package screen;

import javax.swing.JFrame;

import model.Card;

public class CardScreen extends JFrame{
	
	public CardScreen(Card[] cards, int cardsQuantity){
		super();
		PNCards p = new PNCards(cards, cardsQuantity);
		getContentPane().add(p);
		
	}

}
