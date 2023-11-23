package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

public class Partida {

	private List <Personaje> listaPersonajes = new ArrayList <Personaje>();
	private Integer turno;
	
	public Partida(Integer turno) {
		super();
		this.turno = turno;
	}

}
