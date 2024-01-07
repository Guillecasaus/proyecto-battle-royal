package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Personaje {

	public static final Integer MAX_VIDA_DEFAULT = 100;
	public static final Integer ATAQUE_NORMAL_DEFAULT = 10;
	public static final Integer ATAQUE_HABILIDAD_DEFAULT = 30;
	public static final Integer TURNOS_HABILIDAD_DEFAULT = 4;
	
	protected String nombre;
	protected Integer vidaPersonaje;
	protected TipoJugador tipoUser;
	protected TipoPersonaje tipoPer;
	protected Integer numeroJugador;
	
	//Daño de ataque normal 
	protected Integer ataqueNormal;
	//Daño hecho por la habilidad especifica de personaje
	protected Integer ataqueHabilidad;
	//Turnos cooldown de la habilidad especifica de personaje
	protected Integer turnosHabilidad;
	
	//Objetos Cooldown, manejan cooldowns independientemente
	protected Cooldown CDHabilidad;
	protected Cooldown CDCogerHerramienta;
	
	//Objeto Inventario, gestiona herramientas personaje
	protected Inventario inventario;
		
	public Personaje(String nombre, TipoJugador tipoUser, TipoPersonaje tipoPer, Integer numeroJugador) {
		this(nombre, tipoUser, tipoPer, numeroJugador, Personaje.MAX_VIDA_DEFAULT, Personaje.ATAQUE_HABILIDAD_DEFAULT, Personaje.ATAQUE_NORMAL_DEFAULT, Personaje.TURNOS_HABILIDAD_DEFAULT);
	}
	
	public Personaje(String nombre, TipoJugador tipoUser, TipoPersonaje tipoPer, Integer numeroJugador, Integer vida, Integer ataqueHabilidad, Integer ataqueNormal, Integer turnosHabilidad) {
		this.nombre = nombre;
		this.tipoUser = tipoUser;
		this.tipoPer = tipoPer;
		this.numeroJugador = numeroJugador;
		this.vidaPersonaje = vida;
		this.ataqueHabilidad = ataqueHabilidad;
		this.ataqueNormal = ataqueNormal;
		this.turnosHabilidad = turnosHabilidad;
		this.CDHabilidad = new Cooldown();
		this.CDCogerHerramienta = new Cooldown();
		this.inventario = new Inventario();
	}

	public Integer getAtaqueNormal() {
		return ataqueNormal;
	}

	public void setAtaqueNormal(Integer ataqueNormal) {
		this.ataqueNormal = ataqueNormal;
	}

	public Integer getAtaqueHabilidad() {
		return ataqueHabilidad;
	}

	public void setAtaqueHabilidad(Integer ataqueHabilidad) {
		this.ataqueHabilidad = ataqueHabilidad;
	}

	public Integer getTurnosHabilidad() {
		return turnosHabilidad;
	}

	public void setTurnosHabilidad(Integer turnosHabilidad) {
		this.turnosHabilidad = turnosHabilidad;
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
	public TipoJugador getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(TipoJugador tipoUser) {
		this.tipoUser = tipoUser;
	}

	public TipoPersonaje getTipoPer() {
		return tipoPer;
	}

	public void setTipoPer(TipoPersonaje tipoPer) {
		this.tipoPer = tipoPer;
	}
	public Integer getNumeroJugador() {
		return numeroJugador;
	}

	public void setNumeroJugador(Integer numeroJugador) {
		this.numeroJugador = numeroJugador;
	}
	
	public Cooldown getCDHabilidad() {
		return CDHabilidad;
	}

	public void setCDHabilidad(Cooldown cDHabilidad) {
		CDHabilidad = cDHabilidad;
	}

	public Cooldown getCDCogerHerramienta() {
		return CDCogerHerramienta;
	}

	public void setCDCogerHerramienta(Cooldown cDCogerHerramienta) {
		CDCogerHerramienta = cDCogerHerramienta;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	@Override
	public String toString() {
		return "Numero Jugador: " + numeroJugador + " Nombre Personaje: "+ nombre + " Tipo de personje: " + tipoPer + " Vida personaje: " + vidaPersonaje;
	}
		
	public Integer quitarVida(Integer damage) {
		Integer vida;		
		vida = this.getVidaPersonaje() - damage;
		this.setVidaPersonaje(vida);
		
		return vida;
	}
	
	public Integer sumarVida(Integer life) {
		Integer vida;
		vida = this.getVidaPersonaje() + life;
		this.setVidaPersonaje(vida);
		
		return vida;
	}
	
	public Integer recuperarVida() {
		return 1;
	}

	public void actualizarValoresPersonajeEliminado() {
		Partida partida = new Partida();
		
		/*this.nombre = null;
		this.vidaPersonaje = null;
		this.listaHerramientas = null;
		this.tipoUser = null;
		this.numeroHerramientas = null;
		this.tipoPer = null;*/
		
	}

	public boolean equals(Personaje personaje) {
		return this.nombre.equals(personaje.getNombre());
	}
	
	public Integer compareTo(Personaje personaje) {
		if(this.numeroJugador == personaje.getNumeroJugador()) {
			return 0;
		}
		if(this.numeroJugador > personaje.getNumeroJugador()){
			return 1;
		}
		return -1;
	}
	
	
	

	

}


