import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import BancoDeDados.BancoDePalavras;

class TesteBancoDePalavras {

	@Test
	void leituraArquivo() throws IOException {
		BancoDePalavras c = new BancoDePalavras();
		
		assertEquals(c.getPalavra(), "Mateus");
		assertEquals(c.getPalavra(), "Gremio");
		assertEquals(c.getPalavra(), "Mais");
	}

}
