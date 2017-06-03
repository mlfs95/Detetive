
public class Board {

	int linhaMax;
	int colunaMax;
	Casa[][] Board;
	
	public enum Casa {
		livre, ocupado, fora,
		bibliotecaL, bibliotecaO, 
		cozinhaL, cozinhaO, 
		entradaL, entradaO, 
		escritorioL, escritorioO,
		jardimL, jardimO,
		salaDeEstarL, salaDeEstarO,
		salaDeJantarL, salaDeJantarO,
		salaDeMusicaL, salaDeMusicaO,
		salaoDeJogosL, salaoDeJogosO;
	}
	
	public Board(){
		
		linhaMax=25;
		colunaMax=24;
		
		Board = new Casa[25][24];
		
		initializeBoard();
	}
	
	private void initializeBoard() {
		int linha, coluna;
				
		for (linha=0; linha<linhaMax; linha++ ){
			
			for (coluna=0; coluna<colunaMax; coluna++){
				
				// Casas mais externas
				if (linha==0 || linha == 24 || coluna == 0 || coluna==23){
					
					if (coluna==0 && (linha==7 || linha==17)){
						Board[linha][coluna] = Casa.livre;
					}
					else if (coluna==23 && (linha==6 || linha==19)){
						Board[linha][coluna] = Casa.livre;
					}
					else if (linha==0 && (coluna==9 || coluna==14)){
						Board[linha][coluna] = Casa.livre;
					}
					else if (linha==24 && (coluna==7 || coluna==16)){
						Board[linha][coluna] = Casa.livre;
					}
					else{
						Board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas da cozinha
				else if (linha<=6 && coluna<=6){
					
//					if (linha==6 && coluna==4){
//						Board[linha][coluna] = Casa.cozinhaL;
//					}
//					else {
						Board[linha][coluna] = Casa.fora;
					
				}
				
				// Casas da sala de musica
				else if ((linha>=1 && linha<=7) && (coluna>=8 && coluna<=15)){
					
					if (linha==1){
						if (coluna>=10 && coluna<=13){
							Board[linha][coluna] = Casa.fora;
						}
						else{
							Board[linha][coluna] = Casa.livre;
						}
					}
//					else if((linha==5 && (coluna==8 || coluna==15)) || (linha==7 && (coluna==9 || coluna == 14))){
//						Board[linha][coluna] = Casa.salaDeMusicaL;
//					}
					else {
						Board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas do Jardim
				else if (linha<=5 && coluna>=18){
					
					if (linha==5 && coluna==18){
						Board[linha][coluna] = Casa.livre;
					}
//					else if (linha==5 && coluna==19){
//						Board[linha][coluna] = Casa.jardimL;
//					}
					else {
						Board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas da sala de jantar
				else if ((linha>=9 && linha<=15) && coluna<=7){
					
					if (linha==9 && coluna>4){
						Board[linha][coluna] = Casa.livre;
					}
//					else if ((linha==12 && coluna==7) || (linha==15 && coluna==6)){
//						Board[linha][coluna] = Casa.salaDeJantarL;
//					}
					else {
						Board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas da Clue
				else if ((linha>=10 && linha<=16) && (coluna>=10 && coluna<=14)){
					Board[linha][coluna] = Casa.fora;
				}
				
				// Casas do salao de jogos
				else if ((linha>=8 && linha<=12) && coluna>=18){
					
//					if ((linha==9 && coluna==18) || (linha==12 && coluna==22)){
//						Board[linha][coluna] = Casa.salaoDeJogosL;
//					}
//					if {
						Board[linha][coluna] = Casa.fora;
					
				}
				
				// Casas da biblioteca
				else if ((linha>=14 && linha<=18) && coluna>=17){
					
					if ((linha==14 || linha==18) && coluna==17){
						Board[linha][coluna] = Casa.livre;
					}
//					else if ((linha==16 && coluna==17) || (linha==14 && coluna==20)){
//						Board[linha][coluna] = Casa.bibliotecaL;
//					}
					else {
						Board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas da Sala de Estar
				else if(linha>=20 && coluna<=6){
					Board[linha][coluna] = Casa.fora;
				}
				
				// Casas da Entrada
				else if(linha<=18 && (coluna>=9 && coluna<=14)){
					Board[linha][coluna] = Casa.fora;
				}
				
				// Casas do Escritório
				else if(linha<=21 && coluna>=17){
					Board[linha][coluna] = Casa.fora;
				}
				
				// O resto das casas são as casas jogáveis 
				else {
					Board[linha][coluna] = Casa.livre;
				}
			
			}
		}
		
		// entrada cozinha
		Board[7][4] = Casa.cozinhaL;
		
		// entradas sala de musica
		Board[5][7] = Casa.salaDeMusicaL;
		Board[8][9] = Casa.salaDeMusicaL;
		Board[8][14] = Casa.salaDeMusicaL;
		Board[5][16] = Casa.salaDeMusicaL;
		
		// entradas jardim de inverno
		Board[5][18] = Casa.jardimL;
		
		// entradas sala de jantar
		Board[12][8] = Casa.salaDeJantarL;
		Board[16][6] = Casa.salaDeJantarL;
		
		// entradas salão de jogos
		Board[9][17] = Casa.salaoDeJogosL;
		Board[13][22] = Casa.salaoDeJogosL;
		
		// entradas biblioteca
		Board[13][20] = Casa.bibliotecaL;
		Board[16][16] = Casa.bibliotecaL;
		
		// entradas sala de jantar
		Board[18][6] = Casa.salaDeJantarL;
		
		// entradas entrada
		Board[17][11] = Casa.entradaL;
		Board[17][12] = Casa.entradaL;
		Board[20][15] = Casa.entradaL;
		
		// entradas escritório
		Board[20][17] = Casa.escritorioL;
	}
}











