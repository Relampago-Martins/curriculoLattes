package entidades;

import java.util.ArrayList;

public class Pesquisador {
	String nome, universidade;
	int area;
	ArrayList<Projeto> projetos;
	
	public Pesquisador(String nome, String universidade, Projeto projeto) {
		this.setNome(nome);
		this.setUniversidade(universidade);
		this.setProjetos(projeto);
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
	public void setProjetos(Projeto projeto) {
		if (this.projetos == null) {
			this.projetos = new ArrayList<>();
		}
		
		if (projeto != null) {
			this.projetos.add(projeto);
		}
	}
	
}
