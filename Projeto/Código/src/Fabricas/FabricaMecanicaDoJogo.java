package Fabricas;

import java.io.IOException;

import BancoDeDados.BancoDePalavras;
import MecanicasDoJogo.Acertou;
import MecanicasDoJogo.Errou;
import MecanicasDoJogo.TerminaJogo;
import MecanicasDoJogo.PalavraEmbaralhada;
import Principal.MecanicaDoJogo;

public class FabricaMecanicaDoJogo {
	private PalavraEmbaralhada palavraEmbaralhada;
	private Acertou acertou;
	private Errou errou;
	private TerminaJogo exit;
	private FabricaEmbaralhadores feb;
	private String palavra;
	private int quantidadePalavras;
	private int tentativas;
	private BancoDePalavras BD;
	
	public FabricaMecanicaDoJogo () throws IOException {
		feb = new FabricaEmbaralhadores();
		acertou = new Acertou();
		errou = new Errou();
		exit = new TerminaJogo();
		BD = new BancoDePalavras();
		palavraEmbaralhada = new PalavraEmbaralhada();
		
		quantidadePalavras = 0;
		tentativas = 1;
	} 
	
	public MecanicaDoJogo mecanica (String palavraUsuario) throws IOException {
		if (quantidadePalavras == 2) {
			return exit;
		}
		else {
			if (palavraUsuario.equals("go") && quantidadePalavras == 0) {
				tentativas = 1;
				quantidadePalavras++;
				palavra = BD.getPalavra();
				System.out.println(feb.modeloEmbaralhador().embaralharPalavra(palavra));
				return palavraEmbaralhada;
			}
			else 
				if (palavraUsuario.equals("PASSAR") || tentativas == 4) {
					tentativas = 1;
					palavra = BD.getPalavra();
					System.out.println(feb.modeloEmbaralhador().embaralharPalavra(palavra));
					return palavraEmbaralhada;
				}
				else {
					if (palavra.equalsIgnoreCase(palavraUsuario)) {
						quantidadePalavras++;
						tentativas = 1;
						palavra = BD.getPalavra();
						System.out.println(feb.modeloEmbaralhador().embaralharPalavra(palavra));
						return acertou;
				}
					else {
						if (!palavra.equals(palavraUsuario)) {
							tentativas++;
							return errou;
					}
				}
			}
		}
		return palavraEmbaralhada;
	}
}
