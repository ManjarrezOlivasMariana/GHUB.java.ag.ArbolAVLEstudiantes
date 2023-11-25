package miTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import negocios.Universidad;

class AppTest {


	//private ArbolAVL abo = new ArbolAVL();
	private Universidad univ = new Universidad();
	
	
	@Test
	public void test_agregarElementos() throws Exception {
		boolean condicion=univ.agregar_elementos(12345, "Ana");
		assertTrue(condicion, "Elemento agregado con éxito");
		
	}
	
	@Test
	public void test_eliminarElementos() throws Exception {
		univ.agregar_elementos(12345, "Ana");
		boolean condicion=univ.eliminar_elementos(12345,"Ana");
		assertTrue(condicion, "Elemento eliminado con éxito");
		
		condicion=univ.eliminar_elementos(12344,"Bertha");
		assertFalse(condicion," Elemento no fue eliminado");
		
	}
	
	@Test
	public void test_buscarElementos() throws Exception {
		
		univ.agregar_elementos(12345, "Ana");
		boolean condicion = univ.buscar_elementos(12345,"Ana");
		assertTrue(condicion, "Elemento encontrado");
		
		univ.eliminar_elementos(12345,"Ana");
		condicion = univ.buscar_elementos(12345,"Ana");
		assertFalse(condicion," Elemento no encontradp");
		
	}
	
	@Test
	public void test_recorrerElementos() throws Exception {
		boolean condicion = univ.recorrer_elementos();
		assertTrue(condicion, "Recorrido exitoso");
		assertFalse(condicion, "Recorrido fallido");
		
	}

	

}
