package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe que cria um painel com o placar
 */
public class PlacarView {
	/**
	 * variável que armazena o painel
	 */
	private JPanel placar;
	
	/**
	 * Construtor
	 */
	public PlacarView(String nome, int tentativas) {
		this.placar = new JPanel(new FlowLayout());
		
		JPanel painelNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
		painelNome.setPreferredSize(new Dimension(300, 50));
		JLabel labelNome = new JLabel(nome); // criando label para nome
		labelNome.setFont(new Font("Arial", Font.PLAIN, 20));
		painelNome.add(labelNome);
		this.placar.add(painelNome);
		
		JPanel painelTentativas = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel labelTentativas = new JLabel("" + tentativas); // criando label para tentativas
		labelTentativas.setFont(new Font("Arial", Font.PLAIN, 20));
		painelTentativas.add(labelTentativas);
		this.placar.add(painelTentativas);
		
	}
	
	/**
	 * retorna o placar
	 * @return o JPanel com o placar
	 */
	public JPanel getPlacar() {
		return this.placar;
	}
	
}
