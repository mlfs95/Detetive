package model;

public class Anotations {
	private boolean comodos[];
	private boolean armas[];
	private boolean suspeitos[];
//	private static Anotations instance;
	private String nomescomodos[] = new String[9];
	private String nomesarmas[] = new String[6];
	private String nomessuspeitos[] = new String[6];

	public Anotations (Card[] cards, int cardsQuantity){
		
		comodos = new boolean[9];
		armas = new boolean[6];
		suspeitos = new boolean[6];
		int i;
		
		for (i = 0; i < 6; i++){
			if (i<6){
				armas[i] = false;
				comodos[i] = false;
			}
			
			suspeitos[i] = false;
		}
		
		for (i = 0; i < cardsQuantity; i++){
			
			checkAnotation(cards[i]);
		}
	}
	
	public void checkAnotation(Card card){
		
		if (card.getType() == Card.Type.comodo){
			
			if (card.getName() == "Biblioteca"){
				
				comodos[0] = true;
				nomescomodos[0] = card.getName();
			}
			
			else if (card.getName() == "Cozinha"){
				
				comodos[1] = true;
				nomescomodos[1] = card.getName();
			}
			
			else if (card.getName() == "Entrada"){
				
				comodos[2] = true;
				nomescomodos[2] = card.getName();
			}
			
			else if (card.getName() == "Escritório"){
				
				comodos[3] = true;
				nomescomodos[3] = card.getName();
			}
			else if (card.getName() == "Jardim de Inverno"){
				
				comodos[4] = true;
				nomescomodos[4] = card.getName();
			}
			else if (card.getName() == "Sala de Estar"){
	
				comodos[5] = true;
				nomescomodos[5] = card.getName();
			}
			else if (card.getName() == "Sala de Jantar"){
	
				comodos[6] = true;
				nomescomodos[6] = card.getName();
			}
			else if (card.getName() == "Sala de Música"){
	
				comodos[7] = true;
				nomescomodos[7] = card.getName();
			}	
			else if (card.getName() == "Salão de Jogos"){
	
				comodos[8] = true;
				nomescomodos[8] = card.getName();
			}
		}
		
		if (card.getType() == Card.Type.arma){
			
			if (card.getName() == "Cano"){
				
				armas[0] = true;
				nomesarmas[0] = card.getName();
			}
			
			else if (card.getName() == "Castiçal"){
				
				armas[1] = true;
				nomesarmas[1] = card.getName();
			}
			
			else if (card.getName() == "Chave inglesa"){
				
				armas[2] = true;
				nomesarmas[2] = card.getName();
			}
			
			else if (card.getName() == "Corda"){
				
				armas[3] = true;
				nomesarmas[3] = card.getName();
			}
			else if (card.getName() == "Faca"){
				
				armas[4] = true;
				nomesarmas[4] = card.getName();
			}
			else if (card.getName() == "Revólver"){
	
				armas[5] = true;
				nomesarmas[5] = card.getName();
			}
		}
		if (card.getType() == Card.Type.suspeito){
			
			if (card.getName() == "Green"){
				
				suspeitos[0] = true;
				nomessuspeitos[0] = card.getName();
			}
			
			else if (card.getName() == "Mustard"){
				
				suspeitos[1] = true;
				nomessuspeitos[1] = card.getName();
			}
			
			else if (card.getName() == "Peacock"){
				
				suspeitos[2] = true;
				nomessuspeitos[2] = card.getName();
			}
			
			else if (card.getName() == "Plum"){
				
				suspeitos[3] = true;
				nomessuspeitos[3] = card.getName();
			}
			else if (card.getName() == "Scarlet"){
				
				suspeitos[4] = true;
				nomessuspeitos[4] = card.getName();
			}
			else if (card.getName() == "White"){
	
				suspeitos[5] = true;
				nomessuspeitos[5] = card.getName();
			}
		}
	}
	
	public boolean[] getComodos(){
		return comodos;
	}
	
	public boolean[] getArmas(){
		return armas;
	}
	
	public boolean[] getSuspeitos(){
		return suspeitos;
	}
	
	public String[] getNomessuspeitos(){
		return nomessuspeitos;
	}
	
	public String[] getNomesarmas(){
		return nomesarmas;
	}
	
	public String[] getNomecomodos(){
		return nomescomodos;
	}
	
/*	public static Anotations getInstance(Card[] cards, int cardsqtd){
		if(instance == null){
			instance = new Anotations(cards,cardsqtd);
		}
		return instance;
	} */
}
