package LimpiaTuti;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class Configuracion {
	
	private List<String> Directorios;
	
	public List<String> obtieneDirectorios(String file){
		
		List<String> listado = new ArrayList<String>();
		
		Properties prop = new Properties();

		/* RECUPERAMOS EL ARCHIVO CON EL LISTADO DE DIRECTORIOS */
		try {
			InputStream is = new FileInputStream(file);
			prop.load(is);
		} catch (IOException e) {
			System.out.println("No Se pudo leer la configuracion");
		}
		
		/* LEEMOS CADA ELEMENTO DEL PROPERITES */
		for (Enumeration e = prop.keys(); e.hasMoreElements();) {
			// Obtenemos el objeto
			Object obj = e.nextElement();
			
			listado.add(prop.getProperty((obj.toString())));
		}
		
	
		return listado;
		
	}
	public List<String> getDirectorios() {
		return Directorios;
	}

	public void setDirectorios(List<String> directorios) {
		Directorios = directorios;
	}
	
	

}
