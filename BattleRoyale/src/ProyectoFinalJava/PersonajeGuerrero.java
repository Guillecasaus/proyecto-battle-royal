package ProyectoFinalJava;

public class PersonajeGuerrero extends Personaje {
	public static final Integer MAX_VIDA = 120;
	public static final Integer ATAQUE_NORMAL = 15;
	public static final Integer ATAQUE_HABILIDAD = 40;
	public static final Integer TURNOS_HABILIDAD = 3;
	public static final Integer VIDA_RECUPERAR = 15;
	
	public PersonajeGuerrero(String nombre, TipoJugador tipo, Integer numeroJugador) {
		super(nombre, tipo, TipoPersonaje.guerrero, numeroJugador, PersonajeGuerrero.MAX_VIDA, PersonajeGuerrero.ATAQUE_HABILIDAD, PersonajeGuerrero.ATAQUE_NORMAL, PersonajeGuerrero.TURNOS_HABILIDAD);
	}

}
