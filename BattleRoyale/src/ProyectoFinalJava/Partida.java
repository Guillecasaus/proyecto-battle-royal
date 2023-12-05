package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

public class Partida {

	public static final Integer TURNO_INICIAL = 0;
	
	private List <Personaje> listaPersonajes; 
	private List <Turno> listaTurnos;
	private Integer turno;
	
	public Partida() {
		this.turno = Partida.TURNO_INICIAL;
		this.listaPersonajes = new ArrayList <Personaje>();
		this.listaTurnos = new ArrayList <Turno>();
	}

}
