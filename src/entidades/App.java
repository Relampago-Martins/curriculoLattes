package entidades;

import java.io.Serializable;
import java.util.ArrayList;


public class App implements Serializable{
    private ArrayList<Pesquisador> pesquisadores;
    private ArrayList<Projeto> projetos;
    private ArrayList<Artigo> artigos;

    public ArrayList<Pesquisador> getPesquisadores() {
        return this.pesquisadores;
    }

    public void setPesquisadores(ArrayList<Pesquisador> pesquisadores) {
        this.pesquisadores = pesquisadores;
    }

    public ArrayList<Projeto> getProjetos() {
        return this.projetos;
    }

    public void setProjetos(ArrayList<Projeto> projetos) {
        this.projetos = projetos;
    }

    public ArrayList<Artigo> getArtigos() {
        return this.artigos;
    }

    public void setArtigos(ArrayList<Artigo> artigos) {
        this.artigos = artigos;
    }
}
