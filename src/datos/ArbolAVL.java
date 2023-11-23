package datos;



/**
 * Representa un árbol binario ordenado. Tiene las operaciones
 * básicas: insertar, eliminar, buscar y recorridos
 */

public class ArbolAVL  {
	/**
	 * Raiz del arbol
	 */
	private Nodo raiz;
	
	/**
	 * Constructor por defecto
	 */
	
	public ArbolAVL() {
		raiz = null;
	}
	public Nodo getRaiz() {
		return raiz;
	}
	
	/**
	 * ROTACIONES
	 * @param n
	 * @param n1
	 * @return
	 */
	
	private Nodo rotacionII(Nodo n, Nodo n1) {
		//Coloque aquí el código faltante
	}
	
	
	/**
	 * Rotación simple:derecha-derecha
	 * @param n referencia al nodo problema con fe +2
	 * @param n1 referencia al nodo de su rama derecha
	 * @return
	 */
	
	private Nodo rotacionDD(Nodo n, Nodo n1) {
		//coloque código faltante
		
		
	}
	
	
	/**
	 * Rotación doble:derecha-derecha
	 * @param n referencia al nodo problema con fe -2
	 * @param n1 referencia al nodo de su rama izquierda
	 * @return
	 */
	
	private Nodo rotacionID(Nodo n, Nodo n1) {
		//Coloque código faltante
		
	}
	
	
	/**
	 * Rotación doble:derecha-izquierda
	 * @param n referencia al nodo problema con fe -2
	 * @param n1 referencia al nodo de su rama izquierda
	 * @return
	 */
	
	private Nodo rotacionDI(Nodo n, Nodo n1) {
		//Coloque código faltante
		
	}
	
	
	
		//Implementación recursiva de los recorridos
		/**
		 * Invoca al método recursivo
		 */
		public void preorden() {
			preorden(raiz);
		}
		/**
		 * 
		 * @param aux
		 */
		private void preorden(Nodo aux) {
			if(aux !=null) {
				visitar(aux);
				preorden(aux.getIzquierdo());
				preorden(aux.getDerecho());
			}
		}
		private void visitar(Nodo aux) {
			System.out.print(aux.getValor()+" ");
		}
		/**
		 * Invoca al método recursivo
		 */
		public void inorden() {
			inorden(raiz);
		}
		/**
		 * 
		 * @param aux referencia a un nodo
		 */
		private void inorden(Nodo aux) {
			if(aux !=null) {
				inorden(aux.getIzquierdo());
				visitar(aux);
				inorden(aux.getDerecho());
			}
		}
		/**
		 * Invoca al método recursivo
		 */
		public void postorden() {
			postorden(raiz);
		}
		/**
		 * 
		 * @param aux referencia a un nodo
		 */
		
		private void postorden(Nodo aux) {
			if(aux !=null) {
				postorden(aux.getIzquierdo());
				postorden(aux.getDerecho());
				visitar(aux);
			}
			
			
		}
		
		
		
		
		
		
		

	
	/**
	 * Inserta un nodo en el árbol binario version Iterativa
	 * @param valor
	 * @throws Exception
	 * Pendiente de modificar
	 */
	
	public void insertar2(Object valor) throws Exception{
		Comparable dato = (Comparable) valor;
		Nodo nuevo = new Nodo();
		nuevo.setValor(dato);
		
		if(raiz==null)
			raiz=nuevo;
		else {
			//anterior: referencia al padre de aux
			Nodo anterior = null;
			//aux: auxiliar para recorrer los nodos, desde la raiz
			Nodo aux = raiz;
			while (aux!=null) {
				anterior = aux;
				if(dato.esMenor(aux.getValor()))
					aux = aux.getIzquierdo();
				else if (dato.esMayor(aux.getValor()))
					aux = aux.getDerecho();
				else
					throw new Exception("Dato duplicado");
				
			}
			if(dato.esMenor(anterior.getValor()))
				anterior.setIzquierdo(nuevo);
			else
				anterior.setDerecho(nuevo);
			
			
		}
		
		
	}
	/**
	 * versión recursiva
	 * Inserta un elemento en el arvol AVL, llama al método
	 * recursivo insertarAVL
	 * @param valor a insertar
	 * @throws Exception
	 */
	public void insertar(Object valor) throws Exception{
		Comparable dato = (Comparable) valor;
		Logical h = new Logical(false);//intercambio un valor booleano
		raiz = insertarAVL(raiz,dato,h);
	}
	/**
	 * Método Recursivo
	 * @param raizSub
	 * @param dato
	 * @param h
	 * @return Nodo
	 * @throws Exception
	 */
	private Nodo insertarAVL(Nodo raiz, Comparable dt, Logical h) throws Exception{
		Nodo n1;
		if (raiz == null) {
			//Caso Base, termina la recursividad
			raiz = new Nodo(dt);
			h.setLogical(true);
		}
		else if(dt.esMenor(raiz.getValor())) {
				Nodo iz = insertarAVL(raiz.getIzquierdo(),dt,h);
				raiz.setIzquierdo(iz);
				//Regreso por los nodos del camino de búsqueda
				if(h.booleanValue()) {
					//decrementa el fe por aumentar la altura de rama izquierda
					switch(raiz.getFe()) {
					case 1:
						raiz.setFe(0);
						h.setLogical(false);
						break;
					case 0:
						raiz.setFe(-1);
						break;
					case -1: //Aplicar la rotación a la izquierda
						n1=(Nodo)raiz.getIzquierdo();
						if(n1.getFe()==-1)
							raiz=rotacionII(raiz,n1);
						else
							raiz=rotacionID(raiz,n1);
						h.setLogical(false);
						
					}
				}
			}
		    else if(dt.esMayor(raiz.getValor())) {
				Nodo dr = insertarAVL(raiz.getDerecho(),dt,h);
				raiz.setDerecho(dr);
				//Regreso por los nodos del camino de búsqueda
				if(h.booleanValue()) {
					//decrementa el fe por aumentar la altura de rama derecha
					switch(raiz.getFe()) {
					case 1: //Aplicar rotación a la derecha
						n1=(Nodo)raiz.getDerecho();
						if(n1.getFe()==+1)
							raiz=rotacionDD(raiz,n1);
						else
							raiz=rotacionDI(raiz,n1);
						h.setLogical(false);
						break;							
					case 0:
						raiz.setFe(+1);
						break;
					case -1: 
						raiz.setFe(0);
						h.setLogical(false);							
							
					}
				}
			}
		    else 
				//Dato duplicado
					throw new Exception("Nodo Duplicado");
		return raiz;
	}
	
