import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Fabricas.FabricaEmbaralhadores;
import Principal.Embaralhador;
class TesteFabricaEmabaralhadores {

	@Test
	void modeloEmbaralhador() {
		FabricaEmbaralhadores feb = new FabricaEmbaralhadores();
		String t = feb.modeloEmbaralhador().embaralharPalavra("teucu");
		
		System.out.println(t);
	}

}
