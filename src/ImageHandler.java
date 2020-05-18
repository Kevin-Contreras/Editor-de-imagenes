/* NO CAMBIE EL CODIGO DE ESTA CLASE */

import java.io.*;

/**
*	Defines general characteristics of an Image Handler object.
* 	Image Handlers are capable of reading bytes of an file, and also generate files.
*	Abstract class ImageHandler should be inherit by any ImageHandler used for this project.
*
*   @author Jorge Daniel Monterroso Nowell - @jorged104
*	@version 1.0
**/
public abstract class ImageHandler {
    
	/* NO CAMBIE ESTE CODIGO */
	/**
	*	Represents the file name of the original file being handled by this class
	**/
	protected String handledFileName;
	
	/**
	*	Builds and returns an ImageHandler subclass type object which handles the file 
	* 	represented by the given name
	*	@param filename Name of the original file being handled by this object
	**/
	public ImageHandler(String filename) {
		this.handledFileName = filename;
	}

	/**
	*	Retorna el nombre de el archivo original siempre handled sea un objecto 
	*	@return El archivo original.
	**/
	public final String getFileName() {
		return this.handledFileName;
	}

	/**
	*	regresa el archivo en bytes
	**/
	public abstract void readFile() throws Exception;

	/**
	*	genera todos los archivos y los coloca en la carpeta que sea indicada
	* 	esta clase es una subclase de  ImageHandler
	**/
	public abstract void generateFiles() throws Exception;
}