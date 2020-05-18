import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Esta clase cmbiarte de JPEG A BMP 
 * @author Kevin
 *
 */
public class JPEGtoBMPImagem extends ImageHandler{
	File file_imagen;
	BufferedImage imagenBuffer = null;

	public JPEGtoBMPImagem(String filename) {
		super(filename);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void readFile() throws Exception {
		try{
		 file_imagen = new File(this.getFileName());
			imagenBuffer = ImageIO.read(file_imagen);
			
		}catch(Exception e){
			System.out.print("no se encotro el archivo");
		}
		
		
	}

	@Override
	public void generateFiles() throws Exception {
		File carpetaResultados = new File("Resultados");
		carpetaResultados.mkdir();
		String remplazado = file_imagen.getName().replace(".jpg","");
		ImageIO.write( imagenBuffer, "bmp",new File(carpetaResultados.getAbsolutePath()+"/"+"converted-"+remplazado+".bmp"));
	}

}
