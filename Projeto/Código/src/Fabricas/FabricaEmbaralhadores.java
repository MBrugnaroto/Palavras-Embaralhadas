package Fabricas;

import java.util.Random;

import EmbaralharPalavras.EmbaralharCollectionsShuffle;
import EmbaralharPalavras.EmbaralharPosicaoImparPorPar;
import Principal.Embaralhador;

public class FabricaEmbaralhadores {
	EmbaralharPosicaoImparPorPar e1;
	EmbaralharCollectionsShuffle e2;
	
	public FabricaEmbaralhadores () {
		e1 = new EmbaralharPosicaoImparPorPar();
		e2 = new EmbaralharCollectionsShuffle();
	}
	
	public Embaralhador modeloEmbaralhador () {
		 Random rand = new Random();
		 int modelo = rand.nextInt(2);
		 
		 if (modelo == 0) {
			 return e1;
		 }
		 else
			 return e2;
	}
}
