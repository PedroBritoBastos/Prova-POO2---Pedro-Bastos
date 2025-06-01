package view;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import eventos.EventoReiniciarJogo;
import logica.Tabuleiro;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Classe que cria o componente onde fica o titulo do jogo
 */
public class ContainerLabel {
	/**
	 * variavel que armazena o painel
	 */
	private JPanel painel;
	/**
	 * variavel que armazena o titulo que vai estar dentro do painel
	 */
	private JLabel titulo;
	/**
	 * variavel que armazena o texto tentativas
	 */
	private JLabel tentativasTexto;
	/**
	 * variavel que armazena o botao de reiniciar
	 */
	private JButton botaoReiniciar;
	
	/**
	 * Construtor 
	 */
	public ContainerLabel() {
		this.painel = new JPanel();
		this.painel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		this.painel.setBackground(new Color(125, 106, 106));
		this.painel.setBorder(new EmptyBorder(50, 0, 50, 0));
		
		this.botaoReiniciar = new JButton("Reiniciar Jogo");
		this.botaoReiniciar.setFont(new Font("Arial", Font.BOLD, 24));
		this.botaoReiniciar.setForeground(Color.WHITE);
		this.botaoReiniciar.setBorder(new LineBorder(new Color(117, 108, 108), 8, false));
		this.botaoReiniciar.setBackground(new Color(145, 137, 137));
		this.botaoReiniciar.setPreferredSize(new Dimension(200, 80));
		this.painel.add(this.botaoReiniciar);
			
		this.titulo = new JLabel("JOGO DA MEMÓRIA");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 36));
		this.titulo.setForeground(Color.WHITE); 
		this.painel.add(this.titulo);
		
		this.tentativasTexto = new JLabel("tentativas: 0");
		this.tentativasTexto.setFont(new Font("Arial", Font.BOLD, 24));
		this.tentativasTexto.setForeground(Color.WHITE); 
		this.painel.add(this.tentativasTexto);
	}
	
	/**
	 * retorna o painel com o titulo
	 * @return o painel com o titulo do jogo
	 */
	public JPanel getPainel() {
		return this.painel;
	}
	
	/**
	 * retorna o texto de tentativas
	 * @return o JLabel com a quantidade de tentativas
	 */
	public JLabel getTentativasTexto() {
		return this.tentativasTexto;
	}
	
	/**
	 * adiciona o evento de reiniciar jogo ao botao
	 */
	public void adicionarEventoReiniciar(Tabuleiro tabuleiro, ContainerCartas container) {
		this.botaoReiniciar.addActionListener(EventoReiniciarJogo.eventoReiniciarJogo(tabuleiro, container));
	}
}
