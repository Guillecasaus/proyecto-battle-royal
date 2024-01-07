package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Partida {
	public static final Integer TURNOS_CD_ESCOGER_HERRAMIENTA = 4;
	public static final Integer TURNO_INICIAL = 0;
	public static final Integer NUM_MAX_JUGADORES = 8;
	public static final Integer NUM_INICIAL_JUGADORES = 0;
	public static final Integer MAX_TURNOS = 10;
	
	
	private List <Personaje> listaPersonajes; 
	private List <Turno> listaTurnos;
	private Integer turno;
	private Integer jugadoresHumanos;
	private Integer numJugadoresPartida;
	
	public Partida() {
		this.turno = Partida.TURNO_INICIAL;
		this.listaPersonajes = new ArrayList <Personaje>();
		this.listaTurnos = new ArrayList <Turno>();
		this.jugadoresHumanos = Partida.NUM_INICIAL_JUGADORES;
		this.numJugadoresPartida = Partida.NUM_MAX_JUGADORES;
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
			System.out.println(this.listaPersonajes.get(i).toString());
			texto = texto + this.listaPersonajes.get(i).toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, texto);
	}
	public void mostrarPersonajesmaquina() {
		/*for(Personaje personajes : this.listaPersonajes) {
			System.out.println("El personaje nombre : "+ personajes.getNombre());
		}*/
		
		String texto = "";
		System.out.println("Soy maquina\n");
		for(int i=0; i < this.listaPersonajes.size(); i++) {
			System.out.println(this.listaPersonajes.get(i).toString());
			texto = texto + this.listaPersonajes.get(i).toString() + "\n";
		}
		JOptionPane option = new JOptionPane("",JOptionPane.INFORMATION_MESSAGE);
		option.setMessage(texto);  
		JDialog dialog = option.createDialog(null, "Accion");
		new Thread(new Runnable() {
		@Override
		
			public void run() {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.setVisible(false);
			}
		}).start();
		dialog.setVisible(true);
		dialog.dispose();
	}
	public String textoPersonajes() {
		/*for(Personaje personajes : this.listaPersonajes) {
			System.out.println("El personaje nombre : "+ personajes.getNombre());
		}*/
		
		String texto = "Jugadores en la partida: \n\n";
	
		for(int i=0; i < this.listaPersonajes.size(); i++) {
			texto = texto + this.listaPersonajes.get(i).toString() + "\n";
		}
		return texto;
	}

	public List<Personaje> getListaPersonajes() {
		return listaPersonajes;
	}

	public Integer obtenerDamage(Integer posicionJugador) {
		return this.listaPersonajes.get(posicionJugador).getAtaqueNormal();
	}
	
	public Integer obtenerDamageHabilidad(Integer posicionJugador) {
		return this.listaPersonajes.get(posicionJugador).getAtaqueHabilidad();
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
	
	public String devolverListaPersonajes(Integer posicionJugador) {
		return this.listaPersonajes.get(posicionJugador).getNombre();
	}

	public void jugadorEliminado(Integer posicionJugador) {	
		 this.listaPersonajes.remove(this.listaPersonajes.get(posicionJugador));
		
	}
	
	public Integer getNumJugadoresPartida() {
		return numJugadoresPartida;
	}

	public void setNumJugadoresPartida(Integer numJugadoresPartida) {
		this.numJugadoresPartida = numJugadoresPartida;
	}

	public Integer jugadoresDisponibles() {
		return this.listaPersonajes.size();
	}
	
	public Integer devolverPosicionJugador(Integer numeroJugador) {
		for(int i = 0 ; i < this.jugadoresDisponibles(); i++) {
			if(numeroJugador == this.listaPersonajes.get(i).getNumeroJugador()) {
				return i;
			} 					
		}
		return -1;
	}
	
	public Integer devolverNumeroJugador(Integer posicionJugador) {
		return this.listaPersonajes.get(posicionJugador).getNumeroJugador();
	}
	
	public String devolverNombreJugador(Integer posicionJugador) {
		return this.listaPersonajes.get(posicionJugador).getNombre();
	}
	
	public String textoHerramientasDisponibles() {
		String texto = "";
		Integer positionList = 0;
	
		for(TipoArma tipo : TipoArma.values()) {
			System.out.println(positionList + ": Herramienta " + tipo + "\n");
			texto = texto + positionList + ": Herramienta " + tipo + "\n";
			positionList++;
		}
		return texto;
	}	

	public String mostrarTextoHerramientasDisponibles() {
		String texto = "Herramientas disponibles: \n\n";
		Integer positionList = 0;
	
		for(TipoArma tipo : TipoArma.values()) {
			System.out.println(positionList + ": Herramienta " + tipo + "\n");
			texto = texto + positionList + ": Herramienta " + tipo + "\n";
			positionList++;
		}
		return texto;
	}	
	

	public Integer esMaquina(Integer posicionJugador) {
		if (posicionJugador >= this.listaPersonajes.size()) {
			return 0;
		}
		
		if(this.listaPersonajes.get(posicionJugador).getTipoUser() == TipoJugador.maquina) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public void calcularGanador() {
		
		String jugadorMasVida ="";
		Integer maxVida = 0;
		
		for(int i=0; i<this.jugadoresDisponibles(); i++) {
			
			if(this.listaPersonajes.get(i).getVidaPersonaje() > maxVida) {
				jugadorMasVida = this.listaPersonajes.get(i).getNombre();
				maxVida = this.listaPersonajes.get(i).getVidaPersonaje();
			}
		}
		JOptionPane.showMessageDialog(null, "El jugador: " + jugadorMasVida + " es el ganador");
	}
	
	public boolean comparaPersonaje(Personaje personaje) {

		for(int i=0; i<this.jugadoresDisponibles(); i++) {
			if(personaje.equals(this.listaPersonajes.get(i))) {
				return true;
			}			
		}
		return false;
	}

}
