package tdd.testes;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import src.bancoDeDados.Armazenamento;

class testeArmazenamento {

	//Requisito 1:
		@Test
		public void armazenaUsuarioTipoEPontuacao() throws IOException {
			Armazenamento p1 = new Armazenamento();
			p1.armazenaPontuacao("Mateus", "10", "Ouro");
		}
		//Requisito 2:
		@Test
		public void recuperaPontosDeUmTipoDeUmUsuario() throws IOException {
			Armazenamento p1 = new Armazenamento();
			p1.armazenaPontuacao("Mateus", "10", "Ouro");
			int pontuacao = p1.retornarPontuacaoDeUmTipo("Mateus", "Ouro");
			assertEquals(pontuacao, 10);
		}
		@Test
		public void recuperaPontosDeUmTipoDeUmUsuarioQuePontuouVariasVezes() throws IOException {
			Armazenamento p1 = new Armazenamento();
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
		public void recuperaUsuarioQuePontuou() throws IOException {
			List<String> nomesDosUsuarios = new ArrayList<>();
			Armazenamento p1 = new Armazenamento();
			p1.armazenaPontuacao("Mateus", "10", "Ouro");
			nomesDosUsuarios = p1.recuperaTodosOsPontuadores();
			assertEquals(nomesDosUsuarios.get(0), "Mateus");
		}
		@Test
		public void recuperaMaisDeUmUsuarioQuePontuou() throws IOException {
			List<String> nomesDosUsuarios = new ArrayList<>();
			Armazenamento p1 = new Armazenamento();
			p1.armazenaPontuacao("Mateus", "10", "Ouro");
			p1.armazenaPontuacao("Lucas", "10", "Prata");
			nomesDosUsuarios = p1.recuperaTodosOsPontuadores();
			assertEquals(nomesDosUsuarios.get(0), "Mateus");
			assertEquals(nomesDosUsuarios.get(1), "Lucas");
		}
		
		//Requisito 4:
		@Test
		public void recuperaTodosOsTiposDePontosDeUmUsuario() throws IOException {
			List<String> tiposDePontuacao = new ArrayList<>();
			
			Armazenamento p1 = new Armazenamento();
			p1.armazenaPontuacao("Mateus", "10", "Ouro");
			tiposDePontuacao = p1.recuperaTiposDePontosDoUsuario("Mateus");
			assertEquals(tiposDePontuacao.get(0), "Ouro");
		}
		@Test
		public void recuperMaisDeUmTipoDePontoDeUmUsuario() throws IOException {
			List<String> tiposDePontuacao = new ArrayList<>();
			Armazenamento p1 = new Armazenamento();
			p1.armazenaPontuacao("Mateus", "10", "Ouro");
			p1.armazenaPontuacao("Mateus", "5", "Prata");
			tiposDePontuacao = p1.recuperaTiposDePontosDoUsuario("Mateus");
			assertEquals(tiposDePontuacao.get(0), "Ouro");
			assertEquals(tiposDePontuacao.get(1), "Prata");
		}
}
