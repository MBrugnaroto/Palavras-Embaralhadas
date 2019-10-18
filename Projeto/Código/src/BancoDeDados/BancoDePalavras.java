package BancoDeDados;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BancoDePalavras {
	private BufferedReader leituraString;
	private String palavra;
	
	public BancoDePalavras () throws IOException{
		try {
			InputStream leituraByte = new FileInputStream("../Banco de Palavras/BancoDePalavras.txt");
			InputStreamReader leituraCaracter = new InputStreamReader(leituraByte);
			leituraString = new BufferedReader(leituraCaracter);
		
		}catch(FileNotFoundException e) {
			System.out.println("Arquivo contendo o Banco de Palavras não foi encontrado!");
		}
	}
	
	public String getPalavra() throws IOException {
		palavra = leituraString.readLine();
		
		if (palavra == null) {
			leituraString.close();
			return null;
		}
		return palavra;
	}
	
	public void fecharBanco () throws IOException {
		leituraString.close();
	}
}
