package entidades;

import java.util.ArrayList;

import utilitarios.Data; 


public class Artigo {

	private String tituloArtigo, tituloRevista;
	private int anoPublicacao;
	private ArrayList<Pesquisador> pesquisadores;
	
	public Artigo(String tituloArtigo, Pesquisador pesquisadoresTitular, int anoPublicacao) {
		this.setTituloArtigo(tituloArtigo);

		this.pesquisadores = new ArrayList<>(); 
		this.addPesquisador(pesquisadoresTitular);
		this.setAnoPublicacao(anoPublicacao);
	}
	
	public void setTituloArtigo(String tituloArtigo) {
		this.tituloArtigo = tituloArtigo;
	}
	
	public String getTituloArtigo() {
		return this.tituloArtigo;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		int anoAtual = new Data().getAno();

		if (anoPublicacao > 0 && anoPublicacao <= anoAtual)
			this.anoPublicacao = anoPublicacao;
		else
			throw new IllegalArgumentException("Ano de publicação inválido");
			
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
		return String.format("%s, de %d", this.tituloArtigo, this.anoPublicacao);
	}

}
