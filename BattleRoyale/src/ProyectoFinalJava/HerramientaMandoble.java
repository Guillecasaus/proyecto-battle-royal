package ProyectoFinalJava;

public class HerramientaMandoble extends Herramientas{
	public static final Double MANDOBLE_BONUS = 2.0;
	
	public HerramientaMandoble(String nombre) {
		super(nombre, MANDOBLE_BONUS, TipoArma.mandoble);
	}
}
