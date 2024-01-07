package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Inventario {
	public static final Integer NUM_MAX_HERRAMIENTAS_DEFAULT = 3;
	public static final Integer NUM_INICIAL_HERRAMIENTAS = 0;
	
	private List <Herramientas> listaHerramientas; 
	private Integer numeroHerramientas;
	private Integer maxHerramientas;
	
	public Inventario() {
		this(Inventario.NUM_MAX_HERRAMIENTAS_DEFAULT);
	}
	
	public Inventario(Integer maxHerramientas) {
		this.listaHerramientas = new ArrayList<Herramientas>();
		this.numeroHerramientas = Inventario.NUM_INICIAL_HERRAMIENTAS;
		this.maxHerramientas = maxHerramientas;
	}
	
	//GETTERS Y SETTERS
	public List<Herramientas> getListaHerramientas() {
		return listaHerramientas;
	}

	public void setListaHerramientas(List<Herramientas> listaHerramientas) {
		this.listaHerramientas = listaHerramientas;
	}

	public Integer getNumeroHerramientas() {
		return numeroHerramientas;
	}

	public void setNumeroHerramientas(Integer numeroHerramientas) {
		this.numeroHerramientas = numeroHerramientas;
	}

	public Integer getMaxHerramientas() {
		return maxHerramientas;
	}

	public void setMaxHerramientas(Integer maxHerramientas) {
		this.maxHerramientas = maxHerramientas;
	}
	
	//METODOS
	public Integer asignarHerramienta(Herramientas herramientaAsignar) {
		if(this.numeroHerramientas >= this.maxHerramientas) {
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
			System.out.println("Posicion " + i + " - "+ this.listaHerramientas.get(i).toString() + "\n");
			texto = texto + "Posicion " + i + " - "+ this.listaHerramientas.get(i).toString() + "\n"	;
		}
		JOptionPane.showMessageDialog(null, texto);
	}
	
	public String textoInventarioHerramientas() {
		String texto = "";
	
		for(int i=0; i < this.listaHerramientas.size(); i++) {
			System.out.println("Posicion " + i + " - "+ this.listaHerramientas.get(i).toString() + "\n");
			texto = texto + "Posicion " + i + " - "+ this.listaHerramientas.get(i).toString() + "\n";
		}
		return texto;
	}
	
	public void controlHerramientaUsos(Integer numHerramienta) {
		//Quitar 1 uso a herramienta indicada
		this.listaHerramientas.get(numHerramienta).setUsosRestantes(this.listaHerramientas.get(numHerramienta).getUsosRestantes()-1);
		//Comprobar si quedan usos, quitar herramienta de inventario si no quedan
		if(this.listaHerramientas.get(numHerramienta).getUsosRestantes() == 0) {
			this.listaHerramientas.remove(this.listaHerramientas.get(numHerramienta));
		}
	}

}
