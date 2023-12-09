package ProyectoFinalJava;

public class Herramientas {

	private String nombre;
	private Double bonus;
	private TipoArma tipo;
	
	public Herramientas(String nombre, Double bonus, TipoArma tipo) {
		this.nombre = nombre;
		this.bonus = bonus;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public TipoArma getTipo() {
		return tipo;
	}

	public void setTipo(TipoArma tipo) {
		this.tipo = tipo;
	}

	
	
}
