package main;

import logica.Gameplay;
import logica.Tabuleiro;
import logica.Tentativa;
import view.ContainerCartas;
import view.ContainerLabel;
import view.Janela;
import view.JanelaFimDeJogo;

/**
 * Classe principal
 * @author pedro
 * @version 0.2
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
		
		// adicionando o evento de reiniciar jogo
		containerLabel.adicionarEventoReiniciar(tabuleiro, containerCartas);
		
		// renderizando as cartas
		containerCartas.carregarCartas(tabuleiro);
		
		//inicio do jogo
		while(true) {
			// inicia a janela
			janela.iniciar();
			
			// verifica se o jogo terminou
			if(Gameplay.verificarFimDeJogo(tabuleiro)) break;
			
			// trava o loop enquanto as cartas não são viradas
			if(tabuleiro.getAguardandoVirarCartas()) continue;
			
			// verificar se tem duas cartas viradas
			// se forem iguais, descarte as cartas 
			// se forem diferentes, desvire as cartas após 500ms
			// incrementa 1 tentativa
			if(tabuleiro.temDuasCartasViradas()) {
				if(Gameplay.saoIguais(tabuleiro.retornarCartasViradas())) {
					tabuleiro.descartarCartas();
				} else {
					tabuleiro.desvirarCartas(tabuleiro.retornarCartasViradas(), containerCartas, tabuleiro);
				}
			
				Tentativa.incrementarTentativas();
			}
			
			// atualiza o contador de tentativas
			containerLabel.getTentativasTexto().setText("Tentativas: " + Tentativa.getTentativas());
		}
		
		JanelaFimDeJogo janelaFimDeJogo = new JanelaFimDeJogo(Tentativa.getTentativas());
		janelaFimDeJogo.mostrar();
	}

}
