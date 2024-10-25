package ProyectoFinalJava;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Menu {
	
	private static List<Turno> listaTurnos = new ArrayList<Turno>();
	static NuevosJugadores jugadores = new NuevosJugadores();
	static JugarPartida jugar = new JugarPartida();
	
	public static void main(String[] args) {
		//String menu = JOptionPane.showInputDialog("1. Iniciar Partida\n2. Continuar Partida\n3 Terminar");
		//System.out.println("Hello "+ menu);
		String menu = "0";
		IniciaPartida iniP = new IniciaPartida();
		iniP.show();
		do {
			menu = iniP.getNumElegido().toString();
		} while (iniP.getNumElegido().toString().equals("0"));
		System.out.println("Hello "+ menu);
		
		switch(menu) {
			case "1":
				Partida partidaActiva = new Partida();
				JOptionPane.showMessageDialog(null, "Partida iniciada");
				do {
					String numeroJugadores = JOptionPane.showInputDialog("Introduce número de jugadores (Máximo jugadores: "+ Partida.NUM_MAX_JUGADORES+" )");
					partidaActiva.setNumJugadoresPartida(Integer.parseInt(numeroJugadores));
					if(partidaActiva.getNumJugadoresPartida() > Partida.NUM_MAX_JUGADORES) {
						JOptionPane.showMessageDialog(null, "Has introducido más jugadores del máximo permitido");
					}
				}while(partidaActiva.getNumJugadoresPartida() > Partida.NUM_MAX_JUGADORES);
				jugadores.crearJugadores(partidaActiva);	
				jugar.partidaEnCurso(partidaActiva,listaTurnos);
				
				String opcionLog = JOptionPane.showInputDialog("Si desea crear un fichero con el resumen de la partida, escriba \"si\" debajo");
				
				if(opcionLog.equals("si")) {
					try {
						File logFile = new File("logPartida.txt");
						FileWriter fileWriter = new FileWriter(logFile);
					
						for (int i = 0; i < listaTurnos.size(); i++) {
							fileWriter.append(listaTurnos.get(i).toString());
						}
						fileWriter.append("Resultado final: Victoria de " + partidaActiva.devolverNombreJugador(0));
						JOptionPane.showMessageDialog(null, "Fichero \"logPartida.txt\" ha sido creado correctamente.");
						fileWriter.close();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "ERROR: Error inesperado a la hora de crear el fichero de log de la partida");
						e.printStackTrace();
					}
				}
				
				
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

