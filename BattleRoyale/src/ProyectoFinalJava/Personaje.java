package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

public class Personaje {

	public static final Integer MAX_VIDA_PERSONAJE = 100;
	
	private String nombre;
	private Integer vidaPersonaje;
	private List <Herramientas> listaHerramientas; 
	private TipoJugador tipo;
		
	public Personaje(String nombre, TipoJugador tipo) {
		this.nombre = nombre;
		this.vidaPersonaje = Personaje.MAX_VIDA_PERSONAJE;
		this.tipo = tipo;
		this.listaHerramientas = new ArrayList<Herramientas>();
	}
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getVidaPersonaje() {
		return vidaPersonaje;
	}

	public void setVidaPersonaje(Integer vidaPersonaje) {
		this.vidaPersonaje = vidaPersonaje;
	}

	public List<Herramientas> getListaHerramientas() {
		return listaHerramientas;
	}

	public void setListaHerramientas(List<Herramientas> listaHerramientas) {
		this.listaHerramientas = listaHerramientas;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", vidaPersonaje=" + vidaPersonaje + ", listaHerramientas="
				+ listaHerramientas + ", tipo=" + tipo + "]";
	}
	
	public Integer quitarVida(Integer damage) {
		Integer vida;		
		vida = this.getVidaPersonaje() - damage;
		this.setVidaPersonaje(vida);
		
		return vida;
	}
	
}
