package EmbaralharPalavras;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Principal.Embaralhador;

public class EmbaralharCollectionsShuffle implements Embaralhador{
	
	@Override	
	public String embaralharPalavra(String palavra) {
		List<String> letters = Arrays.asList(palavra.split(""));
		Collections.shuffle(letters);
		StringBuilder returnPalavra = new StringBuilder(palavra.length());
		
		for (String k : letters) {
			returnPalavra.append(k);
		}
		
		return returnPalavra.toString();
	}

}
