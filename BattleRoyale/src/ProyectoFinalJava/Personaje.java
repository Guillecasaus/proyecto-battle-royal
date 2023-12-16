package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Personaje {

	public static final Integer MAX_VIDA_PERSONAJE = 100;
	public static final Integer NUM_MAX_HERRAMIENTAS = 3;
	public static final Integer NUM_INICIAL_HERRAMIENTAS = 0;
	public static final Integer ATAQUE_NORMAL = 10;
	public static final Integer ATAQUE_HABILIDAD = 30;
	public static final Integer COOLDOWN_HABILIDAD = 4;
	
	private String nombre;
	private Integer vidaPersonaje;
	private List <Herramientas> listaHerramientas; 
	private TipoJugador tipoUser;
	private Integer numeroHerramientas;
	private TipoPersonaje tipoPer;
	private Integer numeroJugador;
	
	//TRUE si está esperando a acabar cooldown, FALSE si la habilidad está lista
	protected Boolean estaEnCD;
	//Contador cooldown. Empieza en 0 y pasa a un numero especificado tras usarse la habilidad
	protected Integer counterCD;
	//Daño de ataque normal, al que luego se aplica el bonus por arma equipada (daño final = ataqueNormal * bonus arma) 
	protected Integer ataqueNormal;
	//Daño hecho por la habilidad con cooldown (no dependiente de herramientas)
	protected Integer ataqueHabilidad;
	//Cooldown de la habilidad en cuestion (num turnos hasta que se puede usar otra vez)
	protected Integer cooldownHabilidad;
	
	//Boolean y contador cooldown para obtener herramientas
	protected Boolean estaCDHerramienta;
	protected Integer counterCDHerramienta;
		
	public Personaje(String nombre, TipoJugador tipoUser, TipoPersonaje tipoPer, Integer numeroJugador) {
		this.nombre = nombre;
		this.vidaPersonaje = Personaje.MAX_VIDA_PERSONAJE;
		this.tipoUser = tipoUser;
		this.listaHerramientas = new ArrayList<Herramientas>();
		this.numeroHerramientas = Personaje.NUM_INICIAL_HERRAMIENTAS;
		this.tipoPer = tipoPer;
		this.ataqueHabilidad = ATAQUE_HABILIDAD;
		this.ataqueNormal = ATAQUE_NORMAL;
		this.cooldownHabilidad = COOLDOWN_HABILIDAD;
		this.counterCD = 0;
		this.numeroJugador = numeroJugador;
		this.estaEnCD = false;
		this.estaCDHerramienta = false;
		this.counterCDHerramienta = 0;
		
	}
	
	public Personaje(String nombre, TipoJugador tipoUser, Integer vida,  TipoPersonaje tipoPer, Integer ataqueNormal, Integer ataqueHabilidad, Integer cooldownHabilidad, Integer numeroJugador) {
		this.nombre = nombre;
		this.vidaPersonaje = vida;
		this.tipoUser = tipoUser;
		this.listaHerramientas = new ArrayList<Herramientas>();
		this.numeroHerramientas = Personaje.NUM_INICIAL_HERRAMIENTAS;
		this.tipoPer = tipoPer;
		this.ataqueHabilidad = ataqueHabilidad;
		this.ataqueNormal = ataqueNormal;
		this.cooldownHabilidad = cooldownHabilidad;
		this.counterCD = 0;
		this.numeroJugador = numeroJugador;
		this.estaEnCD = false;
		this.estaCDHerramienta = false;
		this.counterCDHerramienta = 0;
	}
	
	public Integer getCounterCD() {
		return counterCD;
	}

	public void setCounterCD(Integer counterCD) {
		this.counterCD = counterCD;
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

	public Integer getCooldownHabilidad() {
		return cooldownHabilidad;
	}

	public void setCooldownHabilidad(Integer cooldownHabilidad) {
		this.cooldownHabilidad = cooldownHabilidad;
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
	
	public Integer getCounterCDHerramienta() {
		return counterCDHerramienta;
	}

	public void setCounterCDHerramienta(Integer counterCDHerramienta) {
		this.counterCDHerramienta = counterCDHerramienta;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", vidaPersonaje=" + vidaPersonaje + ", listaHerramientas="
				+ listaHerramientas + ", tipoUser=" + tipoUser + ", numeroHerramientas=" + numeroHerramientas + ", tipoPer="
				+ tipoPer + "]";
	}
	
	//Funcion que se llama para cada personaje al final de su turno
	public void controlCD() {
		//Si el cd es mas que 0, se baja 1 
		if (this.counterCD > 0) {
			this.counterCD--;
		}
		//Una vez modificado, se ve si ha acabado justo su cd
		if (this.counterCD == 0) {
			this.estaEnCD = false;
		} else {
			this.estaEnCD = true;
		}
	}

	//Funcion que se llama para cada personaje al final de su turno
	public void controlCDHerramienta() {
		//Si el cd es mas que 0, se baja 1 
		if (this.counterCDHerramienta > 0) {
			this.counterCDHerramienta--;
		}
		//Una vez modificado, se ve si ha acabado justo su cd
		if (this.counterCDHerramienta == 0) {
			this.estaCDHerramienta = false;
		} else {
			this.estaCDHerramienta = true;
		}
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
	
	/*
	public Integer habilidad() {
		return 1;
	}
	*/
	public Integer recuperarVida() {
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
	
	public void mostrarInventarioHerramientas() {
		String texto = "Herramientas en el inventario: \n\n";
	
		for(int i=0; i < this.listaHerramientas.size(); i++) {
			System.out.println("Herramienta " + i + ": "+ this.listaHerramientas.get(i).getTipo() + ". Bonus: " + this.listaHerramientas.get(i).getBonus() + ". Usos restantes: " + this.listaHerramientas.get(i).getUsosRestantes());
			texto = texto + "Herramienta " + i + ": "+ this.listaHerramientas.get(i).getTipo() + ". Bonus: " + this.listaHerramientas.get(i).getBonus() + ". Usos restantes: " + this.listaHerramientas.get(i).getUsosRestantes() + "\n";
		}
		JOptionPane.showMessageDialog(null, texto);
	}
	
	public void controlHerramientaUsada(Integer numHerramienta) {
		//Quitar 1 uso a herramienta indicada
		this.listaHerramientas.get(numHerramienta).setUsosRestantes(this.listaHerramientas.get(numHerramienta).getUsosRestantes()-1);
		//Comprobar si quedan usos, quitar herramienta de inventario si no quedan
		if(this.listaHerramientas.get(numHerramienta).getUsosRestantes() == 0) {
			this.listaHerramientas.remove(this.listaHerramientas.get(numHerramienta));
		}
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

}
