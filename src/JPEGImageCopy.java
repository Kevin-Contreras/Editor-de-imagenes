import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;



/**
 * crea la copia de la imagen que se esta procesando en el programa.
 * @author Kevin
 *
 */
public class JPEGImageCopy extends ImageHandler {
	String remplazado;
	File file_imagen;
	BufferedImage imagenBuffers;
JPEGHandler f = new JPEGHandler();
/**
 * es el constructor de la clase donde se ejecuta la palabra super, se ejecutara el constructor de ImageHandler.
 * @param imagename nombre de la imagen
 */
	public JPEGImageCopy(String imagename) {
		super(imagename);
		

	}

	@Override
	public void readFile() throws Exception {
		try{
			  file_imagen = new File(this.getFileName());
				 imagenBuffers = ImageIO.read(file_imagen);
				
				
				
			}catch(Exception e){
				
				System.out.print("no se encotro el archivo");
				
			}
		
	}

	@Override
	public void generateFiles() throws Exception {
		File carpetaResultados = new File("Resultados");

		carpetaResultados.mkdir();
		try{
		remplazado = file_imagen.getName().replace(".jpg","");
		  ImageIO.write( imagenBuffers, "bmp",new File(remplazado+"TemporalBmp"+".bmp"));
		  //ESTA ES LA PARTE DONDE COPIA EL .BMP CON LA CLASE BmpHandlerCopy.
		  ImageHandler l = new BmpHandlerCopy(remplazado+"TemporalBmp"+".bmp");
			JPEGHandler.runHandler(l);
			//------------------------------------------------------
			 File file_imagenm = new File("copy-"+remplazado+"TemporalBmp"+".bmp");
			 System.out.println(file_imagenm.getAbsolutePath());
			 BufferedImage imagenBuffersy = ImageIO.read(file_imagenm);
			 String quitar = file_imagenm.getName().replace(".bmp","");
			 ImageIO.write(imagenBuffersy, "jpg",new File(carpetaResultados.getAbsolutePath()+"/"+"copy-"+remplazado+".jpg"));
			
		}catch(Exception e){
			
		}
		
			 
	}

	
	
	


}
