package ProyectoFinalJava;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SelectorJugador extends JFrame{
	public static final Integer X_BASE_DEFAULT = 15;
	public static final Integer X_ESPACIO = 165;
	public static final Integer Y_BASE_DEFAULT = 40;
	public static final Integer Y_ESPACIO = 120;
	public static final Integer INTERLINEADO_DEFAULT = 25;
	
	private List<JButton> arrayBotones;
	private Integer numElegido;
	private ButtonListener buttonListener = new ButtonListener();
	private SelectorJugador self;
	
	//Clase interna
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			numElegido = Integer.valueOf(((JButton) e.getSource()).getText().substring(8));
		}
	}
	
	public SelectorJugador(List<Personaje> listPers) {
		this.numElegido = 0;
		this.setBounds(650, 350, 700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.arrayBotones = new ArrayList<JButton>();
		this.self = this;
		
		for(int i = 0; i < listPers.size(); i++) {
			this.arrayBotones.add(new JButton("Atacar: " + listPers.get(i).getNumeroJugador()));
			this.arrayBotones.get(i).addActionListener(new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					self.setVisible(false);
					self.dispose();
				}
			});
		}

		componentesSelector(listPers);

		this.setVisible(true);
	}
	

	private void componentesSelector(List<Personaje> listPers) {
		this.setLayout(null);
		
		JLabel titulo = new JLabel("Seleccione el jugador al que quiere atacar: ");
		titulo.setBounds(10, 10, 600, 20);
		this.add(titulo);
		
		for (int i = 0; i < listPers.size(); i++) {
			crearSelector((X_BASE_DEFAULT+(X_ESPACIO*(i-4*(i/4)))), (Y_BASE_DEFAULT+(Y_ESPACIO*(i/4))), i, listPers.get(i));

			this.add(this.arrayBotones.get(i));
			this.arrayBotones.get(i).setBounds((X_BASE_DEFAULT+(X_ESPACIO*(i-4*(i/4)))), ((Y_BASE_DEFAULT+(Y_ESPACIO*(i/4)))+INTERLINEADO_DEFAULT*3), 82, 25);
			this.arrayBotones.get(i).addActionListener(this.buttonListener);
			
		}
	}
	
	private void crearSelector(Integer xBase, Integer yBase, Integer posicion, Personaje pers) {
		JLabel nombre = new JLabel("Nombre: " + pers.getNombre());
		nombre.setBounds(xBase, yBase, 150, 25);
		this.add(nombre);

		JLabel tipo = new JLabel("Tipo: " + pers.getTipoPer());
		tipo.setBounds(xBase, (yBase+INTERLINEADO_DEFAULT*1), 180, 25);
		this.add(tipo);
		
		JLabel vida = new JLabel("Vida: " + pers.getVidaPersonaje());
		vida.setBounds(xBase, (yBase+INTERLINEADO_DEFAULT*2), 180, 25);
		this.add(vida);
	}
	
	public Integer getNumElegido() {
		return numElegido;
	}

	public void setNumElegido(Integer numElegido) {
		this.numElegido = numElegido;
	}

	//TODO BORRAR MAIN
	public static void main(String[] args) {
		 List<Personaje> listPers = new ArrayList<Personaje>();
		 listPers.add(new Personaje("J1", TipoJugador.humano, TipoPersonaje.elfo, 1, 150, 1, 1, 1));
		 listPers.add(new Personaje("jugadorMaquina1", TipoJugador.humano, TipoPersonaje.guerrero, 1, 200, 1, 1, 1));
		 listPers.add(new Personaje("jugadorMaquina2", TipoJugador.humano, TipoPersonaje.mago, 1, 100, 1, 1, 1));
		 listPers.add(new Personaje("jugadorMaquina3", TipoJugador.humano, TipoPersonaje.guerrero, 1, 200, 1, 1, 1));
		 listPers.add(new Personaje("jugadorMaquina4", TipoJugador.humano, TipoPersonaje.mago, 1, 100, 1, 1, 1));
		 SelectorJugador selJ = new SelectorJugador(listPers);
		 selJ.show();
	}
}
