package ProyectoFinalJava;
import javax.swing.*;	

public class Menu {

	
	public static void main(String[] args) {
		
	String menu = JOptionPane.showInputDialog("1. Iniciar Partida\n2. Continuar Partida\n3 Terminar");
	System.out.println("Hello "+menu);
		
		switch(menu) {
			case "1":
				Partida partidaActiva = new Partida();
				JOptionPane.showMessageDialog(null, "Partida iniciada");
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
