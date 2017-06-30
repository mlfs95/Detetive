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
		bibliotecaL, bibliotecaO, bibliotecaPortaL, bibliotecaPortaO,
		cozinhaL, cozinhaO, cozinhaPortaL, cozinhaPortaO, 
		entradaL, entradaO, entradaPortaL, entradaPortaO,
		escritorioL, escritorioO, escritorioPortaL, escritorioPortaO,
		jardimL, jardimO, jardimPortaL, jardimPortaO,
		salaDeEstarL, salaDeEstarO, salaDeEstarPortaL, salaDeEstarPortaO,
		salaDeJantarL, salaDeJantarO, salaDeJantarPortaL, salaDeJantarPortaO,
		salaDeMusicaL, salaDeMusicaO, salaDeMusicaPortaL, salaDeMusicaPortaO,
		salaoDeJogosL, salaoDeJogosO, salaoDeJogosPortaL, salaoDeJogosPortaO;
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
	
	public void setCasa(int linha, int coluna, Casa casa){
		
		board[coluna][linha] = casa;
	}
	
	
	// retorna 0 caso ele se movimente para uma casa livre
	// retorna 1 caso tente se movimentar para uma porta de um comodo
	// retorna -1 caso o movimento seja inválido
	
	public int updateBoard(int linhaAtual, int colunaAtual, int linhaNova, int colunaNova){
		
		System.out.println(linhaNova + ", " + colunaNova);
		System.out.println("update Board atual: " + board[linhaAtual][colunaAtual]);
		System.out.println("update Board nova: " + board[linhaNova][colunaNova]);
		int movimento;
		
		if (board[linhaNova][colunaNova] == Casa.livre){
			board[linhaNova][colunaNova] = Casa.ocupado;
			movimento = 0;
		}
		else if (board[linhaNova][colunaNova] == Casa.bibliotecaPortaL){
			board[linhaNova][colunaNova] = Casa.bibliotecaPortaO;
			movimento = 1;
		}
		else if (board[linhaNova][colunaNova] == Casa.cozinhaPortaL){
			board[linhaNova][colunaNova] = Casa.cozinhaPortaO;
			movimento = 1;
		}
		else if (board[linhaNova][colunaNova] == Casa.entradaPortaL){
			board[linhaNova][colunaNova] = Casa.entradaPortaO;
			movimento = 1;
		}
		else if (board[linhaNova][colunaNova] == Casa.escritorioPortaL){
			board[linhaNova][colunaNova] = Casa.escritorioPortaO;
			movimento = 1;
		}
		else if (board[linhaNova][colunaNova] == Casa.jardimPortaL){
			board[linhaNova][colunaNova] = Casa.jardimPortaO;
			movimento = 1;
		}
		else if (board[linhaNova][colunaNova] == Casa.salaDeEstarPortaL){
			board[linhaNova][colunaNova] = Casa.salaDeEstarPortaO;
			movimento = 1;
		}
		else if (board[linhaNova][colunaNova] == Casa.salaDeJantarPortaL){
			board[linhaNova][colunaNova] = Casa.salaDeJantarPortaO;
			movimento = 1;
		}
		else if (board[linhaNova][colunaNova] == Casa.salaDeMusicaPortaL){
			board[linhaNova][colunaNova] = Casa.salaDeMusicaPortaO;
			movimento = 1;
		}
		else if (board[linhaNova][colunaNova] == Casa.salaoDeJogosPortaL){
			board[linhaNova][colunaNova] = Casa.salaoDeJogosPortaO;
			movimento = 1;
		}
		else {
			return -1;
		}
		
		if (board[linhaAtual][colunaAtual] == Casa.ocupado){
			board[linhaAtual][colunaAtual] = Casa.livre;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.bibliotecaPortaO){
			board[linhaAtual][colunaAtual] = Casa.bibliotecaPortaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.cozinhaPortaO){
			board[linhaAtual][colunaAtual] = Casa.cozinhaPortaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.entradaPortaO){
			board[linhaAtual][colunaAtual] = Casa.entradaPortaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.escritorioPortaO){
			board[linhaAtual][colunaAtual] = Casa.escritorioPortaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.jardimPortaO){
			board[linhaAtual][colunaAtual] = Casa.jardimPortaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.salaDeEstarPortaO){
			board[linhaAtual][colunaAtual] = Casa.salaDeEstarPortaL;
			System.out.println("entrei na sala de estarportaL");
		}
		else if (board[linhaAtual][colunaAtual] == Casa.salaDeJantarPortaO){
			board[linhaAtual][colunaAtual] = Casa.salaDeJantarPortaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.salaDeMusicaPortaO){
			board[linhaAtual][colunaAtual] = Casa.salaDeMusicaPortaL;
		}
		else if (board[linhaAtual][colunaAtual] == Casa.salaoDeJogosPortaO){
			board[linhaAtual][colunaAtual] = Casa.salaoDeJogosPortaL;
		}
		
		return movimento;
	}
	
	// Confere e ajusta as coordenadas para sair de um comodo
	public int[] checkIsInRoom(int linhaAtual, int colunaAtual){
		
		Casa casa = board[linhaAtual][colunaAtual];
		int linhaNova = linhaAtual;
		int colunaNova = colunaAtual;
		
		if (casa == Casa.bibliotecaO || casa == Casa.cozinhaO || casa == Casa.entradaO ||
			casa == Casa.escritorioO || casa == Casa.jardimO || casa == Casa.salaDeEstarO || 
			casa == Casa.salaDeJantarO || casa == Casa.salaDeMusicaO || casa == Casa.salaoDeJogosO){

			if (casa == Casa.entradaO){
				if (linhaAtual == 18){
					if (board[17][colunaAtual] == Casa.entradaPortaL)
						linhaNova = 17;
					else
						return new int[] {-1};
				}
				else {
					if (board[17][colunaAtual] == Casa.entradaPortaL)
						colunaNova = 15;
					else
						return new int[] {-1};
				}
				board[linhaAtual][colunaAtual] = Casa.entradaL;
			}
			
			else {
				
				if (board[linhaAtual+1][colunaAtual] != Casa.fora &&
					board[linhaAtual+1][colunaAtual] != Casa.livre &&
					board[linhaAtual+1][colunaAtual] != Casa.ocupado ){
					
					Casa novaCasa = board[linhaAtual+1][colunaAtual];
					
					if (novaCasa == Casa.bibliotecaPortaL || novaCasa == Casa.cozinhaPortaL || novaCasa == Casa.entradaPortaL ||
						novaCasa == Casa.escritorioPortaL || novaCasa == Casa.jardimPortaL || novaCasa == Casa.salaDeEstarPortaL || 
						novaCasa == Casa.salaDeJantarPortaL || novaCasa == Casa.salaDeMusicaPortaL || novaCasa == Casa.salaoDeJogosPortaL){
						linhaNova += 1;
						updateRoom(linhaAtual, colunaAtual);
					}
					else{
						return new int[] {-1};
					}
				}
				
				else if (board[linhaAtual-1][colunaAtual] != Casa.fora &&
						board[linhaAtual-1][colunaAtual] != Casa.livre &&
						board[linhaAtual-1][colunaAtual] != Casa.ocupado ){
					
					Casa novaCasa = board[linhaAtual-1][colunaAtual];
					if (novaCasa == Casa.bibliotecaPortaL || novaCasa == Casa.cozinhaPortaL || novaCasa == Casa.entradaPortaL ||
						novaCasa == Casa.escritorioPortaL || novaCasa == Casa.jardimPortaL || novaCasa == Casa.salaDeEstarPortaL || 
						novaCasa == Casa.salaDeJantarPortaL || novaCasa == Casa.salaDeMusicaPortaL || novaCasa == Casa.salaoDeJogosPortaL){
						linhaNova -= 1;
						updateRoom(linhaAtual, colunaAtual);
					}
					else{
						return new int[] {-1};
					}
				}
				
				else if (board[linhaAtual][colunaAtual+1] != Casa.fora &&
						board[linhaAtual][colunaAtual+1] != Casa.livre &&
						board[linhaAtual][colunaAtual+1] != Casa.ocupado ){
					
					Casa novaCasa = board[linhaAtual][colunaAtual+1];
					
					if (novaCasa == Casa.bibliotecaPortaL || novaCasa == Casa.cozinhaPortaL || novaCasa == Casa.entradaPortaL ||
						novaCasa == Casa.escritorioPortaL || novaCasa == Casa.jardimPortaL || novaCasa == Casa.salaDeEstarPortaL || 
						novaCasa == Casa.salaDeJantarPortaL || novaCasa == Casa.salaDeMusicaPortaL || novaCasa == Casa.salaoDeJogosPortaL){
						colunaNova += 1;
						updateRoom(linhaAtual, colunaAtual);
					}
					else{
						return new int[] {-1};
					}
				}
				
				else if (board[linhaAtual][colunaAtual-1] != Casa.fora &&
						board[linhaAtual][colunaAtual-1] != Casa.livre &&
						board[linhaAtual][colunaAtual-1] != Casa.ocupado ){
					
					Casa novaCasa = board[linhaAtual][colunaAtual-1];
					
					if (novaCasa == Casa.bibliotecaPortaL || novaCasa == Casa.cozinhaPortaL || novaCasa == Casa.entradaPortaL ||
						novaCasa == Casa.escritorioPortaL || novaCasa == Casa.jardimPortaL || novaCasa == Casa.salaDeEstarPortaL || 
						novaCasa == Casa.salaDeJantarPortaL || novaCasa == Casa.salaDeMusicaPortaL || novaCasa == Casa.salaoDeJogosPortaL){
						colunaNova -= 1;
						updateRoom(linhaAtual, colunaAtual);
					}
					else{
						return new int[] {-1};
					}
				}
			}
		}
		
		return new int[] {linhaNova, colunaNova};
	}
	
	private void updateRoom(int linhaAtual, int colunaAtual){

		Casa casa = board[linhaAtual][colunaAtual];
		
		if (casa == Casa.bibliotecaO){
			board[linhaAtual][colunaAtual] = Casa.bibliotecaL;
		}
		else if (casa == Casa.bibliotecaL){
			board[linhaAtual][colunaAtual] = Casa.bibliotecaO;
		}
		else if (casa == Casa.cozinhaO){
			board[linhaAtual][colunaAtual] = Casa.cozinhaL;
		}
		else if (casa == Casa.cozinhaL){
			board[linhaAtual][colunaAtual] = Casa.cozinhaO;
		}
		else if (casa == Casa.entradaO){
			board[linhaAtual][colunaAtual] = Casa.entradaL;
		}
		else if (casa == Casa.entradaL){
			board[linhaAtual][colunaAtual] = Casa.entradaO;
		}
		else if (casa == Casa.escritorioO){
			board[linhaAtual][colunaAtual] = Casa.escritorioL;
		}
		else if (casa == Casa.escritorioL){
			board[linhaAtual][colunaAtual] = Casa.escritorioO;
		}
		else if (casa == Casa.jardimO){
			board[linhaAtual][colunaAtual] = Casa.jardimL;
		}
		else if (casa == Casa.jardimL){
			board[linhaAtual][colunaAtual] = Casa.jardimO;
		}
		else if (casa == Casa.salaDeEstarO){
			board[linhaAtual][colunaAtual] = Casa.salaDeEstarL;
		}
		else if (casa == Casa.salaDeEstarL){
			board[linhaAtual][colunaAtual] = Casa.salaDeEstarO;
		}
		else if (casa == Casa.salaDeJantarO){
			board[linhaAtual][colunaAtual] = Casa.salaDeJantarL;
		}
		else if (casa == Casa.salaDeJantarL){
			board[linhaAtual][colunaAtual] = Casa.salaDeJantarO;
		}
		else if (casa == Casa.salaDeMusicaO){
			board[linhaAtual][colunaAtual] = Casa.salaDeMusicaL;
		}
		else if (casa == Casa.salaDeMusicaL){
			board[linhaAtual][colunaAtual] = Casa.salaDeMusicaO;
		}
		else if (casa == Casa.salaoDeJogosO){
			board[linhaAtual][colunaAtual] = Casa.salaoDeJogosL;
		}
		else if (casa == Casa.salaoDeJogosL){
			board[linhaAtual][colunaAtual] = Casa.salaoDeJogosO;
		}
	}
	
	private void updateDoor(int linhaAtual, int colunaAtual){

		Casa casa = board[linhaAtual][colunaAtual];
		
		if (casa == Casa.bibliotecaPortaO){
			board[linhaAtual][colunaAtual] = Casa.bibliotecaPortaL;
		}
		else if (casa == Casa.bibliotecaPortaL){
			board[linhaAtual][colunaAtual] = Casa.bibliotecaPortaO;
		}
		else if (casa == Casa.cozinhaPortaO){
			board[linhaAtual][colunaAtual] = Casa.cozinhaPortaL;
		}
		else if (casa == Casa.cozinhaPortaL){
			board[linhaAtual][colunaAtual] = Casa.cozinhaPortaO;
		}
		else if (casa == Casa.entradaPortaO){
			board[linhaAtual][colunaAtual] = Casa.entradaPortaL;
		}
		else if (casa == Casa.entradaPortaL){
			board[linhaAtual][colunaAtual] = Casa.entradaPortaO;
		}
		else if (casa == Casa.escritorioPortaO){
			board[linhaAtual][colunaAtual] = Casa.escritorioPortaL;
		}
		else if (casa == Casa.escritorioPortaL){
			board[linhaAtual][colunaAtual] = Casa.escritorioPortaO;
		}
		else if (casa == Casa.jardimPortaO){
			board[linhaAtual][colunaAtual] = Casa.jardimPortaL;
		}
		else if (casa == Casa.jardimPortaL){
			board[linhaAtual][colunaAtual] = Casa.jardimPortaO;
		}
		else if (casa == Casa.salaDeEstarPortaO){
			board[linhaAtual][colunaAtual] = Casa.salaDeEstarPortaL;
		}
		else if (casa == Casa.salaDeEstarPortaL){
			board[linhaAtual][colunaAtual] = Casa.salaDeEstarPortaO;
		}
		else if (casa == Casa.salaDeJantarPortaO){
			board[linhaAtual][colunaAtual] = Casa.salaDeJantarPortaL;
		}
		else if (casa == Casa.salaDeJantarPortaL){
			board[linhaAtual][colunaAtual] = Casa.salaDeJantarPortaO;
		}
		else if (casa == Casa.salaDeMusicaPortaO){
			board[linhaAtual][colunaAtual] = Casa.salaDeMusicaPortaL;
		}
		else if (casa == Casa.salaDeMusicaPortaL){
			board[linhaAtual][colunaAtual] = Casa.salaDeMusicaPortaO;
		}
		else if (casa == Casa.salaoDeJogosPortaO){
			board[linhaAtual][colunaAtual] = Casa.salaoDeJogosPortaL;
		}
		else if (casa == Casa.salaoDeJogosPortaL){
			board[linhaAtual][colunaAtual] = Casa.salaoDeJogosPortaO;
		}
	}
	
	
	
	public int[] enterRoom(int linha, int coluna){
		
		Casa casa = board[linha][coluna];
		System.out.println(casa);
		
		if (casa == Casa.bibliotecaPortaO || casa == Casa.cozinhaPortaO || casa == Casa.entradaPortaO ||
			casa == Casa.escritorioPortaO || casa == Casa.jardimPortaO || casa == Casa.salaDeEstarPortaO || 
			casa == Casa.salaDeJantarPortaO || casa == Casa.salaDeMusicaPortaO || casa == Casa.salaoDeJogosPortaO){
			
			if (casa == Casa.entradaPortaO){
				if (linha == 17){
					if (coluna == 11 && board[18][11] == Casa.entradaL ||
						coluna == 12 && board[18][12] == Casa.entradaL){
						
						updateDoor(linha,coluna);
						linha = 18;
						updateRoom(linha,coluna);
					}
				}
				else {
					if (board[20][14] == Casa.entradaL){
						updateDoor(linha,coluna);
						coluna = 14;
						updateRoom(linha,coluna);
					}
				}
			}
			
			else {
				
				if (board[linha+1][coluna] != Casa.fora &&
					board[linha+1][coluna] != Casa.livre &&
					board[linha+1][coluna] != Casa.ocupado ){
					
					casa = board[linha+1][coluna];
					if (casa == Casa.bibliotecaL || casa == Casa.cozinhaL || casa == Casa.entradaL ||
						casa == Casa.escritorioL || casa == Casa.jardimL || casa == Casa.salaDeEstarL || 
						casa == Casa.salaDeJantarL || casa == Casa.salaDeMusicaL || casa == Casa.salaoDeJogosL){
						
						updateDoor(linha,coluna);
						linha += 1;
						updateRoom(linha, coluna);
					}
				}
				
				else if (board[linha-1][coluna] != Casa.fora &&
						board[linha-1][coluna] != Casa.livre &&
						board[linha-1][coluna] != Casa.ocupado ){
					
					casa = board[linha-1][coluna];
					System.out.println(casa);
					
					if (casa == Casa.bibliotecaL || casa == Casa.cozinhaL || casa == Casa.entradaL ||
						casa == Casa.escritorioL || casa == Casa.jardimL || casa == Casa.salaDeEstarL || 
						casa == Casa.salaDeJantarL || casa == Casa.salaDeMusicaL || casa == Casa.salaoDeJogosL){
						
						updateDoor(linha,coluna);
						linha -= 1;
						updateRoom(linha, coluna);
					}
				}
				
				else if (board[linha][coluna+1] != Casa.fora &&
						board[linha][coluna+1] != Casa.livre &&
						board[linha][coluna+1] != Casa.ocupado ){
					
					casa = board[linha][coluna+1];
					if (casa == Casa.bibliotecaL || casa == Casa.cozinhaL || casa == Casa.entradaL ||
						casa == Casa.escritorioL || casa == Casa.jardimL || casa == Casa.salaDeEstarL || 
						casa == Casa.salaDeJantarL || casa == Casa.salaDeMusicaL || casa == Casa.salaoDeJogosL){
						
						updateDoor(linha,coluna);
						coluna += 1;
						updateRoom(linha, coluna);
					}
				}
				
				else if (board[linha][coluna-1] != Casa.fora &&
						board[linha][coluna-1] != Casa.livre &&
						board[linha][coluna-1] != Casa.ocupado ){
					
					casa = board[linha][coluna-1];
					if (casa == Casa.bibliotecaL || casa == Casa.cozinhaL || casa == Casa.entradaL ||
						casa == Casa.escritorioL || casa == Casa.jardimL || casa == Casa.salaDeEstarL || 
						casa == Casa.salaDeJantarL || casa == Casa.salaDeMusicaL || casa == Casa.salaoDeJogosL){
						
						updateDoor(linha,coluna);
						coluna -= 1;
						updateRoom(linha, coluna);
					}
				}
			}
		}
	
		return new int[] {linha, coluna};
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
		board[7][4] = Casa.cozinhaPortaL;
		board[6][4] = Casa.cozinhaL;
		
		// entradas sala de musica
		board[5][7] = Casa.salaDeMusicaPortaL;
		board[5][8] = Casa.salaDeMusicaL;
		board[8][9] = Casa.salaDeMusicaPortaL;
		board[7][9] = Casa.salaDeMusicaL;
		board[8][14] = Casa.salaDeMusicaPortaL;
		board[7][14] = Casa.salaDeMusicaL;
		board[5][16] = Casa.salaDeMusicaPortaL;
		board[5][15] = Casa.salaDeMusicaL;
		
		// entradas jardim de inverno
		board[5][18] = Casa.jardimPortaL;
		board[5][19] = Casa.jardimL;
		
		// entradas sala de jantar
		board[12][8] = Casa.salaDeJantarPortaL;
		board[12][7] = Casa.salaDeJantarL;
		board[16][6] = Casa.salaDeJantarPortaL;
		board[15][6] = Casa.salaDeJantarL;
		
		// entradas salão de jogos
		board[9][17] = Casa.salaoDeJogosPortaL;
		board[9][18] = Casa.salaoDeJogosL;
		board[13][22] = Casa.salaoDeJogosPortaL;
		board[12][22] = Casa.salaoDeJogosL;
		
		// entradas biblioteca
		board[13][20] = Casa.bibliotecaPortaL;
		board[14][20] = Casa.bibliotecaL;
		board[16][16] = Casa.bibliotecaPortaL;
		board[16][17] = Casa.bibliotecaL;
		
		// entradas sala de Estar
		board[18][6] = Casa.salaDeEstarPortaL;
		board[19][6] = Casa.salaDeEstarL;
		
		// entradas entrada
		board[17][11] = Casa.entradaPortaL;
		board[18][11] = Casa.entradaL;
		board[17][12] = Casa.entradaPortaL;
		board[18][12] = Casa.entradaL;
		board[20][15] = Casa.entradaPortaL;
		board[20][14] = Casa.entradaL;
		
		// entradas escritório
		board[20][17] = Casa.escritorioPortaL;
		board[21][17] = Casa.escritorioL;
	}
}











