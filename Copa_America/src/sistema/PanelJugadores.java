package sistema;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelJugadores extends PanelImagen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Instancia instancia;

	private JLabel mjeExcepcion, lblPuntosAgregar, lblNombreAgregar,
			lblNacionalidadAgregar, lblNombreEditar,
			lblPosicionEditar, lblNacionalidadEditar;
	private JLabel lblAgregarCliente, lblEditarClientes, lblEliminarClientes,
			lblNombreEliminar, lblPuntosEditar;
	
	private JLabel lblposicionAgregar;
	private JButton btnAgregar;
	private JButton btnEliminarCliente;
	private JButton btnEditarCliente;
	private JTextField txfPuntosAgregar;
	private JTextField txfNombreAgregar;
	private JTextField txfNacionalidadAgregar;
	private JTextField txfPosicionAgregar;

	private JComboBox<String> cBoxNombresEditar;
	private JTextField txfNacionalidadEditar;
	private JTextField txfPosicionEditar;
	private JTextField txfPuntosEditar;

	private JComboBox<String> cBoxNombresEliminar;
	private JTextField txfAmarillasAgregar;
	private JLabel lblAmarillasAgregar;
	private JTextField txfRojasAgregar;
	private JLabel lblRojasAgregar;
	private JTextField txfAmarillasEditar;
	private JTextField txfRojasEditar;

	/**
	 * Create the panel.
	 */
	public PanelJugadores(Instancia instancia) {
		initialize(instancia);
	}

	private void initialize(Instancia instancia) {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.instancia = instancia;
		this.setBounds(308, 0, 580, 597);
		this.patch = "copa_america9.jpg";
		this.setLayout(null);
		lblAgregarCliente = new JLabel("Agregar Clientes");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setForeground(Color.LIGHT_GRAY);
		lblAgregarCliente.setBounds(98, 11, 416, 50);
		lblAgregarCliente.setFont(new Font("Impact", Font.PLAIN, 40));
		this.add(lblAgregarCliente);
		setTxfPuntosAgregar(new JTextField());
		getTxfPuntosAgregar().setBounds(326, 107, 117, 27);
		this.add(getTxfPuntosAgregar());
		getTxfPuntosAgregar().setToolTipText("Ingrese el ID del Cliente");
		getTxfPuntosAgregar().setColumns(10);
		lblPuntosAgregar = new JLabel("Puntos");
		lblPuntosAgregar.setBounds(477, 105, 202, 29);
		this.add(lblPuntosAgregar);
		lblPuntosAgregar.setForeground(Color.ORANGE);
		lblPuntosAgregar.setFont(new Font("Impact", Font.PLAIN, 14));

		setTxfNombreAgregar(new JTextField());
		getTxfNombreAgregar().setBounds(67, 70, 117, 25);
		this.add(getTxfNombreAgregar());
		getTxfNombreAgregar().setToolTipText("Ingrese el Nombre del Cliente");
		getTxfNombreAgregar().setColumns(10);

		lblNombreAgregar = new JLabel("Nombre");
		lblNombreAgregar.setBounds(218, 74, 202, 23);
		this.add(lblNombreAgregar);
		lblNombreAgregar.setForeground(Color.ORANGE);
		lblNombreAgregar.setFont(new Font("Impact", Font.PLAIN, 14));

		lblNacionalidadAgregar = new JLabel("Nacionalidad");
		lblNacionalidadAgregar.setBounds(477, 77, 128, 22);
		this.add(lblNacionalidadAgregar);
		lblNacionalidadAgregar.setForeground(Color.ORANGE);
		lblNacionalidadAgregar.setFont(new Font("Impact", Font.PLAIN, 14));

		setMjeExcepcion(new JLabel());
		getMjeExcepcion().setHorizontalAlignment(SwingConstants.CENTER);
		getMjeExcepcion().setFont(new Font("Impact", Font.PLAIN, 20));
		getMjeExcepcion().setBackground(new Color(128, 128, 128));
		getMjeExcepcion().setBounds(0, 521, 580, 65);
		this.add(getMjeExcepcion());
		getMjeExcepcion().setForeground(Color.YELLOW);
		setBtnAgregar(new JButton("Agregar"));
		getBtnAgregar().setBackground(Color.WHITE);
		getBtnAgregar().setBounds(357, 179, 86, 25);
		this.add(getBtnAgregar());
		getBtnAgregar().setFont(new Font("Impact", Font.PLAIN, 12));

		setBtnEliminarJugador(new JButton("Eliminar"));
		getBtnEliminarJugador().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnEliminarJugador().setBackground(Color.WHITE);
		getBtnEliminarJugador().setBounds(357, 483, 86, 25);
		this.add(getBtnEliminarJugador());

		setBtnEditarJugador(new JButton("Editar"));

		getBtnEditarJugador().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnEditarJugador().setBackground(Color.WHITE);
		getBtnEditarJugador().setBounds(357, 386, 86, 25);
		this.add(getBtnEditarJugador());

		lblEditarClientes = new JLabel("Editar Clientes");
		lblEditarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarClientes.setForeground(Color.LIGHT_GRAY);
		lblEditarClientes.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEditarClientes.setBounds(98, 217, 416, 50);
		this.add(lblEditarClientes);

		lblEliminarClientes = new JLabel("Eliminar Clientes");
		lblEliminarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarClientes.setForeground(Color.LIGHT_GRAY);
		lblEliminarClientes.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEliminarClientes.setBounds(98, 424, 416, 50);
		this.add(lblEliminarClientes);

		setcBoxNombresEliminar(new JComboBox<String>());
		setcBoxNombresEditar(new JComboBox<String>());

		getcBoxNombresEliminar().setBounds(67, 488, 117, 22);
		this.add(getcBoxNombresEliminar());
		getcBoxNombreEditar().setBounds(67, 274, 117, 26);
		this.add(getcBoxNombreEditar());

		lblNombreEliminar = new JLabel("Nombre");
		lblNombreEliminar.setForeground(Color.ORANGE);
		lblNombreEliminar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblNombreEliminar.setBounds(218, 488, 128, 22);

		this.add(lblNombreEliminar);

		lblNombreEditar = new JLabel("Nombre");
		lblNombreEditar.setForeground(Color.ORANGE);
		lblNombreEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblNombreEditar.setBounds(218, 278, 128, 22);
		this.add(lblNombreEditar);

		setTxfNombreEditar(new JTextField());
		getTfxNombreEditar().setColumns(10);
		getTfxNombreEditar().setBounds(326, 274, 117, 25);
		this.add(getTfxNombreEditar());

		lblPosicionEditar = new JLabel("Posicion");
		lblPosicionEditar.setForeground(Color.ORANGE);
		lblPosicionEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblPosicionEditar.setBounds(218, 310, 128, 22);
		this.add(lblPosicionEditar);

		lblNacionalidadEditar = new JLabel("Nacionalidad");
		lblNacionalidadEditar.setForeground(Color.ORANGE);
		lblNacionalidadEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblNacionalidadEditar.setBounds(477, 277, 202, 23);
		this.add(lblNacionalidadEditar);

		lblposicionAgregar = new JLabel("Posicion");
		lblposicionAgregar.setForeground(Color.ORANGE);
		lblposicionAgregar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblposicionAgregar.setBounds(218, 108, 202, 23);
		add(lblposicionAgregar);

		txfPosicionAgregar = new JTextField();
		txfPosicionAgregar.setColumns(10);
		txfPosicionAgregar.setBounds(67, 105, 117, 27);
		add(txfPosicionAgregar);

		txfNacionalidadAgregar = new JTextField();
		txfNacionalidadAgregar.setColumns(10);
		txfNacionalidadAgregar.setBounds(326, 74, 117, 25);
		add(txfNacionalidadAgregar);

		txfPosicionEditar = new JTextField();
		txfPosicionEditar.setBackground(Color.LIGHT_GRAY);
		txfPosicionEditar.setEditable(false);
		txfPosicionEditar.setColumns(10);
		txfPosicionEditar.setBounds(67, 310, 117, 27);
		add(txfPosicionEditar);

		txfPuntosEditar = new JTextField();
		txfPuntosEditar.setColumns(10);
		txfPuntosEditar.setBounds(326, 310, 117, 27);
		add(txfPuntosEditar);

		lblPuntosEditar = new JLabel("Puntos");
		lblPuntosEditar.setForeground(Color.ORANGE);
		lblPuntosEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblPuntosEditar.setBounds(477, 310, 202, 23);
		add(lblPuntosEditar);
		
		txfAmarillasAgregar = new JTextField();
		txfAmarillasAgregar.setColumns(10);
		txfAmarillasAgregar.setBounds(67, 141, 117, 27);
		add(txfAmarillasAgregar);
		
		lblAmarillasAgregar = new JLabel("Amarillas");
		lblAmarillasAgregar.setForeground(Color.ORANGE);
		lblAmarillasAgregar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblAmarillasAgregar.setBounds(218, 139, 202, 29);
		add(lblAmarillasAgregar);
		
		txfRojasAgregar = new JTextField();
		txfRojasAgregar.setColumns(10);
		txfRojasAgregar.setBounds(326, 141, 117, 27);
		add(txfRojasAgregar);
		
		lblRojasAgregar = new JLabel("Rojas");
		lblRojasAgregar.setForeground(Color.ORANGE);
		lblRojasAgregar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblRojasAgregar.setBounds(477, 139, 202, 29);
		add(lblRojasAgregar);
		
		JLabel lblAmarillos = new JLabel("Amarillos");
		lblAmarillos.setForeground(Color.ORANGE);
		lblAmarillos.setFont(new Font("Impact", Font.PLAIN, 14));
		lblAmarillos.setBounds(218, 350, 202, 23);
		add(lblAmarillos);
		
		txfAmarillasEditar = new JTextField();
		txfAmarillasEditar.setColumns(10);
		txfAmarillasEditar.setBounds(67, 347, 117, 25);
		add(txfAmarillasEditar);
		
		JLabel lblRojas = new JLabel("Rojas");
		lblRojas.setForeground(Color.ORANGE);
		lblRojas.setFont(new Font("Impact", Font.PLAIN, 14));
		lblRojas.setBounds(477, 351, 202, 23);
		add(lblRojas);
		
		txfRojasEditar = new JTextField();
		txfRojasEditar.setColumns(10);
		txfRojasEditar.setBounds(326, 348, 117, 25);
		add(txfRojasEditar);
		this.setVisible(false);
		cargarIdDeClientesEnCbox();
		actualizarCamposEditar();
	}

	public void cargarIdDeClientesEnCbox() {

		String[] idClientes = new String [instancia.getCantJugadores()];

		for (int i=0; i<instancia.getCantJugadores();i++)
			idClientes[i] = instancia.getJugadores().dameJugador(i).getNombre();
		
		this.getcBoxNombresEliminar().setModel(
				new DefaultComboBoxModel<String>(idClientes));
		
		this.getcBoxNombreEditar().setModel(
				new DefaultComboBoxModel<String>(idClientes));
	}

	public void limpiar_Campos() {
		
		txfPuntosAgregar.setText("");
		txfNombreAgregar.setText("");
		txfNacionalidadAgregar.setText("");
		txfPosicionAgregar.setText("");
	}

	public JButton getBtnEliminarJugador() {
		return btnEliminarCliente;
	}

	public void setBtnEliminarJugador(JButton btnEliminarClientes) {
		this.btnEliminarCliente = btnEliminarClientes;
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mjeExcepcion.setText("");

				int posicion = 0;
				
				try {
					posicion = cBoxNombresEliminar
							.getSelectedIndex();
					try {
						if(instancia.eliminarJugador(posicion))
						{
							mjeExcepcion.setText("El Jugador se elimino correctamente");
							limpiar_Campos();
						}
						else
							mjeExcepcion.setText("El Jugador No se pudo eliminar");
						} catch (Exception e) {
								mjeExcepcion.setText("<html><body>No existen Jugadores en el Sistema</body></html>");
						}
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					mjeExcepcion
							.setText("<html><body>No existen Jugadores en el Sistema</body></html>");
				}

				cargarIdDeClientesEnCbox();
				actualizarCamposEditar();
			}
		});
	}

	public JButton getBtnEditarJugador() {
		return btnEditarCliente;
	}

	public void setBtnEditarJugador(JButton btnEditarJugador) {
		this.btnEditarCliente = btnEditarJugador;

		btnEditarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				String nombre = "";
				String nacionalidad = "";
				String posicion = "";
				Integer puntos = 0;
				Integer amarillas = 0;
				Integer rojas = 0;
			
				try {
					nombre = (String) cBoxNombresEditar.getSelectedItem();
					nacionalidad = txfNacionalidadEditar.getText();
					posicion = txfPosicionEditar.getText();
					puntos = Integer.parseInt((String) txfPuntosEditar
							.getText());
					amarillas = Integer.parseInt((String) txfAmarillasEditar
							.getText());
					rojas = Integer.parseInt((String) txfRojasEditar
							.getText());
					try {
						Jugador nuevo = new Jugador(nombre,
								nacionalidad, posicion,puntos,amarillas,rojas);
						
						if(instancia.EditarJugador(cBoxNombresEditar.getSelectedIndex(),nuevo))
						{
							mjeExcepcion.setText("El Jugador se edito correctamente");
							limpiar_Campos();
						}
						else
							mjeExcepcion.setText("El Jugador No se pudo editar");
						
					} catch (Exception e) {
						mjeExcepcion.setText("<html><body>Por favor complete todos los campos");
					}
				} catch (NumberFormatException e) {
					mjeExcepcion
							.setText("<html><body>Por favor complete todos los campos");
				}

				cargarIdDeClientesEnCbox();
				actualizarCamposEditar();
			}
		});
	}

	public JComboBox<String> getcBoxNombresEliminar() {
		return cBoxNombresEliminar;
	}

	public void setcBoxNombresEliminar(
			JComboBox<String> cBoxNombresEliminar) {
		this.cBoxNombresEliminar = cBoxNombresEliminar;
		cBoxNombresEliminar.setBackground(Color.LIGHT_GRAY);
	}

	public JComboBox<String> getcBoxNombreEditar() {
		return cBoxNombresEditar;
	}

	public void setcBoxNombresEditar(
			JComboBox<String> cBoxNombresEditar) {
		this.cBoxNombresEditar = cBoxNombresEditar;
		cBoxNombresEditar.setBackground(Color.LIGHT_GRAY);

		cBoxNombresEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCamposEditar();
			}
		});
	}

	public JTextField getTfxNombreEditar() {
		return txfNacionalidadEditar;
	}

	public void setTxfNombreEditar(JTextField precioEditarCancha) {
		this.txfNacionalidadEditar = precioEditarCancha;
		txfNacionalidadEditar.setBackground(Color.LIGHT_GRAY);
		txfNacionalidadEditar.setEditable(false);
	}

	public JLabel getMjeExcepcion() {
		return mjeExcepcion;
	}

	public void setMjeExcepcion(JLabel mjeExcepcion) {
		this.mjeExcepcion = mjeExcepcion;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer puntos = 0;
				Integer amarillas = 0;
				Integer rojas = 0;
				String nombre = "";
				String nacionalidad = "";
				String posicion = "";
				try {
					puntos = Integer.parseInt((String) txfPuntosAgregar
							.getText());
					amarillas = Integer.parseInt((String) txfAmarillasAgregar
							.getText());
					rojas = Integer.parseInt((String) txfRojasAgregar
							.getText());
					nombre = txfNombreAgregar.getText();
					nacionalidad = txfNacionalidadAgregar.getText();
					posicion = txfPosicionAgregar.getText();
				 
					try {
						Jugador nuevo = new Jugador(nombre,
								nacionalidad, posicion,puntos,amarillas,rojas);
						if(instancia.agregarJugador(nuevo))
						{	
							mjeExcepcion.setText("El Jugador se agrego correctamente al Sistema");
							limpiar_Campos();
						}
						else
							mjeExcepcion.setText("El Jugador No se agrego al Sistema");
					
						
					} catch (Exception e) {
						mjeExcepcion.setText(e.getMessage());
					}
				} catch (NumberFormatException e) {
					mjeExcepcion
							.setText("Por favor complete todos los campos");
				}

				cargarIdDeClientesEnCbox();
				actualizarCamposEditar();
			}
		});
	}

	public JTextField getTxfPuntosAgregar() {
		return txfPuntosAgregar;
	}

	public void setTxfPuntosAgregar(JTextField idCliente) {
		this.txfPuntosAgregar = idCliente;
	}

	public void setcBoxNombreEditar(JComboBox<String> cBoxNombreEditar) {
		this.cBoxNombresEditar = cBoxNombreEditar;

	}

	public void actualizarCamposEditar() {

		try
		{
			Jugador j = instancia.getJugadores().dameJugador(
					getcBoxNombreEditar().getSelectedIndex());
			if (j != null) {
				txfPosicionEditar.setText(j.getPosicion());
				txfNacionalidadEditar.setText(j.getNacionalidad());
				txfPuntosEditar.setText(j.getPuntaje()+"");
				txfAmarillasEditar.setText(j.getAmarillas()+"");
				txfRojasEditar.setText(j.getRojas()+"");
			}
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){}
	}

	public JTextField getTxfNombreAgregar() {
		return txfNombreAgregar;
	}

	public void setTxfNombreAgregar(JTextField nombreCliente) {
		this.txfNombreAgregar = nombreCliente;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	
					Instancia inst = new Instancia(1, 4, 3, 3, 2, 1);
					PanelJugadores window = new PanelJugadores(inst);
					window.setVisible(true);
					
					JFrame frame = new JFrame();
					frame.setResizable(false);
					frame.getContentPane().setForeground(new Color(72, 61, 139));
					frame.getContentPane().setFont(new Font("Impact", Font.PLAIN, 14));
					frame.setBounds(100, 100, 896, 624);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					frame.getContentPane().add(window);
					frame.setVisible(true);
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
