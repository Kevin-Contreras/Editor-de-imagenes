import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.swing.SwingConstants;
public class interfaces extends JPanel implements Serializable{
	 private static final long serialVersionUID = 12345347l;
	 JFrame frame;
	 final JPanel panel = new JPanel();
	 JTextField textoNombre;
	 /**
	  * variables creada para recorrer los nodos de la clase Listas
	  */
	Listas lis;
	/**
	 * variables creada para recorrer los nodos de la clase ListaCategorias
	 */
	ListaCategorias nose;
	/**
	 * esta Varible de typo Convertirdor inicializa la clase Convertirdor
	 */
	Convertirdor convertidor ;

	/**
	 * Ejecuta toda la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaces window = new interfaces();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor que ejecuta el metodo initialize().
	 */
	public interfaces() {
		initialize();
		



		
	}

	/**
	 * inicializa la inteface grafica.
	 * En este metodo se inicializa los metodos de agregar imagenes.
	 */
	private void initialize() {
		frame = new JFrame();
		JLabel titulo = new JLabel("MENU");
		frame.setBounds(400, 200, 854, 272);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(10, 5, 854, 417);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(titulo);
		textoNombre = new JTextField();
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(550, 0, 200, 50);
		JButton btnNewButton = new JButton("INGRESAR A BIBLIOTECA");
		JButton editar = new JButton("INGRESAR A EDITAR");
		JButton convertir = new JButton("INGRESAR A CONVERTIR");
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textoNombre.getText().equals(""));
				if(textoNombre.getText().equals("") ){
					JOptionPane.showMessageDialog(null, "NO HA COLOCADO SU USUARIO","USUARIO" ,JOptionPane.DEFAULT_OPTION);
				}else{
					Imagen n = new Imagen(textoNombre.getText());
					frame.setVisible(false);
		    	  	n.frame.setVisible(true);

		    	  	JOptionPane.showMessageDialog(null, "CREAR UNA CATEGORIA","CATEGORIA" ,JOptionPane.DEFAULT_OPTION);
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
				  	
				      if((boolean)lis.find(textoNombre.getText())==true){
				    	  	System.out.println("el nombre ya existe");
				    	  	 JOptionPane.showMessageDialog(null, "Se ingreso con el nombre "+textoNombre.getText()+" es un usuario ya existente", "Nombre", JOptionPane.DEFAULT_OPTION);

				    	  
				    	  		 try {
							         FileInputStream fileIn = new FileInputStream("categorias.text");
									ObjectInputStream in = new ObjectInputStream(fileIn);
							         nose = (ListaCategorias)in.readObject();
							       
							      } catch (IOException i) {
							         i.printStackTrace();
							         return;
							      } catch (ClassNotFoundException c) {
							         System.out.println("Employee class not found");
							         c.printStackTrace();
							         return;
							      }	
					    	  	while(nose.primero!=null){
					    	  		
					    	  			
					    	  			n.modelo.addElement(nose.primero.categoria);
						    	  		nose.primero = nose.primero.siguiente;
					    	  		
					    	  		
					    	  	}
				    	  	
				    	  	}else{
				    	  		 JOptionPane.showMessageDialog(null, "Se agrego el nombre ", "nombre", JOptionPane.DEFAULT_OPTION);
								lis.add(textoNombre.getText());	
							
							
							
						}
				     
				}
					
			
				      
			}
			  
			
		});
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Editor editor = new Editor();
				editor.frame.setVisible(true);
				frame.setVisible(false);

				
			}
			});
		convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//--------------------------- Categorias---------------------------
				File archivo = new File("categorias.text");
				File archivo2=new File("guaradados.text");
				if(archivo.exists()==true || archivo2.exists()==true){
					 convertidor = new Convertirdor();
						convertidor.frame.setVisible(true);
						frame.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "EL USUARIO O LA CATEGORIA NO SE HA CREADO","NO CREADO" ,JOptionPane.DEFAULT_OPTION);
				}
		 		
		 		
		 			 	
		 		
				

				
			}
			});
		btnNewButton.setBounds(119, 136, 187, 40);
		panel.add(btnNewButton);
		panel.add(editar);
		panel.add(convertir);

		editar.setBounds(430,100,175,30);
		convertir.setBounds(620,100,175,30);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(19, 68, 98, 31);
		panel.add(lblUsuario);
		
		
		textoNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoNombre.setBounds(112, 65, 228, 40);
		panel.add(textoNombre);
		
		JLabel lblUsacView = new JLabel("USAC VIEW");
		lblUsacView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsacView.setBounds(150, 11, 124, 19);
		panel.add(lblUsacView);

	
			
}

	
}