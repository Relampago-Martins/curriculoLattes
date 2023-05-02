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
				continuar = false;
				break;
			}
		}
	}
	
	public Menu getMenuOption() {
		System.out.println("Menu, para:\n"+
				"1- Cadastrar Pesquisadores\n"+
				"2- Cadastrar Projetos\n"+
				"3- Cadastrar Artigos\n"+
				"4- Listar Pesquisadores\n"+
				"5- Listar Projetos\n"+
				"6- Listar Artigos\n"+
				"7- Listar Pesquisadores de uma Universidade\n"+
				"8- Listar Autores de um Artigo\n"+
				"9- ListarProjetos de um Pesquisador\n"+
				"10- Listar Autores dos Projetos finalizados\n"+
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
		System.out.println("Nome: ");
		nome = this.leitor.nextLine();
		System.out.println("Nome da Universidade");
		universidade = this.leitor.nextLine();

		Pesquisador novoPesquisador = new Pesquisador(nome, universidade);
		this.pesquisadores.add(novoPesquisador);
		return novoPesquisador;
	}

	public Projeto criarProjeto(){
		String nomeProjeto, descricao;
		

		System.out.println("Nome: ");
		nomeProjeto = this.leitor.nextLine();
		System.out.println("Descricao: ");
		descricao = this.leitor.nextLine();
		
		System.out.println("Forneça a data de fim do projeto");
		Data dataFim = this.getInputData();
		Pesquisador pesquisadorFind = this.getInputPesquisador();
	
		if (pesquisadorFind != null && dataFim != null) {
			Projeto novoProjeto = new Projeto(nomeProjeto, pesquisadorFind, dataFim);
			novoProjeto.setDescricao(descricao);
			this.projetos.add(novoProjeto);

			return novoProjeto;
		}
		System.out.println("Pesquisador nao encontrado. Operacao cancelada.");
		return null;
	}
	
	public Artigo criarArtigo(){
		System.out.println("Titulo do Artigo: ");
		String tituloArtigo = this.leitor.nextLine();
		System.out.println("Ano de publicação: ");
		int anoPublicacao = this.leitor.nextInt();
		this.leitor.nextLine();
		
		Pesquisador pesquisadorFind = this.getInputPesquisador();
		if (pesquisadorFind != null){
			try{
				Artigo novoArtigo = new Artigo(tituloArtigo, pesquisadorFind, anoPublicacao);
				this.artigos.add(novoArtigo);
				return novoArtigo;
			}catch (Exception error) {
				System.out.println(error.getMessage());
				return null;
			}
		}
		System.out.println("Pesquisador nao encontrado. Operacao cancelada.");
		return null;
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
		System.out.println("Nome da Universidade: ");
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
			System.out.printf("Autores do artigo '%s...':\n", artigoFind.getTitulo().substring(0, 30));
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
		System.out.println("Nome do Pesquisador: ");
		String nomePesquisador = this.leitor.nextLine();

		System.out.printf("Projetos em que %s está:\n", nomePesquisador);
		for (Projeto projeto: this.projetos){
			if (projeto.temAutor(nomePesquisador))
				System.out.printf("\t%s\n", projeto);
		}
	}

	public void autoresProjFinalizado(){
		System.out.println("Autores de projetos finalizados:");
		for (Projeto projeto: this.projetos){
			if (projeto.estahFinalizado()){
				System.out.printf("  - %s:\n", projeto);
				for (int i=0; i<projeto.getAutoresSize(); i++){
					System.out.printf("\t%s\n", projeto.getAutor(i).getNome());
				}
			}
		}
	}
	
	public Artigo getInputArtigo(){
		System.out.println("ID do artigo: ");
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
		System.out.println("Nome do Pesquisador: ");
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
		System.out.println("Dia: ");
		int dia = this.leitor.nextInt();
		System.out.println("Mes:");
		int mes = this.leitor.nextInt();
		System.out.println("Ano:");
		int ano = this.leitor.nextInt();

		try{
			Data data = new Data(dia, mes, ano);
			return data;
		}catch (Exception error){
			System.out.println(error.getMessage());
		}
		return null;
	}
}
