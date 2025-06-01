package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import arquivo.LerJson;
import logica.Jogador;

/**
 * Classe que cria uma janela com os placares
 */
public class JanelaPlacar {
	/**
	 * lista de jogadores do arquivo json
	 */
	private List<Jogador> jogadores = new ArrayList<>();
	/**
	 * variável que guarda a janela do placar
	 */
	private JFrame janela;
	/**
	 * varável que guarda o container onde vai ser inseridos os placares
	 */
	private JPanel painel;

	
	/**
	 * Construtor
	 */
    public JanelaPlacar() {
    	this.janela = new JFrame("Placares");
    	this.janela.setSize(500, 700);
    	this.janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.janela.setLocationRelativeTo(null);
    	this.janela.setLayout(new FlowLayout());
    	
    	// criando container para titulo e para o painel de placares alinhados verticalmente
    	JPanel container = new JPanel();
    	container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    	
    	// inserindo os painéis no container
    	this.painel = new JPanel();
    	this.painel.setLayout(new BoxLayout(this.painel, BoxLayout.Y_AXIS));
    	container.add(criarPainelTitulo());
    	JScrollPane scroll = new JScrollPane(this.painel);
    	container.add(this.painel);
    	
    	// carregando os dados do json e ordenando do menor para o maior
        carregarDados();
        ordenarCrescente();
        
        // criando os placares
        inserirPlacares();
        
        // adicionando o container na tela
        this.janela.add(scroll);
        this.janela.add(container);
    }
	
    /**
     * método que carrega os dados do arquivo json
     */
    private void carregarDados() {
        List<Jogador> dados = LerJson.lerJson();
        if (dados != null) {
            jogadores.addAll(dados);

            // Exemplo: imprimir no console
            for (Jogador jogador : jogadores) {
                System.out.println("Nome: " + jogador.getNome() + ", Tentativas: " + jogador.getTentativas());
            }
        }
    }
    
    /**
     * método que ordena a lista de jogadores por número de tentativas, do menor para o maior
     */
    private void ordenarCrescente() {
        // Ordena por tentativas em ordem crescente
        Collections.sort(jogadores, Comparator.comparingInt(Jogador::getTentativas));
    }
    
    /**
     * método que cria os placares com o nome de jogador e tentativas para serem apresentados na tela
     */
    private void inserirPlacares() {
    	for (int i = 0; i < this.jogadores.size(); i++) {
    	    // pegar o nome e tentativas do jogador na posição atual
    		String nome = jogadores.get(i).getNome();
    		int tentativas = jogadores.get(i).getTentativas();
    		
    		// criar um placarview com o nome e as tentativas
    		PlacarView placar = new PlacarView(nome, tentativas);
    		
    		// inserir o placar na janela
    		this.painel.add(placar.getPlacar());
    	}
    }
    
    /**
     * cria um painel com o título Jogador/Tentativas
     * @return o JPanel com o título
     */
    private JPanel criarPainelTitulo() {
    	JPanel painel = new JPanel();
    	painel.setLayout(new FlowLayout());
    	
    	JPanel painelJogador = new JPanel();
    	painelJogador.setLayout(new FlowLayout(FlowLayout.LEFT));
    	painelJogador.setPreferredSize(new Dimension(200, 50));
    	JLabel labelJogador = new JLabel("Jogador");
    	labelJogador.setFont(new Font("Arial", Font.BOLD, 40));
    	painelJogador.add(labelJogador);
    	
    	JPanel painelTentativas = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	JLabel labelTentativas = new JLabel("Tentativas");
    	labelTentativas.setFont(new Font("Arial", Font.BOLD, 30));
    	labelTentativas.setPreferredSize(new Dimension(200, 50));
    	painelTentativas.add(labelTentativas);
    	
    	painel.add(painelJogador);
    	painel.add(painelTentativas);
    	
    	return painel;
    }
    
    /**
     * torna o placar visível
     */
    public void mostrar() {
    	this.janela.setVisible(true);
    }
    
}
