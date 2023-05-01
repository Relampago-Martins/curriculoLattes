package entidades;

import java.util.ArrayList;

import utilitarios.Data;


public class Projeto {
	private String titulo, descricao;
	private Data dtInicio, dtFim;
	private ArrayList<Pesquisador> pesquisadores;
	
	public Projeto(String titulo, Pesquisador pesquisadorTitular){
		this.setTitulo(titulo);
		this.pesquisadores = new ArrayList<>();
		this.addPesquisador(pesquisadorTitular);
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

	public void setDtInicio(Data dtInicio) {
		if (this.dtFim != null && dtInicio.compareTo(this.dtFim) > 0) {
			System.out.println("Data de início não pode ser posterior à data de fim");
		}else {
			this.dtInicio = dtInicio;
		}
	}

	public void addPesquisador(Pesquisador pesquisador){
		if (pesquisador != null) {
			if (this.pesquisadores.indexOf(pesquisador) == -1)
				this.pesquisadores.add(pesquisador);
			else
				System.out.println("Pesquisador já cadastrado");
		}
	}

	public Pesquisador getPesquisador(int indice) {
		if (indice >= 0 && indice < this.pesquisadores.size())
			return this.pesquisadores.get(indice);
		
		return null;
	}	

	public String toString(){
		return String.format("%s", this.titulo);
	}

	public boolean estahFinalizado() {
		Data hoje = new Data();
		return this.dtFim.compareTo(hoje) < 0;
	}
}
