package ProyectoFinalJava;

public class PersonajeMago extends Personaje {

	public static final Integer MAX_VIDA_MAGO = 80;
	
	public PersonajeMago(String nombre, TipoJugador tipo) {
		super(nombre, tipo, PersonajeMago.MAX_VIDA_MAGO, TipoPersonaje.mago);
	}

	@Override 
	public Integer habilidad() {
		return 40;
	} 
	
	public Integer recuperarVida() {
		return 10;
	}

}
