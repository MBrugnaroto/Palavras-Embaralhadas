package src.mockObject;

import java.util.ArrayList;
import java.util.List;

public class MockArmazenamento {
	private List<String> nomesDosUsuarios = new ArrayList<>();
	private List<String> pontuacoes = new ArrayList<>();
	private List<String> tiposDePontuacoes = new ArrayList<>();
	
	public void armazenaPontuacao(String nome, String pontuacao, String tipoPontuacao) {
		nomesDosUsuarios.add(nome);
		pontuacoes.add(pontuacao);
		tiposDePontuacoes.add(tipoPontuacao);
	}

	public Integer retornarPontuacaoDeUmTipo(String nome, String tipoPontuacao) {
		int pontuacaoTotal = 0;
		
		for (int i = 0; i < nomesDosUsuarios.size(); i++) {
			if (nomesDosUsuarios.get(i).equalsIgnoreCase(nome)) {
				if (tipoPontuacao.equalsIgnoreCase(tiposDePontuacoes.get(i))) {
					pontuacaoTotal += Integer.parseInt(pontuacoes.get(i));
				}
			}
		}
		return pontuacaoTotal;
	}

	public List<String> recuperaTodosOsPontuadores() {
		return nomesDosUsuarios;
	}

	public List<String> recuperaTiposDePontosDoUsuario(String nome) {
		List<String> tiposDePontuacaoDoUsuario = new ArrayList<>();
		
		for (int i = 0; i < nomesDosUsuarios.size(); i++) {
			if (nomesDosUsuarios.get(i).equalsIgnoreCase(nome)) { 
				tiposDePontuacaoDoUsuario.add(tiposDePontuacoes.get(i));
			}}
		
		return tiposDePontuacaoDoUsuario;
	}

}
