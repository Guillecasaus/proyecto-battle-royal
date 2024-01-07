package ProyectoFinalJava;

import javax.swing.JOptionPane;

public class NuevosJugadores {
	
public static void crearJugadores(Partida partidaActual) {
		
		Integer numJugadores = 0;
		String nombreMaquina;
		String nombreJugador;
		PersonajeMago mago;	
		PersonajeElfo elfo;
		PersonajeGuerrero guerrero;
	
		
		do {
			String tipoJugador = JOptionPane.showInputDialog("1. Mago\n2. Guerrero\n3. Elfo\n4. Generar jugadores máquina");
			
				switch(tipoJugador) {
					case "1":
						do {
						nombreJugador = JOptionPane.showInputDialog("Personaje número: " + (numJugadores + 1) + ", Nombre: ");
						mago = new PersonajeMago(nombreJugador, TipoJugador.humano, numJugadores + 1);													
						if(partidaActual.comparaPersonaje(mago)){
							JOptionPane.showMessageDialog(null, "Este nombre ya ha sido introducido");
						}
						}while(partidaActual.comparaPersonaje(mago));
						partidaActual.nuevoPersonaje(mago);
						mago.getInventario().asignarHerramienta(new HerramientaBaston(1));
					break;	
					case "2":
						do {
						nombreJugador = JOptionPane.showInputDialog("Personaje número: " + (numJugadores + 1) + ", Nombre: ");
						guerrero = new PersonajeGuerrero(nombreJugador, TipoJugador.humano, numJugadores + 1);
						if(partidaActual.comparaPersonaje(guerrero)){
							JOptionPane.showMessageDialog(null, "Este nombre ya ha sido introducido");
						}
						}while(partidaActual.comparaPersonaje(guerrero));
						partidaActual.nuevoPersonaje(guerrero);
						guerrero.getInventario().asignarHerramienta(new HerramientaBaston(1));
					break;	
					case "3":
						do {
						nombreJugador = JOptionPane.showInputDialog("Personaje número: " + (numJugadores + 1) + ", Nombre: ");
						elfo = new PersonajeElfo(nombreJugador, TipoJugador.humano, numJugadores + 1);
						if(partidaActual.comparaPersonaje(elfo)){
							JOptionPane.showMessageDialog(null, "Este nombre ya ha sido introducido");
						}
						}while(partidaActual.comparaPersonaje(elfo));
						partidaActual.nuevoPersonaje(elfo);
						elfo.getInventario().asignarHerramienta(new HerramientaBaston(1));
					break;
					case "4":					
						for(int i=numJugadores; i<partidaActual.getNumJugadoresPartida(); i++) {
							Integer tipoJugadorMaquina = (int)(Math.random()*3+1);
							nombreMaquina = "jugadorMaquina" + i;
							switch(tipoJugadorMaquina){
								case 1:
									PersonajeGuerrero guerreroMaquina = new PersonajeGuerrero(nombreMaquina, TipoJugador.maquina, numJugadores + 1);							
									partidaActual.nuevoPersonaje(guerreroMaquina);
									guerreroMaquina.getInventario().asignarHerramienta(new HerramientaBaston(1));
									numJugadores++;
								break;	
							
								case 2:
									PersonajeMago magoMaquina = new PersonajeMago(nombreMaquina, TipoJugador.maquina, numJugadores + 1);							
									partidaActual.nuevoPersonaje(magoMaquina);
									magoMaquina.getInventario().asignarHerramienta(new HerramientaBaston(1));
									numJugadores++;
								break;
							
								case 3:
									PersonajeElfo elfoMaquina = new PersonajeElfo(nombreMaquina, TipoJugador.maquina, numJugadores + 1);							
									partidaActual.nuevoPersonaje(elfoMaquina);
									elfoMaquina.getInventario().asignarHerramienta(new HerramientaBaston(1));
									numJugadores++;
								break;
							
							}
						}
						numJugadores = partidaActual.getNumJugadoresPartida();
						
					break;
					
					default:	
						JOptionPane.showMessageDialog(null, "Valor introducido erróneo");
				}				
			numJugadores++;
		}while((numJugadores < partidaActual.getNumJugadoresPartida()));
	
		partidaActual.mostrarPersonajes();
	
	}
	
}
