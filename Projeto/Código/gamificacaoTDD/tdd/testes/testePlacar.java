package tdd.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.principal.Placar;

class testePlacar {
	
	///Requisito 1:
	@Test
	public void registraUmTipoDePontoParaUmUsuario() throws IOException {
		Placar placar = new Placar();
		placar.registraPontoParaOUsuario("Mateus", "10", "Estrela");
	}
	
	//Requisito 2:
	@Test
	public void retornaApenasUmPontoDeUmUsuário() throws IOException {
		List<String> pontosDoUsuario = new ArrayList<>();
		Placar placar = new Placar();
		placar.registraPontoParaOUsuario("Mateus", "10", "Estrela");
		pontosDoUsuario = placar.retornaPontosDoUsuario("Mateus");
		assertEquals(pontosDoUsuario.get(0), "Estrela: 10 pontos");
	}*/
	@Test
	public void retornaMaisDeUmPontoDeUmUsuário() throws IOException {
		List<String> pontosDoUsuario = new ArrayList<>();
		Placar placar = new Placar();
		placar.registraPontoParaOUsuario("Mateus", "10", "Estrela");
		placar.registraPontoParaOUsuario("Mateus", "10", "Ouro");
		placar.registraPontoParaOUsuario("Mateus", "10", "Prata");
		pontosDoUsuario = placar.retornaPontosDoUsuario("Mateus");
		assertEquals(pontosDoUsuario.get(0), "Estrela: 10 pontos");
		assertEquals(pontosDoUsuario.get(1), "Ouro: 10 pontos");
		assertEquals(pontosDoUsuario.get(2), "Prata: 10 pontos");
	}
	
	//Requisito 3:
	@Test
	public void retornaRankingDeUmTipoDePonto() throws IOException {
		Map<String, Integer> ranking = new HashMap<>();
		Placar placar = new Placar();
		placar.registraPontoParaOUsuario("Mateus", "10", "Estrela");
		placar.registraPontoParaOUsuario("Pedro", "10", "Prata");
		placar.registraPontoParaOUsuario("Lucas", "5", "Estrela");
		placar.registraPontoParaOUsuario("Lucas", "5", "Estrela");
		placar.registraPontoParaOUsuario("Pedro", "10", "Ouro");
		placar.registraPontoParaOUsuario("Mateus", "10", "Estrela");
		placar.registraPontoParaOUsuario("Pedro", "5", "Estrela");
		
		ranking.put("Mateus", 20);
		ranking.put("Lucas", 10);
		ranking.put("Pedro", 5);
		assertEquals(placar.rankingDoTipoDePonto("Estrela"), ranking);
	}

}
