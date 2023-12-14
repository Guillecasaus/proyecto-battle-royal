package ProyectoFinalJava;

public class PersonajeMago extends Personaje {

	public static final Integer MAX_VIDA_MAGO = 80;
	public static final Integer ATAQUE_NORMAL_MAGO = 40;
	public static final Integer ATAQUE_HABILIDAD_MAGO = 60;
	public static final Integer COOLDOWN_HABILIDAD_MAGO = 5;
	
	public PersonajeMago(String nombre, TipoJugador tipo, Integer numeroJugador) {
		super(nombre, tipo, PersonajeMago.MAX_VIDA_MAGO, TipoPersonaje.mago, PersonajeMago.ATAQUE_NORMAL_MAGO, PersonajeMago.ATAQUE_HABILIDAD_MAGO, PersonajeMago.COOLDOWN_HABILIDAD_MAGO, numeroJugador);
	}

	/*
	@Override 
	public Integer habilidad() {
		return 40;
	} 
	*/
	public Integer recuperarVida() {
		return 10;
	}

}
