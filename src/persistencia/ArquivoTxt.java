package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import entidades.App;
import entidades.Artigo;
import entidades.Pesquisador;
import entidades.Projeto;
import utilitarios.Data;


public class ArquivoTxt extends Arquivo{


    public ArquivoTxt(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void dumpData(App data) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public App loadData() {
        App data = new App();
        ArrayList<Pesquisador> pesquisadores = new ArrayList<>();
        ArrayList<Projeto> projetos = new ArrayList<>();
        ArrayList<Artigo> artigos = new ArrayList<>();
        String linha;
        
        try{
            BufferedReader buffReader = new BufferedReader( new FileReader(this.nomeArquivo) );
            linha = buffReader.readLine();

            String nome, universidade;
            while(linha.trim().equals("#Pesquisador")){
                nome = this.cleanAttr( buffReader.readLine() );
                universidade = this.cleanAttr( buffReader.readLine() );
                
                pesquisadores.add( new Pesquisador(nome, universidade) );
                linha = buffReader.readLine();
            }
    
            String titulo, descricao, pesquisadoresNome;
            Data dataInicio, dataFim; 
            while(linha.trim().equals("#Projeto")){
                dataInicio = new Data(this.cleanAttr( buffReader.readLine() ));
                dataFim = new Data(this.cleanAttr( buffReader.readLine() ));
                titulo = this.cleanAttr( buffReader.readLine() );
                descricao = this.cleanAttr( buffReader.readLine() );
                pesquisadoresNome = this.cleanAttr( buffReader.readLine() );

                Projeto projeto = new Projeto(titulo, descricao, dataInicio, dataFim);

                for (Pesquisador pesquisador: pesquisadores){
                    if (pesquisador.getNome().contains(pesquisadoresNome)){
                        projeto.addAutor(pesquisador);
                    }
                }
                projetos.add(projeto);
                linha = buffReader.readLine();
            }

            String Revista;
            int ano;
            while(linha.trim().equals("#Artigo")){
                titulo = this.cleanAttr( buffReader.readLine() );
                ano = Integer.parseInt( this.cleanAttr(buffReader.readLine()) );
                Revista = this.cleanAttr( buffReader.readLine() );
                pesquisadoresNome = this.cleanAttr( buffReader.readLine() );

                Artigo artigo = new Artigo(titulo, Revista, ano);

                for (Pesquisador pesquisador: pesquisadores){
                    if (pesquisador.getNome().contains(pesquisadoresNome)){
                        artigo.addAutor(pesquisador);
                    }
                }
                artigos.add(artigo);
                linha = buffReader.readLine();
            }
            
            data.setPesquisadores(pesquisadores);
            data.setArtigos(artigos);
            data.setProjetos(projetos);

            buffReader.close();
        }catch(Exception e){
            handleExceptions(e);
        }
        return data;
    }

    private String cleanAttr(String attr){
        String[] splits = attr.split(":", 2);
        if (splits.length >= 2){
            return attr.split(":", 2)[1].trim();
        }

        return attr;

    }
    
}
