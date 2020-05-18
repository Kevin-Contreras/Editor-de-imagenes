import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ESTA CLASE GENERA LAS IMAGENES BLANCO Y NEGRO 
 * @author Kevin 
 *
 */
public class BlancoYnegro {
	/**
	 *  ESTA MATRIZ GUARDA LOS BITZ DE COLOR ROJO.
	 */
	int [][] R;
	/**
	 *  ESTA MATRIZ GUARDA LOS BITZ DE COLOR VERDE.
	 */
	int [][] G;
	/**
	 *  ESTA MATRIZ GUARDA LOS BITZ DE COLOR AZUL.
	 */
	int [][] B;
	/**
	 * ESTA MATRIZ GUARDA LOS DATOS YA TRANSFORMADOS A COLOR GRIZ
	 */
	Color [][] gris;
	int grises;
	BufferedImage imagenGris;
	BufferedImage salidaGris;

/**
 * EL CONSTRUCTOR EJECUTA LA CLASE BLANCOYNEGRO
 * @param urls direccion de la imagen(ruta)
 * @param names nombre de la imagen que se esta procesando.
 */
 public BlancoYnegro(String urls,String names){
	 try {
		imagenGris = ImageIO.read(new File(urls));
		R = new int [imagenGris.getHeight()][imagenGris.getWidth()];
		G = new int [imagenGris.getHeight()][imagenGris.getWidth()];
		B = new int [imagenGris.getHeight()][imagenGris.getWidth()];
		gris = new Color [imagenGris.getHeight()][imagenGris.getWidth()];
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 grises(names);
 }
 /**
  * procesa las imagenes de color a blanco y negro.
  * @param names el nombre de la imagen
  */
 public void grises (String names){
	 salidaGris = new BufferedImage(imagenGris.getWidth(), imagenGris.getHeight(), BufferedImage.TYPE_INT_RGB);
	 for(int i =0; i<imagenGris.getHeight();i++){
		 for(int k=0; k<imagenGris.getWidth();++k){
			 Color pixel = new Color(imagenGris.getRGB(k, i));
			int R  = (int) (0.3*pixel.getRed());
			int G  = (int) (0.587*pixel.getGreen());
			int B = (int) (pixel.getBlue()* 0.114);

			 
			 gris[i][k]= new Color( R +G+B,R +G+B,R +G+B);
			 salidaGris.setRGB(k, i, new Color(gris[i][k].getRed(),gris[i][k].getGreen(),gris[i][k].getBlue()).getRGB());
			 
		 }
		
		 
	 }
	 try {
		 File carpetaResultados = new File("Resultados");
			carpetaResultados.mkdir();
			String cadenad = names.replace(".jpg.bmp","");
			ImageIO.write(salidaGris, "jpg", new File(carpetaResultados.getAbsolutePath()+"/"+cadenad+"-blanco.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
}
