package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;

import entidades.App;

/**
 * Classe que define o comportamento de um gerenciador de IO
 * e define alguns métodos para tratar exceções 
 */
public abstract class Arquivo {

    /**
     * Salva uma lista de objetos T em um arquivo indicado
     * Acessa o arquivo indicado e retorna uma lista de objetos T
     * @param nomeArquivo
     */
    protected String nomeArquivo;

    public abstract void dumpData(App data);

    public abstract App loadData();

    /**
     * Trata as exceções lançadas pelo sistema
     * @param error
     */
    public void handleExceptions(Exception error){
        try{
            throw error;
        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado.");
        } catch (SecurityException e){
            System.out.println("Sem permissão de acesso ao arquivo."+
            "Verifique as permissões de acesso ao arquivo.");
        } catch (IOException e){
            System.out.println("Erro ao ler arquivo.");
        } catch (Exception e){
            System.out.println("Erro desconhecido.");
        }
    }
    
}
