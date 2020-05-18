import java.io.*;
public class Listas extends EstructuraDeDatos implements Serializable{
	 private static final long serialVersionUID = 1234567l;
	Nodo primero = new Nodo();
	Nodo ultimo = new Nodo();
	Nodo actual;
	Listas nombres;
	int contador =0;
	
public Listas(){
	nombres = null;
	primero = null;
	ultimo = null;
	
}

@Override
public  void add(Object e){
	 Nodo nuevo = new Nodo();
	 nuevo.dato= e;
	 if(primero==null){
		 primero = nuevo;
		 primero.siguiente=null;
		 ultimo = nuevo;
	 }else{
		 ultimo.siguiente = nuevo;
		 nuevo.siguiente = null;
		 ultimo = nuevo;
	 }
	 try {
			FileOutputStream fileOut = new FileOutputStream("guaradados.text");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(this);

			System.out.println("el nombre se guardo en  /desktop/guaradados.text");
			} catch (IOException i) {
			i.printStackTrace();
			}
contador++;
}

@Override
public Object find(Object e) {
	// TODO Auto-generated method stub
	Nodo actual = new Nodo();
	actual = primero;
	boolean encotrado = false;
	
	if(primero !=null){
		while(actual != null && encotrado!=true){
			if(actual.dato.equals(e) ){
				System.out.println("nodo con el dato "+ actual.dato +" encontrado");
				encotrado =true;	
			}
			actual=(Nodo) actual.siguiente;

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
		return primero.dato;
	}else{
		while(i==contador && i > contador ){
			contador--;
		 ultimo=(Nodo) ultimo.siguiente;
		
		}
		return primero.dato;
	}
	
}
@Override
public Object pop() {
	Nodo n = null;
	if(contador>0){
		n = ultimo;
		ultimo = null;
	}
	return n;
}
@Override
public void delete(Object e) {
	Nodo eliminar = new Nodo();
	eliminar = primero;
	boolean encontrado = false;
	while(eliminar != null && !encontrado){
		encontrado = (eliminar.dato==e);
		eliminar = (Nodo) eliminar.siguiente;
		if(!encontrado){
			if(eliminar == primero){
				primero = (Nodo) primero.siguiente;
			}else{
				primero.siguiente = primero;
			}
		}
		
	}	
}
@Override
public Object peek() {
	// TODO Auto-generated method stub
	return ultimo;
}

}
