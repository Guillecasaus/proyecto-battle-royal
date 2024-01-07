package ProyectoFinalJava;

public class HerramientaArco  extends Herramientas{
	public static final Integer ARCO_BONUS = 20;
	public static final Integer USOS = 1;
	
	public HerramientaArco(Integer numHerramienta) {
		super(ARCO_BONUS, TipoArma.arco, HerramientaArco.USOS, numHerramienta);
	}
}