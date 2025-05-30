package logica;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cria um tabuleiro com cartas lógicas
 */
public class Tabuleiro {
	/**
	 * Array de cartas lógicas
	 */
	private CartaLogica[] tabuleiro = new CartaLogica[10];
	/**
	 * Lista com as cartas que serão desconsideradas
	 */
	private List<CartaLogica> cartasDesativadas = new ArrayList<>();
	
	/**
	 * construtor
	 */
	public Tabuleiro() {
		
	}
	
	/**
	 * método que cria as cartas lógicas no tabuleiro
	 */
	public void criarCartas() {
		// criando um array com 10 caracteres que serão usados como valores das cartas
		char[] valores = {'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E'};
		
		// criando 10 cartas com os valores
		for(int i = 0; i <= valores.length - 1; i++) {
			this.tabuleiro[i] = new CartaLogica(valores[i]);
		}
	}
	
	/**
	 * método que coloca as cartas em posições aleatórias
	 */
	public void embaralharCartas() {
	    Random random = new Random();

	    for (int i = tabuleiro.length - 1; i > 0; i--) {
	        int j = random.nextInt(i + 1); // índice aleatório entre 0 e i

	        // troca as posições i e j
	        CartaLogica temp = tabuleiro[i];
	        tabuleiro[i] = tabuleiro[j];
	        tabuleiro[j] = temp;
	    }
	}
	
	/**
	 * retorna o tabuleiro de cartas lógicas
	 * @return retorna o tabuleiro
	 */
	public CartaLogica[] getTabuleiro() {
		return this.tabuleiro;
	}
	
	/**
	 * método que percorre todo o tabuleiro e conta a quantidade de cartas viradas
	 * @return um booleano que indica se há duas cartas viradas
	 */
	public boolean temDuasCartasViradas() {
		int quantidade = 0;
		
		// só vai considerar as cartas viradas que não foram descartadas
		for(int i = 0; i <= this.tabuleiro.length - 1; i++) {
			if(this.tabuleiro[i].getVirada() && !this.tabuleiro[i].getDescartada()) {
				quantidade++;
			}
		}
		
		if(quantidade < 2) return false;
		
		return true;
	}
	
	/**
	 * percorre todo o tabuleiro e descarta as duas cartas viradas
	 */
	public void descartarCartas() {
		for(int i = 0; i <= this.tabuleiro.length - 1; i++) {
			if(this.tabuleiro[i].getVirada() && !this.tabuleiro[i].getDescartada()) {
				this.tabuleiro[i].descartar();
			}
		}
	}
	
}
