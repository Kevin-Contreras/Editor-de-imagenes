import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Esta clase selecciona la imagen que se usara en el programa
 * @author Kevin
 *
 */
public class SeleccionarImagen {
	// SE CREA UN OBJECTO EDITOR PARA ShowOpenDialog
Editor editor = new  Editor();
/**
 * Abre la ventana de archivos y al seleccionar los archivos se obtienen los nombres de los archivos
 * @return una cadena de texto con la ruta de la imagen.
 */
public Object Imagen (){
	//FILTRO DE LA IMAGEN QUE ES LO QUE SE VA A EXPORTAR
	FileNameExtensionFilter filtro = new FileNameExtensionFilter("solo bmp y jpeg","bmp","jpg");
	//SE CREA EL OBJECTO PARA ABRIR LA VENTANA
	JFileChooser fc = new JFileChooser();
	//SE LE APLICA EL FILTRO A LA VENTANA
	fc.setFileFilter(filtro);
	//CUANTAS IMAGENES SELECCIONAREMOS EN ESTE CASO UNA.
	fc.setMultiSelectionEnabled(false);
	//SE ABRIRA LA VENTANA
	int ventana =	fc.showOpenDialog(editor.frame);
	if(ventana == JFileChooser.APPROVE_OPTION){
		 File imagenObtenida = fc.getSelectedFile();
		 return imagenObtenida;
		 
	}else{
		return "LA IMAGEN NO ESTA SELECCIONADA";
	}
	
	} 
}
