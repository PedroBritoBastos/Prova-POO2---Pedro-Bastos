package provaPOO2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import logica.CartaLogica;
import logica.Tabuleiro;

/**
 * Classe que testa métodos da classe Tabuleiro
 */
public class TabuleiroTest {
	
	/**
	 * testar se as cartas estão sendo criadas corretamente
	 * o esperado é ter um array com CartasLogicas
	 */
	@Test
	public void criarCartasTest() {
		// criando um array com 10 caracteres que serão usados como valores das cartas
		char[] valores = {'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E'};
		
		Tabuleiro tabuleiro = new Tabuleiro();
		
		// criando 10 cartas com os valores
		for(int i = 0; i <= valores.length - 1; i++) {
			tabuleiro.getTabuleiro()[i] = new CartaLogica(valores[i]);
		}
		
		// retorno
		Assertions.assertEquals('A', tabuleiro.getTabuleiro()[0].getValor());
		Assertions.assertEquals('A', tabuleiro.getTabuleiro()[1].getValor());
		Assertions.assertEquals('B', tabuleiro.getTabuleiro()[2].getValor());
		Assertions.assertEquals('B', tabuleiro.getTabuleiro()[3].getValor());
		Assertions.assertEquals('C', tabuleiro.getTabuleiro()[4].getValor());
		Assertions.assertEquals('C', tabuleiro.getTabuleiro()[5].getValor());
		Assertions.assertEquals('D', tabuleiro.getTabuleiro()[6].getValor());
		Assertions.assertEquals('D', tabuleiro.getTabuleiro()[7].getValor());
		Assertions.assertEquals('E', tabuleiro.getTabuleiro()[8].getValor());
		Assertions.assertEquals('E', tabuleiro.getTabuleiro()[9].getValor());
	}
	
	/**
	 * testar se há duas cartas viradas
	 */
	@Test
	public void temDuasCartasViradasTest() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.criarCartas();
		tabuleiro.embaralharCartas();
		
		// virando duas cartas para teste
		tabuleiro.getTabuleiro()[2].alterarStatus();
		tabuleiro.getTabuleiro()[7].alterarStatus();
		
		Assertions.assertEquals(true, tabuleiro.temDuasCartasViradas());
	}
}
