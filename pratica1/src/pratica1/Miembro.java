/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica1;

/**
 *
 * @author alumno
 */
public class Miembro {  
	
    int numSocios;
    String nombre;
    int nMotos;
    int importe;
    
    Miembro(int numSocios,String nombre){
        this.numSocios = numSocios;
        this.nombre = nombre;
        this.nMotos = 0;
        this.importe = 0;
    }

	@Override
	public String toString() {
		return "Miembro [numSocios=" + numSocios + ", nombre=" + nombre + ", nMotos=" + nMotos + ", importe=" + importe
				+ "]";
	}
    
    
    
}

