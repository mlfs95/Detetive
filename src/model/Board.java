package model;

public class Board {

	private static Board instancia = null;
	private int linhaMax;
	private int colunaMax;
	private static Casa[][] board;
	private int casaWidth = 25;
	private int casaHeight = 25;
	private int xMin = 52;
	private int yMin = 55;
	
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
	
	private Board(){
		
		linhaMax=25;
		colunaMax=24;
		
		board = new Casa[25][24];
		
		initializeBoard();
	}
	
	public static Board getInstance(){
		if(instancia == null){
			instancia = new Board();
		} 
		return instancia;
	}
	
	public Casa getCasa(int x, int y){
		
		return board[y][x];
	}
	
	public int setCasa(int linhaAtual, int colunaAtual, int linhaNova, int colunaNova){
		
		System.out.println(linhaNova + ", " + colunaNova);
		System.out.println(board[linhaNova][colunaNova]);
		
		if (board[linhaNova][colunaNova] == Casa.livre){
			board[linhaNova][colunaNova] = Casa.ocupado;
		}
		else if (board[linhaNova][colunaNova] == Casa.bibliotecaL){
			board[linhaNova][colunaNova] = Casa.bibliotecaO;
		}
		else if (board[linhaNova][colunaNova] == Casa.cozinhaL){
			board[linhaNova][colunaNova] = Casa.cozinhaO;
		}
		else if (board[linhaNova][colunaNova] == Casa.entradaL){
			board[linhaNova][colunaNova] = Casa.entradaO;
		}
		else if (board[linhaNova][colunaNova] == Casa.escritorioL){
			board[linhaNova][colunaNova] = Casa.escritorioO;
		}
		else if (board[linhaNova][colunaNova] == Casa.jardimL){
			board[linhaNova][colunaNova] = Casa.jardimO;
		}
		else if (board[linhaNova][colunaNova] == Casa.salaDeEstarL){
			board[linhaNova][colunaNova] = Casa.salaDeEstarO;
		}
		else if (board[linhaNova][colunaNova] == Casa.salaDeJantarL){
			board[linhaNova][colunaNova] = Casa.salaDeJantarO;
		}
		else if (board[linhaNova][colunaNova] == Casa.salaDeMusicaL){
			board[linhaNova][colunaNova] = Casa.salaDeMusicaO;
		}
		else if (board[linhaNova][colunaNova] == Casa.salaoDeJogosL){
			board[linhaNova][colunaNova] = Casa.salaoDeJogosO;
		}
		else {
			return -1;
		}
		
		if (board[linhaAtual][colunaAtual] == Casa.ocupado){
			board[linhaAtual][colunaAtual] = Casa.livre;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.bibliotecaO){
			board[linhaAtual][colunaAtual] = Casa.bibliotecaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.cozinhaO){
			board[linhaAtual][colunaAtual] = Casa.cozinhaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.entradaO){
			board[linhaAtual][colunaAtual] = Casa.entradaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.escritorioO){
			board[linhaAtual][colunaAtual] = Casa.escritorioL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.jardimO){
			board[linhaAtual][colunaAtual] = Casa.jardimL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.salaDeEstarO){
			board[linhaAtual][colunaAtual] = Casa.salaDeEstarL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.salaDeJantarO){
			board[linhaAtual][colunaAtual] = Casa.salaDeJantarL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.salaDeMusicaO){
			board[linhaAtual][colunaAtual] = Casa.salaDeMusicaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.salaoDeJogosO){
			board[linhaAtual][colunaAtual] = Casa.salaoDeJogosL;
		}
		
		return 0;
	}
	
	public int[] getLinhaColuna(int x, int y){
		
		int linha = (y-yMin)/casaWidth;
		int coluna = (x-xMin)/casaHeight;
		
		System.out.println(linha);
		System.out.println(coluna);
		
		if (x<xMin || y<yMin || linha>=linhaMax || coluna>=colunaMax){
			System.out.println("fora");
			
			return new int[] {-1, -1};
		}
		
		return new int[] {linha, coluna};
		
	}
	
	public int[] getXY(int linha, int coluna){
		
		int y = coluna*casaWidth+yMin;
		int x = linha*casaHeight+xMin;
		
		return new int[] {x, y};
	}
	
