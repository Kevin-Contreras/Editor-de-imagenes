import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;










import java.awt.Component;

import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * la clase editor es la clase interface del proyecto de cambiar imagenes
 * @author Kevin
 *
 */
public class Editor {
	//VARIABLES GLOBALES
	/**
	 * la variable capturarImagen captura la imagen que sera procesa en el programa.
	 */
	File capturarImagen;
	/**
	 * inicializa la interface 
	 */
	 JFrame frame;
	
	
	/**
	 * El constructor Editor ejecuta al metodo initialize.
	 */
	public Editor() {
		initialize();
		
	}

	/**
	 * Inicializa el frame de la aplicacion java.
	 */
	
	private void initialize() {
		//VARIABLES
		frame = new JFrame();
		frame.setBounds(100, 100, 529, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 503, 367);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel tituloImagen = new JLabel("No hay Imagen seleccionada");
		tituloImagen.setBounds(65, 11, 393, 34);
		panel.add(tituloImagen);
		
		JButton btnNewButton = new JButton("EJECUTAR");
	
		btnNewButton.setBounds(35, 300, 170, 39);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 56, 223, 218);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton JPENGBMP = new JRadioButton("JPEG A BMP y viceversa");

		JPENGBMP.setBounds(37, 7, 174, 23);
		panel_1.add(JPENGBMP);
		
		JRadioButton rdbtnCopia = new JRadioButton("Copia JPEG");
		rdbtnCopia.setBounds(37, 47, 137, 23);
		panel_1.add(rdbtnCopia);
		
		JRadioButton rdbtnRojoAzul = new JRadioButton("Rojo Verde Azul Sepia");
		rdbtnRojoAzul.setBounds(37, 88, 158, 23);
		panel_1.add(rdbtnRojoAzul);
		
		JRadioButton rdbtnModificarImagen = new JRadioButton("Modificar Imagen");
		rdbtnModificarImagen.setBounds(37, 130, 158, 23);
		panel_1.add(rdbtnModificarImagen);
		
		JRadioButton rdbtnBlacoYNegro = new JRadioButton("Blaco y Negro");
		rdbtnBlacoYNegro.setBounds(37, 175, 109, 23);
		panel_1.add(rdbtnBlacoYNegro);
		
		panel_1.add( JPENGBMP);
		panel_1.add(rdbtnCopia);
		panel_1.add(rdbtnRojoAzul);
		panel_1.add(rdbtnModificarImagen);
		panel_1.add(rdbtnBlacoYNegro);

		JButton btnNewButton_1 = new JButton("SELECCIONAR IMAGEN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeleccionarImagen imagen = new SeleccionarImagen();
				capturarImagen = (File) imagen.Imagen();
				tituloImagen.setText(capturarImagen.getAbsolutePath());
				
			}
		});
		JPEGHandler m = new JPEGHandler();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				if(JPENGBMP.isSelected()==true){
					try {
						if(capturarImagen.getName().contains(".jpg")){
							ImageHandler n = new JPEGtoBMPImagem(capturarImagen.getAbsolutePath());
							m.runHandler(n);	
							
						}else{
							ImageHandler d = new BMPtoJPEGImage(capturarImagen.getAbsolutePath());
							m.runHandler(d);
						
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				}
				
				//----------------------copiar--------------------
				
				if(rdbtnCopia.isSelected()==true){
					try {
						File carpeta = new File("Temporal");
						carpeta.mkdir();
						/**
						 * ejecuta JPEGIMAGECOPY 
						 * 
						 */
						ImageHandler copy = new JPEGImageCopy(capturarImagen.getAbsolutePath());
						JPEGHandler.runHandler(copy);
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
				
				//--------------------colores------------------------
				if(rdbtnRojoAzul.isSelected()==true){
					ImageHandler nuev = (ImageHandler) new JPEGImageHandlerColors(capturarImagen.getAbsolutePath(),capturarImagen.getName()); 
					try {
						JPEGHandler.runHandler(nuev);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
				
				//-------------------------- Horizontal y Vertical ------------------------------
				if(rdbtnModificarImagen.isSelected()==true){
					ImageHandler HorizontalYvertical  = (ImageHandler) new JPEGImageHandlerRotator(capturarImagen.getAbsolutePath(),capturarImagen.getName()); 
					try {
						JPEGHandler.runHandler(HorizontalYvertical);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
				//---------------------------- WHITE AND BLACK -----------------------------------
				if(rdbtnBlacoYNegro.isSelected()==true){
					ImageHandler blackandwhite  = (ImageHandler) new JPEGImageHandlerBN(capturarImagen.getAbsolutePath(),capturarImagen.getName()); 
					try {
						JPEGHandler.runHandler(blackandwhite);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				

			}
		
			
			
			
					
		});
		btnNewButton_1.setBounds(304, 66, 170, 34);
		panel.add(btnNewButton_1);


	
		
		
	}
}
