package sistema;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;

import java.awt.Font;
import javax.swing.SwingConstants;

import java.io.Serializable;

public class Sistema_Visual implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Sistema sistema;
	private Instancia instancia;
//	private PanelCanchas panelCanchas;
//	private PanelCanchasConsultar panelCanchasConsultar;
	private PanelJugadores panelJugadores;
	private PanelGenerador panelGenerador;
//	private PanelReservas panelReservas;
//	private PanelReservasConsultar panelReservasConsultar;
	private PanelImagen panelMenu;
	private JLabel lblGenerador;
	private JButton btnJugadores, btnJugadoresEditar,
			btnJugadoresGenerador;

	/**b
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema_Visual window = new Sistema_Visual();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sistema_Visual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		instancia = new Instancia(1, 4, 3, 3, 2, 1);
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setForeground(new Color(72, 61, 139));
		frame.getContentPane().setFont(new Font("Impact", Font.PLAIN, 14));
		frame.setBounds(100, 100, 896, 624);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelJugadores = new PanelJugadores(instancia);
		panelGenerador = new PanelGenerador(sistema);
		frame.getContentPane().add(panelJugadores);
		frame.getContentPane().add(panelGenerador);
		panelJugadores.setVisible(false);
		panelGenerador.setVisible(false);
		
		panelMenu = new PanelImagen();
		panelMenu.setBounds(-62, 0, 950, 597);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		panelMenu.patch = "copa_america.jpg";
		
		lblGenerador = new JLabel("Generador (v2.4)");
		lblGenerador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerador.setForeground(Color.LIGHT_GRAY);
		lblGenerador.setFont(new Font("Impact", Font.PLAIN, 40));
		lblGenerador.setBounds(0, 11, 280, 71);
		panelMenu.add(lblGenerador);

		btnJugadores = new JButton("Jugadores");
		btnJugadores.setFont(new Font("Impact", Font.PLAIN, 13));
		btnJugadores.setBackground(Color.WHITE);
		btnJugadores.setBounds(68, 120, 106, 54);
		panelMenu.add(btnJugadores);

		btnJugadoresEditar = new JButton("Editar");
		btnJugadoresEditar.setFont(new Font("Impact", Font.PLAIN, 11));
		btnJugadoresEditar.setBounds(68, 209, 106, 34);
		panelMenu.add(btnJugadoresEditar);
		
		btnJugadoresGenerador = new JButton("Generador");
		btnJugadoresGenerador.setFont(new Font("Impact", Font.PLAIN, 11));
		btnJugadoresGenerador.setBounds(68, 277, 106, 34);
		panelMenu.add(btnJugadoresGenerador);
		btnJugadoresEditar.setVisible(false);
		btnJugadoresGenerador.setVisible(false);

		btnJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = btnJugadoresEditar.isVisible() == false;
				btnJugadoresEditar.setVisible(flag);
				btnJugadoresGenerador.setVisible(flag);
				panelGenerador.setVisible(false);

			}
		});
		
		btnJugadoresEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelJugadores.setVisible(true);

			}
		});
		btnJugadoresGenerador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelJugadores.setVisible(false);
				panelGenerador.setVisible(true);
			 }
		});
	}
}
