package ProyectoFinalJava;

public class PersonajeGuerrero extends Personaje {

	public static final Integer MAX_VIDA_GUERRERO = 120;
	public static final Integer ATAQUE_NORMAL_GUERRERO = 15;
	public static final Integer ATAQUE_HABILIDAD_GUERRERO = 40;
	public static final Integer COOLDOWN_HABILIDAD_GUERRERO = 3;
	
	public PersonajeGuerrero(String nombre, TipoJugador tipo) {
		super(nombre, tipo, PersonajeGuerrero.MAX_VIDA_GUERRERO, TipoPersonaje.guerrero, PersonajeGuerrero.ATAQUE_NORMAL_GUERRERO, PersonajeGuerrero.ATAQUE_HABILIDAD_GUERRERO, PersonajeGuerrero.COOLDOWN_HABILIDAD_GUERRERO);
	}
	
	/*
	@Override 
	public Integer habilidad() {
		return 15;
	} 
	*/
	public Integer recuperarVida() {
		return 10;
	}

}
