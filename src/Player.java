
public class Player {
    
    public int fila;
    public int coluna;
    public Character personagem;
    
    public enum Character{
        
        Green, Mustard, Peacock, Plum, Scarlet, White;
    }
    
    public Player (Character personagem){
        
        this.personagem = personagem;
        
        switch (personagem) {
                
            case Green:
                fila=14;
                coluna=0;
                
            case Mustard:
                fila=0;
                coluna=17;
                
            case Peacock:
                fila=24;
                coluna=6;
                
            case Plum:
                fila=24;
                coluna=19;
                
            case Scarlet:
                fila=7;
                coluna=14;
                
            case White:
                fila=9;
                coluna=0;
        }
    }

}
