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
	private PanelCanchas panelCanchas;
	private PanelClientes panelClientes;
	private PanelReservas panelReservas;
	private PanelImagen panelMenu;
	private JLabel lblFutsys;
	private JButton btnClientes, btnCanchas, btnClientesEditar,
			btnClientesConsultar, btnReservas, btnReservasEditar,
			btnReservasConsultar;
	private JButton btnCanchasEditar, btnCanchasConsultar;

	/**
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
		sistema = new Sistema();
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(72, 61, 139));
		frame.getContentPane().setFont(new Font("Impact", Font.PLAIN, 14));
		frame.setBounds(100, 100, 896, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelClientes = new PanelClientes(sistema.getClientes());
		panelCanchas = new PanelCanchas(sistema);
		panelReservas = new PanelReservas(sistema);
		frame.getContentPane().add(panelClientes);
		frame.getContentPane().add(panelCanchas);
		frame.getContentPane().add(panelReservas);
		panelClientes.setVisible(false);		
		panelCanchas.setVisible(false);
		panelReservas.setVisible(false);
		
		panelMenu = new PanelImagen();
		panelMenu.setBounds(0, 0, 888, 597);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		panelMenu.patch = "cancha_pasto_noche.jpg";
		
		lblFutsys = new JLabel("FutSyS (v " + serialVersionUID+")");
		lblFutsys.setHorizontalAlignment(SwingConstants.CENTER);
		lblFutsys.setForeground(Color.WHITE);
		lblFutsys.setFont(new Font("Impact", Font.PLAIN, 40));
		lblFutsys.setBounds(0, 11, 280, 71);
		panelMenu.add(lblFutsys);

		btnCanchas = new JButton("Canchas");
		btnCanchas.setBackground(Color.WHITE);
		btnCanchas.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCanchas.setBounds(34, 115, 106, 54);
		panelMenu.add(btnCanchas);

		btnCanchasEditar = new JButton("Editar");
		btnCanchasEditar.setFont(new Font("Impact", Font.PLAIN, 11));
		btnCanchasEditar.setBounds(174, 174, 106, 34);
		panelMenu.add(btnCanchasEditar);

		btnCanchasConsultar = new JButton("Consultar");
		btnCanchasConsultar.setFont(new Font("Impact", Font.PLAIN, 11));
		btnCanchasConsultar.setBounds(174, 205, 106, 34);
		panelMenu.add(btnCanchasConsultar);

		btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Impact", Font.PLAIN, 13));
		btnClientes.setBackground(Color.WHITE);
		btnClientes.setBounds(34, 250, 106, 54);
		panelMenu.add(btnClientes);

		btnClientesEditar = new JButton("Editar");
		btnClientesEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelClientes.setVisible(true);
				panelCanchas.setVisible(false);
			}
		});
		btnClientesEditar.setFont(new Font("Impact", Font.PLAIN, 11));
		btnClientesEditar.setBounds(174, 307, 106, 34);
		panelMenu.add(btnClientesEditar);

		btnClientesConsultar = new JButton("Consultar");
		btnClientesConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelClientes.setVisible(false);
			}
		});
		btnClientesConsultar.setFont(new Font("Impact", Font.PLAIN, 11));
		btnClientesConsultar.setBounds(174, 340, 106, 34);
		panelMenu.add(btnClientesConsultar);

		btnReservas = new JButton("Reservas");
		btnReservas.setFont(new Font("Impact", Font.PLAIN, 13));
		btnReservas.setBackground(Color.WHITE);
		btnReservas.setBounds(34, 385, 106, 54);
		panelMenu.add(btnReservas);

		btnReservasEditar = new JButton("Editar");
		
		btnReservasEditar.setFont(new Font("Impact", Font.PLAIN, 11));
		btnReservasEditar.setBounds(174, 442, 106, 34);
		panelMenu.add(btnReservasEditar);

		btnReservasConsultar = new JButton("Consultar");
		btnReservasConsultar.setFont(new Font("Impact", Font.PLAIN, 11));
		btnReservasConsultar.setBounds(174, 475, 106, 34);
		panelMenu.add(btnReservasConsultar);

		btnCanchasEditar.setVisible(false);
		btnCanchasConsultar.setVisible(false);
		btnClientesEditar.setVisible(false);
		btnClientesConsultar.setVisible(false);
		btnReservasEditar.setVisible(false);
		btnReservasConsultar.setVisible(false);

		// EVENTOS

		btnCanchas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = btnCanchasEditar.isVisible() == false;
				btnCanchasEditar.setVisible(flag);
				btnCanchasConsultar.setVisible(flag);
				btnClientesEditar.setVisible(false);
				btnClientesConsultar.setVisible(false);
				btnReservasEditar.setVisible(false);
				btnReservasConsultar.setVisible(false);
				panelReservas.setVisible(false);
				panelClientes.setVisible(false);
			}
		});

		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = btnClientesEditar.isVisible() == false;
				btnClientesEditar.setVisible(flag);
				btnClientesConsultar.setVisible(flag);
				btnCanchasEditar.setVisible(false);
				btnCanchasConsultar.setVisible(false);
				btnReservasEditar.setVisible(false);
				btnReservasConsultar.setVisible(false);
				panelCanchas.setVisible(false);
				 panelReservas.setVisible(false);
			}
		});

		btnReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = btnReservasEditar.isVisible() == false;
				btnReservasEditar.setVisible(flag);
				btnReservasConsultar.setVisible(flag);
				btnClientesEditar.setVisible(false);
				btnClientesConsultar.setVisible(false);
				btnCanchasEditar.setVisible(false);
				btnCanchasConsultar.setVisible(false);
				panelCanchas.setVisible(false);
				panelClientes.setVisible(false);
			}
		});

		btnCanchasEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCanchas.setVisible(true);
			}
		});

		
		btnCanchasConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCanchas.setVisible(false);
			}
		});
		
		btnReservasEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelReservas.setVisible(true);				
			}
		});
	}
}
