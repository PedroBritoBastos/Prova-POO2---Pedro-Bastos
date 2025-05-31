package logica;

/**
 * Classe responsável por controlar as tentativas
 */
public class Tentativa {
	/**
	 * variável que armazena as tentativas
	 */
	private static int tentativas = 0;
	
	/**
	 * método que incrementa tentativas
	 */
	public static void incrementarTentativas() {
		tentativas++;
	}
	
	/**
	 * retorna as tentativas
	 */
	public static int getTentativas() {
		return tentativas;
	}
	
	/**
	 * reinicia as tentativas
	 */
	public static void reiniciarTentativas() {
		tentativas = 0;
	}
	
}
