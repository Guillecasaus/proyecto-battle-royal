package ProyectoFinalJava;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

public class IniciaPartida extends JFrame {
	private Integer numElegido;
	private ButtonListener buttonListener = new ButtonListener();
	private IniciaPartida self;
	
	//Clase interna
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (((JButton) e.getSource()).getText().equals("Iniciar partida")) {
				self.numElegido = 1;
			} else if (((JButton) e.getSource()).getText().equals("Continuar partida")) {
				self.numElegido = 2;
			} else if (((JButton) e.getSource()).getText().equals("Terminar")) {
				self.numElegido = 3;
			}
		}
	}
	
	public IniciaPartida() {
		this.numElegido = 0;
		this.setBounds(650, 350, 400, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.self = this;
		
		this.setLayout(null);
		
		JLabel titulo = new JLabel("BIENVENIDO AL JUEGO");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		titulo.setBounds(80, 10, 400, 20);
		this.add(titulo);
		
		JButton botonIniciar = new JButton("Iniciar partida");
		botonIniciar.setBounds(120, 100, 150, 50);
		this.add(botonIniciar);
		botonIniciar.addActionListener(this.buttonListener);
		botonIniciar.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				self.setVisible(false);
				self.dispose();
			}
		});
		
		JButton botonContinuar = new JButton("Continuar partida");
		botonContinuar.setBounds(120, 160, 150, 50);
		this.add(botonContinuar);
		botonContinuar.addActionListener(this.buttonListener);
		botonContinuar.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				self.setVisible(false);
				self.dispose();
			}
		});
		
		JButton botonTerminar = new JButton("Terminar");
		botonTerminar.setBounds(120, 220, 150, 50);
		this.add(botonTerminar);
		botonTerminar.addActionListener(this.buttonListener);
		botonTerminar.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				self.setVisible(false);
				self.dispose();
			}
		});

		this.setVisible(true);
	}
	
	public Integer getNumElegido() {
		return numElegido;
	}

	public void setNumElegido(Integer numElegido) {
		this.numElegido = numElegido;
	}
	
	public static void main(String[] args) {
		IniciaPartida iniP = new IniciaPartida();
		iniP.show();
		System.out.println(iniP.getNumElegido());
	}
}

