

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
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

public class Imagen implements Serializable {
	int contador =0;
	int contador2 =1;
	String categorias;
	 JFrame frame;
	 String lis;
	 JList list;
	 ListaCategorias lisy = new ListaCategorias();
		DefaultListModel modelo = new DefaultListModel();

	
/**
 * Constructor que inicializa el metodo initialize.
 * @param imagen direccion de la imagen que se utilizara en el proceso.
 */
	public Imagen(String imagen)  {

		initialize(imagen);
	}

	/**
	 * inicializa el contenido del Frame ejecuta todo el proceso para colocar una imagen, eliminar una categoria, agregar una categoria, eliminar una imagen
	 *  
	 * @param imagen  direccion de la imagen que se utilizara en el proceso.
	 */
	private void initialize(String imagen) {
		Listas no = new Listas();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1112, 673);
		JLabel col = new JLabel("USUARIO: "+imagen);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(col);
		list= new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setModel(modelo);
		list.setBounds(10, 11, 104, 498);
		frame.getContentPane().add(list);
		col.setBounds(900, 20, 300, 20);
		JButton btnNewButton_2 = new JButton("ELIMINAR CATEGORIA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dato = list.getSelectedIndex();
				String datoa = (String) modelo.get(dato);
				int categorias1 = JOptionPane.showConfirmDialog(null, "¿DESEA ELIMINAR A LA CATEGORIA "+datoa+"?");
				if(categorias1 ==0){
					if(datoa=="GENERAL"){
						JOptionPane.showMessageDialog(null, "No se puede eliminar la categoria "+datoa,"ELIMINAR" ,JOptionPane.DEFAULT_OPTION);
					}else{
						JOptionPane.showMessageDialog(null, "Se ha eliminado la categoria "+datoa,"ELIMINAR" ,JOptionPane.DEFAULT_OPTION);
						lisy.delete(datoa);
						modelo.remove(dato);
					}
				
				}else{
					JOptionPane.showMessageDialog(null, "La categoria "+datoa+" no se elimino","ELIMINAR" ,JOptionPane.DEFAULT_OPTION);
				}


				
			}
		});
		btnNewButton_2.setBounds(240, 538, 203, 47);
		frame.getContentPane().add(btnNewButton_2);
		JButton button = new JButton("AGREGAR CATEGORIA");
		ListaCategorias ca = new ListaCategorias();
				
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
				 categorias = JOptionPane.showInputDialog(null,"INGRESE EL NOMBRE DE LA LISTA");
				 JOptionPane.showMessageDialog(null, "Se agrego una categoria con exito", "Categoria", JOptionPane.DEFAULT_OPTION);
				 modelo.addElement(categorias);	
			
				}
			});
		
		
	
		
		button.setBounds(26, 538, 203, 47);
		frame.getContentPane().add(button);
		JLabel lblNewLabel_1 = new JLabel("");
		JPanel panel = new JPanel();
		panel.setBounds(229, 11, 754, 498);
		frame.getContentPane().add(panel);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 73, 754, 425);
		JButton btnNewButton = new JButton("AGREGAR IMAGEN");
		btnNewButton.setBounds(54, 24, 155, 38);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("solo jpg","jpg");
		JFileChooser fc = new JFileChooser();
		ListaCircular circular = new ListaCircular();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setFileFilter(filtro);
				fc.setMultiSelectionEnabled(true);
			int k =	fc.showOpenDialog(frame);
			if(k == JFileChooser.APPROVE_OPTION){
				File [] fichero  = fc.getSelectedFiles();
				String[] matriz = new String[modelo.size()];
				for(int i =0; i<modelo.size();++i){
					matriz[i]=(String) modelo.get(i);
				}
				Object color = JOptionPane.showInputDialog(null,"Seleccione una categoria","CATEGORIAS", JOptionPane.QUESTION_MESSAGE, null,matriz,"Seleccione");
				lblNewLabel.setIcon(new ImageIcon(fichero[0].getAbsolutePath()));
				lblNewLabel_1.setText(fichero[0].getName());
				for(int i=0;i<fichero.length;++i){
					circular.add(fichero[i].getAbsolutePath());
				}
				
				

				
			}
			
			
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JButton btnEliminarImagen = new JButton("ELIMINAR IMAGEN");
		btnEliminarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
			});
		btnEliminarImagen.setBounds(242, 24, 155, 38);
		panel.add(btnEliminarImagen);
		panel.add(lblNewLabel);
		
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(64, 73, 603, 52);
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		panel.add(lblNewLabel_1);
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			
				 File[] fichero = fc.getSelectedFiles();
			
				if(contador2<0){
					
				}else{
					if(contador2== 0){
							
					}else{
						--contador2;
						lblNewLabel.setIcon(new ImageIcon(fichero[contador2].getAbsolutePath()));
						lblNewLabel_1.setText(fichero[contador2].getName());
					}	
				
				}
				
				
		
				
			}
		});
		btnNewButton_1.setBounds(124, 256, 89, 47);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button_1 = new JButton(">");
		button_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				 File[] fichero = fc.getSelectedFiles();
				if(contador2<fichero.length){
					lblNewLabel.setIcon(new ImageIcon(fichero[contador2].getAbsolutePath()));
					lblNewLabel_1.setText(fichero[contador2].getName());

				}else{
					
				}
			
			if(contador2!= fichero.length){
				contador2++;	
			}	
			
			}
		});
		button_1.setBounds(997, 284, 89, 47);
		frame.getContentPane().add(button_1);
		frame.addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent e) {
				   if((boolean)no.find(imagen)==true){
			    	  	System.out.println("el nombre ya existe");
					}else{
						File file = new File("guaradados.text");
						
						if(file.length()==0){
							no.add(imagen);
						}
						
					}
				   
				   // GUARDAR LAS CATEGORIAS
				   try {
						File file = new File("categorias.text");
						FileOutputStream fileOut = new FileOutputStream("categorias.text");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						for(int i =0; i<modelo.size();++i){
							if(modelo.get(i)=="GENERAL"){
								
							}else{
								ca.add(modelo.get(i));
							}


						}
							while(ca.primero !=null){
								out.writeObject(ca);
								ca.primero = ca.primero.siguiente;
								

							}
							
						
							
						System.out.println("la categoria se guardo en  /deskt/categoria.text");
						} catch (IOException i) {
						i.printStackTrace();
						}
				   //GUARDAR IMAGEN
				   try {
						File file = new File("imagenes.text");
						FileOutputStream fileOut = new FileOutputStream("imagenes.text");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
								out.writeObject(circular);
						System.out.println("la categoria se guardo en  /deskt/categoria.text");
						} catch (IOException i) {
						i.printStackTrace();
						}
			     System.exit(0);
			   }
			 });
	}
	
}

	
