package ProyectoFinalJava;
import javax.swing.*;	

public class Menu {
	
	public static void crearJugadores(Partida partidaActual) {
		
		Integer numJugadores = 0;
		
		do {
			String tipoJugador = JOptionPane.showInputDialog("1. Mago\n2. Guerrero\n3. Elfo");
			
			String nombreJugador = JOptionPane.showInputDialog("Personaje número: " + (numJugadores + 1) + ", Nombre: ");
			
				switch(tipoJugador) {
					case "1":
						PersonajeMago mago = new PersonajeMago(nombreJugador, TipoJugador.humano);							
						partidaActual.nuevoPersonaje(mago);
					break;	
					case "2":
						PersonajeGuerrero guerrero = new PersonajeGuerrero(nombreJugador, TipoJugador.humano);
						partidaActual.nuevoPersonaje(guerrero);
					break;	
					case "3":
						PersonajeElfo elfo = new PersonajeElfo(nombreJugador, TipoJugador.humano);
						partidaActual.nuevoPersonaje(elfo);
					break;
					
					default:	
						JOptionPane.showMessageDialog(null, "Valor introducido erróneo");
			
				}				
			numJugadores++;
		}while((numJugadores < Partida.NUM_MAX_JUGADORES));
	
		partidaActual.mostrarPersonajes();
	
	}
	
	public static void main(String[] args) {
		
	String menu = JOptionPane.showInputDialog("1. Iniciar Partida\n2. Continuar Partida\n3 Terminar");
	System.out.println("Hello "+menu);
		
		switch(menu) {
			case "1":
				Partida partidaActiva = new Partida();
				JOptionPane.showMessageDialog(null, "Partida iniciada");
				crearJugadores(partidaActiva);	
			break;	
			case "2":
				JOptionPane.showMessageDialog(null, "Partida reanudada");
			break;	
			case "3":
				JOptionPane.showMessageDialog(null, "Partida terminidada");
			break;	
			
			default:	
				JOptionPane.showMessageDialog(null, "Valor introducido erróneo");
				
		}	
	}
}

