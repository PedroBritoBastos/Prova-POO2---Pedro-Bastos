package arquivo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import logica.Jogador;
import logica.Placar;

/**
 * Classe para salvar arquivos Json
 */
public class SalvarJson {
	
	public static void salvarArquivo(Placar placar, String path) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// tentar ler arquivo
		File arquivo = new File(path);
		
		// pega os jogadores que estão no arquivo e coloca na lista
		List<Jogador> jogadoresDoArquivo = new ArrayList<>(); 
		
		if(arquivo.exists()) {
			try(Reader reader = new FileReader(path)){
				jogadoresDoArquivo = gson.fromJson(reader, new TypeToken<List<Jogador>>() {}.getType());
				
				if(jogadoresDoArquivo == null) {
					jogadoresDoArquivo = new ArrayList<>();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
        // Adiciona os novos jogadores do placar
        jogadoresDoArquivo.addAll(placar.getJogadores());
		
		try(FileWriter writer = new FileWriter(path)){
			gson.toJson(jogadoresDoArquivo, writer);
			System.out.println("Jogadores salvos com sucesso em: " + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
