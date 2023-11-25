package negocios;
import datos.ArbolAVL;
import datos.Estudiante;
import datos.BTreePrinter;


public class Universidad {
	ArbolAVL abo = new ArbolAVL();
	
	public Universidad() {
		
		
	}
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @throws Exception
	 */
	public boolean agregar_elementos(int id, String nombre) throws Exception {
		try {
		
		   abo.insertar(new Estudiante(id, nombre));
		   return true;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @throws Exception
	 */
	public boolean eliminar_elementos(int id, String nombre) throws Exception{
		try {
		   abo.eliminar(new Estudiante(id, nombre));
		   return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 
	 * @param valor elemento buscado
	 * @return si el elemento buscado existe, regresa true
	 *       en caso contrario regresa false
	 */
	public boolean buscar_elementos(int id, String nombre) throws Exception{
		if (abo.buscar(new Estudiante(id, nombre)) != null)
			return true;
		else return false;
		
	}
	public boolean recorrer_elementos() throws Exception{
		try {
			System.out.print("\nPreOrden:");
			abo.preorden();
			System.out.print("\nInOrden:");
			abo.inorden();
			System.out.print("\nPostOrden:");
			abo.postorden();
			System.out.print("\nNiveles:");
			
			System.out.print("\nJerárquico:\n");
			BTreePrinter.printNode(abo.getRaiz());
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}