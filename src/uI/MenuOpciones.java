package uI;

import java.util.Scanner;



import negocios.Universidad;


public class MenuOpciones {
	static Scanner entrada = new  Scanner(System.in);
	private Universidad univ = new Universidad();
	/**
	 * Agregar un elemento al árbol, validando que no exista
	 */
	public void agregar_elementos() {
		try {
			int id;
			String nombre;
			
			do {
				System.out.print("Introduce ID de nuevo Estudiante a insertar:");
				id = entrada.nextInt();
				System.out.print("Introduce Nombre de  nuevo Estudiante a insertar:");
				nombre=entrada.next();
				
			}while (univ.buscar_elementos(id,nombre));
			univ.agregar_elementos(id,nombre);
			System.out.println("Estudiante Insertado con éxito");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
	}
	/**
	 * Elimina un elemento del árbol validando que el elemento exista
	 */
	public void eliminar_elementos() {
		try {
			int id;
			String nombre;
			do {
				System.out.print("Introduce ID de Estudiante a eliminar:");
				id = entrada.nextInt();
				System.out.print("Introduce Nombre de Estudiante a eliminar:");
				nombre = entrada.next();
				
				
			} while (!univ.buscar_elementos(id,nombre));
		   univ.eliminar_elementos(id,nombre);
		   System.out.println("Estudiante Eliminado con éxito");
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	/**
	 * Busca un elemento en el árbol hasta terminar con 
	 */
	
	public void buscar_elementos() {
		try {
			int id;
			String nombre;
			
			System.out.print("Introduce ID de Estudiantes  a buscar:");
			id = entrada.nextInt();
			System.out.print("Introduce Nombre de Estudiantes  a buscar:");
			nombre = entrada.next();
			if (univ.buscar_elementos(id,nombre))
				System.out.println("El Estudiante con ID  "+id+" Existe");
			else
				System.out.println("El Estudiante con ID"+id+" NO Existe!");
				
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	public void recorrer_elementos() {
		univ.recorrer_elementos();
		
	}
	
	
	
}

	

	

