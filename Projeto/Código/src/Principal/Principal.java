package Principal;

import java.io.IOException;
import java.util.Scanner;

import Fabricas.FabricaMecanicaDoJogo;

public class Principal {
	
	private static Scanner scanner = new Scanner(System.in);
	private static FabricaMecanicaDoJogo FM;
	private static MecanicaDoJogo MDJ;
	private static Boolean game;
	private static String menu;
	private static String palpiteUsuario;
	private static String proximoPasso;
	private static boolean desenvolvimento;
	
	public static void main(String[] args) throws IOException {
		
		desenvolvimento = true;
		System.out.println("\nBEM VINDO AO JOGO: PALAVRAS EMBARALHADAS");
		
		while (desenvolvimento) {
			
			FM = new FabricaMecanicaDoJogo();
			game = true;
			
			System.out.println("\nMenu");
			System.out.println("1 - Como jogar");
			System.out.println("2 - Modo Fácil");
		    System.out.println("3 - Modo Difícil");
		    System.out.println("4 - Recuperar última pontuação");
			System.out.println("5 - Sair");
		
			menu = scanner.nextLine();
			
			if (menu.equals("1")){
				System.out.println("COMO JOGAR:");
				System.out.println("- No menu principal selecione uma dos dois modos de jogo: fácil ou dificil.\n"
									+ "A partir desse ponto, será apresentado no display uma palavra embaralhada\n"
									+ "e um campo onde você poderá inserir a palavra que voce deduziu ser.\n"
									+ "Para voltar para o menu principal ou fazer algum outro acesso, siga as\n"
									+ "instruções disponiveis no display. Caso queira sair no meio de uma partida,\n"
									+ "digite EXIT com todas as letras em maiúsculo\n");
				
				System.out.println("INFORMAÇÔES SOBRE O JOGO:");
				System.out.println("- Tanto o modo fácil quanto o modo difícil, você terá apenas 3 chances de\n"
				+ "acertar a palavra e um total de 5 palavras embaralhadas. Boa sorte!!\n");
				
				System.out.println("MODO FÁCIL:");
				System.out.println("- A palavra sofre um embaralhamento e dentro das 3 tentativas você a verá\n"
									+ "do mesmo modo, ou seja, no mesmo formado da primeira tentativa.\n");
				System.out.println("Pontuação:");
				System.out.println("Acerto na primeira tentativa: 15 pontos\n"
								+  "Acerto na segunda tentativa : 10 pontos\n"
								+  "Acerto na terceira tentativa: 5  pontos\n"
								+  "Errou a palavra             : 0  pontos\n");
				System.out.println("MODO Difícil:");
				System.out.println("- A palavras sofre um embaralhamento e dentro das 3 tentativas você a verá\n"
									+ "em formatos diferentes, ou seja, a palavra será mostra em formatos diferentes.\n");
				System.out.println("Pontuação:");
				System.out.println("Acerto na primeira tentativa: 30 pontos\n"
								 + "Acerto na segunda tentativa : 20 pontos\n"
							   	 + "Acerto na terceira tentativa: 10 pontos\n"
							 	 + "Errou a palavra             : 0  pontos\n");
				System.out.println("Precione ENTER para voltar ao menu principal.");
				proximoPasso = scanner.nextLine();
			}
			else {
				if(menu.equals("2") || menu.equals("3")) {
					if (menu.equals("2")) {
						MDJ = FM.mecanica(1);
					}
					else {
						if (menu.equals("3")) {
							MDJ = FM.mecanica(2);
						}
					}
					
					while (game) {
						
						System.out.println("Palavra Embaralhada: " + MDJ.embaralhaPalavra());
						System.out.println("Insira seu palpite: ");
						palpiteUsuario = scanner.nextLine();
						
						if (palpiteUsuario.equals("EXIT")) {
							game = false;
						}
						else {
							if (MDJ.comparaPalavra(palpiteUsuario)) {
								System.out.println("VOCÊ ACERTOU!!!\n");
							}
							else {
								int i = MDJ.getTentativas();
								System.out.println("VOCÊ ERROU!!!");
								
								if (i == 3) {
									System.out.println("A palavra era " + MDJ.getPalavra() + "\n");
								}
								else
									System.out.println("\nTem mais " + (3-i) + " tentativas");
							}
							
							if (MDJ.finalJogo()) {
								game = false;
								System.out.println("\nO jogo terminou");
							}
						}
					}
					System.out.println("\nPróximo Passo");
					System.out.println("1 - Voltar ao menu anterior");
				    System.out.println("2 - Ver Pontuação");
					System.out.println("3 - Sair");
					proximoPasso = scanner.nextLine();
					
					if (proximoPasso.equals("1")) {
						desenvolvimento = true;
					}
					else {
						if (proximoPasso.equals("2")) {
						 System.out.println("Pontuação final: " + MDJ.totalizaPontos());
						 System.out.println("Precione ENTER para voltar ao menu principal.");
						 proximoPasso = scanner.nextLine();
						}
						
						else {
							if (proximoPasso.equals("3")) {
							desenvolvimento = false;
							System.out.println("------- Bye Bye --------");
							}
						}
					}
				}
			else {
				if(menu.equals("4")) {
					try {
					 System.out.println("Pontuação final: " + MDJ.totalizaPontos());
					 System.out.println("Precione ENTER para voltar ao menu principal.");
					 proximoPasso = scanner.nextLine();
					 
					 
					} catch (Exception e){
						 System.out.println("Nenhuma partida registrada ainda");
						 System.out.println("Precione ENTER para voltar ao menu principal.");
						 proximoPasso = scanner.nextLine();
					}
				}
				
				else {
					if(menu.equals("5")) {
						desenvolvimento = false;
						System.out.println("------- Bye Bye --------");
					}
			
					else {
						System.out.println("Entrada Inválida");
						}
					}
				}
			}
		}
	}
}
