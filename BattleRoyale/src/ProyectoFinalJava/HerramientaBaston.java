package ProyectoFinalJava;

public class HerramientaBaston extends Herramientas{
	public static final Integer BASTON_BONUS = 10;
	public static final Integer USOS = 3;
	
	public HerramientaBaston(String nombre) {
		super(nombre, BASTON_BONUS, TipoArma.baston, HerramientaBaston.USOS);
	}
}
