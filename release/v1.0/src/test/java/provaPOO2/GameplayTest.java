package provaPOO2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import logica.CartaLogica;
import logica.Gameplay;
import logica.Tabuleiro;

/**
 * Classe para testar os métodos da classe Gameplay
 */
public class GameplayTest {
	
	/**
	 * Método para testar se as cartão são iguais
	 */
	@Test
	public void saoIguaisTest() {
		CartaLogica[] cartasTeste = new CartaLogica[2];
		CartaLogica carta1 = new CartaLogica('A');
		CartaLogica carta2 = new CartaLogica('A');
		
		cartasTeste[0] = carta1;
		cartasTeste[1] = carta2;
		
		Assertions.assertEquals(true, Gameplay.saoIguais(cartasTeste));
	}
	
	/**
	 * Método para testar a verificação de fim de jogo
	 */
	@Test
	public void verficarFimDeJogoTest() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.criarCartas();
		tabuleiro.embaralharCartas();
		
		// descartando todas cartas para simular o fim do jogo
		for(int i = 0; i <= tabuleiro.getTabuleiro().length - 1; i++) {
			tabuleiro.getTabuleiro()[i].descartar();
		}
		
		// testando o método que deverá retornar true para o fim de jogo
		Assertions.assertEquals(true, Gameplay.verificarFimDeJogo(tabuleiro));
	}
}
