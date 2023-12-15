package ProyectoFinalJava;

public class Herramientas {
	protected String nombre;
	protected Integer bonus;
	protected TipoArma tipo;
	protected Integer usosRestantes;
	
	public Herramientas(String nombre, Integer bonus, TipoArma tipo, Integer usosRestantes) {
		this.nombre = nombre;
		this.bonus = bonus;
		this.tipo = tipo;
		this.usosRestantes = usosRestantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public TipoArma getTipo() {
		return tipo;
	}

	public void setTipo(TipoArma tipo) {
		this.tipo = tipo;
	}

	public Integer getUsosRestantes() {
		return usosRestantes;
	}

	public void setUsosRestantes(Integer usosRestantes) {
		this.usosRestantes = usosRestantes;
	}

	
	
}
