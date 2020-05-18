import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * la clase ejecuta el convertidor para modificar la imagen a horizontal y vertical
 * @author Kevin
 *
 */
public class HorizontalVertical {
	/**
	 * convierte la imagen en bytes para poder modificar la imagen
	 */
	BufferedImage imagen;
	/**
	 * retorna los bytes ya modificados
	 */
	BufferedImage salida;
/**
 *  matriz donde se guardan los bytes no modificados
 */
	Color [][] matriz;
	/**
	 * matriz donde se guardan los bytes modificados de forma horizontal
	 */
	Color [][] horizontal;
	/**
	 * matriz donde se guardan los bytes modificados de forma vertical
	 */
	Color [][] vertical;
	Color [][] matrizvertical;
	File carpetaResultados = new File("Resultados");
	/**
	 * El costructor lee la imagen obtiene el ancho y el largo de la imagen y se coloca en una matriz.
	 * de tipo Color 
	 * @param ruta direccion donde se encuentra la imagen.
	 * @param name nombre de la imagen.
	 */
	public HorizontalVertical(String ruta,String name){
		try {
			imagen = ImageIO.read(new File(ruta));
			matriz = new Color [imagen.getHeight()][imagen.getWidth()];
			matrizvertical = new Color [imagen.getWidth()][imagen.getHeight()];
			horizontal = new Color [imagen.getHeight()][imagen.getWidth()];

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carpetaResultados.mkdir();
		horizontal(ruta,name);
		vertical(ruta,name);
	}
	/**
	 *  Este metodo convierte la imagen a horizontal utilizando un dos for añidados para recorrer las matrices .
	 * @param ruta direccion donde se encuentra la imagen.
	 * @param name nombre de la imagen.
	 */
	public void horizontal (String ruta,String name){
		for(int i =0; i<imagen.getHeight(); ++i){
			for(int k =0; k<imagen.getWidth();++k){
				matriz[i][k] = new Color( imagen.getRGB(k,i ));
			}
		}
		//------------------------ INVERSA HORIZONTAL ------------------------
		 salida = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		for(int i =0; i<imagen.getHeight(); ++i){
			for(int k =0; k<imagen.getWidth();++k){
				horizontal[i][k] = matriz[i][imagen.getWidth()-k-1];
				salida.setRGB(k, i, horizontal[i][k].getRGB());
			}
			
		}
		 try {
				String cadena = name.replace(".jpg.bmp","");
				ImageIO.write(salida, "jpg", new File(carpetaResultados.getAbsolutePath()+"/"+cadena+"-Vertical.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 *  Este metodo convierte la imagen a vertical utilizando un dos for añidados para recorrer las matrices .
	 * @param ruta direccion donde se encuentra la imagen.
	 * @param name nombre de la imagen.
	 */
	public void vertical(String ruta,String name){
		for(int i =0; i<imagen.getHeight(); ++i){
			for(int k =0; k<imagen.getWidth();++k){
				matriz[i][k] = new Color( imagen.getRGB(k,i ));
			}
		}
		//------------------------ INVERSA HORIZONTAL ------------------------
		 salida = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		for(int i =0; i<imagen.getHeight(); ++i){
			for(int k =0; k<imagen.getWidth();++k){
				horizontal[i][k] = matriz[imagen.getHeight()-i-1][imagen.getWidth()-k-1];
				salida.setRGB(k, i, horizontal[i][k].getRGB());
			}
			
		}
		 try {
				String cadena = name.replace(".jpg.bmp","");
				ImageIO.write(salida, "jpg", new File(carpetaResultados.getAbsolutePath()+"/"+cadena+"-Horizontal.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
