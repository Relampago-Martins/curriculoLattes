package entidades;

import java.util.ArrayList;

public class Pesquisador {
	private String nome, universidade, areaConhecimento;
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
	public String getAreaConhecimento() {
		return this.areaConhecimento;
	}
	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	public void addProjeto(Projeto projeto) {
		if (projeto != null) {
			if (this.projetos.indexOf(projeto) == -1)
				this.projetos.add(projeto);
			else
				System.out.println("Projeto já cadastrado");
		}
	}

	public Projeto getProjeto(int indice) {
		if (indice >= 0 && indice < this.projetos.size())
			return this.projetos.get(indice);
		
		return null;
	}

	public String toString(){
		return String.format("%s da universidade %s", this.nome, this.universidade);
	}
	
}
