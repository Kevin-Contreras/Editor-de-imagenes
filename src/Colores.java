import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ejecuta los metodos de los colores verde azul rojo y sepia.
 * @author Kevin
 *
 */
public class Colores {
	BufferedImage imagen;
	Color [][] matriz;
	BufferedImage salida;
	Color nuevo;
	File carpetaResultados = new File("Resultados");
	/**
	 * Contructor que ejecuta la clase colores
	 * @param url le pasa el directorio donde se encuentra la imagen
	 * @param nombres le pasa el nombre de la imagen
	 * @throws IOException si no se ha encontrado el archivo arrojara un error de archivo no encontrado
	 */
public Colores (String url,String nombres ) throws IOException{
	 try {
		imagen = ImageIO.read(new File(url));
		matriz = new Color [imagen.getHeight()][imagen.getWidth()];
		for(int i=0; i<imagen.getHeight();i++){
			for(int k =0; k<imagen.getWidth();++k){
				matriz[i][k]= new Color( imagen.getRGB(k, i));
				
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		carpetaResultados.mkdir();

	azul(nombres);
	rojo(nombres);
	verde(nombres);
	sepia(nombres);
}
/**
 * este metodo combierte el color de las imagenes a color azul.
 * @param url directorio donde se encuentra la imagen seleccionada.
 */
public void azul(String url){
	
		 salida = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
		for(int u=0; u<imagen.getHeight();u++){
			for(int h=0; h<imagen.getWidth();++h){
				Color pixel = matriz[u][h];
				int j = 255-pixel.getRed();
				int k = 255-pixel.getGreen();
				int p = 255-pixel.getBlue();
				salida.setRGB(h, u, new Color(0,0,pixel.getBlue()).getRGB());
			}
		}
		
		try {
			/**
			 *  la variable cadena toma el valor de la url pero sin la extencion jpeg.bmp
			 */
			String cadena = url.replace(".jpg.bmp","");
			ImageIO.write(salida, "jpg", new File(carpetaResultados.getAbsolutePath()+"/"+cadena+"-azul.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	

}
/**
 * este metodo combierte el color de las imagenes a color rojo.
 * @param url directorio donde se encuentra la imagen seleccionada.
 */
public void rojo(String url){
	 salida = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
		for(int u=0; u<imagen.getHeight();u++){
			for(int h=0; h<imagen.getWidth();++h){
				Color pixel = matriz[u][h];
				salida.setRGB(h, u, new Color(pixel.getRed(),0,0).getRGB());
			}
		}
		
		try {
			/**
			 *  la variable cadena toma el valor de la url pero sin la extencion jpeg.bmp
			 */
			String cadena = url.replace(".jpg.bmp","");
			ImageIO.write(salida, "jpg", new File(carpetaResultados.getAbsolutePath()+"/"+cadena+"-rojo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
/**
 * este metodo combierte el color de las imagenes a color rojo.
 * @param url directorio donde se encuentra la imagen seleccionada.
 */
public void verde(String url){
	salida = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
	for(int u=0; u<imagen.getHeight();u++){
		for(int h=0; h<imagen.getWidth();++h){
			Color pixel = matriz[u][h];
			salida.setRGB(h, u, new Color(0,pixel.getGreen(),0).getRGB());
		}
	}
	
	try {
		/**
		 *  la variable cadena toma el valor de la url pero sin la extencion jpeg.bmp
		 */
		String cadena = url.replace(".jpg.bmp","");
		ImageIO.write(salida, "jpg", new File(carpetaResultados.getAbsolutePath()+"/"+cadena+"-verde.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
/**
 * este metodo combierte el color de las imagenes a color rojo.
 * @param url directorio donde se encuentra la imagen seleccionada.
 */

public void sepia(String url){
	salida = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
	for(int u=0; u<imagen.getHeight();u++){
		for(int h=0; h<imagen.getWidth();++h){
			Color pixel = matriz[u][h];
			salida.setRGB(h, u, new Color(220,pixel.getGreen(),00).getRGB());
		}
	}
	
	try {
		/**
		 *  la variable cadena toma el valor de la url pero sin la extencion jpeg.bmp
		 */
		String cadena = url.replace(".jpg.bmp","");
		ImageIO.write(salida, "jpg", new File(carpetaResultados.getAbsolutePath()+"/"+cadena+"-sepia.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
