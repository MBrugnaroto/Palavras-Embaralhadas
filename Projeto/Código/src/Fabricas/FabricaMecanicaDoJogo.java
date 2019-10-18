package Fabricas;

import java.io.IOException;

import MecanicasDoJogo.MecanicaDificil;
import MecanicasDoJogo.MecanicaSimples;
import Principal.MecanicaDoJogo;

public class FabricaMecanicaDoJogo {
	private MecanicaSimples m1;
	private MecanicaDificil m2;
	
	public FabricaMecanicaDoJogo () throws IOException {
		m1 = new MecanicaSimples();
		m2 = new MecanicaDificil();
	} 
	
	public MecanicaDoJogo mecanica (int mecanicaEscolhida) {
		if (mecanicaEscolhida == 1) {
			return m1;
		}
		if (mecanicaEscolhida == 2) {
			return m2;
		}
		return m1;
		
	}
}
