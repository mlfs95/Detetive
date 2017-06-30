package model;
import java.awt.*;

public class Player {
    
    private int fila;
    private int coluna;
    private Character personagem;
    private Color color;
    private String nome;
    private int cardsQuantity;
    private Card cards[];
    private Anotations anotations;
    private boolean isInGame = true;
    
    public enum Character{
        
        Green, Mustard, Peacock, Plum, Scarlet, White;
    }
    
    public Player (Character personagem){
        
        this.personagem = personagem;
        
        if (personagem == Character.Green){
        	fila=0;
            coluna=14;
            color = Color.GREEN;
            nome = "Rev. Green";
        }
        else if (personagem == Character.Mustard){
        	fila=17;
            coluna=0;
            color = Color.YELLOW;
            nome = "Coronel Mustard";
        }
        else if (personagem == Character.Peacock){
        	fila=6;
            coluna=23;
            color = Color.BLUE;
            nome = "Sra. Peacock";
        }
        else if (personagem == Character.Plum){
        	fila=19;
            coluna=23;
            color = Color.CYAN;
            nome = "Professor Plum";
        }
        else if (personagem == Character.Scarlet){
        	fila=24;
            coluna=7;
            color = Color.RED;
            nome = "Srta. Scarlet";
        }
        else {
            fila=0;
            coluna=9;
            color = Color.WHITE;
            nome = "Sra. White";
        }
    }
    
    public void setFila(int fila){
    	this.fila = fila;
    }
    
    public void setColuna(int coluna){
    	this.coluna = coluna;
    }
    
    public void setCard(Card[] cards){
    	this.cards = cards;
    }
    
    public void setCardsQuantity(int quantity){
    	this.cardsQuantity = quantity;
    }
    
    public void setAnotations(Anotations anotations){
    	this.anotations = anotations;
    }
    
    public void setIsInGame (boolean isInGame){
    	this.isInGame = isInGame;
    }
    
    public int getFila(){
    	return fila;
    }
    
    public int getColuna(){
    	return coluna;
    }
    
    public Character getPersonagem(){
    	return personagem;
    }
    
    public Color getColor(){
    	return color;
    }
    
    public String getNome(){
    	return nome;
    }
    
    public Card[] getCards(){
    	return cards;
    }
    
    public int getCardsQuantity(){
    	return cardsQuantity;
    }
    
    public Anotations getAnotations(){
    	return anotations;
    }
    
    public boolean getIsInGame(){
    	return isInGame;
    }
    
    public Card checkCards(String cardName){

    	for (int i = 0; i < cardsQuantity; i++){
    		if (new String(cards[i].getName()).equals(cardName)){
    			return cards[i];
    		}
    	}
    	
    	return null;
    }
}
