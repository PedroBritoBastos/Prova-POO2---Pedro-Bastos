package view;

import javax.swing.JFrame;

import logica.Tabuleiro;

import javax.swing.BoxLayout;
import java.awt.Color;


/**
 * Cria uma janela 
 */
public class Janela {
	/**
	 * janela que vai mostrar todo o jogo
	 */
	private JFrame janela;
	
	/**
	 * Construtor 
	 */
	public Janela() {
		this.janela = new JFrame("Jogo da memória");
		this.janela.setSize(1400, 1000);
		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.getContentPane().setLayout(new BoxLayout(this.janela.getContentPane(), BoxLayout.Y_AXIS));
		this.janela.getContentPane().setBackground(new Color(255, 204, 204));
	}
	
	/**
	 * inicia a janela do jogo
	 */
	public void iniciar() {
		this.janela.setVisible(true);
	}
	
	/**
	 * retorna o componente janela
	 * @return o componente janela
	 */
	public JFrame getJanela() {
		return this.janela;
	}
	
}