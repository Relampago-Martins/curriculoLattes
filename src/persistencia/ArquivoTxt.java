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


    }

    @Override
    public App loadData() {
        App data = new App();
        ArrayList<Pesquisador> pesquisadores = new ArrayList<>();
        ArrayList<Projeto> projetos = new ArrayList<>();
        ArrayList<Artigo> artigos = null;
        String linha;
        
        try{
            BufferedReader buffReader = new BufferedReader( new FileReader(this.nomeArquivo) );
            linha = buffReader.readLine();

            String nome, universidade;
            while(linha.equals("#Pesquisador")){
                nome = this.cleanAttr( buffReader.readLine() );
                universidade = this.cleanAttr( buffReader.readLine() );
                
                pesquisadores.add( new Pesquisador(nome, universidade) );
                linha = buffReader.readLine();
            }
            
            String titulo, descricao, pesquisadoresNome;
            Data dataInicio, dataFim; 
            while(linha.equals("#Projeto")){
                dataInicio = new Data(this.cleanAttr( buffReader.readLine() ));
                dataFim = new Data(this.cleanAttr( buffReader.readLine() ));
                titulo = this.cleanAttr( buffReader.readLine() );
                descricao = this.cleanAttr( buffReader.readLine() );
                pesquisadoresNome = this.cleanAttr( buffReader.readLine() );

                Projeto projeto = new Projeto(titulo, descricao, dataInicio, dataFim);

                for (Pesquisador pesq: pesquisadores){
                    if (pesq.getNome().contains(pesquisadoresNome)){
                        projeto.addAutor(pesq);
                    }
                }
                projetos.add(projeto);
                linha = buffReader.readLine();
            }

            buffReader.close();
        }catch(Exception e){
            handleExceptions(e);
        }
        return data;
    }

    private String cleanAttr(String attr){
        return attr.split(":", 1)[1].trim();
    }
    
}
