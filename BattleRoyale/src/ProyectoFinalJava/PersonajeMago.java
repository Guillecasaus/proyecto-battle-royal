package ProyectoFinalJava;

public class PersonajeMago extends Personaje {
	public static final Integer MAX_VIDA = 80;
	public static final Integer ATAQUE_NORMAL = 40;
	public static final Integer ATAQUE_HABILIDAD = 60;
	public static final Integer TURNOS_HABILIDAD = 5;
	public static final Integer VIDA_RECUPERAR = 10;
	
	public PersonajeMago(String nombre, TipoJugador tipo, Integer numeroJugador) {
		super(nombre, tipo, TipoPersonaje.mago, numeroJugador, PersonajeMago.MAX_VIDA, PersonajeMago.ATAQUE_HABILIDAD, PersonajeMago.ATAQUE_NORMAL, PersonajeMago.TURNOS_HABILIDAD);
	}
}
