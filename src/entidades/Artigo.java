package entidades;

import java.util.ArrayList;

public class Artigo {

	String tituloArtigo, tituloRevista;
	int anoPublicacao;
	ArrayList<Pesquisador> pesquisadores;
	
	public Artigo(String tituloArtigo, Pesquisador pesquisadoresTitular) {
		this.setTituloArtigo(tituloArtigo);
		this.setPesquisadores(pesquisadoresTitular);
	}
	
	public void setTituloArtigo(String tituloArtigo) {
		this.tituloArtigo = tituloArtigo;
	}
	
	public void setPesquisadores(Pesquisador pesquisador) {
		if (this.pesquisadores == null) {
			this.pesquisadores = new ArrayList<>(); 
		}
		
		if (pesquisador != null) {
			this.pesquisadores.add(pesquisador);
		}
	}

}
