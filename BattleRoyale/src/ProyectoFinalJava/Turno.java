package ProyectoFinalJava;

public class Turno {
	
	private Integer turnoJugador;
	private String actua;
	private String afectado;
	private Acciones accionesTurno;
	private Boolean exitoso;
	
	public Turno(Integer turnoJugador) {
		this.turnoJugador = turnoJugador;
		this.afectado = "N/A";
		this.accionesTurno = Acciones.ERROR;
		this.exitoso = false;
	}

	public String getActua() {
		return actua;
	}

	public void setActua(String actua) {
		this.actua = actua;
	}

	public String getAfectado() {
		return afectado;
	}

	public void setAfectado(String afectado) {
		this.afectado = afectado;
	}

	public Acciones getAccionesTurno() {
		return accionesTurno;
	}

	public void setAccionesTurno(Acciones accionesTurno) {
		this.accionesTurno = accionesTurno;
	}

	public Boolean getExitoso() {
		return exitoso;
	}

	public void setExitoso(Boolean exitoso) {
		this.exitoso = exitoso;
	}

	@Override
	public String toString() {
		return "Turno " + turnoJugador + ":\n"
				+ "    Jugador actuando: " + actua + "\n"
				+ "    Jugador afectado: " + afectado + "\n"
				+ "    Acción en el turno: " + accionesTurno + "\n"
				+ "    Acción se lleva a cabo con éxito: " + exitoso + "\n\n";
	}
	
}
