package arquivo;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import logica.Jogador;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Classe com método para ler json
 */
public class LerJson {
	/**
	 * variavel que guarda o caminho do arquivo
	 */
	private static String path = "dadosPlacarJson/dadosJogadores.json";
	
	/**
	 * método que lê o arquivo json
	 * @return a lista com os jogadores do arquivo
	 */ 
    public static List<Jogador> lerJson() {
        Gson gson = new Gson();
        
        try (FileReader reader = new FileReader(path)) {
            Type listaTipo = new TypeToken<List<Jogador>>(){}.getType();
            List<Jogador> jogadores = gson.fromJson(reader, listaTipo);
            return jogadores;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
