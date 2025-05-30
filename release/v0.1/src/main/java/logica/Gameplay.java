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
}
