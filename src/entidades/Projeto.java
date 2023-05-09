package entidades;

import java.util.ArrayList;

import utilitarios.Data;


public class Projeto {
	private static int countProjetos = 0;
	private String titulo, descricao;
	private Data dtInicio, dtFim;
	private ArrayList<Pesquisador> autores;
	private int id;
	
	public Projeto(String titulo, Pesquisador autorTitular, Data dtInicio, Data dtFim) {
		this.id = ++Projeto.countProjetos;
		this.setTitulo(titulo);
		this.autores = new ArrayList<>();
		this.addAutor(autorTitular);
		this.setDtInicio(dtInicio);
		this.setDtFim(dtFim);
			
	}

	public String toString(){
		return String.format("%s", this.titulo);
	}

	public int getId() {
		return this.id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return this.descricao;
	}

	public void setDtInicio(Data dtInicio) {
		if (dtInicio == null)
			throw new IllegalArgumentException("Data de inicio não pode ser nula.");
		else
			this.dtInicio = dtInicio;
	}

	public void setDtFim(Data dtFim) {
		if (dtFim == null || dtFim.compareTo(this.dtInicio) < 0) {
			throw new IllegalArgumentException("Data de fim inválida.");
		}else {
			this.dtFim = dtFim;
		}
	}

	public boolean estahFinalizado() {
		Data hoje = new Data();
		return this.dtFim.compareTo(hoje) < 0;
	}

	public void addAutor(Pesquisador novoAutor){
		if (novoAutor != null) {
			if (this.autores.indexOf(novoAutor) == -1)
				this.autores.add(novoAutor);
			else
				throw new IllegalArgumentException("Pesquisador já cadastrado como autor.");
		} 
		else
			throw new IllegalArgumentException("Pesquisador não pode ser nulo.");
	}

	public Pesquisador getAutor(int indice) {
		if (indice >= 0 && indice < this.autores.size())
			return this.autores.get(indice);
		
		return null;
	}	
	
	public boolean temAutor(Pesquisador pesquisador) {
		if (this.autores.indexOf(pesquisador) != -1)
			return true;
		return false;
	}

	public boolean temAutor(String nomeAutor) {
		for (Pesquisador pesquisador : this.autores) {
			if (pesquisador.getNome().equals(nomeAutor))
				return true;
		}
		return false;
	}

	public int getAutoresSize() {
		return this.autores.size();
	}
}
