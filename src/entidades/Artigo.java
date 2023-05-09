package entidades;

import java.util.ArrayList;

import utilitarios.Data; 


public class Artigo {

	private static int countArtigos = 0;
	private String titulo, revista;
	private int anoPublicacao, id;
	private ArrayList<Pesquisador> autores;
	
	public Artigo(String titulo, Pesquisador autorTitular, int anoPublicacao) {
		this.id = ++Artigo.countArtigos;
		this.setTitulo(titulo);

		this.autores = new ArrayList<>(); 
		this.addAutor(autorTitular);
		this.setAnoPublicacao(anoPublicacao);
	}
	
	public String toString(){
		return String.format("(ID: %d) %s, de %d",this.id, this.titulo, this.anoPublicacao);
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

	public void setRevista(String revista) {
		this.revista = revista;
	}

	public String getRevista() {
		return this.revista;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		int anoAtual = new Data().getAno();

		if (anoPublicacao > 0 && anoPublicacao <= anoAtual)
			this.anoPublicacao = anoPublicacao;
		else
			throw new IllegalArgumentException("Ano de publicação inválido");
			
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

	public int getAutoresSize() {
		return this.autores.size();
	}

}
