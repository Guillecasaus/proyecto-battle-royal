package ProyectoFinalJava;

public class HerramientaEspada extends Herramientas{
	public static final Integer ESPADA_BONUS = 30;
	public static final Integer USOS = 2;
	
	public HerramientaEspada(Integer numHerramienta) {
		super(ESPADA_BONUS, TipoArma.espada, HerramientaEspada.USOS, numHerramienta);
	}
}
