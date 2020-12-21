package LimpiaTuti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Consumer;

public class Principal {

	public static void main(String[] args) {

		//String configFile = System.getProperty("user.dir");
		
		/* PARA PRUEBAS */
		String configFile = "C:\\Users\\Sebastian\\Documents\\Java\\Proyectos\\LimpiaLog\\src\\main\\resources";

		configFile = configFile + "\\config.properties";
		
		System.out.println("Directorio actual: " + configFile);
		

		System.out.println("==============================");
		System.out.println("==       LIMPIA TUTI        ==");
		System.out.println("==============================");

		/* OBTENEMOS EL LISTADO DE DIRECTORIOS */
		List<String> listDirectorio = new Configuracion().obtieneDirectorios(configFile);

		// listDirectorio.forEach(System.out::println);

		listDirectorio.forEach((final String directorio) -> {
			System.out.println("Lee Directorio: " + directorio);
			try {
				limpiamosDirectorio(directorio);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		//Haciendo prubeas para el Git Branch
		
		Util utilit = new Util();
		utilit.setUtilidad("sarasa");
		
		
		//Haciendo un cambio en el master
		Util utilit2 = new Util();
		utilit2.setUtilidad("cambios");

	}

	/* RECORREMOS ARCHIVOS */

	private static void limpiamosDirectorio(String carpeta) throws IOException {

		File[] ficheros = null;
		String[] archivos = null;

		File fil = new File(carpeta);
		String filaEliminar = null;
		ficheros = fil.listFiles();
		archivos = fil.list();

		if (ficheros == null)
			System.out.println("No hay ficheros en el directorio especificado");
		else {
			for (int x = 0; x < ficheros.length; x++)
				// System.out.println(ficheros[x].getName());
				if (archivos[x].toString().contains(".log")) {
					filaEliminar = carpeta + "\\" + archivos[x].toString();
					System.out.println(filaEliminar);

					try {
						File fD = new File(filaEliminar);
						if (fD.delete())
							System.out.println("** Archivo Eliminado. **");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("ERROR AL ELIMINAR.");
					}
				}
		}
		// InputStream is = new FileInputStream(carpeta);

	}

}
