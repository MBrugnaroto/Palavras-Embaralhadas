import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import BancoDeDados.BancoDePalavras;

class TesteBancoDePalavras {

	@Test
	void leituraArquivo() throws IOException {
		BancoDePalavras c = new BancoDePalavras();
		
		System.out.println(c.getPalavra());
		System.out.println(c.getPalavra());
		System.out.println(c.getPalavra());
	}

}
