package logica;

/**
 * Classe que controla as condições de jogo e verificações
 */
public class Gameplay {
	
	/**
	 * método que retorna verdadeiro se houver duas cartas viradas
	 * @param cartas array de cartas viradas
	 * @return um booleano que indica se tem duas cartas viradas
	 */
	public static boolean temDuasCartasViradas(CartaLogica[] cartas) {
		if(cartas.length == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * verifica se duas cartas são iguais
	 * @param cartas array com 2 CartasLogicas para comparar
	 * @return um booleano que indica se são iguais
	 */
	public static boolean saoIguais(CartaLogica[] cartas) {
		if(cartas[0].getValor() == cartas[1].getValor()) return true;
		
		return false;
	}
	
	/**
	 * Percorre todo o tabuleiro verificando se todas as cartas estão descartas.
	 * Se houver alguma carta que não está descartada, retorna falso.
	 * @param tabuleiro o tabuleiro atual
	 * @return um booleano indicando se o jogo finalizou ou não
	 */
	public static boolean verificarFimDeJogo(Tabuleiro tabuleiro) {
		for(int i = 0; i <= tabuleiro.getTabuleiro().length - 1; i++) {
			if(!tabuleiro.getTabuleiro()[i].getDescartada()) {
				return false;
			}
		}
		
		return true;
	}
}
