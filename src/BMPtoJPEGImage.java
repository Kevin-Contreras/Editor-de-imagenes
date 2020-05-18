import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;
/**
 * ESTA CLASE HEREDA DE IMAGEHANDLER Y TODOS SUS METODOS
 * @author Kevin
 *
 */

public class BMPtoJPEGImage extends ImageHandler{
	File file_imagen;
	BufferedImage imagenBuffer = null;
	public BMPtoJPEGImage(String filename) {
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
		String remplazado = file_imagen.getName().replace(".bmp","");
		ImageIO.write( imagenBuffer, "jpg",new File(carpetaResultados.getAbsolutePath()+"/"+"converted-"+remplazado+".jpg"));
	}

}
