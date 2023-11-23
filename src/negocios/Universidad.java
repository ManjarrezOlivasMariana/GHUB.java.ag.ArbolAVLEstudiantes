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
	public void agregar_elementos(int id, String nombre) throws Exception {
		
		abo.insertar(new Estudiante(id, nombre));
		
	}
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @throws Exception
	 */
	public void eliminar_elementos(int id, String nombre) throws Exception{
		abo.eliminar(new Estudiante(id, nombre));
		
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
	public void recorrer_elementos() {
		System.out.print("\nPreOrden:");
		abo.preorden();
		System.out.print("\nInOrden:");
		abo.inorden();
		System.out.print("\nPostOrden:");
		abo.postorden();
		System.out.print("\nNiveles:");
		
		System.out.print("\nJerárquico:\n");
		BTreePrinter.printNode(abo.getRaiz());
		
	}
	
	
}
		
	
	





