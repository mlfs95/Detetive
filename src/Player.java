import java.awt.*;

public class Player {
    
    private int fila;
    private int coluna;
    private Character personagem;
    private Color color;
    
    public enum Character{
        
        Green, Mustard, Peacock, Plum, Scarlet, White;
    }
    
    public Player (Character personagem){
        
        this.personagem = personagem;
        
        if (personagem == Character.Green){
        	fila=0;
            coluna=14;
            color = Color.GREEN;
        }
        else if (personagem == Character.Mustard){
        	fila=17;
            coluna=0;
            color = Color.YELLOW;
        }
        else if (personagem == Character.Peacock){
        	fila=6;
            coluna=23;
            color = Color.BLUE;
        }
        else if (personagem == Character.Plum){
        	fila=19;
            coluna=23;
            color = Color.CYAN;
        }
        else if (personagem == Character.Scarlet){
        	fila=24;
            coluna=7;
            color = Color.RED;
        }
        else {
            fila=0;
            coluna=9;
            color = Color.WHITE;
        }
    }
    
    public void setFila(int fila){
    	this.fila = fila;
    }
    
    public void setColuna(int coluna){
    	this.coluna = coluna;
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
}
