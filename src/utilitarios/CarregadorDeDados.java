package utilitarios;

import java.util.ArrayList;

import entidades.Pesquisador;
import entidades.Projeto;
import persistencia.ArquivoObj;
import persistencia.ArquivoTxt;
import entidades.App;
import entidades.Artigo;

/**
 * Classe que puxa as informações de um arquivo de texto e carrega na memória
 */
public class CarregadorDeDados {

	/**
	 * Carrega os dados de um arquivo de texto para a memória
	 * @param pesquisadores ArrayList de pesquisadores
	 * @param artigos ArrayList de artigos
	 * @param projetos ArrayList de projetos
	 */
	public static void chargeFromTxt(ArrayList<Pesquisador> pesquisadores,
			ArrayList<Artigo> artigos, ArrayList<Projeto> projetos) {
	
		ArquivoTxt arquivo = new ArquivoTxt("curriculoLates.txt");

		App data = arquivo.loadData();
		
		pesquisadores.addAll(data.getPesquisadores());
		artigos.addAll(data.getArtigos());
		projetos.addAll(data.getProjetos());
	}
	
	/**
	 * Salva os dados de um objeto na memória para um arquivo objeto
	 * @param app Objeto a ser salvo
	 */
	public static void saveAsObject(App app) {
		ArquivoObj arquivo = new ArquivoObj("curriculoLates.obj");
		arquivo.dumpData(app);
	}
}
