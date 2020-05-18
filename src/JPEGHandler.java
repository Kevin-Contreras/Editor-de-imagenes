/**
 * La clase que ejecuta los procesos de lectura del programa.
 * @author Kevin
 *
 */
public class JPEGHandler {
/**
 * Contructor que ejecuta la ecucion de los procesos de lectura del programa.
 * @param imgh clase ImageHandler.
 * @throws Exception si no se encuentra el archivo.
 */
	public static void runHandler(ImageHandler imgh) throws Exception {
		/** NO CAMBIE ESTE CODIGO **/
		System.out.println("--------------------------------------");
		System.out.println(imgh.getClass().getTypeName().toUpperCase() + ": ");
		System.out.println("\nLeyendo imagen : " + imgh.getFileName());
		imgh.readFile();
		System.out.println("Proceso de lectura de imagen terminado!");
		System.out.println("\nGenerando imagenes : ");
		imgh.generateFiles();
		System.out.println("Proceso de generacion de archivos terminado!");
		System.out.println("\n--------------------------------------");
		/** --------------------- **/
	}
}