package entidades;

import java.util.ArrayList;

import utilitarios.Data;


public class Projeto {
	String titulo, descricao;
	Data dtInicio, dtFim;
	ArrayList<Pesquisador> pesquisadores;
	
	public Projeto(String titulo, Pesquisador pesquisadorTitular){
		this.setTitulo(titulo);
		this.setPesquisadores(pesquisadorTitular);
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setPesquisadores(Pesquisador pesquisador) {
		if (this.pesquisadores == null) {			
			this.pesquisadores = new ArrayList<>();
		}

		if (pesquisador != null) {
			this.pesquisadores.add(pesquisador);
		}
	}

	public void setDtInicio(Data dtInicio) {
		if (this.dtFim != null && dtInicio.compareTo(this.dtFim) > 0) {
		}else {
			this.dtInicio = dtInicio;
		}
	}
}
