package screen;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Card;

public class PNCards extends JPanel{
	private Card[] cards;
	//private Card[] cardlist;
	public PNCards(Card[] cardlist){
		this.cards = cardlist;
	//	for(Card p:cardlist){
	//	}
	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        int i = 0;
	        for(Card c:cards){
	        	
	        	g.drawImage(c.getImage(), i, 0, null);
	        	i = i+200;
	        }
	        
	        //g.drawImage(i1, 0, 0, null);
	                  
	    } 

}
