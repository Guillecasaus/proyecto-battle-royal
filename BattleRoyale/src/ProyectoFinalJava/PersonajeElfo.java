package ProyectoFinalJava;

public class PersonajeElfo extends Personaje {

	public static final Integer MAX_VIDA_ELFO = 110;
	
	public PersonajeElfo(String nombre, TipoJugador tipo) {
		super(nombre, tipo, PersonajeElfo.MAX_VIDA_ELFO, TipoPersonaje.elfo);
	}

	@Override 
	public Integer habilidad() {
		return 20;
	}  

}
