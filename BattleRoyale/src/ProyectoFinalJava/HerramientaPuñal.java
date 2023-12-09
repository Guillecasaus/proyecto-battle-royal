package ProyectoFinalJava;

public class HerramientaPuñal extends Herramientas{
	public static final Double PUÑAL_BONUS = 1.2;
	
	public HerramientaPuñal(String nombre) {
		super(nombre, PUÑAL_BONUS, TipoArma.puñal);
	}
}
