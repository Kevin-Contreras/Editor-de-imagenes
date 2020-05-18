import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Time;
import java.util.Timer;

import javax.swing.JProgressBar;
import javax.swing.JTextPane;

/**
 * La clase Convertidor genera todos los procesos de ejecucion de la parte del convertidor.
 * @author Kevin Contreras.
 * 
 *
 */
public class Convertirdor {
	 Listas lis;
	ListaCategorias nose;
	ListaCircular imagenes;
	int contadorTotal = 0;
	 JFrame frame;
	DefaultListModel modelo = new DefaultListModel();

	/**
	 * el constructor Convertidor genera todo el proceso de ejecucion del convertidor.
	 */
	public Convertirdor() {
		
		//--------------------------- Categorias---------------------------
 		 try {
	         FileInputStream fileIn = new FileInputStream("categorias.text");
			ObjectInputStream in = new ObjectInputStream(fileIn);
	           nose =  (ListaCategorias) in.readObject();
	       
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }	
		//---------------------------- nombres ----------------------------
 		 
 		try {
	         FileInputStream fileIn = new FileInputStream("guaradados.text");
			ObjectInputStream in = new ObjectInputStream(fileIn);
	          lis = (Listas) in.readObject();

	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
 		 //-------------------------------- imagenes -------------------------------
 		try {
	         FileInputStream fileIn = new FileInputStream("imagenes.text");
			ObjectInputStream in = new ObjectInputStream(fileIn);
	          imagenes =  (ListaCircular) in.readObject();

	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
		//--------------------------------------------------------------------------
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 727);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 879, 688);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(46, 28, 132, 29);
		panel.add(lblNewLabel);
		
		JLabel lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCategoria.setBounds(323, 28, 132, 29);
		panel.add(lblCategoria);
		
		JList list = new JList();
		list.setBounds(31, 115, 186, 562);
		panel.add(list);
		JLabel lblColaDeProcesos = new JLabel("Cola de procesos");
		lblColaDeProcesos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColaDeProcesos.setBounds(46, 75, 132, 29);
		panel.add(lblColaDeProcesos);
		
		JRadioButton rdbtnJpgABmp = new JRadioButton("JPG A BMP Y VICEVERSA");
		rdbtnJpgABmp.setBounds(323, 137, 186, 23);
		panel.add(rdbtnJpgABmp);
		
		JRadioButton rdbtnCopiaJpeg = new JRadioButton("COPIA JPEG");
		rdbtnCopiaJpeg.setBounds(323, 189, 109, 23);
		panel.add(rdbtnCopiaJpeg);
		
		JRadioButton rdbtnRojoAzulVerde = new JRadioButton("ROJO AZUL VERDE Y SEPIA");
		rdbtnRojoAzulVerde.setBounds(323, 251, 186, 23);
		panel.add(rdbtnRojoAzulVerde);
		
		JRadioButton rdbtnModificarImagen = new JRadioButton("MODIFICAR IMAGEN");
		rdbtnModificarImagen.setBounds(323, 315, 155, 23);
		panel.add(rdbtnModificarImagen);
		
		JRadioButton rdbtnBlancoYNegro = new JRadioButton("BLANCO Y NEGRO");
		rdbtnBlancoYNegro.setBounds(323, 379, 186, 23);
		panel.add(rdbtnBlancoYNegro);
		
		JTextPane txt = new JTextPane();
		txt.setBounds(266, 534, 574, 114);
		panel.add(txt);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(300, 490, 511, 29);
		panel.add(progressBar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 33, 132, 20);
		panel.add(comboBox);
		while(lis.primero!=null){
			comboBox.addItem(lis.primero.dato);
			System.out.println(lis.primero.dato);
			lis.primero = (Nodo) lis.primero.siguiente;
		}
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(444, 33, 132, 20);
		panel.add(comboBox_1);

		while(nose.primero!=null){
			comboBox_1.addItem(nose.primero.categoria);
		nose.primero = (NodoCategorias) nose.primero.siguiente;
		}
		
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.setBounds(658, 25, 162, 37);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list.setModel(modelo);
				modelo.addElement(comboBox_1.getSelectedItem());
			}
		});
		/**
		 * La matriz nuevo guarda los url de las imagenes que utilizara el convertidor
		 */
		 String nuevo [] = new String[imagenes.getSize()];
		 /**
		  * La matriz nombre guardara los nombres de los nombres de las imagenes que el convertidor
		  * usara.
		  */
		 String nombre [] = new String[imagenes.getSize()]; 
		 /**
		  * la variable z de tipo int es un contador que se utilizara en un while
		  */
		 int z =0;
		/**
		 * El ciclo while recorre las imagenes guardadas en los archivo imagenes.text 
		 */
		while(z<imagenes.getSize()){
			nuevo[z] = imagenes.primero.imagen;
			File file = new File(nuevo[z]);
			nombre[z] = file.getName();
			System.out.println(imagenes.primero.imagen);
			imagenes.primero = (NodosCircular) imagenes.primero.siguiente;
			z++;
		}
		JButton btnParalelo = new JButton("PARALELO");
		btnParalelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "NO TERMINADO :(","NO TERMINADO" ,JOptionPane.DEFAULT_OPTION);
			}
		});
		btnParalelo.setBounds(658, 163, 162, 37);
		panel.add(btnParalelo);
		JButton btnFifo = new JButton("LIFO");
		btnFifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * La variable md es un contador.
				 */
				 int md = modelo.getSize();
				 /**
					 * La variable progreso es un contador.
					 */
				 int progreso = modelo.getSize();
				 /**
					 * La variable contador es un contador.
					 */
				 int contador=0;
				 /**
					 * La variable total es un contador.
					 */
				 int total=0;
				 /**
					 * La variable h es un contador.
					 */
				 String h="";
				 /**
					 * La variable h es un contador.
					 */
				 String pr = "";
				 /**
					 * La variable pr es un contador.
					 */
				for(int k =0; k<md;++k){
					for(int i =0; i<imagenes.getSize(); i++){
						if(rdbtnJpgABmp.isSelected() == true){
							try {
								if(nuevo[i].contains(".jpg")){
									ImageHandler n = new JPEGtoBMPImagem(nuevo[i]);
									JPEGHandler.runHandler(n);
									pr+="JPG A BMP, ";
									
								}else{
									ImageHandler d = new BMPtoJPEGImage(nuevo[i]);
									JPEGHandler.runHandler(d);
								
								}
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(rdbtnCopiaJpeg.isSelected() == true){
							try {
								File carpeta = new File("Temporal");
								carpeta.mkdir();
								ImageHandler copy = new JPEGImageCopy(nuevo[i]);
								JPEGHandler.runHandler(copy);
								pr+="COPIA JPG, ";
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}
						if(rdbtnRojoAzulVerde.isSelected()==true){
							ImageHandler nuev = (ImageHandler) new JPEGImageHandlerColors(nuevo[i],nombre[i]); 
							try {
								JPEGHandler.runHandler(nuev);
								pr +="ROJO VERDE AZUL Y SEPIA, ";
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}
						if(rdbtnModificarImagen.isSelected()==true){
							ImageHandler HorizontalYvertical  = (ImageHandler) new JPEGImageHandlerRotator(nuevo[i],nombre[i]); 
							try {
								JPEGHandler.runHandler(HorizontalYvertical);
								pr += "MODIFICAR IMAGEN, ";
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}
						if(rdbtnBlancoYNegro.isSelected()==true){
							ImageHandler blackandwhite  = (ImageHandler) new JPEGImageHandlerBN(nuevo[i],nombre[i]); 
							try {
								JPEGHandler.runHandler(blackandwhite);
								pr +="BLANCO Y NEGRO, ";
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}						
						h += "la imagen:"+ nombre[i]+" ha sido procesada, procesos: "+pr+ "\n";
						txt.setText(h);
						pr="";
						}
					modelo.remove(0);
					contador+=(int)(100/progreso);
					progressBar.setValue(contador);
					progreso-=1;
					

				}
				

				
			}
		
			
				
			
		});
		btnFifo.setBounds(658, 251, 162, 37);
		panel.add(btnFifo);
		
		JButton btnFifo_1 = new JButton("FIFO");
		/**
		 * procesa todas las imagenes de una forma FIFO.
		 */
		btnFifo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int md = modelo.getSize();
				 int progreso = modelo.getSize();
				 int contador=0;
				 int total=0;
				 String h="";
				 String pr = "";
				 System.out.println(modelo.getSize());
				 int i=0;
				for(int k =0; k<md;++k){
					for( i =0; i<imagenes.getSize(); i++){
						if(rdbtnJpgABmp.isSelected() == true){
							try {
								if(nuevo[i].contains(".jpg")){
									ImageHandler n = new JPEGtoBMPImagem(nuevo[i]);
									JPEGHandler.runHandler(n);
									pr+="JPG A BMP, ";
									
								}else{
									ImageHandler d = new BMPtoJPEGImage(nuevo[i]);
									JPEGHandler.runHandler(d);
								
								}
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(rdbtnCopiaJpeg.isSelected() == true){
							try {
								File carpeta = new File("Temporal");
								carpeta.mkdir();
								ImageHandler copy = new JPEGImageCopy(nuevo[i]);
								JPEGHandler.runHandler(copy);
								pr+="COPIA JPG, ";
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}
						if(rdbtnRojoAzulVerde.isSelected()==true){
							ImageHandler nuev = (ImageHandler) new JPEGImageHandlerColors(nuevo[i],nombre[i]); 
							try {
								JPEGHandler.runHandler(nuev);
								pr +="ROJO VERDE AZUL Y SEPIA, ";
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}
						if(rdbtnModificarImagen.isSelected()==true){
							ImageHandler HorizontalYvertical  = (ImageHandler) new JPEGImageHandlerRotator(nuevo[i],nombre[i]); 
							try {
								JPEGHandler.runHandler(HorizontalYvertical);
								pr += "MODIFICAR IMAGEN, ";
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}
						if(rdbtnBlancoYNegro.isSelected()==true){
							ImageHandler blackandwhite  = (ImageHandler) new JPEGImageHandlerBN(nuevo[i],nombre[i]); 
							try {
								JPEGHandler.runHandler(blackandwhite);
								pr +="BLANCO Y NEGRO, ";
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}			
						h += "la imagen:"+ nombre[i]+" ha sido procesada, procesos: "+pr+ "\n";
						txt.setText(h);
						
						
						}
					modelo.remove(0);
					contador+=(int)(100/progreso);
					progressBar.setValue(contador);
					progreso-=1;
					

				}
				
				
				
			}
		});
		btnFifo_1.setBounds(658, 350, 162, 37);
		panel.add(btnFifo_1);
		
		JLabel lblCantidadProcesada = new JLabel("CANTIDAD PROCESADA");
		lblCantidadProcesada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadProcesada.setBounds(471, 450, 205, 29);
		panel.add(lblCantidadProcesada);
		
		
		
		
	}
}
