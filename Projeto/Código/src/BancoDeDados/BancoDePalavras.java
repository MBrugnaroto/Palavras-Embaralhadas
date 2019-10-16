package BancoDeDados;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BancoDePalavras {
	private BufferedReader leituraString;
	private String palavra;
	
	public BancoDePalavras () throws IOException{
		InputStream leituraByte = new FileInputStream("../Banco de Palavras/BancoDePalavras.txt");
		InputStreamReader leituraCaracter = new InputStreamReader(leituraByte);
		leituraString = new BufferedReader(leituraCaracter);
	}
	
	public String getPalavra() throws IOException {
		palavra = leituraString.readLine();
		
		if (palavra == null) {
			leituraString.close();
			return null;
		}
		return palavra;
	}
}
