import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * rota las imagenes seleccionadas horizontal o vertical.
 * @author Kevin
 *
 */
public class JPEGImageHandlerRotator extends ImageHandler{
	/**
	 * combierte la imagen a bytes para poder manipularlas
	 */
	BufferedImage imagenBuffers;
	/**
	 * nombre de la imagen
	 */
	String d;

	public JPEGImageHandlerRotator(String filename,String name) {
		super(filename);
		d = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readFile() throws Exception {
		File file= new File (this.getFileName());
		imagenBuffers = ImageIO.read(file);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateFiles() throws Exception {
		File carpeta = new File("Temporal");
		carpeta.mkdir();
		String nuevaRutaPosicion =  carpeta.getAbsolutePath()+"/"+d+"-horizontal80"+".bmp";
		 ImageIO.write( imagenBuffers, "bmp",new File(nuevaRutaPosicion));
		 HorizontalVertical Posicion = new HorizontalVertical(nuevaRutaPosicion,d);
		// TODO Auto-generated method stub
		
	}

}
