import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Esta clase cambia de color a todas las imaganes
 * @author Kevin
 *
 */
public class JPEGImageHandlerColors extends ImageHandler {
	/**
	 * combierte la imagen a bytes para poder manipularlas
	 */
	BufferedImage imagenBuffers;
	/**
	 * nombre de la imagen
	 */
String d;
	public JPEGImageHandlerColors(String filename,String nombre) {
		super(filename);
		d = nombre;
	}

	@Override
	public void readFile() throws Exception {
		File file= new File (this.getFileName());
		imagenBuffers = ImageIO.read(file);
		
	}

	@Override
	public void generateFiles() throws Exception {
		File carpeta = new File("Temporal");
		carpeta.mkdir();
		String nuevaRutaColores =  carpeta.getAbsolutePath()+"/"+d+"-colores"+".bmp";
		 ImageIO.write( imagenBuffers, "bmp",new File(nuevaRutaColores));
		 Colores color = new Colores(nuevaRutaColores, d);
		
	}

}
