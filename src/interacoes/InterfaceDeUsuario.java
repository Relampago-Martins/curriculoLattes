package interacoes;

import java.util.Scanner;
import java.util.ArrayList;

import utilitarios.CarregadorDeDados;
import utilitarios.Data;
import entidades.Pesquisador;
import entidades.Projeto;
import entidades.Artigo;

public class InterfaceDeUsuario {
	Scanner leitor = new Scanner(System.in);
	enum Menu{
		CRIAR_PESQUISADOR, CRIAR_PROJETO, CRIAR_ARTIGO,
		LIS_PESQUISADORES, LIS_PROJETOS, LIS_ARTIGOS, PESQUISADOR_UNIVERSIDADE,
		AUTORES_ARTIGO, PROJETOS_PESQUISADOR, AUTORES_PROJ_FINALIZADO,
		DEFAULT
	}

	ArrayList<Pesquisador> pesquisadores = new ArrayList<>(); 
	ArrayList<Projeto> projetos = new ArrayList<>();
	ArrayList<Artigo> artigos = new ArrayList<>();
	int contadorProjetos, contadorArtigos;
	
	public void rodarMenuPrincipal() {
		CarregadorDeDados.charge(this.pesquisadores, this.artigos, this.projetos);
	
		boolean continuar = true;	
		while (continuar) {			
			switch(getMenuOption()) {
			case CRIAR_PESQUISADOR:
				this.criarPesquisador();
				break;
			case CRIAR_PROJETO:
				this.criarProjeto();
				break;
			case CRIAR_ARTIGO:
				this.criarArtigo();
				break;
			case LIS_PESQUISADORES:
				this.lisPesquisadores();
				break;
			case LIS_PROJETOS:
				this.lisProjetos();
				break;
			case LIS_ARTIGOS:
				this.lisArtigos();
				break;
			case PESQUISADOR_UNIVERSIDADE:
				this.pesquisadorUniversidade();
				break;
			case AUTORES_ARTIGO:
				this.autoresArtigo();
				break;
			case PROJETOS_PESQUISADOR:
				this.projetosPesquisador();
				break;
			case AUTORES_PROJ_FINALIZADO:
				this.autoresProjFinalizado();
				break;
			default:
				System.out.println("Encerrando o programa...");
				continuar = false;
				break;
			}
			if (continuar) {
				System.out.print("\nPressione ENTER para continuar...");
				this.leitor.nextLine();
				System.out.println("----------------------\n");
			}
		}
	}
	
	public Menu getMenuOption() {
		System.out.println("Menu, para:\n"+
				"  1- Cadastrar Pesquisadores\n"+
				"  2- Cadastrar Projetos\n"+
				"  3- Cadastrar Artigos\n"+
				"  4- Listar Pesquisadores\n"+
				"  5- Listar Projetos\n"+
				"  6- Listar Artigos\n"+
				"  7- Listar Pesquisadores de uma Universidade\n"+
				"  8- Listar Autores de um Artigo\n"+
				"  9- Listar Projetos de um Pesquisador\n"+
				"  10- Listar Autores dos Projetos finalizados\n"+
				"  Outros -> Sair\n"+
				"----------------------"
				);
		int option = this.leitor.nextInt();
		this.leitor.nextLine();
		
		try {
			return Menu.values()[ option - 1 ];
		}catch (Exception e) {
			return Menu.DEFAULT;
		}
	}

	public Pesquisador criarPesquisador() {
		String nome = "", universidade="";
		System.out.print("Nome: ");
		nome = this.leitor.nextLine();
		System.out.print("Universidade: ");
		universidade = this.leitor.nextLine();

		Pesquisador novoPesquisador = new Pesquisador(nome, universidade);
		this.pesquisadores.add(novoPesquisador);
		return novoPesquisador;
	}

	public Projeto criarProjeto(){
		String nomeProjeto, descricao;
		

		System.out.print("Nome: ");
		nomeProjeto = this.leitor.nextLine();
		System.out.print("Descricao: ");
		descricao = this.leitor.nextLine();
		
		System.out.println("Forneça a data de início do projeto");
		Data dataInicio = this.getInputData();
		System.out.println("Forneça a data de fim do projeto");
		Data dataFim = this.getInputData();
		Pesquisador pesquisadorFind = this.getInputPesquisador();
	
		try{
			Projeto novoProjeto = new Projeto(nomeProjeto, pesquisadorFind, dataInicio, dataFim);
			novoProjeto.setDescricao(descricao);
			this.projetos.add(novoProjeto);
			return novoProjeto;
		}catch (Exception error) {
			System.out.printf("%s Operação cancelada.\n", error.getMessage());
			return null;
		}
	}
	
