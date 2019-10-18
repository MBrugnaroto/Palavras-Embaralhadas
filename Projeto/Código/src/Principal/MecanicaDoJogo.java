package Principal;

import java.io.IOException;

public interface MecanicaDoJogo {
	
	final int pontuacao = 5;
	final int nTentativas = 3;
	final int nPalavras = 5;
	
	public Boolean comparaPalavra(String palavraUsuario);
	public String embaralhaPalavra() throws IOException;
	public int totalizaPontos();
	public Boolean finalJogo() throws IOException;
	public String getPalavra();
	public int getTentativas();

}
