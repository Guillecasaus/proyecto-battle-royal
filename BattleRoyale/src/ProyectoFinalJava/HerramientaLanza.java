package ProyectoFinalJava;

public class HerramientaLanza extends Herramientas{
	public static final Double LANZA_BONUS = 1.6;
	
	public HerramientaLanza(String nombre) {
		super(nombre, LANZA_BONUS, TipoArma.lanza);
	}
}