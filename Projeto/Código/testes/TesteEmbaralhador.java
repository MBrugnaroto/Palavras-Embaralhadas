import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import EmbaralharPalavras.EmbaralharCollectionsShuffle;
import EmbaralharPalavras.EmbaralharPosicaoImparPorPar;

class TesteEmbaralhador {

	@Test
	void testCollectionsShuffle() {
		EmbaralharCollectionsShuffle c = new EmbaralharCollectionsShuffle();
		System.out.println(c.embaralharPalavra("tomanocu"));
	}
	
	@Test
	void testPosicaoImparPorPar() {
		EmbaralharPosicaoImparPorPar d = new EmbaralharPosicaoImparPorPar();
		System.out.println(d.embaralharPalavra("tomanocu"));
	}

}