	public Artigo criarArtigo(){
		System.out.print("Titulo do Artigo: ");
		String tituloArtigo = this.leitor.nextLine();
		System.out.print("Revista de publicação: ");
		String revista = this.leitor.nextLine();
		System.out.print("Ano de publicação: ");
		int anoPublicacao = this.leitor.nextInt();
		this.leitor.nextLine();
		
		Pesquisador pesquisadorFind = this.getInputPesquisador();
		try{
			Artigo novoArtigo = new Artigo(tituloArtigo, pesquisadorFind, anoPublicacao);
			novoArtigo.setRevista(revista);
			this.artigos.add(novoArtigo);
			return novoArtigo;
		}catch (Exception error) {
			System.out.println(error.getMessage());
			return null;
		}
	}

	public void lisPesquisadores(){
		System.out.println("Pesquisadores: ");
		for (Pesquisador pesquisador : this.pesquisadores) {
			System.out.printf("\t%s\n", pesquisador);
		}
	}

	public void lisProjetos(){
		System.out.println("Projetos: ");
		for (Projeto projeto : this.projetos) {
			System.out.printf("\t%s\n", projeto);
		}
	}

	public void lisArtigos(){
		System.out.println("Artigos: ");
		for (Artigo artigo : this.artigos) {
			System.out.printf("\t%s\n", artigo);
		}
	}

	/**
	 * Lista os pesquisadores de uma mesma Universidade;
	 * */
	public void pesquisadorUniversidade(){
		System.out.print("Nome da Universidade: ");
		String universidade = this.leitor.nextLine();
		System.out.printf("Pesquisadores da %s:\n", universidade);

		for(Pesquisador pesquisador: this.pesquisadores){
			if (pesquisador.getUniversidade().equals(universidade)){
				System.out.printf("\t%s\n", pesquisador.getNome());
			}
		}
	}
	
	/**
	 * Lista os autores de um determinado artigo;
	 */
	public void autoresArtigo(){
		Artigo artigoFind = this.getInputArtigo();
	
		if (artigoFind != null){
			System.out.printf("Autores do artigo '%s...':\n", 
								this.getStrResumida(artigoFind.getTitulo()));

			for (int i=0; i<artigoFind.getAutoresSize(); i++){
				System.out.printf("\t%s\n", artigoFind.getAutor(i).getNome());
			}
		}else{
			System.out.println("Artigo nao encontrado. Operacao cancelada.");
		}
	}

	/**
	 * Lista todos os projetos de um determinado pesquisador;
	 */
	public void projetosPesquisador(){
		System.out.print("Nome do Pesquisador: ");
		String nomePesquisador = this.leitor.nextLine();

		System.out.printf("Projetos em que %s está:\n", nomePesquisador);
		for (Projeto projeto: this.projetos){
			if (projeto.temAutor(nomePesquisador))
				System.out.printf("\t%s\n", projeto);
		}
	}

	public void autoresProjFinalizado(){
		ArrayList<Pesquisador> autoresProjFim = new ArrayList<>();	
		
		for (Projeto projeto: this.projetos){
			if (projeto.estahFinalizado()){
				for (int i=0; i<projeto.getAutoresSize(); i++){
					autoresProjFim.add(projeto.getAutor(i));
				}
			}
		}
		
		System.out.println("Autores de projetos finalizados:");
		for(Pesquisador autorProjFim: autoresProjFim){
			System.out.printf("\t%s\n", autorProjFim.getNome());
		}
	}
	
	public Artigo getInputArtigo(){
		System.out.print("ID do artigo: ");
		int idArtigo = this.leitor.nextInt();
		this.leitor.nextLine();

		for (Artigo artigo: this.artigos){
			if (artigo.getId() == idArtigo){
				return artigo;
			}
		}
		return null;		
	}

	public Pesquisador getInputPesquisador(){
		Pesquisador getInputPesquisador=null;
		System.out.print("Nome do Pesquisador: ");
		String nome = this.leitor.nextLine();

		for (Pesquisador pesquisador : this.pesquisadores) {
			if (pesquisador.getNome().equals(nome)) {
				getInputPesquisador = pesquisador;
				break;
			}
		}
		return getInputPesquisador;
	}

	public Data getInputData(){
		System.out.print("Dia: ");
		int dia = this.leitor.nextInt();
		System.out.print("Mes: ");
		int mes = this.leitor.nextInt();
		System.out.print("Ano: ");
		int ano = this.leitor.nextInt();
		this.leitor.nextLine();

		try{
			Data data = new Data(dia, mes, ano);
			return data;
		}catch (Exception error){
			System.out.println(error.getMessage());
		}
		return null;
	}

	public String getStrResumida(String strFull){
		int endIndex = 30 < strFull.length() ? 30 : strFull.length(); 
		return strFull.substring(0, endIndex);
	}
}
