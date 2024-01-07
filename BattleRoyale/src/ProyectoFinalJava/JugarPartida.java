package ProyectoFinalJava;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class JugarPartida {
	static Maquina maquina = new Maquina();
	//private static List<Turno> listaTurnos = new ArrayList<Turno>();
	
	public static void partidaEnCurso(Partida partidaActual,List<Turno> listaTurnos ) {
		List<Herramientas> listHerrPosibles = new ArrayList<Herramientas>();
		listHerrPosibles.add(new Herramientas(10, TipoArma.baston, 3, 1));
		listHerrPosibles.add(new Herramientas(30, TipoArma.espada, 3, 2));
		listHerrPosibles.add(new Herramientas(20, TipoArma.arco, 3, 3));
		Integer numTurnos = 0;
		Integer numJugadorAtacante;
		Integer jugadorRecuperarVida;
		String herramientaEscoger = "0";
		String menuPartida;
		String menuAtaque;
		String menuHerramientaAtaque = "-1";
		Integer damage = 0;
		Integer vida;
		String jugadoresDisponibles=" ";
		Integer jugadorAtacado=0;
		Integer numHerramientaUsada = 0;
		
		do{
			numJugadorAtacante = numTurnos % partidaActual.jugadoresDisponibles();
			jugadorRecuperarVida = numTurnos % partidaActual.jugadoresDisponibles();
			
			//Crea nuevo objeto turno y va rellenando con información corespondiente
			Turno turnoActual = new Turno(numTurnos);
			turnoActual.setActua(partidaActual.getListaPersonajes().get(numJugadorAtacante).getNombre());
			jugadorAtacado = 0;
			numHerramientaUsada = 0;
			menuHerramientaAtaque = "-1";
			herramientaEscoger = "0";
			
			if(partidaActual.esMaquina(numJugadorAtacante) == 1) {
				turnoActual = Maquina.turnoMaquina(partidaActual, numJugadorAtacante, numTurnos);
			} else {
				menuPartida = JOptionPane.showInputDialog("Turno: " + numTurnos + "\nJugador Numero: " + partidaActual.devolverNumeroJugador(numJugadorAtacante) + "\n1. Atacar \n2. Usar Habilidad Ofensiva\n3 Coger Objeto \n4. Recuperar Vida");
				switch (menuPartida) {
					case "1":
						menuAtaque = JOptionPane.showInputDialog("Turno: " + numTurnos + "\nJugador Numero: " + partidaActual.devolverNumeroJugador(numJugadorAtacante) + "\n1. Ataque Normal \n2. Usar Herramienta");
						switch (menuAtaque) {
							case "1":
								turnoActual.setAccionesTurno(Acciones.atacarNormal);
								do{
									SelectorJugador selJugAt = new SelectorJugador(partidaActual.getListaPersonajes());
									selJugAt.show();
									while(jugadorAtacado == 0) {
										
										jugadorAtacado = selJugAt.getNumElegido();
									}
								/*jugadoresDisponibles = JOptionPane.showInputDialog("A que jugador quieres atacar: \n" + partidaActual.textoPersonajes());																																													
								jugadorAtacado = Integer.parseInt(jugadoresDisponibles);*/
									if(partidaActual.devolverPosicionJugador(jugadorAtacado) == numJugadorAtacante) {
										JOptionPane.showMessageDialog(null, "No te puedes atacar a ti mismo");
									}
								} while(partidaActual.devolverPosicionJugador(jugadorAtacado) == numJugadorAtacante);
								
								//jugadorAtacado = Integer.parseInt(jugadoresDisponibles);	
								turnoActual.setAfectado(partidaActual.getListaPersonajes().get(partidaActual.devolverPosicionJugador(jugadorAtacado)).getNombre());
								damage = partidaActual.obtenerDamage(numJugadorAtacante);
								partidaActual.quitarDamage(partidaActual.devolverPosicionJugador(jugadorAtacado), damage);
							
							if (partidaActual.devolverVidaPersonaje(partidaActual.devolverPosicionJugador(jugadorAtacado)) <= 0) {
								partidaActual.jugadorEliminado(partidaActual.devolverPosicionJugador(jugadorAtacado));
							}
							turnoActual.setExitoso(true);
												
							break;
							case "2":
								//partidaActual.getListaPersonajes().get(numJugadorAtacante).mostrarInventarioHerramientas();
								turnoActual.setAccionesTurno(Acciones.atacarHerramienta);
									do{
										SelectorHerramientas selHerrAt = new SelectorHerramientas(partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas());
										selHerrAt.show();
										while(numHerramientaUsada == 0) {
											numHerramientaUsada = selHerrAt.getNumElegido();
										}
									} while(partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas().get(numHerramientaUsada-1).getNumHerramienta() != numHerramientaUsada);
									
								//menuHerramientaAtaque = JOptionPane.showInputDialog("Turno: " + numTurnos + "\nJugador Numero: " + partidaActual.devolverNumeroJugador(numJugadorAtacante) + "\n Introduzca numero de la herramienta deseada: \n"+ partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().textoInventarioHerramientas());
								damage = partidaActual.obtenerDamage(numJugadorAtacante) + partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas().get(numHerramientaUsada-1).getBonus();
								partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().controlHerramientaUsos(numHerramientaUsada-1);
								
								do{
									SelectorJugador selJugAt = new SelectorJugador(partidaActual.getListaPersonajes());
									selJugAt.show();
									while(jugadorAtacado == 0) {
										jugadorAtacado = selJugAt.getNumElegido();
									}
								/*jugadoresDisponibles = JOptionPane.showInputDialog("A que jugador quieres atacar: \n" + partidaActual.textoPersonajes());																																													
								jugadorAtacado = Integer.parseInt(jugadoresDisponibles);*/
									if(partidaActual.devolverPosicionJugador(jugadorAtacado) == numJugadorAtacante) {
										JOptionPane.showMessageDialog(null, "No te puedes atacar a ti mismo");
									}
								} while(partidaActual.devolverPosicionJugador(jugadorAtacado) == numJugadorAtacante);
								
								turnoActual.setAfectado(partidaActual.getListaPersonajes().get(partidaActual.devolverPosicionJugador(jugadorAtacado)).getNombre());
								partidaActual.quitarDamage(partidaActual.devolverPosicionJugador(jugadorAtacado), damage);
								turnoActual.setExitoso(true);
								if (partidaActual.devolverVidaPersonaje(partidaActual.devolverPosicionJugador(jugadorAtacado)) <= 0) {
									partidaActual.jugadorEliminado(partidaActual.devolverPosicionJugador(jugadorAtacado));
								}
							break;
							default:
								JOptionPane.showMessageDialog(null, "Opción elegida incorrecta");
								turnoActual.setAccionesTurno(Acciones.ERROR);
								turnoActual.setExitoso(false);
							break;
							}
					break;
					case "2":
						turnoActual.setAccionesTurno(Acciones.HabilidadOfensiva);
						if (partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDHabilidad().getEstaOnCD() == false) {
							
							do{
								SelectorJugador selJugAt = new SelectorJugador(partidaActual.getListaPersonajes());
								selJugAt.show();
								while(jugadorAtacado == 0) {
									jugadorAtacado = selJugAt.getNumElegido();
								}
							/*jugadoresDisponibles = JOptionPane.showInputDialog("A que jugador quieres atacar: \n" + partidaActual.textoPersonajes());																																													
							jugadorAtacado = Integer.parseInt(jugadoresDisponibles);*/
								if(partidaActual.devolverPosicionJugador(jugadorAtacado) == numJugadorAtacante) {
									JOptionPane.showMessageDialog(null, "No te puedes atacar a ti mismo");
								}
							} while(partidaActual.devolverPosicionJugador(jugadorAtacado) == numJugadorAtacante);
							
							turnoActual.setAfectado(partidaActual.getListaPersonajes().get(partidaActual.devolverPosicionJugador(jugadorAtacado)).getNombre());
							damage = partidaActual.obtenerDamageHabilidad(numJugadorAtacante);
							turnoActual.setExitoso(true);;
							partidaActual.quitarDamage(partidaActual.devolverPosicionJugador(jugadorAtacado), damage);
							if (partidaActual.devolverVidaPersonaje(partidaActual.devolverPosicionJugador(jugadorAtacado)) <= 0) {
								partidaActual.jugadorEliminado(partidaActual.devolverPosicionJugador(jugadorAtacado));
							}
							partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setEstaOnCD(true);
							partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDHabilidad().setCounterCD(partidaActual.getListaPersonajes().get(numJugadorAtacante).getTurnosHabilidad()+1);
						} else {
							JOptionPane.showMessageDialog(null, "La habilidad no está disponible");
							turnoActual.setExitoso(false);
						}
					break;	
					case "3":
						turnoActual.setAccionesTurno(Acciones.cogerObjeto);
						turnoActual.setAfectado(partidaActual.getListaPersonajes().get(numJugadorAtacante).getNombre());
						if(partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().getEstaOnCD() == false) {
							SelectorHerramientas selHerrPos = new SelectorHerramientas(listHerrPosibles);
							do {
								selHerrPos.show();
								herramientaEscoger = selHerrPos.getNumElegido().toString();
							} while (selHerrPos.getNumElegido().toString().equals("-1"));
							//String herramientaEscoger = JOptionPane.showInputDialog("Seleccione herramienta para añadir: \n" + partidaActual.textoHerramientasDisponibles());
							switch (herramientaEscoger) {
								case "0": 
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().asignarHerramienta(new HerramientaBaston(partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas().size()+1));
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setEstaOnCD(true);
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setCounterCD(Partida.TURNOS_CD_ESCOGER_HERRAMIENTA+1);
									turnoActual.setExitoso(true);
								break;
								case "1": 
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().asignarHerramienta(new HerramientaEspada(partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas().size()+1));
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setEstaOnCD(true);
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setCounterCD(Partida.TURNOS_CD_ESCOGER_HERRAMIENTA+1);
									turnoActual.setExitoso(true);
								break;
								case "2": 
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().asignarHerramienta(new HerramientaArco(partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas().size()+1));
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setEstaOnCD(true);
									partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setCounterCD(Partida.TURNOS_CD_ESCOGER_HERRAMIENTA+1);
									turnoActual.setExitoso(true);
								break;
								default:
									JOptionPane.showMessageDialog(null, "No existe la herramienta escogida");
									turnoActual.setExitoso(false);
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Aún no puede volver a elegir una herramienta");
							turnoActual.setExitoso(false);
						}
					break;	
					case "4":
						turnoActual.setAccionesTurno(Acciones.recuperarVida);
						turnoActual.setAfectado(partidaActual.getListaPersonajes().get(numJugadorAtacante).getNombre());
						vida = partidaActual.obtenerVida(jugadorRecuperarVida);
						partidaActual.recuperarVida(jugadorRecuperarVida, vida);
						turnoActual.setExitoso(true);
					break;
					
					default:	
						JOptionPane.showMessageDialog(null, "Valor introducido erróneo");
						turnoActual.setAccionesTurno(Acciones.ERROR);
					}
			}	
			listaTurnos.add(turnoActual);
			if (partidaActual.esMaquina(numJugadorAtacante) == 1)
			{
				partidaActual.mostrarPersonajesmaquina();
			}
			else
			{
				partidaActual.mostrarPersonajes();
			}
			  
			numTurnos ++;
		
			//System.out.println("Final turno: "+ turnoActual+" "+ numJugadorAtacante+" "+partidaActual.jugadoresDisponibles());
			//Controlar cuando el ultimo jugador ha eliminado a alguien
			if(numJugadorAtacante >= partidaActual.jugadoresDisponibles()) {
			
				numJugadorAtacante --;
			
			}
			
			//Jugador que gana la partida 
			if(partidaActual.jugadoresDisponibles() == 1) {
				JOptionPane.showMessageDialog(null, "El jugador: " + partidaActual.devolverNombreJugador(0) + " es el ganador");
				numTurnos = Partida.MAX_TURNOS+1;
			}else {
				//Cambiar valor CD personaje que ha jugado
				partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().controlCD();
				partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDHabilidad().controlCD();
				
		
			}
			
		//	partidaActual.mostrarPersonajes();
		} while(numTurnos < Partida.MAX_TURNOS);
	
		if(numTurnos == Partida.MAX_TURNOS) {
			partidaActual.calcularGanador();
		}
	}
	
}
