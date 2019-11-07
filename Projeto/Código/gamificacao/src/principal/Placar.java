package src.principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import src.bancoDeDados.Armazenamento;

public class Placar {
	Armazenamento armazenamento;
	
	public Placar() throws IOException {
		armazenamento = new Armazenamento();
	}
	
	//Funções Básicas
	public void registraPontoParaOUsuario(String nome, String pontos, String tipoDePonto) throws IOException {
		armazenamento.armazenaPontuacao(nome, pontos, tipoDePonto);
	}

	public List<String> retornaPontosDoUsuario(String nomeDoJogador) throws IOException {
		List<String> pontosDoUsuario = new ArrayList<>();
		calculandoPontuacaoDeCadaTipoDePonto(nomeDoJogador, pontosDoUsuario);
		
		return pontosDoUsuario;
	}
	
	public Map<String, Integer> rankingDoTipoDePonto(String tipoDePonto) throws IOException {
		Map<String, Integer> ranking = new HashMap<>();
		
		listandoJogadoresComOTipoDePontuacao(tipoDePonto, ranking);
		ordenandoRanking(ranking);
		
		return ranking;
	}
	
	//Funções extras
	private void listandoJogadoresComOTipoDePontuacao(String tipoDePonto, Map<String, Integer> ranking) throws IOException {
		List<String> nomesDosPontuadores = new ArrayList<>();
		
		nomesDosPontuadores = armazenamento.recuperaTodosOsPontuadores();
		for (String nomeDoJogador : nomesDosPontuadores) {
			ranking.put(nomeDoJogador, armazenamento.retornarPontuacaoDeUmTipo(nomeDoJogador, tipoDePonto));
		}
	}

	private void ordenandoRanking(Map<String, Integer> ranking) {
		ranking = ranking.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
	private void calculandoPontuacaoDeCadaTipoDePonto(String nomeDoJogador, List<String> pontosDoUsuario) throws IOException {
		List<String> tiposDePontoDoUsuario = new ArrayList<>();
		
		tiposDePontoDoUsuario = armazenamento.recuperaTiposDePontosDoUsuario(nomeDoJogador);
		for (String tipoPontuacao : tiposDePontoDoUsuario) {
			pontosDoUsuario.add(tipoPontuacao+":"+ " "+armazenamento.retornarPontuacaoDeUmTipo(nomeDoJogador, tipoPontuacao)+" pontos");
		}	
	}

}
