package ProyectoFinalJava;

public class HerramientaEspada extends Herramientas{
	public static final Double ESPADA_BONUS = 1.8;
	
	public HerramientaEspada(String nombre) {
		super(nombre, ESPADA_BONUS, TipoArma.espada);
	}
}