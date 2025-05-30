package logica;

/**
 * Classe responsável por indicar se o jogo finalizou
 */
public class Finalizacao {
	
	/**
	 * variavel que armazena o status do jogo
	 */
	private static boolean finalizado = false;
	
	/**
	 * retorna o status do jogo
	 * @return um booleano indicando se o jogo encerrou
	 */
	public static boolean estaFinalizado() {
		return finalizado;
	}
}
