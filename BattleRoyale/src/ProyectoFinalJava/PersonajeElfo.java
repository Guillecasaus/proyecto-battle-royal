package ProyectoFinalJava;

public class PersonajeElfo extends Personaje {
	public static final Integer MAX_VIDA = 110;
	public static final Integer ATAQUE_NORMAL = 20;
	public static final Integer ATAQUE_HABILIDAD = 60;
	public static final Integer TURNOS_HABILIDAD = 5;
	public static final Integer VIDA_RECUPERAR = 10;
	
	public PersonajeElfo(String nombre, TipoJugador tipo, Integer numeroJugador) {
		super(nombre, tipo, TipoPersonaje.elfo, numeroJugador, PersonajeElfo.MAX_VIDA, PersonajeElfo.ATAQUE_HABILIDAD, PersonajeElfo.ATAQUE_NORMAL, PersonajeElfo.TURNOS_HABILIDAD);
	}
}
