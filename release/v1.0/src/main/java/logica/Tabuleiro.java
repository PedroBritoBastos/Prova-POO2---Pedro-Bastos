package logica;
import java.util.Random;

import view.ContainerCartas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que cria um tabuleiro com cartas lógicas
 */
public class Tabuleiro {
	/**
	 * Array de cartas lógicas
	 */
	private CartaLogica[] tabuleiro;
	/**
	 * variável de controle para travar o jogo enquanto as cartas não são viradas
	 */
	private boolean aguardandoVirarCartas ;
	
	/**
	 * construtor
	 */
	public Tabuleiro() {
		this.tabuleiro = new CartaLogica[10];
		this.aguardandoVirarCartas = false;
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
	
	/**
	 * percorre todo o tabuleiro e retorna as cartas viradas
	 * @return um array com as cartas viradas
	 */
	public CartaLogica[] retornarCartasViradas() {
		List<CartaLogica> cartasViradas = new ArrayList<>();
		
		for(int i = 0; i <= this.tabuleiro.length - 1; i++) {
			if(this.tabuleiro[i].getVirada() && !this.tabuleiro[i].getDescartada()) {
				cartasViradas.add(this.tabuleiro[i]);
			}
		}

		return cartasViradas.toArray(new CartaLogica[0]);
	}
	
	/**
	 * Desvira as cartas que estão viradas e são diferentes após 500ms
	 * @param cartas o array de cartas viradas
	 * @param container o container com as cartas
	 * @param tabuleiro o tabuleiro 
	 */
	public void desvirarCartas(CartaLogica[] cartas, ContainerCartas container, Tabuleiro tabuleiro) {
		if (cartas == null || cartas.length < 2) {
		    return; 
		}
		
		this.aguardandoVirarCartas = true;
		
		// Cria um Timer que espera 500ms antes de executar o ActionListener
	    Timer timer = new Timer(500, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cartas[0].alterarStatus();
	            cartas[1].alterarStatus();

	            // Atualiza a interface
	            container.carregarCartas(tabuleiro);
	            container.atualizarInterface();
	            
	            aguardandoVirarCartas = false;
	        }
	    });

	    // Inicia o timer
	    timer.setRepeats(false); // garante que executa só uma vez
	    timer.start();
	}
	
	/**
	 * retorna a variável aguardandoVirarCartas
	 * @return a variável de controle
	 */
	public boolean getAguardandoVirarCartas() {
		return this.aguardandoVirarCartas;
	}
	
	/**
	 * limpa o tabuleiro
	 */
	public void limparTabuleiro() {
		this.tabuleiro = null;
		this.tabuleiro = new CartaLogica[10];
	}
	
	
}
