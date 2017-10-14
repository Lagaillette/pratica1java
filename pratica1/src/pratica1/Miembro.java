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
public class Miembro {  
	
    int numSocios;
    String nombre;
    int nMotos;
    int importe;
    Miembro(String nombre){
        this.numSocios = idIncrement;
        idIncrement += 1;
        this.nombre = nombre;
        this.nMotos = 0;
        this.importe = 0;
    }
    static int idIncrement = 1;
	@Override
	public String toString() {
		return "Miembro [numSocios=" + numSocios + ", nombre=" + nombre + ", numero de motos=" + nMotos + ", importe=" + importe
				+ "]";
	}
    
    
    
}

