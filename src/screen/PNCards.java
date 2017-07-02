package screen;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Card;

public class PNCards extends JPanel{
	private Card[] cards;
	private int cardsQuantity;
	//private Card[] cardlist;
	public PNCards(Card[] cardlist, int cardsQuantity){
		this.cards = cardlist;
		this.cardsQuantity = cardsQuantity;
	
	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        int i = 0;
	        for(int j = 0; j<cardsQuantity; j++){
	        	
	        	g.drawImage(cards[j].getImage(), i, 0, null);
	        	i = i+200;
	        }
	                  
	    } 

}