	/**
	 *  Version iterativa
	 * @param valor a buscar
	 * @return Nodo buscado o Null si no lo encuentra
	 */
	public Nodo buscar(Object valor) {
		Comparable dato = (Comparable)valor;
		if(raiz ==null)
			return raiz;
		else {
			//aux: auxiliar que va recorriendo los nodos, desde la raiz
			Nodo aux = raiz;
			while (aux !=null) {
				if(dato.esIgual(aux.getValor()))
					return aux;
				if(dato.esMenor(aux.getValor()))
					aux = aux.getIzquierdo();
				else
					aux = aux.getDerecho();
			}
			return null;
		}
		
	}
	
	/**
	 * Version Recursiva
	 * @param Elemento Buscado
	 * @return Nodo si lo encuentra y si no Null
	 */
	public Nodo buscar2(Object buscado) {
		Comparable dato = (Comparable)buscado;
		if (raiz ==null)
			return null;
		else
			return localizar(raiz, dato);
	}
	
	public Nodo localizar(Nodo raizSub, Comparable buscado) {
		if (raizSub ==null)
			return null;
		else if(buscado.esIgual(raizSub.getValor()))
			return raizSub;
		else if(buscado.esMenor(raizSub.getValor()))
			return localizar(raizSub.getIzquierdo(),buscado);
		else
			return localizar(raizSub.getDerecho(),buscado);
	}
	/**
	 * 
	 * @param valor a eliminar
	 * @throws Exception
	 */
	public void eliminar(Object valor) throws Exception{
		Comparable dato;
		dato = (Comparable) valor;
		Logical flag = new Logical(false);
		raiz = borrarAVL(raiz,dato,flag);
		
	}
	/**
	 * 
	 * @param r Nodo raiz
	 * @param clave elemento a borrar
	 * @param cambioAltura tipo Logical
	 * @return 
	 * @throws Exception
	 */
	
	public Nodo borrarAVL(Nodo r, Comparable clave, Logical cambioAltura) 
			throws Exception{
		//Coloque código faltante
	}
		
	/**
	 * Reemplaza el nodo a eliminar por el nodo mas a la izquierda
	 * del hijo derecho
	 * @param n nodo a reemplazar
	 * @param act dato a actualizar
	 * @param cambioAltura
	 * @return
	 */
	
	private Nodo reemplazar(Nodo n, Nodo act,Logical cambioAltura)  {
		
		if(act.getDerecho()!=null) {
			Nodo d;
			
			d = reemplazar(n,(Nodo)act.getDerecho(),cambioAltura);
			
			act.setDerecho(d);
			if(cambioAltura.booleanValue())
				act=equilibrar2(act,cambioAltura);
		}else {

			n.setValor(act.getValor());
			n=act;
			act=(Nodo)act.getIzquierdo();
			n=null;
			cambioAltura.setLogical(true);
		}
		return act;
		
	}
	
	/**
	 * Equilibrar el arbol
	 * @param n
	 * @param cambioAltura
	 * @return
	 */
	private Nodo equilibrar1(Nodo n,Logical cambioAltura)  {
		//Coloque código faltante
		
	}
	
	/**
	 * Equilibrar el arbol
	 * @param n
	 * @return
	 */
	
	private Nodo equilibrar2(Nodo n, Logical cambioAltura) {
		//Coloque código faltante
		
	}



}
