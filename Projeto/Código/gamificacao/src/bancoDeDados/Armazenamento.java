package src.bancoDeDados;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Armazenamento extends TratamentoDeArquivo {
	
	public Armazenamento() throws IOException {
		inicializandoBancoDeDados();
	}
	
	//Funções Básicas
	public void armazenaPontuacao(String nome, String pontuacao, String tipoDePonto) throws IOException {	
		BufferedWriter arquivoEscrita = abrindoArquivo();
		arquivoEscrita.write(nome+"|"+pontuacao+"|"+tipoDePonto+"\n");
		arquivoEscrita.close();
	}
	
	public int retornarPontuacaoDeUmTipo(String nome, String tipoPontuacao) throws IOException {	
		List<String[]> dadosDoArquivo = lendoOArquivo();
		int pontuacaoTotal = 0;
		for (int i = 0; i < dadosDoArquivo.size(); i++) {
			if (dadosDoArquivo.get(i)[0].equalsIgnoreCase(nome)) {
				if (dadosDoArquivo.get(i)[2].equalsIgnoreCase(tipoPontuacao)) {
					pontuacaoTotal += Integer.parseInt(dadosDoArquivo.get(i)[1]);
		}}}
		return pontuacaoTotal;
	}
	
	public List<String> recuperaTodosOsPontuadores() throws IOException {
		List<String[]> dadosDoArquivo = lendoOArquivo();
		List<String> nomesDosUsuarios = new ArrayList<>();
		
		for (int i = 0; i < dadosDoArquivo.size(); i++) {
			nomesDosUsuarios.add(dadosDoArquivo.get(i)[0]);
		}
		return nomesDosUsuarios;
	}
	
	public List<String> recuperaTiposDePontosDoUsuario(String nome) throws IOException {
		List<String[]> dadosDoArquivo = lendoOArquivo();
		List<String> tiposDePontuacaoDoUsuario = new ArrayList<>();
		
		for (int i = 0; i < dadosDoArquivo.size(); i++) {
			if (dadosDoArquivo.get(i)[0].equalsIgnoreCase(nome)) { 
				tiposDePontuacaoDoUsuario.add(dadosDoArquivo.get(i)[2]);
		}}
		return tiposDePontuacaoDoUsuario;
	}
}
