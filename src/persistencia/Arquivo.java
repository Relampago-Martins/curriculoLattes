package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entidades.Pesquisador;


/**
 * Classe que define o comportamento de um gerenciador de IO
 */
public class Arquivo extends IOManager{
    /**
     * Salva uma lista de Pesquisadores em um arquivo de persistencia de dados
     * @param pesquisadores
     */
    public void dumpClientes(List<Pesquisador> pesquisadores){
        try{
            ObjectOutputStream objOutput = new ObjectOutputStream( new FileOutputStream("pesquisadores.obj") );

            objOutput.writeObject(pesquisadores);

            objOutput.flush();
            objOutput.close();

        } catch (Exception e){
            handleExceptions(e);
        }
    }

    /**
     * Carrega uma lista de Pesquisadores de um arquivo de persistencia de dados
     * para a memoria
     * @return List<Pesquisador>
     */
    public List<Pesquisador> loadClientes(){
        List<Pesquisador> pesquisadores = new ArrayList<>();
        try{
            ObjectInputStream objInput = new ObjectInputStream( new FileInputStream("pesquisadores.obj") );
            
            pesquisadores = (List<Pesquisador>) objInput.readObject();

            objInput.close();
        } catch (Exception e){
            handleExceptions(e);
        }
        return pesquisadores;
    }

} 