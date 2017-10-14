package pratica1;

/**
* 
* @author Julien Gallego y Filipe
*/
public class Cesion {
	
	Moto moto;
	Miembro miembroAntiguo;
	Miembro miembroNuevo;
	
	public Cesion(Moto moto,Miembro miembroAntiguo,Miembro miembroNuevo){
		this.moto = moto;
		this.miembroAntiguo = miembroAntiguo;
		this.miembroNuevo = miembroNuevo;
	}

	@Override
	public String toString() {
		return miembroAntiguo.nombre  + " el socios numero " + miembroAntiguo.numSocios + " deja la moto "
			   + moto.nombre + " con el id " + moto.id + " al socios "+ miembroNuevo.numSocios + miembroNuevo.nombre;
				
	}
	
	
}
