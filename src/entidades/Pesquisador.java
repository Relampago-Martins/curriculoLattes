package entidades;

public class Pesquisador {
	private String nome, universidade, areaConhecimento;
	
	public Pesquisador(String nome, String universidade) {
		this.setNome(nome);
		this.setUniversidade(universidade);
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

	public String toString(){
		return String.format("%s da universidade %s", this.nome, this.universidade);
	}
	
}
