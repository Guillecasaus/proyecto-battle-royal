package ProyectoFinalJava;

public class Herramientas {
	protected Integer bonus;
	protected TipoArma tipo;
	protected Integer usosRestantes;
	protected Integer numHerramienta;
	
	public Herramientas(Integer bonus, TipoArma tipo, Integer usosRestantes, Integer numHerramienta) {
		this.bonus = bonus;
		this.tipo = tipo;
		this.usosRestantes = usosRestantes;
		this.numHerramienta = numHerramienta;
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
	
	public Integer getNumHerramienta() {
		return numHerramienta;
	}

	public void setNumHerramienta(Integer numHerramienta) {
		this.numHerramienta = numHerramienta;
	}

	@Override
	public String toString() {
		return "Herramienta " + tipo + ": bonus = " + bonus + ", Usos = "
				+ usosRestantes;
	}
}
