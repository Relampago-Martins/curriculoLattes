package entidades;

import java.util.ArrayList;

public class Artigo {

	private String tituloArtigo, tituloRevista;
	private int anoPublicacao;
	private ArrayList<Pesquisador> pesquisadores;
	
	public Artigo(String tituloArtigo, Pesquisador pesquisadoresTitular) {
		this.setTituloArtigo(tituloArtigo);

		this.pesquisadores = new ArrayList<>(); 
		this.addPesquisador(pesquisadoresTitular);
	}
	
	public void setTituloArtigo(String tituloArtigo) {
		this.tituloArtigo = tituloArtigo;
	}

	public String getTituloArtigo() {
		return this.tituloArtigo;
	}
	
	public void addPesquisador(Pesquisador pesquisador){
		if (pesquisador != null) {
			if (this.pesquisadores.indexOf(pesquisador) == -1)
				this.pesquisadores.add(pesquisador);
			else
				System.out.println("Pesquisador já cadastrado");
		}
	}

}
