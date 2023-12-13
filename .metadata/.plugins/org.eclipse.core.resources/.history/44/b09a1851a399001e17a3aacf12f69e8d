package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Partida {

	public static final Integer TURNO_INICIAL = 0;
	public static final Integer NUM_MAX_JUGADORES = 10;
	public static final Integer NUM_INICIAL_JUGADORES = 0;
	public static final Integer MAX_TURNOS = 15;
	
	
	private List <Personaje> listaPersonajes; 
	private List <Turno> listaTurnos;
	private Integer turno;
	private Integer jugadoresHumanos;
	
	public Partida() {
		this.turno = Partida.TURNO_INICIAL;
		this.listaPersonajes = new ArrayList <Personaje>();
		this.listaTurnos = new ArrayList <Turno>();
		this.jugadoresHumanos = Partida.NUM_INICIAL_JUGADORES;
	}

	public void nuevoPersonaje(Personaje personaje) {
		this.listaPersonajes.add(personaje);
	} 
	
	public void mostrarPersonajes() {
		/*for(Personaje personajes : this.listaPersonajes) {
			System.out.println("El personaje nombre : "+ personajes.getNombre());
		}*/
		
		String texto = "";
	
		for(int i=0; i < this.listaPersonajes.size(); i++) {
			System.out.println("Posicion: " + i + " Nombre Personaje: "+ this.listaPersonajes.get(i).getNombre() + " Tipo de personje: " + this.listaPersonajes.get(i).getTipoPer() + " Vida personaje: " + this.listaPersonajes.get(i).getVidaPersonaje());
			texto = texto + "Posicion: " + i + " Nombre Personaje: "+ this.listaPersonajes.get(i).getNombre() + " Tipo de personje: " + this.listaPersonajes.get(i).getTipoPer() + " Vida personaje: " + this.listaPersonajes.get(i).getVidaPersonaje() + "\n";
		}
		JOptionPane.showMessageDialog(null, texto);
	}

	public Integer obtenerDamage(Integer posicionJugador) {
		//TODO Añadir bonus por arma/herramienta (Multiplicar? Float vs int?) (Recalcular equilibrio daño)
		return this.listaPersonajes.get(posicionJugador).getAtaqueNormal();
	}
	
	public Integer quitarDamage(Integer posicionJugador ,Integer damage) {	
		return this.listaPersonajes.get(posicionJugador).quitarVida(damage);
	}

	public Integer obtenerVida(Integer posicionJugador) {
		return this.listaPersonajes.get(posicionJugador).recuperarVida();
	}
	
	public Integer recuperarVida(Integer posicionJugador, Integer vida) {
		return this.listaPersonajes.get(posicionJugador).sumarVida(vida);
	}
	
	public Integer devolverVidaPersonaje(Integer posicionJugador) {
		return this.listaPersonajes.get(posicionJugador).getVidaPersonaje();
	}
	
	public String devolverListaPersonajes (Integer posicionJugador) {
		return this.listaPersonajes.get(posicionJugador).getNombre();
	}

	public void jugadorEliminado(Integer posicionJugador) {	
		 this.listaPersonajes.remove( this.listaPersonajes.get(posicionJugador));
		
	}
	
}
