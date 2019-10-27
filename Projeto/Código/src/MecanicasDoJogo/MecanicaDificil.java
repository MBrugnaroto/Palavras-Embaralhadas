package MecanicasDoJogo;

import java.io.IOException;

import BancoDeDados.BancoDePalavras;
import Fabricas.FabricaEmbaralhadores;
import Principal.Embaralhador;
import Principal.MecanicaDoJogo;

public class MecanicaDificil implements MecanicaDoJogo{
	private Embaralhador embaralhar;
	private FabricaEmbaralhadores fabricaDeEmbaralhar;
	private BancoDePalavras BD;
	private String palavraBanco;
	private int palavra;
	private int totalPontos;
	private String palavraEmbaralhada;
	private int tentativa;
	private boolean trocouPalavra;
	
	public MecanicaDificil () throws IOException {
		fabricaDeEmbaralhar = new FabricaEmbaralhadores();
		embaralhar = fabricaDeEmbaralhar.modeloEmbaralhador();
		BD = new BancoDePalavras();
		palavraBanco = BD.getPalavra();
		palavra = 1;
		totalPontos = 0;
		tentativa = 0;
		trocouPalavra = false;
	}
	
	@Override
	public Boolean comparaPalavra(String palavraUsuario) {
		if (palavraBanco != null) {
			if (palavraUsuario.equalsIgnoreCase(palavraBanco)) {
				this.pontuação();
				trocouPalavra = true;

				return true;
			}
			else {
				if (!trocouPalavra) {
					tentativa++;
					return false;
				}
				else {
					tentativa = 1;
					trocouPalavra = false;
					return false;
				}
			}
		}
		else {
			System.out.println("Parabéns, você acabou com as palavras o jogo");
			return null;
		}
	}

	@Override
	public String embaralhaPalavra() throws IOException {
		if (tentativa < nTentativas && !trocouPalavra) {
			return embaralhar.embaralharPalavra(palavraBanco);
		}
		if (palavraBanco != null) {
			palavraBanco = BD.getPalavra();
			palavraEmbaralhada = embaralhar.embaralharPalavra(palavraBanco);
			trocouPalavra = true;
			palavra++;
			
			return palavraEmbaralhada;
		}
		else
			return null;
	}

	@Override
	public Boolean finalJogo() throws IOException {
		if ((palavra == nPalavras && trocouPalavra) || (palavra == nPalavras && tentativa == nTentativas)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public int totalizaPontos() {
		return totalPontos;
	}

	@Override
	public String getPalavra() {
		if (palavraBanco != null) {
			return palavraBanco;
		}
		return "";
	}

	@Override
	public int getTentativas() {
		return tentativa;
	}
	
	public void pontuação() {
		totalPontos += pontuacao*(nTentativas-tentativa)*2;
	}
}
