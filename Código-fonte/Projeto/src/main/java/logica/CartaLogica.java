package logica;

/**
 * Classe que cria a carta no backend
 */
public class CartaLogica {
	/**
	 * Valor que será armazenado na carta
	 */
	private char valor;
	/**
	 * Guarda o status da carta se está virada ou não
	 */
	private boolean virada;
	/*
	 * Indica se a carta foi descartada
	 */
	private boolean descartada;
	
	/**
	 * Construtor
	 */
	public CartaLogica(char valor) {
		this.valor = valor;
		this.virada = false;
		this.descartada = false;
	}
	
	/**
	 * retorna o valor da carta
	 * @return valor da carta
	 */
	public char getValor() {
		return this.valor;
	}
	
	/**
	 * retorna o status da carta
	 * @return um booleano identificando se está virada ou não
	 */
	public boolean getVirada() {
		return this.virada;
	}
	
	/**
	 * altera o status da carta
	 */
	public void alterarStatus() {
		this.virada = !this.virada;
	}
	
	/**
	 * altera o valor de descartada
	 */
	public void descartar() {
		this.descartada = !this.descartada;
	}
	
	/**
	 * retorna se está descartada ou não
	 * @return descartada
	 */
	public boolean getDescartada() {
		return this.descartada;
	}
}
