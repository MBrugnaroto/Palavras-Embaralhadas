package BancoDeDados;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BancoDePalavras {
	private BufferedReader leituraString;
	private List<String> listaPalavras;
	private List<Integer> posicao;
	private String palavra;
	private int nPosicao = 0;
	
	public BancoDePalavras () throws IOException{
		try {
			InputStream leituraByte = new FileInputStream("../Banco de Palavras/BancoDePalavras.txt");
			InputStreamReader leituraCaracter = new InputStreamReader(leituraByte);
			leituraString = new BufferedReader(leituraCaracter);
		
		}catch(FileNotFoundException e) {
			System.out.println("Arquivo contendo o Banco de Palavras não foi encontrado!");
		}
		listaPalavras = new ArrayList<>();
		posicao = new ArrayList<>();
		palavra = leituraString.readLine();
		int i = 0;
		
		while (palavra != null) {
			listaPalavras.add(palavra);
			posicao.add(i);
			i++;
			palavra = leituraString.readLine();
		}
		Collections.shuffle(posicao);
		leituraString.close();
	}
	
	public String getPalavra() throws IOException {
		palavra = listaPalavras.get(posicao.get(nPosicao));
		nPosicao++;
		return palavra.toUpperCase();
	}
}
