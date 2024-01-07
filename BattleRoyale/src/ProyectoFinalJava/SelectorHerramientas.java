package ProyectoFinalJava;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SelectorHerramientas extends JFrame{
	public static final Integer X_BASE_DEFAULT = 10;
	public static final Integer X_ESPACIO = 150;
	public static final Integer Y_BASE_DEFAULT = 40;
	public static final Integer Y_ESPACIO = 120;
	public static final Integer INTERLINEADO_DEFAULT = 25;
	private List<JButton> arrayBotones;
	private Integer numElegido;
	private ButtonListener buttonListener = new ButtonListener();
	private SelectorHerramientas self;
	
	//Clase interna
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			numElegido = Integer.valueOf(((JButton) e.getSource()).getText().substring(6));
		}
	}
	
	public SelectorHerramientas(List<Herramientas> listHerr) {
		this.numElegido = 0;
		this.setBounds(650, 350, 600, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.arrayBotones = new ArrayList<JButton>();
		this.self = this;
		
		for(int i = 0; i < listHerr.size(); i++) {
			this.arrayBotones.add(new JButton("Usar: " + listHerr.get(i).getNumHerramienta()));
			this.arrayBotones.get(i).addActionListener(new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					self.setVisible(false);
					self.dispose();
				}
			});
		}

		componentesSelector(listHerr);

		this.setVisible(true);
	}
	
	private void componentesSelector(List<Herramientas> listHerr) {
		this.setLayout(null);
		
		JLabel titulo = new JLabel("Seleccione la herramienta que quiere utilizar: ");
		titulo.setBounds(10, 10, 600, 20);
		this.add(titulo);
		
		for (int i = 0; i < listHerr.size(); i++) {
			crearSelector((X_BASE_DEFAULT+(X_ESPACIO*(i-4*(i/4)))), (Y_BASE_DEFAULT+(Y_ESPACIO*(i/4))), i, listHerr.get(i));

			this.add(this.arrayBotones.get(i));
			this.arrayBotones.get(i).setBounds((X_BASE_DEFAULT+(X_ESPACIO*(i-4*(i/4)))), ((Y_BASE_DEFAULT+(Y_ESPACIO*(i/4)))+INTERLINEADO_DEFAULT*3), 82, 25);
			this.arrayBotones.get(i).addActionListener(this.buttonListener);
			
		}
	}
	
	private void crearSelector(Integer xBase, Integer yBase, Integer posicion, Herramientas herr) {
		Integer yEntreLineas = 25;
		
		JLabel tipo = new JLabel("Tipo: " + herr.getTipo());
		tipo.setBounds(xBase, yBase, 80, 25);
		this.add(tipo);

		JLabel bonus = new JLabel("Bonus: " + herr.getBonus());
		bonus.setBounds(xBase, (yBase+yEntreLineas*1), 80, 25);
		this.add(bonus);
		
		JLabel usos = new JLabel("Usos restantes: " + herr.getUsosRestantes());
		usos.setBounds(xBase, (yBase+yEntreLineas*2), 80, 25);
		this.add(usos);
	}
	
	public Integer getNumElegido() {
		return numElegido;
	}

	public void setNumElegido(Integer numElegido) {
		this.numElegido = numElegido;
	}
	
	//TODO BORRAR MAIN
	public static void main(String[] args) {
		 List<Herramientas> list = new ArrayList<Herramientas>();
		 list.add(new Herramientas(10, TipoArma.baston, 3, 1));
		 list.add(new Herramientas(30, TipoArma.espada, 3, 2));
		 list.add(new Herramientas(20, TipoArma.arco, 3, 3));
		 SelectorHerramientas selH = new SelectorHerramientas(list);
		 selH.show();
	}
}