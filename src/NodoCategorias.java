import java.io.Serializable;


public class NodoCategorias implements Serializable{
	 private static final long serialVersionUID = 12345642197l;

	public String categoria;
	public NodoCategorias siguiente;
	public NodoCategorias anterior;
	public  NodoCategorias(){
		this.categoria =null;
		this.siguiente = null;
		this.anterior=null;
	}
	/*
	public NodoCategorias getAnterior(){
		return anterior;
	}
	public NodoCategorias getsiguiente(){
		return siguiente;
	}
	public String getValor(){
		return categoria;
	}
	public void SetAnterior(){
		this.anterior = anterior;
	}
	public void setSiguiente(){
		 this.siguiente=siguiente;
	}
	public void setValor(String categorias){
		this.categoria = categoria;
	}
*/
	
}

