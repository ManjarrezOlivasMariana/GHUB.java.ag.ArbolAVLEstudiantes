package uI;
import java.util.Scanner;


public class Menu {
	static Scanner entrada = new  Scanner(System.in);
	
	static MenuOpciones  iOpc = new MenuOpciones();
	
	public void lectura() {
		imprimirMenu();			
	}
	private static void imprimirMenu()  {
		while (true) {
			System.out.println("\t************ MENU PRINCIPAL *************");
			System.out.println("\t*  1. Agregar Estudiantes               *");
			System.out.println("\t*  2. Eliminar Estudiantes              *");
			System.out.println("\t*  3. Buscar  Estudiantes               *");
			System.out.println("\t*  4. Mostrar Estudiantes               *");			
			System.out.println("\t*                                       *");
			System.out.println("\t* 99. Salir                             *");
			System.out.println("\t*****************************************");
			System.out.print("Seleccione opción ->");
			int opcion = entrada.nextInt();
			switch  (opcion) {
			case 1:
				iOpc.agregar_elementos();
				break;
			case 2:
				iOpc.eliminar_elementos();
				break;
			case 3:
				iOpc.buscar_elementos();
				break;
			case 4:
				iOpc.recorrer_elementos();
				break;
			
			case 99:
				salir();
				break;
			default:
				System.out.println("Opcion inválida");
					
			}
	   }
	}
	private static void salir() {
		System.out.println("Sesion Finalizada");
		System.out.println("Adios!");
		System.exit(0);
	}

}
	

	

