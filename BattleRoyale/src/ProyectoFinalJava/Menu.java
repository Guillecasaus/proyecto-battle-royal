package ProyectoFinalJava;
import javax.swing.*;	

public class Menu {
	
	public static void crearJugadores(Partida partidaActual) {
		
		Integer numJugadores = 0;
		String nombreMaquina;
		String nombreJugador;
		
		do {
			String tipoJugador = JOptionPane.showInputDialog("1. Mago\n2. Guerrero\n3. Elfo\n4. Salir");
			
				switch(tipoJugador) {
					case "1":
						nombreJugador = JOptionPane.showInputDialog("Personaje número: " + (numJugadores + 1) + ", Nombre: ");
						PersonajeMago mago = new PersonajeMago(nombreJugador, TipoJugador.humano, numJugadores + 1);							
						partidaActual.nuevoPersonaje(mago);
						mago.asignarHerramienta(new HerramientaBaston("baston"));
					break;	
					case "2":
						nombreJugador = JOptionPane.showInputDialog("Personaje número: " + (numJugadores + 1) + ", Nombre: ");
						PersonajeGuerrero guerrero = new PersonajeGuerrero(nombreJugador, TipoJugador.humano, numJugadores + 1);
						partidaActual.nuevoPersonaje(guerrero);
						guerrero.asignarHerramienta(new HerramientaBaston("baston"));
					break;	
					case "3":
						nombreJugador = JOptionPane.showInputDialog("Personaje número: " + (numJugadores + 1) + ", Nombre: ");
						PersonajeElfo elfo = new PersonajeElfo(nombreJugador, TipoJugador.humano, numJugadores + 1);
						partidaActual.nuevoPersonaje(elfo);
						elfo.asignarHerramienta(new HerramientaBaston("baston"));
					break;
					case "4":
					
						for(int i=numJugadores; i<Partida.NUM_MAX_JUGADORES; i++) {
							nombreMaquina = "jugadorMaquina" + i;
							PersonajeGuerrero guerreroMaquina = new PersonajeGuerrero(nombreMaquina, TipoJugador.maquina, numJugadores + 1);
							partidaActual.nuevoPersonaje(guerreroMaquina);
							guerreroMaquina.asignarHerramienta(new HerramientaBaston("baston"));
						}
						numJugadores = Partida.NUM_MAX_JUGADORES;
						
					break;
					
					default:	
						JOptionPane.showMessageDialog(null, "Valor introducido erróneo");
				}				
			numJugadores++;
		}while((numJugadores < Partida.NUM_MAX_JUGADORES));
	
		partidaActual.mostrarPersonajes();
	
	}
	
