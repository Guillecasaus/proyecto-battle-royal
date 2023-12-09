package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

public class Personaje {

	public static final Integer MAX_VIDA_PERSONAJE = 100;
	public static final Integer NUM_MAX_HERRAMIENTAS = 3;
	public static final Integer NUM_INICIAL_HERRAMIENTAS = 0;
	
	private String nombre;
	private Integer vidaPersonaje;
	private List <Herramientas> listaHerramientas; 
	private TipoJugador tipo;
	private Integer numeroHerramientas;
	private TipoPersonaje tipoPer;
		
	public Personaje(String nombre, TipoJugador tipo, TipoPersonaje tipoPer) {
		this.nombre = nombre;
		this.vidaPersonaje = Personaje.MAX_VIDA_PERSONAJE;
		this.tipo = tipo;
		this.listaHerramientas = new ArrayList<Herramientas>();
		this.numeroHerramientas = Personaje.NUM_INICIAL_HERRAMIENTAS;
		this.tipoPer = tipoPer;
	}
	
	public Personaje(String nombre, TipoJugador tipo, Integer vida,  TipoPersonaje tipoPer) {
		this.nombre = nombre;
		this.vidaPersonaje = vida;
		this.tipo = tipo;
		this.listaHerramientas = new ArrayList<Herramientas>();
		this.numeroHerramientas = Personaje.NUM_INICIAL_HERRAMIENTAS;
		this.tipoPer = tipoPer;
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

	public TipoJugador getTipo() {
		return tipo;
	}

	public void setTipo(TipoJugador tipo) {
		this.tipo = tipo;
	}

	public TipoPersonaje getTipoPer() {
		return tipoPer;
	}

	public void setTipoPer(TipoPersonaje tipoPer) {
		this.tipoPer = tipoPer;
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
	
	public Integer habilidad() {
		return 1;
	}

	public Integer asignarHerramienta(Herramientas herramientaAsignar) {
		if(this.numeroHerramientas >= Personaje.NUM_MAX_HERRAMIENTAS) {
			return 0;		
		}
		else{
			this.listaHerramientas.add(herramientaAsignar);		
			this.numeroHerramientas ++;	
			return 1;
		}	
	}
}
