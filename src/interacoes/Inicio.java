package interacoes;

public class Inicio {
	
	public static void main(String[] args){
		InterfaceDeUsuario menu =  new InterfaceDeUsuario();
		System.out.print("----------------------------------------\n");
		System.out.print(" Iniciando Sistema de Curriculos Lattes\n");
		System.out.print("----------------------------------------\n");
		menu.rodarMenuPrincipal();
	}
}