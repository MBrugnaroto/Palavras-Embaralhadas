import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import EmbaralharPalavras.EmbaralharCollectionsShuffle;
import EmbaralharPalavras.EmbaralharPosicaoImparPorPar;

class TesteEmbaralhador {

	@Test
	void testCollectionsShuffle() {
		EmbaralharCollectionsShuffle c = new EmbaralharCollectionsShuffle();
		assertNotEquals(c.embaralharPalavra("Embaralhar"), "Embaralhar");
	}
	
	@Test
	void testPosicaoImparPorPar() {
		EmbaralharPosicaoImparPorPar d = new EmbaralharPosicaoImparPorPar();
		assertEquals(d.embaralharPalavra("Embaralhar"), "mEabarhlra");
	}

}
