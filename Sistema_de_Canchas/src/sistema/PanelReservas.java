package sistema;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.naming.LimitExceededException;
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
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

public class PanelReservas extends PanelImagen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sistema sistema;

	private JLabel mjeExcepcion, lblIdclienteAgregar, lblIdCanchaAgregar,
			lblFechaAgregar, lblIdclienteEditar, lblSeniaEditar,
			lblIDCanchaEditar;
	private JLabel lblAgregarReservas, lblEditarReservas, lblEliminarReservas,
			lblIdclienteAeliminar, lblHorarioEditar, lblSeniaAgregar;
	private JLabel lblFechaEditar;
	private JLabel lblHorarioAgregar;
	private JLabel lblIdDReservaAgregar;
	private JButton btnAgregarReserva;
	private JButton btnEliminarReserva;
	private JButton btnEditarReserva;
	private JComboBox<String> cBoxHorarioAgregar;
	private JComboBox<String> cBoxIdClienteAgregar;
	private JComboBox<String> cBoxIdCanchasAgregar;
	private JComboBox<String> cBoxIdClienteEditar;
	private JComboBox<String> cBoxIdCanchaEditar;
	private JComboBox<String> cBoxHorarioEditar;
	private JTextField txfSeniaEditar;
	private JDateChooser dateFechaAgregar;
	private JDateChooser dateFechaEditar;

	final private String[] horarioSTR = { "00:00", "01:00", "02:00", "03:00",
			"04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
			"11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
			"18:00", "19:00", "20:00", "21:00", "22:00", "23:00" };
	private JComboBox<String> auxiliar;
	private JTextField txfSeniaAgregar;
	private JTextField txfIdReservaAgregar;
	private JComboBox<String> cBoxIdReservaEditar;
	private JLabel lblIdReservaEditar;

	/**
	 * Create the panel.
	 */
	public PanelReservas(Sistema sistema) {
		initialize(sistema);
	}

	private void initialize(Sistema sistema) {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.sistema = sistema;
		this.setBounds(308, 0, 580, 597);
		this.patch = "CANCHA_TRON2.jpg";
		this.setLayout(null);
		
				setMjeExcepcion(new JLabel());
				getMjeExcepcion().setHorizontalAlignment(SwingConstants.CENTER);
				getMjeExcepcion().setFont(new Font("Impact", Font.PLAIN, 20));
				getMjeExcepcion().setBackground(new Color(128, 128, 128));
				getMjeExcepcion().setBounds(98, 521, 370, 65);
				this.add(getMjeExcepcion());
				getMjeExcepcion().setForeground(Color.YELLOW);
		lblAgregarReservas = new JLabel("Agregar Reservas");
		lblAgregarReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarReservas.setForeground(Color.WHITE);
		lblAgregarReservas.setBounds(98, 11, 416, 50);
		lblAgregarReservas.setFont(new Font("Impact", Font.PLAIN, 40));
		this.add(lblAgregarReservas);
		lblIdclienteAgregar = new JLabel("ID del cliente (DNI)");
		lblIdclienteAgregar.setBounds(154, 107, 202, 29);
		this.add(lblIdclienteAgregar);
		lblIdclienteAgregar.setForeground(Color.WHITE);
		lblIdclienteAgregar.setFont(new Font("Impact", Font.PLAIN, 14));

		lblIdCanchaAgregar = new JLabel("ID de la cancha");
		lblIdCanchaAgregar.setBounds(154, 147, 202, 23);
		this.add(lblIdCanchaAgregar);
		lblIdCanchaAgregar.setForeground(Color.WHITE);
		lblIdCanchaAgregar.setFont(new Font("Impact", Font.PLAIN, 14));

		lblFechaAgregar = new JLabel("Fecha");
		lblFechaAgregar.setBounds(439, 75, 128, 22);
		this.add(lblFechaAgregar);
		lblFechaAgregar.setForeground(Color.WHITE);
		lblFechaAgregar.setFont(new Font("Impact", Font.PLAIN, 14));
		setBtnAgregarReserva(new JButton("Agregar"));
		getBtnAgregarCliente().setBackground(Color.WHITE);
		getBtnAgregarCliente().setBounds(343, 184, 86, 25);
		this.add(getBtnAgregarCliente());
		getBtnAgregarCliente().setFont(new Font("Impact", Font.PLAIN, 12));

		setBtnEliminarReserva(new JButton("Eliminar"));
		getBtnEliminarCliente().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnEliminarCliente().setBackground(Color.WHITE);
		getBtnEliminarCliente().setBounds(400, 485, 86, 25);
		this.add(getBtnEliminarCliente());

		setBtnEditarReserva(new JButton("Editar"));

		getBtnEditarCliente().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnEditarCliente().setBackground(Color.WHITE);
		getBtnEditarCliente().setBounds(343, 388, 86, 25);
		this.add(getBtnEditarCliente());

		lblEditarReservas = new JLabel("Editar Reservas");
		lblEditarReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarReservas.setForeground(Color.WHITE);
		lblEditarReservas.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEditarReservas.setBounds(98, 217, 416, 50);
		this.add(lblEditarReservas);

		lblEliminarReservas = new JLabel("Eliminar Reservas");
		lblEliminarReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarReservas.setForeground(Color.WHITE);
		lblEliminarReservas.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEliminarReservas.setBounds(98, 424, 416, 50);
		this.add(lblEliminarReservas);

		setcBoxIdClientesAgregar(new JComboBox<String>());
		getcBoxIdClientesAgregar().setBounds(27, 107, 117, 25);
		this.add(getcBoxIdClientesAgregar());
		setcBoxIdCanchasAgregar(new JComboBox<String>());
		getcBoxIdCanchasAgregar().setBounds(27, 146, 117, 25);
		this.add(getcBoxIdCanchasAgregar());

		lblIdclienteAeliminar = new JLabel("ID del cliente(DNI)");
		lblIdclienteAeliminar.setForeground(Color.WHITE);
		lblIdclienteAeliminar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblIdclienteAeliminar.setBounds(154, 488, 128, 22);

		this.add(lblIdclienteAeliminar);

		lblIdclienteEditar = new JLabel("ID del cliente (DNI)");
		lblIdclienteEditar.setForeground(Color.WHITE);
		lblIdclienteEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblIdclienteEditar.setBounds(154, 315, 128, 22);
		this.add(lblIdclienteEditar);

		dateFechaAgregar = new JDateChooser();
		dateFechaAgregar.setDateFormatString("dd MMM yyyy");
		dateFechaAgregar.setBounds(312, 72, 117, 25);
		add(dateFechaAgregar);

		lblSeniaEditar = new JLabel("Se\u00F1a");
		lblSeniaEditar.setForeground(Color.WHITE);
		lblSeniaEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblSeniaEditar.setBounds(439, 350, 128, 22);
		this.add(lblSeniaEditar);

		lblIDCanchaEditar = new JLabel("ID de la cancha");
		lblIDCanchaEditar.setForeground(Color.WHITE);
		lblIDCanchaEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblIDCanchaEditar.setBounds(154, 354, 202, 23);
		this.add(lblIDCanchaEditar);

		lblHorarioAgregar = new JLabel("Horario");
		lblHorarioAgregar.setForeground(Color.WHITE);
		lblHorarioAgregar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblHorarioAgregar.setBounds(439, 112, 151, 23);
		add(lblHorarioAgregar);

		cBoxHorarioAgregar = new JComboBox<String>();
		cBoxHorarioAgregar
				.setModel(new DefaultComboBoxModel<String>(horarioSTR));
		cBoxHorarioAgregar.setSelectedIndex(15);
		cBoxHorarioAgregar.setToolTipText("");
		cBoxHorarioAgregar.setBounds(312, 108, 117, 25);
		add(cBoxHorarioAgregar);

		txfSeniaEditar = new JTextField();
		txfSeniaEditar.setHorizontalAlignment(SwingConstants.RIGHT);
		txfSeniaEditar.setText("0");
		txfSeniaEditar.setToolTipText("");
		txfSeniaEditar.setColumns(10);
		txfSeniaEditar.setBounds(312, 350, 117, 25);
		add(txfSeniaEditar);

		lblHorarioEditar = new JLabel("Horario");
		lblHorarioEditar.setForeground(Color.WHITE);
		lblHorarioEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblHorarioEditar.setBounds(442, 315, 202, 23);
		add(lblHorarioEditar);

		txfSeniaAgregar = new JTextField();
		txfSeniaAgregar.setHorizontalAlignment(SwingConstants.RIGHT);
		txfSeniaAgregar.setText("0");
		txfSeniaAgregar.setToolTipText("");
		txfSeniaAgregar.setColumns(10);
		txfSeniaAgregar.setBounds(312, 147, 117, 25);
		add(txfSeniaAgregar);

		lblSeniaAgregar = new JLabel("Se\u00F1a");
		lblSeniaAgregar.setForeground(Color.WHITE);
		lblSeniaAgregar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblSeniaAgregar.setBounds(439, 147, 202, 23);
		add(lblSeniaAgregar);

		cBoxIdClienteEditar = new JComboBox<String>();
		cBoxIdClienteEditar.setBounds(27, 313, 117, 25);
		add(cBoxIdClienteEditar);

		cBoxIdCanchaEditar = new JComboBox<String>();
		cBoxIdCanchaEditar.setBounds(27, 350, 117, 25);
		add(cBoxIdCanchaEditar);

		dateFechaEditar = new JDateChooser();
		dateFechaEditar.setDateFormatString("dd MMM yyyy");
		dateFechaEditar.setBounds(312, 275, 117, 25);
		add(dateFechaEditar);

		cBoxHorarioEditar = new JComboBox<String>();
		cBoxHorarioEditar
				.setModel(new DefaultComboBoxModel<String>(horarioSTR));
		cBoxHorarioEditar.setToolTipText("");
		cBoxHorarioEditar.setSelectedIndex(15);
		cBoxHorarioEditar.setBounds(312, 315, 117, 25);
		add(cBoxHorarioEditar);

		lblFechaEditar = new JLabel("Fecha");
		lblFechaEditar.setForeground(Color.WHITE);
		lblFechaEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblFechaEditar.setBounds(439, 278, 128, 22);
		add(lblFechaEditar);

		txfIdReservaAgregar = new JTextField();
		txfIdReservaAgregar.setToolTipText("");
		txfIdReservaAgregar.setColumns(10);
		txfIdReservaAgregar.setBounds(27, 72, 117, 25);
		add(txfIdReservaAgregar);

		lblIdDReservaAgregar = new JLabel("ID de la Reserva");
		lblIdDReservaAgregar.setForeground(Color.WHITE);
		lblIdDReservaAgregar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblIdDReservaAgregar.setBounds(154, 75, 202, 23);
		add(lblIdDReservaAgregar);
		
		cBoxIdReservaEditar = new JComboBox<String>();
		cBoxIdReservaEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarCamposEditar();
			}
		});
		cBoxIdReservaEditar.setBounds(27, 278, 117, 25);
		add(cBoxIdReservaEditar);
		
		lblIdReservaEditar = new JLabel("ID de la Reserva");
		lblIdReservaEditar.setForeground(Color.WHITE);
		lblIdReservaEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblIdReservaEditar.setBounds(154, 280, 202, 23);
		add(lblIdReservaEditar);

		this.setVisible(false);

		cargarIdDeClientesEnCbox();
		cargarIdDeCanchasEnCbox();
		cargarIdDeReservasEnCbox();
		actualizarCamposEditar();

	}

	private JComboBox<String> getcBoxIdCanchasAgregar() {
		return this.cBoxIdCanchasAgregar;
	}

	private void setcBoxIdCanchasAgregar(JComboBox<String> cBoxIdCanchasAgregar) {
		this.cBoxIdCanchasAgregar = cBoxIdCanchasAgregar;
	}

	public void cargarIdDeClientesEnCbox() {

		String[] id_clientes = new String[sistema.getClientes().size()];
		int cont = 0;
		for (Cliente c : sistema.getClientes()) {
			id_clientes[cont] = c.getId() + "";  
			cont++;
		}
		this.cBoxIdClienteAgregar.setModel(new DefaultComboBoxModel<String>(
				id_clientes));
		
		this.cBoxIdClienteEditar.setModel(new DefaultComboBoxModel<String>(
				id_clientes));
	}
	
	public void cargarIdDeReservasEnCbox() {
		
		String[] id_Reservas = new String[sistema.getReservas().size()];
		int cont = 0;
		for (Reserva r : sistema.getReservas()) {
			id_Reservas[cont] = r.getId() + "";
			cont++;
		}
		this.cBoxIdReservaEditar.setModel(new DefaultComboBoxModel<String>(
				id_Reservas));
		
//		this.cBoxIdReservaEliminar.setModel(new DefaultComboBoxModel<String>(
//				id_Reservas));
	}
	
	public void actualizarCamposEditar() {
		 
		for (Reserva r : sistema.getReservas()) {
			if (cBoxIdReservaEditar.getSelectedItem().equals(
					r.getId() + "")) 
				cBoxIdClienteEditar.setSelectedItem(r.getCliente().getId()+"");
				cBoxIdCanchaEditar.setSelectedItem(r.getCancha().getId()+"");
				txfSeniaEditar.setText(r.getSeña()+"");
				
		}
	}

	public void cargarIdDeCanchasEnCbox() {
		String[] nombres_de_canchas = new String[sistema.getCanchas().size()];
		int cont = 0;
		for (Cancha c : sistema.getCanchas()) {
			nombres_de_canchas[cont] = c.getId() + "";
			cont++;
		}
		this.cBoxIdCanchasAgregar.setModel(
				new DefaultComboBoxModel<String>(nombres_de_canchas));
		this.cBoxIdCanchaEditar.setModel(
				new DefaultComboBoxModel<String>(nombres_de_canchas));
	}

	public JButton getBtnEliminarCliente() {
		return btnEliminarReserva;
	}

	public void setBtnEliminarReserva(JButton btnEliminarReserva) {
		this.btnEliminarReserva = btnEliminarReserva;
		btnEliminarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer idCliente = 0;
				try {
					idCliente = 0;
					try {
						sistema.eliminarCliente(idCliente);
						 
						 
					} catch (Exception e) {
						mjeExcepcion.setText(e.getMessage());
					}
					System.out.println(sistema.getClientes());
				} catch (NumberFormatException e) {
					mjeExcepcion.setEnabled(true);
					mjeExcepcion
							.setText("<html><body>No existen canchas guardadas</body></html>");
				}

				cargarIdDeClientesEnCbox();
				cargarIdDeCanchasEnCbox();
				cargarIdDeReservasEnCbox();
			}
		});
	}

	public JButton getBtnEditarCliente() {
		return btnEditarReserva;
	}

	public void setBtnEditarReserva(JButton btnEditarReserva) {
		this.btnEditarReserva = btnEditarReserva;

		btnEditarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer idCliente = 0;
				Integer idCancha = 0;
				Integer seña = 0;
				Integer idReserva = 0;
				Calendar fecha = null;
				try {

					fecha = dateFechaAgregar.getCalendar();

					try {

						idCliente = Integer
								.parseInt((String) cBoxIdClienteEditar
										.getSelectedItem());
						idCancha = Integer
								.parseInt((String) cBoxIdCanchaEditar
										.getSelectedItem());
						

						fecha.set(Calendar.HOUR_OF_DAY,
								cBoxHorarioAgregar.getSelectedIndex());
						fecha.set(Calendar.MINUTE, 0);
						fecha.set(Calendar.SECOND, 0);
						try {
							seña = Integer.parseInt((String) txfSeniaEditar
									.getText());
							idReserva = Integer
								.parseInt((String) cBoxIdReservaEditar.getSelectedItem());
							try {
								sistema.editarReserva(fecha, idCancha,
										idCliente, seña, idReserva);
								System.out.println("Aqui deberia Editar la reserva");
							} catch (Exception e) {
								mjeExcepcion.setText(e.getMessage());
							}
						} catch (NumberFormatException e) {
							mjeExcepcion
									.setText("<html><body>Por favor complete los campos ID DE RESERVA y SEÑA.<br> Recuerde que solo acepta numeros</body></html>");
						}

					} catch (NumberFormatException e) {
						mjeExcepcion
								.setText("<html><body>Debe ingresar al menos una cancha y un cliente al Sistema</body></html>");
					}
				} catch (NullPointerException e) {
					mjeExcepcion
							.setText("<html><body>Por favor complete el campo FECHA</body></html>");
				}
				System.out.println(sistema);
			}

		});
	}

	public void setcBoxNombresDeCanchas(JComboBox<String> cBoxNombresDeClientes) {
	}

	public JComboBox<String> getcBoxIdClientesAgregar() {
		return cBoxIdClienteAgregar;
	}

	public void setcBoxIdClientesAgregar(JComboBox<String> cBoxIdClientesAgregar) {
		this.cBoxIdClienteAgregar = cBoxIdClientesAgregar;
	}

	public void setPrecioEditarCancha(JTextField precioEditarCancha) {
	}

	public JLabel getMjeExcepcion() {
		return mjeExcepcion;
	}

	public void setMjeExcepcion(JLabel mjeExcepcion) {
		this.mjeExcepcion = mjeExcepcion;
	}

	public JButton getBtnAgregarCliente() {
		return btnAgregarReserva;
	}

	public void setBtnAgregarReserva(JButton btnAgregarReserva) {
		this.btnAgregarReserva = btnAgregarReserva;
		btnAgregarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer idCliente = 0;
				Integer idCancha = 0;
				Integer seña = 0;
				Integer idReserva = 0;
				Calendar fecha = null;
				try {

					fecha = dateFechaAgregar.getCalendar();

					try {

						idCliente = Integer
								.parseInt((String) cBoxIdClienteAgregar
										.getSelectedItem());
						idCancha = Integer
								.parseInt((String) cBoxIdCanchasAgregar
										.getSelectedItem());
						

						fecha.set(Calendar.HOUR_OF_DAY,
								cBoxHorarioAgregar.getSelectedIndex());
						fecha.set(Calendar.MINUTE, 0);
						fecha.set(Calendar.SECOND, 0);
						try {
							seña = Integer.parseInt((String) txfSeniaAgregar
									.getText());
							idReserva = Integer
								.parseInt((String) txfIdReservaAgregar.getText());
							try {
								sistema.agregarReserva(fecha, idCancha,
										idCliente, seña, idReserva);
								System.out.println("Aqui deberia agregar la reserva");
							} catch (Exception e) {
								mjeExcepcion.setText(e.getMessage());
							}
						} catch (NumberFormatException e) {
							mjeExcepcion
									.setText("<html><body>Por favor complete los campos ID DE RESERVA y SEÑA.<br> Recuerde que solo acepta numeros</body></html>");
						}

					} catch (NumberFormatException e) {
						mjeExcepcion
								.setText("<html><body>Debe ingresar al menos una cancha y un cliente al Sistema</body></html>");
					}
				} catch (NullPointerException e) {
					mjeExcepcion
							.setText("<html><body>Por favor complete el campo FECHA</body></html>");
				}

				cargarIdDeClientesEnCbox();
				cargarIdDeCanchasEnCbox();
				cargarIdDeReservasEnCbox();
				actualizarCamposEditar();
				System.out.println(sistema);
			}
		});
	}

	public void setTxfIdClienteAgregar(JTextField idCliente) {
	}

	public void setTxfNombreClienteAgregar(JTextField nombreCliente) {
	}
}