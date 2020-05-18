import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * crea la imagen en blanco y negro.
 * @author Kevin
 *
 */
public class JPEGImageHandlerBN extends ImageHandler {
	BufferedImage imagenBuffers;
	String d;
	public JPEGImageHandlerBN(String filename,String name) {
		super(filename);
		d=name;
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
		/**
		 * crea una carpeta temporal donde iran todos los archivos reciclados
		 */
		File carpeta = new File("Temporal");
		carpeta.mkdir();
		String nuevaRutaPosicion =  carpeta.getAbsolutePath()+"/"+d+"-negro"+".bmp";
		 ImageIO.write( imagenBuffers, "bmp",new File(nuevaRutaPosicion));
		 BlancoYnegro negro = new BlancoYnegro(nuevaRutaPosicion,d);
		// TODO Auto-generated method stub
		
	}

	

}
