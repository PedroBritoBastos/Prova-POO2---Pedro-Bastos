package logica;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cria um placar de jogadores
 */
public class Placar {
	/**
	 * lista com todos os jogadores criados
	 */
	private List<Jogador> jogadores;
	
	/**
	 * Construtor
	 */
	public Placar() {
		this.jogadores = new ArrayList<>();
	}
	
	/**
	 * Insere um jogador na lista de jogadores
	 * @param jogador O jogador atual
	 */
	public void adicionarJogador(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	
	/**
	 * retorna a lista de jogadores
	 * @return jogadores
	 */
	public List<Jogador> getJogadores() {
		return this.jogadores;
	}
}
