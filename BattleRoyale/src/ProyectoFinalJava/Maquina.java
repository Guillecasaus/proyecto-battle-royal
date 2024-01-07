package ProyectoFinalJava;

import javax.swing.JOptionPane;

public class Maquina {
	
public static Turno turnoMaquina(Partida partidaActual, Integer numJugadorAtacante, Integer numTurnos) {
		
		Integer menuAtaque = (int)(Math.random()*2+1);
		Integer menuPartida = (int)(Math.random()*4+1);
		Integer jugadorAtacado = (int)(Math.random()*partidaActual.jugadoresDisponibles());
		Integer menuHerramientaAtaque = (int)(Math.random()*partidaActual.getListaPersonajes().get(numJugadorAtacante).inventario.getListaHerramientas().size());
		Integer herramientaEscoger = (int)(Math.random()*partidaActual.getListaPersonajes().get(numJugadorAtacante).inventario.getListaHerramientas().size());
	 	Integer damage;
		Integer vida;
		Turno turnoActual = new Turno(numTurnos);
		turnoActual.setActua(partidaActual.getListaPersonajes().get(numJugadorAtacante).getNombre());
		
		do {
		jugadorAtacado = (int)(Math.random()*partidaActual.jugadoresDisponibles());
		}while(jugadorAtacado == numJugadorAtacante);
		
		switch (menuPartida) {
		case 1:
			switch (menuAtaque) {
				case 1:
					turnoActual.setAccionesTurno(Acciones.atacarNormal);
					turnoActual.setAfectado(partidaActual.getListaPersonajes().get(jugadorAtacado).getNombre());
					//System.out.println("paso 1 " + numJugadorAtacante);
					damage = partidaActual.obtenerDamage(numJugadorAtacante);
					partidaActual.quitarDamage(jugadorAtacado, damage);
					//System.out.println("paso 1 " + jugadorAtacado + damage );
					if (partidaActual.devolverVidaPersonaje(jugadorAtacado) <= 0) {
						partidaActual.jugadorEliminado(jugadorAtacado);
					}
					turnoActual.setExitoso(true);
				
				break;
				case 2:
					//partidaActual.getListaPersonajes().get(numJugadorAtacante).mostrarInventarioHerramientas();
					turnoActual.setAccionesTurno(Acciones.atacarHerramienta);
					if ((menuHerramientaAtaque) <= partidaActual.getListaPersonajes().get(numJugadorAtacante).inventario.getListaHerramientas().size() && partidaActual.getListaPersonajes().get(numJugadorAtacante).inventario.getListaHerramientas().size() != 0) {
						damage = partidaActual.obtenerDamage(numJugadorAtacante) + partidaActual.getListaPersonajes().get(numJugadorAtacante).inventario.getListaHerramientas().get(menuHerramientaAtaque).getBonus();
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().controlHerramientaUsos(menuHerramientaAtaque);
					} else {
						JOptionPane.showMessageDialog(null, "No tiene ninguna herramienta en esta posicion de inventario");
						damage = partidaActual.obtenerDamage(numJugadorAtacante);
						turnoActual.setExitoso(false);
					}	
					turnoActual.setAfectado(partidaActual.getListaPersonajes().get(jugadorAtacado).getNombre());
					partidaActual.quitarDamage(jugadorAtacado, damage);					
					turnoActual.setExitoso(true);
					
					if (partidaActual.devolverVidaPersonaje(jugadorAtacado) <= 0) {
						partidaActual.jugadorEliminado(jugadorAtacado);
					}
				break;
			}
		break;
		case 2:
			turnoActual.setAccionesTurno(Acciones.HabilidadOfensiva);
			if (partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDHabilidad().getEstaOnCD() == false) {
				turnoActual.setAfectado(partidaActual.getListaPersonajes().get(jugadorAtacado).getNombre());
				damage = partidaActual.obtenerDamageHabilidad(numJugadorAtacante);
				partidaActual.quitarDamage(jugadorAtacado, damage);
				partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDHabilidad().setEstaOnCD(true);
				partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDHabilidad().setCounterCD(partidaActual.getListaPersonajes().get(numJugadorAtacante).getTurnosHabilidad()+1);
				if (partidaActual.devolverVidaPersonaje(jugadorAtacado) <= 0) {
					partidaActual.jugadorEliminado(jugadorAtacado);					
				}
				turnoActual.setExitoso(true);
			} else {
				JOptionPane.showMessageDialog(null, "La habilidad no está disponible");
				//TODO Añadir opcio realizar ataque normal
				turnoActual.setExitoso(false);
			}
		break;	
		case 3:
			turnoActual.setAccionesTurno(Acciones.cogerObjeto);
			turnoActual.setAfectado(partidaActual.getListaPersonajes().get(numJugadorAtacante).getNombre());
			if(partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().getEstaOnCD() == false) {
				switch (herramientaEscoger) {
					case 0: 
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().asignarHerramienta(new HerramientaBaston(partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas().size()+1));
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setEstaOnCD(true);
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setCounterCD(Partida.TURNOS_CD_ESCOGER_HERRAMIENTA+1);
						turnoActual.setExitoso(true);
					break;
					case 1: 
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().asignarHerramienta(new HerramientaEspada(partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas().size()+1));
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setEstaOnCD(true);
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setCounterCD(Partida.TURNOS_CD_ESCOGER_HERRAMIENTA+1);
						turnoActual.setExitoso(true);
					break;
					case 2: 
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().asignarHerramienta(new HerramientaArco(partidaActual.getListaPersonajes().get(numJugadorAtacante).getInventario().getListaHerramientas().size()+1));
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setEstaOnCD(true);
						partidaActual.getListaPersonajes().get(numJugadorAtacante).getCDCogerHerramienta().setCounterCD(Partida.TURNOS_CD_ESCOGER_HERRAMIENTA+1);
						turnoActual.setExitoso(true);
					break;
					default:
						JOptionPane.showMessageDialog(null, "No existe la herramienta escogida");
						turnoActual.setExitoso(false);
				}
			}
		break;	
		
		case 4:
			turnoActual.setAccionesTurno(Acciones.recuperarVida);
			turnoActual.setAfectado(partidaActual.getListaPersonajes().get(numJugadorAtacante).getNombre());
			vida = partidaActual.obtenerVida(numJugadorAtacante);
			partidaActual.recuperarVida(numJugadorAtacante, vida);
			turnoActual.setExitoso(true);
		break;
		
		default:	
			JOptionPane.showMessageDialog(null, "Valor introducido erróneo");
			turnoActual.setAccionesTurno(Acciones.ERROR);;
		}
		return turnoActual;		
	}
}