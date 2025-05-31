package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;

/**
 * Classe que cria um evento para fechar todas as janelas abertas
 */
public class EventoFecharTodasAsJanelas {
	
	/**
	 * Retorna um evento para fechar todas as janelas
	 * @return Um actionPerformed que fecha todas as janelas abertas
	 */
	public static ActionListener eventoFecharTodasAsJanelas() {
		return new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                for (Frame f : Frame.getFrames()) {
                    f.dispose();
                }
            }
		};
	}
}
