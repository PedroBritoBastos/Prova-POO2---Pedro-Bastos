package view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import eventos.EventoCriarJogador;
import eventos.EventoFecharTodasAsJanelas;
import logica.Placar;

/**
 * Cria uma janela com a mensagem de fim de jogo
 */
public class JanelaFimDeJogo {
	/**
	 * a variável que armazena a caixa de mensagem que vai aparecer
	 */
	private JFrame caixaMensagem;
	/**
	 * botão para fechar janela
	 */
	private JButton botaoFechar;
	/**
	 * input para o nome do jogador
	 */
	private JTextField inputNome;

	
	/**
	 * Construtor
	 * @param tentativas O valor de tentativas jogadas
	 */
	public JanelaFimDeJogo(int tentativas) {
		this.caixaMensagem = new JFrame("Fim de jogo!");
        this.caixaMensagem.setSize(500, 700);
        this.caixaMensagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.caixaMensagem.setLocationRelativeTo(null);
        this.caixaMensagem.setLayout(new FlowLayout());
        
        // container principal dos componentes
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.caixaMensagem.add(container);
        
        // mensagem de fim de jogo
        JPanel painelMensagem = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JLabel mensagem = new JLabel("Fim de jogo!", SwingConstants.CENTER);
        mensagem.setFont(new Font("Arial", Font.BOLD, 24));
        painelMensagem.add(mensagem);
        container.add(painelMensagem);
        
        // mensagem pedindo o nome do jogador
        JPanel painelNome = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JLabel mensagemNome = new JLabel("Insira o nome do jogador:", SwingConstants.CENTER);
        mensagemNome.setFont(new Font("Arial", Font.PLAIN, 14));
        mensagemNome.setBorder(new EmptyBorder(20, 0, 0, 0));
        painelNome.add(mensagemNome);
        container.add(painelNome);

        // input para nome
        JPanel painelInput = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        this.inputNome = new JTextField(15);
        this.inputNome.setPreferredSize(new Dimension(500, 50));
        painelInput.add(this.inputNome);
        container.add(painelInput);
        
        // mensagem de tentativas
        JPanel painelTentativas = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JLabel mensagemTentativas = new JLabel("Tentativas: " + tentativas, SwingConstants.CENTER);
        mensagemTentativas.setFont(new Font("Arial", Font.PLAIN, 16));
        mensagemTentativas.setBorder(new EmptyBorder(20, 0, 0, 0));
        painelTentativas.add(mensagemTentativas);
        container.add(painelTentativas);
        
        // botão para fechar
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        this.botaoFechar = new JButton("fechar");
        botaoFechar.setPreferredSize(new Dimension(80, 30));
        botaoFechar.addActionListener(EventoFecharTodasAsJanelas.eventoFecharTodasAsJanelas());
        painelBotoes.add(botaoFechar);
        container.add(painelBotoes);
    }
	
	/**
	 * mostra a janela 
	 */
	public void mostrar() {
		this.caixaMensagem.setVisible(true);
	}
	
	/**
	 * adiciona o evento para criar jogador ao botão
	 */
	public void adicionarEventoCriarJogador(Placar placar, int tentativas, JanelaFimDeJogo janela) {
		this.botaoFechar.addActionListener(EventoCriarJogador.eventoCriarJogador(placar, tentativas, janela));
	}
	
	/**
	 * pega o nome digitado no input
	 * @return nome do jogador inserido no input
	 */
	public String pegarNomeDeJogador() {
		return inputNome.getText();
	}
	
	/**
	 * retorna o JFrame 
	 * @return o JFrame da caixa de mensagem
	 */
	public JFrame getJanela() {
		return this.caixaMensagem;
	}
	
}
