package view;

import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

import logica.Tabuleiro;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Classe que cria o painel onde todas as cartas serão visíveis
 */
public class ContainerCartas {
	/**
	 * variavel que armazena o painel
	 */
	private JPanel painel;
	
	/**
	 * Construtor
	 */
	public ContainerCartas() {
		this.painel = new JPanel();
		this.painel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		this.painel.setBorder(new EmptyBorder(100, 0, 200, 0));
		this.painel.setBackground(new Color(84, 72, 72)); 
		this.painel.setPreferredSize(new Dimension(0, 800));
	}
	
	/**
	 * retorna o painel
	 * @return o container com as cartas visíveis
	 */
	public JPanel getPainel() {
		return this.painel;
	}
	
	/**
	 * carrega as cartas do backend na tela
	 */
	public void carregarCartas(Tabuleiro tabuleiro) {
		this.painel.removeAll();
		
		for(int i = 0; i <= tabuleiro.getTabuleiro().length - 1; i++) {
			if(tabuleiro.getTabuleiro()[i].getVirada()) {
				CartaView carta = new CartaView(tabuleiro.getTabuleiro()[i], tabuleiro, this);
				carta.getCarta().setText(tabuleiro.getTabuleiro()[i].getValor() + "");
				carta.getCarta().setEnabled(false);
				carta.getCarta().setBackground(new Color(209, 197, 197));
				this.painel.add(carta.getCarta());
			} else {
				CartaView carta = new CartaView(tabuleiro.getTabuleiro()[i], tabuleiro, this);
				carta.getCarta().setText("?");
				this.painel.add(carta.getCarta());
				carta.getCarta().setEnabled(true);
			}
		}
	}
	
	/**
	 * atualiza o container de cartas
	 */
	public void atualizarInterface() {
        this.painel.revalidate();   
        this.painel.repaint();
	}
	
	/**
	 * limpa o container
	 */
	public void limpar() {
		this.painel.removeAll();
	}
}
