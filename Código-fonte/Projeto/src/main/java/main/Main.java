package main;

import logica.Finalizacao;
import logica.Tabuleiro;
import logica.Tentativa;
import view.ContainerCartas;
import view.ContainerLabel;
import view.Janela;

/**
 * Classe principal
 */
public class Main {
	
	/**
	 * método principal
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		
		// cria a janela do jogo
		Janela janela = new Janela();
		
		// criando titulo e container de cartas
		ContainerLabel containerLabel = new ContainerLabel();
		janela.getJanela().add(containerLabel.getPainel());
		
		ContainerCartas containerCartas = new ContainerCartas();
		janela.getJanela().add(containerCartas.getPainel());
		
		// iniciando tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.criarCartas();
		tabuleiro.embaralharCartas();
		
		// renderizando as cartas
		containerCartas.carregarCartas(tabuleiro);
		
		//inicio do jogo
		boolean finalizado = false;
		while(!finalizado) {
			janela.iniciar();
			
			if(tabuleiro.temDuasCartasViradas()) {
				tabuleiro.descartarCartas();
				Tentativa.incrementarTentativas();
			}
			
			containerLabel.getTentativasTexto().setText("" + Tentativa.getTentativas());
		}
	
		
	}

}
