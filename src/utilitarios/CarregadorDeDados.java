package utilitarios;

import java.util.ArrayList;

import entidades.Pesquisador;
import entidades.Projeto;
import persistencia.ArquivoTxt;
import entidades.App;
import entidades.Artigo;

/**
 * Classe que puxa as informações de um arquivo de texto e carrega na memória
 */
public class CarregadorDeDados {
	
	public static void charge(ArrayList<Pesquisador> pesquisadores,
			ArrayList<Artigo> artigos, ArrayList<Projeto> projetos) {
	
		ArquivoTxt arquivo = new ArquivoTxt("curriculoLates.txt");

		App data = arquivo.loadData();
		
		pesquisadores.addAll(data.getPesquisadores());
		artigos.addAll(data.getArtigos());
		projetos.addAll(data.getProjetos());
	}
	
}
