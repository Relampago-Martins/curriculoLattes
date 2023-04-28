package interacoes;
import utilitarios.CarregadorDeDados;
import entidades.Pesquisador;
import entidades.Projeto;

import java.util.Scanner;
import java.util.ArrayList;

import entidades.Artigo;

public class InterfaceDeUsuario {
	Scanner leitor = new Scanner(System.in);
	enum Menu{
		CRIAR_PESQUISADOR, CRIAR_PROJETO, CRIAR_ARTIGO,
		LIS_PESQUISADORES, LIS_PROJETOS, LIS_ARTIGOS, PESQUISADOR_UNIVERSIDADE,
		AUTORES_ARTIGO, PROJETOS_PESQUISADOR, PESQ_PROJ_FINALIZADO,
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
				break;
			case CRIAR_ARTIGO:
				break;
			case LIS_PESQUISADORES:
				break;
			case LIS_PROJETOS:
				break;
			case LIS_ARTIGOS:
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
				"7- Listar Pesquisadores por Universidade\n"+
				"8- Listar Autores de um Artigo\n"+
				"9- ListarProjetos de um Pesquisador\n"+
				"10- Listar Pesquisadores por Projetos finalizados\n"+
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
}
