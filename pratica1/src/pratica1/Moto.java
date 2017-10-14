/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica1;

/**
 *
 * @author Julien Gallego y Filipe
 */
public class Moto {
	
	static int idIncrement = 0;
    
    int id;
    String nombre;
    int CC;
    int coste;
    Miembro miembro;
    
    Moto(String nombre,int CC,int coste, Miembro miembro){
        this.id = idIncrement;
        this.nombre = nombre;
        this.CC = CC;
        this.coste = coste;
        idIncrement = idIncrement + 1;
        this.miembro = miembro;
    }

	@Override
	public String toString() {
		return "Moto [id=" + id + ", nombre=" + nombre + ", CC=" + CC + ", coste=" + coste + ", miembro=" + miembro
				+ "]";
	}
    
    
    
    
}


