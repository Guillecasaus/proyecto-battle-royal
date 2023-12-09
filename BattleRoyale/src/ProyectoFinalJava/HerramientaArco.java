package ProyectoFinalJava;

public class HerramientaArco extends Herramientas{
	public static final Double ARCO_BONUS = 1.4;
	
	public HerramientaArco(String nombre) {
		super(nombre, ARCO_BONUS, TipoArma.arco);
	}
}
