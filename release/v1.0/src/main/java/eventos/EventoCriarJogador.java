package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import arquivo.SalvarJson;
import logica.Jogador;
import logica.Placar;
import view.JanelaFimDeJogo;


/**
 * Classe que cria um evento para criar um jogador
 */
public class EventoCriarJogador {
	
	/**
	 * Retorna um evento para criar jogador
	 * @return um ActionListener que cria um jogador
	 */
	public static ActionListener eventoCriarJogador(Placar placar, int tentativas, JanelaFimDeJogo janela) {
		return new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				String nome = janela.pegarNomeDeJogador();
				placar.adicionarJogador(new Jogador(nome, tentativas));
				SalvarJson.salvarArquivo(placar, "dadosPlacarJson/dadosJogadores.json");
            }
		};
	}
}
