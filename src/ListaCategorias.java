import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ListaCategorias extends EstructuraDeDatos implements Serializable{
	 private static final long serialVersionUID = 1234567217l;

 NodoCategorias primero;
 NodoCategorias ultimo;
 int contador =0;
 ListaCategorias siguiente;
public ListaCategorias(){
	primero = ultimo = null;
	
	
	
}


@Override
public void add(Object e) {
NodoCategorias nuevos = new NodoCategorias();

	nuevos.categoria=(String) e;

if(primero==null){
	primero = nuevos;
	ultimo = nuevos;
	}else{
			ultimo.siguiente = nuevos;
			nuevos.anterior = ultimo;
			nuevos.siguiente=null;
			ultimo = nuevos;
	}
contador++;
}



@Override
public Object peek() {
	// TODO Auto-generated method stub
	return ultimo;
}
@Override
public Object find(Object e) {
	// TODO Auto-generated method stub
	NodoCategorias actual = new NodoCategorias();
	actual = primero;
	boolean encotrado = false;
	
	if(primero !=null){
		while(actual != null && encotrado!=true){
			if(actual.categoria.equals(e) ){
				System.out.println("nodo con el dato "+ actual.categoria +" encontrado");
				encotrado =true;	
			}
			actual=(NodoCategorias) actual.siguiente;

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
	return contador;
}
@Override
public Object get(int i) {
	if(primero == null){
		return primero.categoria;
	}else{
		while(i==contador && i > contador ){
			contador--;
		 ultimo=(NodoCategorias) ultimo.siguiente;
		
		}
		return primero.categoria;
	}}
@Override
public Object pop() {
	NodoCategorias n = null;
	if(contador>0){
		n = ultimo;
		ultimo = null;
	}
	return n;
}
@Override
public void delete(Object e) {
	NodoCategorias eliminar = new NodoCategorias();
	eliminar = primero;
	boolean encontrado = false;
	while(eliminar != null && !encontrado){
		encontrado = (eliminar.categoria==e);
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

