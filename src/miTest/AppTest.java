package miTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import datos.ArbolAVL;
import datos.Estudiante;

class AppTest {


	private ArbolAVL abo = new ArbolAVL();
	
	
	@Test
	public void test_agregarElementos() throws Exception {
		
		abo.insertar(new Estudiante(12345, "Ana"));
		abo.insertar(new Estudiante(12346, "Cecilia"));
		abo.insertar(new Estudiante(12341, "Bertha"));
		
	}
	
	@Test
	public void test_eliminarElementos() throws Exception {
		abo.insertar(new Estudiante(12345, "Ana"));
		abo.eliminar(new Estudiante(12345,"Ana"));
		
	}
	
	@Test
	public void test_buscarElementos() {
		abo.buscar(new Estudiante(12345,"Ana"));
		abo.buscar(new Estudiante(12346, "Cecilia"));
		
	}
	
	@Test
	public void test_recorrerElementos() {
		abo.postorden();
		abo.inorden();
		abo.preorden();
		
		
	}

	

}
