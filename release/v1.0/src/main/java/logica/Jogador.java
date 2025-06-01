package logica;

/**
 * Classe que cria um jogador
 */
public class Jogador {
	/**
	 * nome do jogador
	 */
	private String nome;
	/**
	 * tentativas que o jogador fez
	 */
	private int tentativas;
	
	/**
	 * Construtor
	 */
	public Jogador(String nome, int tentativas) {
		this.nome = nome;
		this.tentativas = tentativas;
	}
	
	/**
	 * retorna o nome
	 * @return o nome do jogador
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * retorna as tentativas do jogador
	 * @return tentativas
	 */
	public int getTentativas() {
		return this.tentativas;
	}
}
