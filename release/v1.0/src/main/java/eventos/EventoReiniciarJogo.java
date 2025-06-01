package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.Tabuleiro;
import logica.Tentativa;
import view.ContainerCartas;

/**
 * Classe que cria um evento de reiniciar o jogo
 */
public class EventoReiniciarJogo {
	
	/**
	 * retorna um ActionListener com o evento de reiniciar o jogo
	 * @return o evento de reiniciar jogo
	 */
	public static ActionListener eventoReiniciarJogo(Tabuleiro tabuleiro, ContainerCartas container) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    container.limpar(); // limpa a interface
			    tabuleiro.limparTabuleiro(); // remove todas as cartas do array
			    tabuleiro.criarCartas(); // cria novas cartas
			    tabuleiro.embaralharCartas(); // embaralha novamente
			    container.carregarCartas(tabuleiro); // carrega as cartas na interface
			    container.atualizarInterface(); // atualiza a interface
			    Tentativa.reiniciarTentativas(); // reinicia o contador de tentativas
			}
		};
	}
}
