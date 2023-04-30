package entidades;

import java.util.ArrayList;

public class Pesquisador {
	private String nome, universidade;
	private int area;
	private ArrayList<Projeto> projetos;
	
	public Pesquisador(String nome, String universidade, Projeto projeto) {
		this.setNome(nome);
		this.setUniversidade(universidade);

		this.projetos = new ArrayList<>();
		this.addProjeto(projeto);
	}

	public Pesquisador(String nome, String universidade) {
		this(nome, universidade, null);
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUniversidade() {
		return this.universidade;
	}
	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}
	public int getArea() {
		return this.area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public void addProjeto(Projeto projeto) {
		if (projeto != null) {
			if (this.projetos.indexOf(projeto) == -1)
				this.projetos.add(projeto);
			else
				System.out.println("Projeto já cadastrado");
		}
	}
	
}
