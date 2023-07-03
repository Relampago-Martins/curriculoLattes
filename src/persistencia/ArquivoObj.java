package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entidades.App;


/**
 * Classe que define o comportamento de um gerenciador de IO
 */
public class ArquivoObj extends Arquivo{

    public ArquivoObj(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public void dumpData(App data){
        try{
            ObjectOutputStream objOutput = new ObjectOutputStream( new FileOutputStream(this.nomeArquivo) );

            objOutput.writeObject(data);

            objOutput.flush();
            objOutput.close();

        } catch (Exception e){
            handleExceptions(e);
        }
    }

    public App loadData(){
        App data = new App();
        try{
            ObjectInputStream objInput = new ObjectInputStream( new FileInputStream(this.nomeArquivo) );
            
            data = (App) objInput.readObject();

            objInput.close();
        } catch (Exception e){
            handleExceptions(e);
        }
        return data;
    }

} 