	public static void partidaEnCurso(Partida partidaActual) {
		
		Integer numTurnos = 0;
		Integer numJugadorAtacante;
		Integer jugadorRecuperarVida;
		String menuPartida;
		String menuAtaque;
		String menuHerramientaAtaque;
		Integer damage;
		Integer vida;
		String jugadoresDisponibles;
		Integer jugadorAtacado;
		
		do{
			numJugadorAtacante = numTurnos % Partida.NUM_MAX_JUGADORES;
			jugadorRecuperarVida = numTurnos % Partida.NUM_MAX_JUGADORES;
			
			menuPartida = JOptionPane.showInputDialog("Turno: " + numTurnos + "\nJugador Numero: " + numJugadorAtacante +"\n1. Atacar \n2. Usar Habilidad Ofensiva \n3 Coger Objeto \n4. Recuperar Vida");
			
			switch (menuPartida) {
				case "1":
					menuAtaque = JOptionPane.showInputDialog("Turno: " + numTurnos + "\nJugador Numero: " + numJugadorAtacante +"\n1. Ataque Normal \n2. Usar Herramienta");
					switch (menuAtaque) {
						case "1":
							jugadoresDisponibles = JOptionPane.showInputDialog("A que jugador quieres atacar: ");
							jugadorAtacado = Integer.parseInt(jugadoresDisponibles);	
							damage = partidaActual.obtenerDamage(numJugadorAtacante);
							partidaActual.quitarDamage(jugadorAtacado, damage);
							if (partidaActual.devolverVidaPersonaje(jugadorAtacado) <= 0) {
								partidaActual.jugadorEliminado(jugadorAtacado);
							}
						break;
						case "2":
							partidaActual.getListaPersonajes().get(numJugadorAtacante).mostrarInventarioHerramientas();
							menuHerramientaAtaque = JOptionPane.showInputDialog("Turno: " + numTurnos + "\nJugador Numero: " + numJugadorAtacante +"\n Introduzca numero de la herramienta deseada: ");
							if (Integer.valueOf(menuHerramientaAtaque) <= partidaActual.getListaPersonajes().get(numJugadorAtacante).getListaHerramientas().size()) {
								//Buscar herramienta
								damage = partidaActual.obtenerDamage(numJugadorAtacante) + partidaActual.getListaPersonajes().get(numJugadorAtacante).getListaHerramientas().get(Integer.valueOf(menuHerramientaAtaque)).getBonus();
								
							} else {
								JOptionPane.showMessageDialog(null, "No tiene ninguna herramienta en esta posicion de inventario");
								damage = partidaActual.obtenerDamage(numJugadorAtacante);
								//TODO Volver a inicio
							}
							jugadoresDisponibles = JOptionPane.showInputDialog("A que jugador quieres atacar: ");
							jugadorAtacado = Integer.parseInt(jugadoresDisponibles);	
							partidaActual.quitarDamage(jugadorAtacado, damage);
							if (partidaActual.devolverVidaPersonaje(jugadorAtacado) <= 0) {
								partidaActual.jugadorEliminado(jugadorAtacado);
							}
						break;
					}
				break;
				case "2":
					if (partidaActual.getListaPersonajes().get(numJugadorAtacante).estaEnCD == false) {
						jugadoresDisponibles = JOptionPane.showInputDialog("Contra que jugador quieres usar la habilidad: ");
						jugadorAtacado = Integer.parseInt(jugadoresDisponibles);
						damage = partidaActual.obtenerDamageHabilidad(numJugadorAtacante);
						partidaActual.quitarDamage(jugadorAtacado, damage);
						if (partidaActual.devolverVidaPersonaje(jugadorAtacado) <= 0) {
							partidaActual.jugadorEliminado(jugadorAtacado);
						}
						partidaActual.getListaPersonajes().get(numJugadorAtacante).estaEnCD = true;
						partidaActual.getListaPersonajes().get(numJugadorAtacante).setCounterCD(partidaActual.getListaPersonajes().get(numJugadorAtacante).getCooldownHabilidad()+1);
					} else {
						//TODO Volver al inicio
						JOptionPane.showMessageDialog(null, "La habilidad no está disponible"); //TODO Poner cuantos turnos faltan 
					}
				break;	
				case "3":
					
				break;	
				case "4":
					vida = partidaActual.obtenerVida(jugadorRecuperarVida);
					partidaActual.recuperarVida(jugadorRecuperarVida, vida);
				break;
				
				default:	
					JOptionPane.showMessageDialog(null, "Valor introducido erróneo");
			}
		
			numTurnos ++;
			
			if(partidaActual.jugadoresDisponibles() == 1) {
				JOptionPane.showMessageDialog(null, "El jugador: " + numJugadorAtacante + " es el ganador");
				numTurnos = Partida.MAX_TURNOS;
			}
			
			//Cambiar valor CD personaje que ha jugado
			partidaActual.getListaPersonajes().get(numJugadorAtacante).controlCD();
			
			partidaActual.mostrarPersonajes();
		}while(numTurnos < Partida.MAX_TURNOS);
	}
	
	public static void main(String[] args) {
		
	String menu = JOptionPane.showInputDialog("1. Iniciar Partida\n2. Continuar Partida\n3 Terminar");
	System.out.println("Hello "+menu);
		
		switch(menu) {
			case "1":
				Partida partidaActiva = new Partida();
				JOptionPane.showMessageDialog(null, "Partida iniciada");
				crearJugadores(partidaActiva);	
				partidaEnCurso(partidaActiva);
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

