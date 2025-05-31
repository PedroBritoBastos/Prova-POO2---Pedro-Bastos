package eventos;
import java.awt.event.ActionListener;


import logica.CartaLogica;
import logica.Tabuleiro;
import view.ContainerCartas;

import java.awt.event.ActionEvent;

/**
 * Classe que cria um evento para virar a carta
 */
public final class EventoVirarCarta {
    
	/**
	 * cria um evento de virar carta
	 * mostra o valor da carta quando é disparado
	 * @param carta
	 * @return um evento que chama o método para virar a carta
	 */
	public static ActionListener virarCarta(CartaLogica carta, Tabuleiro tabuleiro, ContainerCartas container) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carta.alterarStatus();
                container.carregarCartas(tabuleiro);  
                container.getPainel().revalidate();   
                container.getPainel().repaint();      
            }
        };
    }
}
