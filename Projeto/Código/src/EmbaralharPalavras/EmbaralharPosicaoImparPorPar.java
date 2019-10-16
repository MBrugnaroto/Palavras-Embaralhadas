package EmbaralharPalavras;

import java.util.Arrays;
import java.util.List;

import Principal.Embaralhador;

public class EmbaralharPosicaoImparPorPar implements Embaralhador{
	
	@Override
	public String embaralharPalavra(String palavra) {
		List<String> letters = Arrays.asList(palavra.split(""));
		StringBuilder returnPalavra = new StringBuilder(palavra.length());
		int t = palavra.length();
		String ant = null;
		
		for (int i = 0; i < t; i++) {
			if (i%2 != 0) {
				returnPalavra.append(ant);
			}
			else
				if (i+1 == t) {
					returnPalavra.append(letters.get(i));
				}
				else {
					if (letters.get(i+1) != null) {
					ant = letters.get(i);
					returnPalavra.append(letters.get(i+1));
					}
				}
		}
		return returnPalavra.toString();
	}

}
