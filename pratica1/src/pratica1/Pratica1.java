/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Pratica1 {

	/**
	 * @param args the command line arguments
	 */
	static ArrayList<Miembro> miembros = new ArrayList<Miembro>();

	static ArrayList<Moto> motos = new ArrayList<Moto>();

	static ArrayList<Cesion> historicaCesiones = new ArrayList<Cesion>();


	public static void main(String[] args) {
		// TODO code application logic here	
		boolean end = false;

		int choice = 0;

		do{
			System.out.println("1. Registrar un nuevo miembro \n "
					+ "2. Registrar una nueva motocicleta \n "
					+ "3. Registrar una cesión \n "
					+ "4. Listar en pantalla los miembros con motos en posesión \n"
					+ "5. Listar todas las motos \n"
					+ "6. Mostrar las cesiones realizadas \n"
					+ "7. Salir del programa"
					);
			try {
				choice = pedirEntero();
				System.out.println(choice);
				switch(choice){
				case 1: registrarMiembro();
				break;
				case 2: registrarMoto();
				break;
				case 3: registrarUnaCesion();
				break;
				case 4: listaMiembrosMotos();
				break;
				case 5: listaMotos();
				break;
				case 6: listaCesiones();
				break;
				case 7: end = true;
				break;
				default : System.out.println("Porfavor, elige un numero valido");
				}

			} catch (Exception inputMismatchException) {
				System.out.println("Valor no funciona");
			}
		}while(!end);
	}

	public static void registrarMiembro(){
		System.out.println("Elige el numero de Socios del miembro porfavor");
		int numSocios = pedirEntero();
		System.out.println("Cual es el nombre del miembro");
		String nombre = pedirPalabra();
		Miembro miembro = new Miembro(numSocios,nombre);
		miembros.add(miembro);
		System.out.println(miembros);
	}

	public static void registrarMoto(){
		if(miembros.isEmpty() ){
			System.out.println("No puedes añadir una moto si no hay miembro");
		}
		else{
			String nombre;
			do{
				System.out.println("Escribir el nombre de la moto");
				nombre = pedirPalabra();
			}while(nombre.length() == 0);
			System.out.println("Escribir el CC de la moto");
			int CC = pedirEntero();
			System.out.println("Escribir el coste de la moto");
			int coste = pedirEntero();
			Miembro miembro = null;
			int numeroSocios;
			do{
				System.out.println("Escribir el numero de socios de el que va a tener la moto");
				System.out.println(miembros);
				numeroSocios = pedirEntero();
			}while(!existeMiembro(numeroSocios));
			Moto moto = new Moto(nombre,CC,coste,miembro);
			if(AñadirMotoAMiembro(moto, miembro)){
				motos.add(moto);
			}
			else{
				System.out.println("por favor, empiezas otra vez");
			}		
		}
	}


	public static void registrarUnaCesion(){
		if(motos.size() == 0 || miembros.size() < 2 ){
			System.out.println("No Hay miembro o motos necesarios para registrar una cesion");
		}else{
			boolean valorIncorrecto = true;
			Miembro miembro1 = null;
			Miembro miembro2 = null;
			Moto moto = null;
			int id;
			int numSocios1;
			int numSocios2;
			
			do{
				System.out.println("cual es el id de la moto que quieres que cambia de miembro");
				id = pedirEntero();
			}while(!existeMoto(id));
			
			moto = getMotoById(id);
			
			do{
				System.out.println("cual es el id de la moto que quieres que cambia de miembro");
				numSocios1 = pedirEntero();
			}while(!existeMiembro(numSocios1));
			
			miembro1 = getMiembroByNumSocios(numSocios1);
			
			do{
				System.out.println("cual es el id de la moto que quieres que cambia de miembro");
				numSocios2 = pedirEntero();
			}while(!existeMiembro(numSocios2));
			
			miembro2 = getMiembroByNumSocios(numSocios2);

			Cesion cesion = new Cesion(moto, miembro1, miembro2);
			
			historicaCesiones.add(cesion);
		}
		

	}

	public static void listaMiembrosMotos(){
		if(miembros.isEmpty()){
			System.out.println("no hay miembros, perdonna");
		}
		else{
			Moto moto;
			Miembro miembro;
			Iterator itMiembros = miembros.iterator();
			while(itMiembros.hasNext()){
				miembro = (Miembro) itMiembros.next();
				miembro.toString();
				Iterator itMotos = motos.iterator();
				while(itMotos.hasNext()){
					moto = (Moto) itMotos.next();
					if(moto.miembro == miembro){
						moto.toString();
					}

				}
			}
		}

	}
	
	public static void listaMotos(){
			System.out.println(motos);
	}
	
	public static void listaMiembros(){
		Iterator it = miembros.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void listaCesiones(){
		Iterator it = historicaCesiones.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	public static int pedirEntero(){

		Scanner input = new Scanner(System.in);
		int resultado = 0;
		boolean valorIncorrecto = true;

		do{
			try{
				resultado = input.nextInt();
				valorIncorrecto = false;
			}
			catch (Exception a){
				System.out.println("Valor no funciona. Tienes que poner un numero. Intentar otra vez");
				input.nextLine();
			}
		}while(valorIncorrecto);
		return resultado;
	}

	public static String pedirPalabra(){

		Scanner input = new Scanner(System.in);
		String resultado = null;
		boolean valorIncorrecto = true;

		do{
			try{
				resultado = input.next();
				valorIncorrecto = false;
			}
			catch (Exception a){
				System.out.println("Valor no funciona. Tienes que poner un numero. Intentar otra vez");
				input.nextLine();
			}
		}while(valorIncorrecto);
		return resultado;
	}

	public static boolean existeMiembro(int numSocios){
		boolean resultado = false;
		Miembro miembro;
		Iterator<Miembro> it = miembros.iterator();
		while(it.hasNext() && resultado==false){
			miembro = (Miembro) it.next();
			System.out.println(miembro.numSocios + "   " + numSocios);
			if(miembro.numSocios == numSocios){
				resultado = true;
			}
		}
		return resultado;
	}
	
	public static boolean existeMoto(int id){
		boolean resultado = false;
		Moto moto;
		Iterator it = miembros.iterator();
		while(it.hasNext() && resultado==true){
			moto = (Moto) it.next();
			if(moto.id == id){
				resultado = true;
			}
		}
		return resultado;
	}
	
	public static Miembro getMiembroByNumSocios(int numSocios){
		boolean encontrado = false;
		Miembro miembro = null;
		Iterator it = miembros.iterator();
		while(it.hasNext() && !encontrado){
			miembro = (Miembro) it.next();
			if(miembro.numSocios == numSocios){
				encontrado = true;
			}
		}
		return miembro;

	}
	
	public static Moto getMotoById(int id){
		boolean encontrado = false;
		Moto moto = null;
		Iterator it = motos.iterator();
		while(it.hasNext() && !encontrado){
			moto = (Moto) it.next();
			if(moto.id == id){
				encontrado = true;
			}
		}
		return moto;
	}
	
	public static boolean AñadirMotoAMiembro(Moto moto, Miembro miembro){
		boolean añadido = false;
		int importe = miembro.importe + moto.coste;
		if(importe > 6000){
			System.out.println("Este miembro no puede coger esta moto. Su importe es demasiado grande");
		}else{
			int index = miembros.indexOf(miembro);
			miembro.importe += moto.coste;
			miembro.nMotos += 1;
			miembros.set(index, miembro);
			añadido = true;
		}
		return añadido;	
	}
}
