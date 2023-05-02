package utilitarios;

import java.util.ArrayList;

import entidades.Pesquisador;
import entidades.Projeto;
import entidades.Artigo;


public class CarregadorDeDados {
	
	public static void charge(ArrayList<Pesquisador> pesquisadores,
			ArrayList<Artigo> artigos, ArrayList<Projeto> projetos) {
				
		CarregadorDeDados.carregarPesquisadores(pesquisadores);
		CarregadorDeDados.carregarArtigos(artigos);
		CarregadorDeDados.carregarProjetos(projetos);
		
		projetos.get(0).addAutor(pesquisadores.get(0));
		projetos.get(0).addAutor(pesquisadores.get(1));

		artigos.get(0).addAutor(pesquisadores.get(0));
		artigos.get(0).addAutor(pesquisadores.get(1));
	}
	
	private static void carregarPesquisadores(ArrayList<Pesquisador> pesquisadores) {
		pesquisadores.add(new Pesquisador("Bruno Martins", "UCS"));
		pesquisadores.add(new Pesquisador("Willian Bazegio", "UCS"));
		pesquisadores.add(new Pesquisador("Maisa Dallemolle", "FSG"));
		pesquisadores.add(new Pesquisador("Gabriel da Silva", "UFSM"));
		pesquisadores.add(new Pesquisador("Fernando Soso Girardi", "UFSM"));
		pesquisadores.add(new Pesquisador("Samuel Frederico", "UCS"));		
	}
	
	private static void carregarArtigos(ArrayList<Artigo> artigos) {
		artigos.add(new Artigo("Aprendizado de máquina na previsão de preços de ações", null, 2019));
		artigos.add(new Artigo("Compras online versus lojas de varejo", null, 2019));
		artigos.add(new Artigo("Sono e desempenho acadêmico", null, 2019));
		artigos.add(new Artigo("Energia renovável versus fontes de energia tradicionais", null, 2000));
		artigos.add(new Artigo("Meditação da atenção plena no local de trabalho", null, 2022));
		artigos.add(new Artigo("Linguagens de programação para aplicativos da web", null, 2023));
	}
	
	private static void carregarProjetos(ArrayList<Projeto> projetos) {
		projetos.add(new Projeto("Efeitos de campos eletromagnéticos na saúde humana", null, new Data(1, 01, 2022), new Data(10, 01, 2022)));
		projetos.add(new Projeto("Inteligência artificial para análise de dados climáticos", null, new Data(1, 2, 2002), new Data(20, 3, 2002)));		
		projetos.add(new Projeto("Monitoramento da qualidade do ar em áreas urbanas", null, new Data(2, 2, 2021), new Data(2, 2, 2022)));		
		projetos.add(new Projeto("Propriedades antioxidantes de extratos vegetais", null, null, new Data()));		
		projetos.add(new Projeto("Previsão de demanda de energia elétrica", null, null, new Data()));		
		projetos.add(new Projeto("Reconhecimento de voz para pessoas com deficiências motoras", null, null, new Data()));		
	}
	

}
