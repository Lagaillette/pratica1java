package pratica1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Tests {
	static ArrayList<Miembro> miembros = new ArrayList<Miembro>();
	public static void main (String[] args){
		/**Miembro m = new Miembro("jose");
		Miembro m1 = new Miembro("pepe");
		Miembro m3 = new Miembro("filipe");
		miembros.add(m);
		miembros.add(m1);
		int index = miembros.indexOf(m1);
		System.out.println(index);
		
		Iterator it = miembros.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		miembros.set(index, m3);
		Iterator it2 = miembros.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		*/
		
		
		File f = new File("test.txt");
		System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
	    System.out.println("Nom du fichier : " + f.getName());
	    System.out.println("Est-ce qu'il existe ? " + f.exists());
	    System.out.println("Est-ce un répertoire ? " + f.isDirectory());
	    System.out.println("Est-ce un fichier ? " + f.isFile());
	    try {
			FileWriter fw = new FileWriter (f);
			fw.write("wesh");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

	}
	
	
}
