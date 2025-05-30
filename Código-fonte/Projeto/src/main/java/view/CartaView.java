package view;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Font;
import eventos.EventoVirarCarta;
import logica.CartaLogica;
import logica.Tabuleiro;

/**
 * Classe que cria um JButton representando uma carta
 */
public class CartaView {
	/**
	 * index que conecta a CartaView a CartaLogica 
	 */
	private int index;
	/**
	 * variável que armazena o JButton
	 */
	private JButton carta;
	
	/**
	 * Construtor
	 */
	public CartaView(int index, CartaLogica cartaLogica, Tabuleiro tabuleiro, ContainerCartas container) {
		this.carta = new JButton("?");
		this.carta.setPreferredSize(new Dimension(200, 300));
		this.carta.setFont(new Font("Arial", Font.BOLD, 70));
		this.carta.setBorder(new LineBorder(new Color(117, 108, 108), 8, false));
		this.carta.setBackground(new Color(145, 137, 137));
		this.carta.addActionListener(EventoVirarCarta.virarCarta(cartaLogica, tabuleiro, container));
		this.carta.setForeground(Color.WHITE);
		this.index = index;
	}
	
	/**
	 * retorna o componente carta
	 * @return a carta visível
	 */
	public JButton getCarta() {
		return this.carta;
	}
	
}
