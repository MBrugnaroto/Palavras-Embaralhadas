package tdd.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import src.mockObject.MockArmazenamento;

class testeMockArmazenamento {
	
	//Requisito 1:
	@Test
	public void armazenaUsuarioTipoEPontuacao() {
		MockArmazenamento p1 = new MockArmazenamento();
		p1.armazenaPontuacao("Mateus", "10", "Ouro");
	}
	//Requisito 2:
	@Test
	public void recuperaPontosDeUmTipoDeUmUsuario() {
		MockArmazenamento p1 = new MockArmazenamento();
		p1.armazenaPontuacao("Mateus", "10", "Ouro");
		int pontuacao = p1.retornarPontuacaoDeUmTipo("Mateus", "Ouro");
		assertEquals(pontuacao, 10);
	}
	@Test
	public void recuperaPontosDeUmTipoDeUmUsuarioQuePontuouVariasVezes() {
		MockArmazenamento p1 = new MockArmazenamento();
		p1.armazenaPontuacao("Mateus", "10", "Ouro");
		p1.armazenaPontuacao("Pedro", "5", "Ouro");
		p1.armazenaPontuacao("Mateus", "15", "Ouro");
		p1.armazenaPontuacao("Mateus", "15", "Prata");
		p1.armazenaPontuacao("Lucas", "30", "Ouro");
		int pontuacao = p1.retornarPontuacaoDeUmTipo("Mateus", "Ouro");
		assertEquals(pontuacao, 25);
	}
	
	//Requisito 3:
	@Test
	public void recuperaUsuarioQuePontuou() {
		List<String> nomesDosUsuarios = new ArrayList<>();
		MockArmazenamento p1 = new MockArmazenamento();
		p1.armazenaPontuacao("Mateus", "10", "Ouro");
		nomesDosUsuarios = p1.recuperaTodosOsPontuadores();
		assertEquals(nomesDosUsuarios.get(0), "Mateus");
	}
	@Test
	public void recuperaMaisDeUmUsuarioQuePontuou() {
		List<String> nomesDosUsuarios = new ArrayList<>();
		MockArmazenamento p1 = new MockArmazenamento();
		p1.armazenaPontuacao("Mateus", "10", "Ouro");
		p1.armazenaPontuacao("Lucas", "10", "Prata");
		nomesDosUsuarios = p1.recuperaTodosOsPontuadores();
		assertEquals(nomesDosUsuarios.get(0), "Mateus");
		assertEquals(nomesDosUsuarios.get(1), "Lucas");
	}
	
	//Requisito 4:
	@Test
	public void recuperaTodosOsTiposDePontosDeUmUsuario() {
		List<String> tiposDePontuacao = new ArrayList<>();
		
		MockArmazenamento p1 = new MockArmazenamento();
		p1.armazenaPontuacao("Mateus", "10", "Ouro");
		tiposDePontuacao = p1.recuperaTiposDePontosDoUsuario("Mateus");
		assertEquals(tiposDePontuacao.get(0), "Ouro");
	}
	@Test
	public void recuperMaisDeUmTipoDePontoDeUmUsuario() {
		List<String> tiposDePontuacao = new ArrayList<>();
		MockArmazenamento p1 = new MockArmazenamento();
		p1.armazenaPontuacao("Mateus", "10", "Ouro");
		p1.armazenaPontuacao("Mateus", "5", "Prata");
		tiposDePontuacao = p1.recuperaTiposDePontosDoUsuario("Mateus");
		assertEquals(tiposDePontuacao.get(0), "Ouro");
		assertEquals(tiposDePontuacao.get(1), "Prata");
	}
}
