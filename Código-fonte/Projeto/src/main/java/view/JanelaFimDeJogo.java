package view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import eventos.EventoFecharTodasAsJanelas;

/**
 * Cria uma janela com a mensagem de fim de jogo
 */
public class JanelaFimDeJogo {
	/**
	 * a variável que armazena a caixa de mensagem que vai aparecer
	 */
	private JFrame caixaMensagem;
	
	/**
	 * Construtor
	 * @param tentativas O valor de tentativas jogadas
	 */
	public JanelaFimDeJogo(int tentativas) {
        this.caixaMensagem = new JFrame("Fim de jogo!");
        this.caixaMensagem.setSize(300, 180);
        this.caixaMensagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.caixaMensagem.setLocationRelativeTo(null);
        this.caixaMensagem.setLayout(new BorderLayout());

        JLabel mensagem = new JLabel("Fim de jogo!", SwingConstants.CENTER);
        mensagem.setFont(new Font("Arial", Font.BOLD, 24));
        this.caixaMensagem.add(mensagem, BorderLayout.CENTER);

        JLabel mensagemTentativas = new JLabel("Tentativas: " + tentativas, SwingConstants.CENTER);
        mensagemTentativas.setFont(new Font("Arial", Font.PLAIN, 16));
        mensagemTentativas.setBorder(new EmptyBorder(20, 0, 0, 0));
        this.caixaMensagem.add(mensagemTentativas, BorderLayout.NORTH);

        JButton botaoFechar = new JButton("fechar");
        botaoFechar.setPreferredSize(new Dimension(80, 30));
        botaoFechar.addActionListener(EventoFecharTodasAsJanelas.eventoFecharTodasAsJanelas());

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoFechar);
        this.caixaMensagem.add(painelBotoes, BorderLayout.SOUTH);
    }
	
	/**
	 * mostra a janela 
	 */
	public void mostrar() {
		this.caixaMensagem.setVisible(true);
	}
}
