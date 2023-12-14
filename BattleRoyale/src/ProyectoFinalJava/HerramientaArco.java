package ProyectoFinalJava;

public class HerramientaArco extends Herramientas{
	public static final Integer ARCO_BONUS = 20;
	public static final Integer USOS = 3;
	
	public HerramientaArco(String nombre) {
		super(nombre, ARCO_BONUS, TipoArma.arco, HerramientaArco.USOS);
	}
}
