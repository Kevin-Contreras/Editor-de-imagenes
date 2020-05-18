import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class ListaCircular extends EstructuraDeDatos implements Serializable{
NodosCircular primero;
NodosCircular ultimo;
ListaCategorias nose;
int tamaño =0;
public ListaCircular(){
	primero = null;
	ultimo = null;
}
@Override
public void add(Object e) {
	
	NodosCircular nuevo = new NodosCircular();
	nuevo.imagen=(String)e;
	if(primero == null){
		primero = nuevo;
		primero.siguiente = primero;
		primero.atras=ultimo;
		ultimo = nuevo;
	}else{
		ultimo.siguiente = nuevo;
		nuevo.siguiente = primero;
		ultimo = nuevo;
		primero.atras = ultimo;
	}
	tamaño++;
	// TODO Auto-generated method stub
	
}
@Override
public Object peek() {
	// TODO Auto-generated method stub
	return ultimo;
}
@Override
public Object find(Object e) {
	NodosCircular actual = new NodosCircular();
	actual = primero;
	boolean encotrado = false;
	
	if(primero !=null){
		while(actual != null && encotrado!=true){
			if(actual.imagen.equals(e)){
				System.out.println("nodo con el dato "+ actual.imagen +" encontrado");
				encotrado =true;	
			}
			actual=(NodosCircular) actual.siguiente;

		}
		
		if(!encotrado){
			System.out.println("no encontro el dato hueco");
		}
	}
	else{
		System.out.println("la lista se encuentra vacia");
	}
	
	return encotrado;
	
}
@Override
public Object getNext() {
	// TODO Auto-generated method stub
	if(primero == null){
		return primero;
	}else{
		return primero.siguiente;
	}
}
@Override
public int getSize() {
	// TODO Auto-generated method stub
	return tamaño;
}
@Override
public Object get(int i) {
	// TODO Auto-generated method stub
	if(primero == null){
		return primero.imagen;
	}else{
		while(i==tamaño && i > tamaño ){
			tamaño--;
		 ultimo=(NodosCircular) ultimo.siguiente;
		
		}
		return primero.imagen;
	}
}
@Override
public Object pop() {
	NodosCircular n = null;
	if(tamaño>0){
		n = ultimo;
		ultimo = null;
	}
	return n;
}
@Override
public void delete(Object e) {
	NodosCircular eliminar = new NodosCircular();
	eliminar = primero;
	boolean encontrado = false;
	while(eliminar != null && !encontrado){
		encontrado = (eliminar.imagen==e);
		eliminar = eliminar.siguiente;
		if(!encontrado){
			if(eliminar == primero){
				primero = primero.siguiente;
			}else{
				primero.siguiente = primero;
			}
		}
		
	}	
}
}
