package src.bancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

abstract class TratamentoDeArquivo {
	protected void inicializandoBancoDeDados() throws IOException {
		FileWriter arquivo = new FileWriter("Banco de Registros/armazenamento.txt");
		BufferedWriter arquivoEscrita = new BufferedWriter(arquivo);
		arquivoEscrita.write("Nome|Pontuação|Tipo dos Pontos\n");
		arquivoEscrita.close();
	}
	
	protected BufferedWriter abrindoArquivo() throws IOException {
		FileWriter arquivo = new FileWriter("Banco de Registros/armazenamento.txt", true);
		BufferedWriter arquivoEscrita = new BufferedWriter(arquivo);
		return arquivoEscrita;
		
	}
	
	protected List<String[]> lendoOArquivo() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("Banco de Registros/armazenamento.txt"));
		List<String[]> dadosDoArquivo = new ArrayList<>();
		String[] dado;

		br.readLine();
		while(br.ready()){
			dado = br.readLine().split(Pattern.quote("|"));
			dadosDoArquivo.add(dado);
		}
		br.close();
		return dadosDoArquivo;
	}
}