	private void initializeBoard() {
		int linha, coluna;
				
		for (linha=0; linha<linhaMax; linha++ ){
			
			for (coluna=0; coluna<colunaMax; coluna++){
				
				// Casas mais externas
				if (linha==0 || linha == 24 || coluna == 0 || coluna==23){
					
					if (coluna==0 && (linha==7 || linha==17)){
						board[linha][coluna] = Casa.livre;
					}
					else if (coluna==23 && (linha==6 || linha==19)){
						board[linha][coluna] = Casa.livre;
					}
					else if (linha==0 && (coluna==9 || coluna==14)){
						board[linha][coluna] = Casa.livre;
					}
					else if (linha==24 && (coluna==7 || coluna==16)){
						board[linha][coluna] = Casa.livre;
					}
					else{
						board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas da cozinha
				else if (linha<=6 && coluna<=6){
					
//					if (linha==6 && coluna==4){
//						Board[linha][coluna] = Casa.cozinhaL;
//					}
//					else {
						board[linha][coluna] = Casa.fora;
					
				}
				
				// Casas da sala de musica
				else if ((linha>=1 && linha<=7) && (coluna>=8 && coluna<=15)){
					
					if (linha==1){
						if (coluna>=10 && coluna<=13){
							board[linha][coluna] = Casa.fora;
						}
						else{
							board[linha][coluna] = Casa.livre;
						}
					}
//					else if((linha==5 && (coluna==8 || coluna==15)) || (linha==7 && (coluna==9 || coluna == 14))){
//						Board[linha][coluna] = Casa.salaDeMusicaL;
//					}
					else {
						board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas do Jardim
				else if (linha<=5 && coluna>=18){
					
					if (linha==5 && coluna==18){
						board[linha][coluna] = Casa.livre;
					}
//					else if (linha==5 && coluna==19){
//						Board[linha][coluna] = Casa.jardimL;
//					}
					else {
						board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas da sala de jantar
				else if ((linha>=9 && linha<=15) && coluna<=7){
					
					if (linha==9 && coluna>4){
						board[linha][coluna] = Casa.livre;
					}
//					else if ((linha==12 && coluna==7) || (linha==15 && coluna==6)){
//						Board[linha][coluna] = Casa.salaDeJantarL;
//					}
					else {
						board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas da Clue
				else if ((linha>=10 && linha<=16) && (coluna>=10 && coluna<=14)){
					board[linha][coluna] = Casa.fora;
				}
				
				// Casas do salao de jogos
				else if ((linha>=8 && linha<=12) && coluna>=18){
					
//					if ((linha==9 && coluna==18) || (linha==12 && coluna==22)){
//						Board[linha][coluna] = Casa.salaoDeJogosL;
//					}
//					if {
						board[linha][coluna] = Casa.fora;
					
				}
				
				// Casas da biblioteca
				else if ((linha>=14 && linha<=18) && coluna>=17){
					
					if ((linha==14 || linha==18) && coluna==17){
						board[linha][coluna] = Casa.livre;
					}
//					else if ((linha==16 && coluna==17) || (linha==14 && coluna==20)){
//						Board[linha][coluna] = Casa.bibliotecaL;
//					}
					else {
						board[linha][coluna] = Casa.fora;
					}
				}
				
				// Casas da Sala de Estar
				else if(linha>=19 && coluna<=6){
					board[linha][coluna] = Casa.fora;
				}
				
				// Casas da Entrada
				else if(linha>=18 && (coluna>=9 && coluna<=14)){
					board[linha][coluna] = Casa.fora;
				}
				
				// Casas do Escritório
				else if(linha>=21 && coluna>=17){
					board[linha][coluna] = Casa.fora;
				}
				
				// O resto das casas são as casas jogáveis 
				else {
					board[linha][coluna] = Casa.livre;
				}
			
			}
		}
		
		// entrada cozinha
		board[7][4] = Casa.cozinhaL;
		
		// entradas sala de musica
		board[5][7] = Casa.salaDeMusicaL;
		board[8][9] = Casa.salaDeMusicaL;
		board[8][14] = Casa.salaDeMusicaL;
		board[5][16] = Casa.salaDeMusicaL;
		
		// entradas jardim de inverno
		board[5][18] = Casa.jardimL;
		
		// entradas sala de jantar
		board[12][8] = Casa.salaDeJantarL;
		board[16][6] = Casa.salaDeJantarL;
		
		// entradas salão de jogos
		board[9][17] = Casa.salaoDeJogosL;
		board[13][22] = Casa.salaoDeJogosL;
		
		// entradas biblioteca
		board[13][20] = Casa.bibliotecaL;
		board[16][16] = Casa.bibliotecaL;
		
		// entradas sala de Estar
		board[18][6] = Casa.salaDeEstarL;
		
		// entradas entrada
		board[17][11] = Casa.entradaL;
		board[17][12] = Casa.entradaL;
		board[20][15] = Casa.entradaL;
		
		// entradas escritório
		board[20][17] = Casa.escritorioL;
	}
	
	
}











