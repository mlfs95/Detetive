package model;

public class Anotations {
	private boolean comodos[];
	private boolean armas[];
	private boolean suspeitos[];
//	private static Anotations instance;

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
			}
			
			else if (card.getName() == "Cozinha"){
				
				comodos[1] = true;
			}
			
			else if (card.getName() == "Entrada"){
				
				comodos[2] = true;
			}
			
			else if (card.getName() == "Escritório"){
				
				comodos[3] = true;
			}
			else if (card.getName() == "Jardim de Inverno"){
				
				comodos[4] = true;
			}
			else if (card.getName() == "Sala de Estar"){
	
				comodos[5] = true;
			}
			else if (card.getName() == "Sala de Jantar"){
	
				comodos[6] = true;
			}
			else if (card.getName() == "Sala de Música"){
	
				comodos[7] = true;
			}	
			else if (card.getName() == "Salão de Jogos"){
	
				comodos[8] = true;
			}
		}
		
		if (card.getType() == Card.Type.arma){
			
			if (card.getName() == "Cano"){
				
				armas[0] = true;
			}
			
			else if (card.getName() == "Castiçal"){
				
				armas[1] = true;
			}
			
			else if (card.getName() == "Chave inglesa"){
				
				armas[2] = true;
			}
			
			else if (card.getName() == "Corda"){
				
				armas[3] = true;
			}
			else if (card.getName() == "Faca"){
				
				armas[4] = true;
			}
			else if (card.getName() == "Revólver"){
	
				armas[5] = true;
			}
		}
		if (card.getType() == Card.Type.suspeito){
			
			if (card.getName() == "Green"){
				
				suspeitos[0] = true;
			}
			
			else if (card.getName() == "Mustard"){
				
				suspeitos[1] = true;
			}
			
			else if (card.getName() == "Peacock"){
				
				suspeitos[2] = true;
			}
			
			else if (card.getName() == "Plum"){
				
				suspeitos[3] = true;
			}
			else if (card.getName() == "Scarlet"){
				
				suspeitos[4] = true;
			}
			else if (card.getName() == "White"){
	
				suspeitos[5] = true;
			}
		}
	}
	
/*	public static Anotations getInstance(Card[] cards, int cardsqtd){
		if(instance == null){
			instance = new Anotations(cards,cardsqtd);
		}
		return instance;
	} */
}
