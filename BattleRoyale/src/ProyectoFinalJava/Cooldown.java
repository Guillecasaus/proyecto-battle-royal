package ProyectoFinalJava;

public class Cooldown {
	//TRUE si está esperando a acabar cooldown, FALSE si está listo para usar
	private Boolean CDActivo;
	//Contador cooldown. Empieza en 0 y pasa a un numero especificado tras uso
	private Integer counterCD;
	
	public Cooldown() {
		this.CDActivo = false;
		this.counterCD = 0;
	}
	
	public Boolean getEstaOnCD() {
		return CDActivo;
	}

	public void setEstaOnCD(Boolean estaOnCD) {
		this.CDActivo = estaOnCD;
	}

	public Integer getCounterCD() {
		return counterCD;
	}

	public void setCounterCD(Integer counterCD) {
		this.counterCD = counterCD;
	}
	
	//Funcion que se llama para cada personaje al final de su turno
	public void controlCD() {
		//Si el cd es mas que 0, se baja 1 
		if (this.counterCD > 0) {
			this.counterCD--;
		}
		//Una vez modificado, se ve si ha acabado justo su cd
		if (this.counterCD == 0) {
			this.CDActivo = false;
		} else {
			this.CDActivo = true;
		}
	}
}
