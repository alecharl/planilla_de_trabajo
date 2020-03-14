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

public class PanelClientes extends PanelImagen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Clientes clientes;

	private JLabel mjeExcepcion, lblIdclienteAgregar, lblNombreClienteAgregar,
			lblApellidoClienteAgregar, lblIdclienteEditar,
			lblApellidoClienteEliminar, lblNombreClienteEditar;
	private JLabel lblAgregarCliente, lblEditarClientes, lblEliminarClientes,
			lblIdclienteAeliminar, lblDireccionClienteEliminar;	
	private JLabel lblDireccionClienteAgregar;
	private JButton btnAgregarCliente;
	private JButton btnEliminarCliente;
	private JButton btnEditarCliente;
	// private String[] jug_canchas = { "5", "7", "11" };
	private JTextField txfIdClienteAgregar;
	private JTextField txfNombreClienteAgregar;
	private JTextField txfAoellidoClienteAgregar;
	private JTextField txfDireccionClienteAgregar;

	private JComboBox<String> cBoxIdClienteEditar;
	private JTextField txfNombreClienteEditar;
	private JTextField txfApellidoClienteEditar;
	private JTextField txfDireccionClienteEditar;

	private JComboBox<String> cBoxIdClienteEliminar;

	/**
	 * Create the panel.
	 */
	public PanelClientes(Clientes clientes) {
		initialize(clientes);
	}

	private void initialize(Clientes clientes) {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.clientes = clientes;
		this.setBounds(308, 0, 580, 597);
		this.patch = "CANCHA_TRON2.jpg";
		this.setLayout(null);
		lblAgregarCliente = new JLabel("Agregar Clientes");
		lblAgregarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarCliente.setForeground(Color.WHITE);
		lblAgregarCliente.setBounds(98, 11, 416, 50);
		lblAgregarCliente.setFont(new Font("Impact", Font.PLAIN, 40));
		this.add(lblAgregarCliente);
		setTxfIdClienteAgregar(new JTextField());
		getTxfIdClienteAgregar().setBounds(67, 67, 117, 27);
		this.add(getTxfIdClienteAgregar());
		getTxfIdClienteAgregar().setToolTipText("");
		getTxfIdClienteAgregar().setColumns(10);
		lblIdclienteAgregar = new JLabel("ID del cliente (DNI)");
		lblIdclienteAgregar.setBounds(218, 65, 202, 29);
		this.add(lblIdclienteAgregar);
		lblIdclienteAgregar.setForeground(Color.WHITE);
		lblIdclienteAgregar.setFont(new Font("Impact", Font.PLAIN, 14));

		setTxfNombreClienteAgregar(new JTextField());
		getTxfNombreClienteAgregar().setBounds(67, 105, 117, 25);
		this.add(getTxfNombreClienteAgregar());
		getTxfNombreClienteAgregar().setToolTipText("");
		getTxfNombreClienteAgregar().setColumns(10);

		lblNombreClienteAgregar = new JLabel("Nombre");
		lblNombreClienteAgregar.setBounds(218, 104, 202, 23);
		this.add(lblNombreClienteAgregar);
		lblNombreClienteAgregar.setForeground(Color.WHITE);
		lblNombreClienteAgregar.setFont(new Font("Impact", Font.PLAIN, 14));

		lblApellidoClienteAgregar = new JLabel("Apellido");
		lblApellidoClienteAgregar.setBounds(218, 144, 128, 22);
		this.add(lblApellidoClienteAgregar);
		lblApellidoClienteAgregar.setForeground(Color.WHITE);
		lblApellidoClienteAgregar.setFont(new Font("Impact", Font.PLAIN, 14));

		setMjeExcepcion(new JLabel());
		getMjeExcepcion().setHorizontalAlignment(SwingConstants.CENTER);
		getMjeExcepcion().setFont(new Font("Impact", Font.PLAIN, 20));
		getMjeExcepcion().setBackground(new Color(128, 128, 128));
		getMjeExcepcion().setBounds(98, 521, 370, 65);
		this.add(getMjeExcepcion());
		getMjeExcepcion().setForeground(Color.YELLOW);
		setBtnAgregarCliente(new JButton("Agregar"));
		getBtnAgregarCliente().setBackground(Color.WHITE);
		getBtnAgregarCliente().setBounds(400, 122, 86, 25);
		this.add(getBtnAgregarCliente());
		getBtnAgregarCliente().setFont(new Font("Impact", Font.PLAIN, 12));

		setBtnEliminarCliente(new JButton("Eliminar"));
		getBtnEliminarCliente().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnEliminarCliente().setBackground(Color.WHITE);
		getBtnEliminarCliente().setBounds(400, 485, 86, 25);
		this.add(getBtnEliminarCliente());

		setBtnEditarCliente(new JButton("Editar"));

		getBtnEditarCliente().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnEditarCliente().setBackground(Color.WHITE);
		getBtnEditarCliente().setBounds(400, 315, 86, 25);
		this.add(getBtnEditarCliente());

		lblEditarClientes = new JLabel("Editar Clientes");
		lblEditarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarClientes.setForeground(Color.WHITE);
		lblEditarClientes.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEditarClientes.setBounds(98, 217, 416, 50);
		this.add(lblEditarClientes);

		lblEliminarClientes = new JLabel("Eliminar Clientes");
		lblEliminarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarClientes.setForeground(Color.WHITE);
		lblEliminarClientes.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEliminarClientes.setBounds(98, 424, 416, 50);
		this.add(lblEliminarClientes);

		setcBoxNombresDeClientesEliminar(new JComboBox<String>());
		setcBoxNombresDeClientesEditar(new JComboBox<String>());

		getcBoxIdClientes().setBounds(67, 488, 117, 22);
		this.add(getcBoxIdClientes());
		getcBoxIdClientesEditar().setBounds(67, 278, 117, 22);
		this.add(getcBoxIdClientesEditar());

		lblIdclienteAeliminar = new JLabel("ID del cliente(DNI)");
		lblIdclienteAeliminar.setForeground(Color.WHITE);
		lblIdclienteAeliminar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblIdclienteAeliminar.setBounds(218, 488, 128, 22);

		this.add(lblIdclienteAeliminar);

		lblIdclienteEditar = new JLabel("ID del cliente (DNI)");
		lblIdclienteEditar.setForeground(Color.WHITE);
		lblIdclienteEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblIdclienteEditar.setBounds(218, 278, 128, 22);
		this.add(lblIdclienteEditar);

		setTxfNombreClienteEditar(new JTextField());
		getTfxNombreClienteEditar().setToolTipText("");
		getTfxNombreClienteEditar().setColumns(10);
		getTfxNombreClienteEditar().setBounds(67, 312, 117, 25);
		this.add(getTfxNombreClienteEditar());

		lblApellidoClienteEliminar = new JLabel("Apellido");
		lblApellidoClienteEliminar.setForeground(Color.WHITE);
		lblApellidoClienteEliminar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblApellidoClienteEliminar.setBounds(218, 348, 128, 22);
		this.add(lblApellidoClienteEliminar);

		lblNombreClienteEditar = new JLabel("Nombre");
		lblNombreClienteEditar.setForeground(Color.WHITE);
		lblNombreClienteEditar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblNombreClienteEditar.setBounds(218, 315, 202, 23);
		this.add(lblNombreClienteEditar);

		lblDireccionClienteAgregar = new JLabel("Direccion");
		lblDireccionClienteAgregar.setForeground(Color.WHITE);
		lblDireccionClienteAgregar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblDireccionClienteAgregar.setBounds(218, 183, 202, 23);
		add(lblDireccionClienteAgregar);

		txfDireccionClienteAgregar = new JTextField();
		txfDireccionClienteAgregar.setToolTipText("");
		txfDireccionClienteAgregar.setColumns(10);
		txfDireccionClienteAgregar.setBounds(67, 177, 117, 27);
		add(txfDireccionClienteAgregar);

		txfAoellidoClienteAgregar = new JTextField();
		txfAoellidoClienteAgregar.setToolTipText("");
		txfAoellidoClienteAgregar.setColumns(10);
		txfAoellidoClienteAgregar.setBounds(67, 141, 117, 25);
		add(txfAoellidoClienteAgregar);

		txfApellidoClienteEditar = new JTextField();
		txfApellidoClienteEditar.setToolTipText("");
		txfApellidoClienteEditar.setColumns(10);
		txfApellidoClienteEditar.setBounds(67, 348, 117, 27);
		add(txfApellidoClienteEditar);

		txfDireccionClienteEditar = new JTextField();
		txfDireccionClienteEditar.setToolTipText("");
		txfDireccionClienteEditar.setColumns(10);
		txfDireccionClienteEditar.setBounds(67, 386, 117, 27);
		add(txfDireccionClienteEditar);

		lblDireccionClienteEliminar = new JLabel("Direccion");
		lblDireccionClienteEliminar.setForeground(Color.WHITE);
		lblDireccionClienteEliminar.setFont(new Font("Impact", Font.PLAIN, 14));
		lblDireccionClienteEliminar.setBounds(218, 386, 202, 23);
		add(lblDireccionClienteEliminar);
		this.setVisible(false);
		cargarIdDeClientesEnCbox();
		actualizarCamposEditar();

	}

	public void cargarIdDeClientesEnCbox() {
		String[] id_clientes = new String[clientes.getClientes().size()];
		int cont = 0;
		for (Cliente c : clientes.getClientes()) {
			id_clientes[cont] = c.getId() + "";
			cont++;
		}
		// Cargo los nombres de las canchas en el comboBox
		this.getcBoxIdClientes().setModel(
				new DefaultComboBoxModel<String>(id_clientes));
		this.getcBoxIdClientesEditar().setModel(
				new DefaultComboBoxModel<String>(id_clientes));
	}

	public void limpiar_Campos_Clientes() {
		txfIdClienteAgregar.setText("");
		txfNombreClienteAgregar.setText("");
		txfAoellidoClienteAgregar.setText("");
		txfDireccionClienteAgregar.setText("");
	}

	public JButton getBtnEliminarCliente() {
		return btnEliminarCliente;
	}

	public void setBtnEliminarCliente(JButton btnEliminarClientes) {
		this.btnEliminarCliente = btnEliminarClientes;
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer idCliente = 0;
				try {
					idCliente = Integer.parseInt((String)cBoxIdClienteEliminar.getSelectedItem());
					try {
						clientes.eliminarCliente(idCliente);
						// Limpiar los campos
						limpiar_Campos_Clientes();
					} catch (Exception e) {
						mjeExcepcion.setText(e.getMessage());
					}
					System.out.println(clientes.getClientes());
				} catch (NumberFormatException e) {
					mjeExcepcion.setEnabled(true);
					mjeExcepcion.setText(
									"<html><body>No existen canchas guardadas</body></html>");
				}

				cargarIdDeClientesEnCbox();
				actualizarCamposEditar();
			}			
		});
	}

	public JButton getBtnEditarCliente() {
		return btnEditarCliente;
	}


	public void setBtnEditarCliente(JButton btnEditarCliente) {
		this.btnEditarCliente = btnEditarCliente;
	
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer idCliente = 0;
				String nombre = "";
				String apellido = "";
				String direccion= "";

				try {
					idCliente = Integer.parseInt((String)cBoxIdClienteEditar.getSelectedItem());
					nombre = txfNombreClienteEditar.getText();
					apellido = txfApellidoClienteEditar.getText();
					direccion = txfDireccionClienteEditar.getText();
					try {
						clientes.editarCliente(idCliente, nombre, apellido, direccion);
						// Limpiar los campos
						limpiar_Campos_Clientes();
					} catch (Exception e) {
						mjeExcepcion.setText(e.getMessage());
					}
				} catch (NumberFormatException e) {
					mjeExcepcion.setEnabled(true);
					mjeExcepcion.setText("<html><body>No existen Clientes cargados en el sistema</body></html>");
				}
				
				System.out.println(clientes.getClientes());
			}
				
		});
	}


	public JComboBox<String> getcBoxIdClientes() {
		return cBoxIdClienteEliminar;
	}

	public void setcBoxNombresDeClientesEliminar(JComboBox<String> cBoxNombresDeClientesEliminar) {
		this.cBoxIdClienteEliminar = cBoxNombresDeClientesEliminar;
	}

	public JComboBox<String> getcBoxIdClientesEditar() {
		return cBoxIdClienteEditar;
	}

	public void setcBoxNombresDeClientesEditar(
			JComboBox<String> cBoxNombresDeClientesEditar) {
		this.cBoxIdClienteEditar = cBoxNombresDeClientesEditar;
		cBoxIdClienteEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCamposEditar();
			}
		});
	}

	public JTextField getTfxNombreClienteEditar() {
		return txfNombreClienteEditar;
	}

	public void setTxfNombreClienteEditar(JTextField precioEditarCancha) {
		this.txfNombreClienteEditar = precioEditarCancha;
	}

	public JLabel getMjeExcepcion() {
		return mjeExcepcion;
	}

	public void setMjeExcepcion(JLabel mjeExcepcion) {
		this.mjeExcepcion = mjeExcepcion;
	}

	public JButton getBtnAgregarCliente() {
		return btnAgregarCliente;
	}

	public void setBtnAgregarCliente(JButton btnAgregarCliente) {
		this.btnAgregarCliente = btnAgregarCliente;
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer idCliente = 0;
				String nombreCliente = "";
				String apellidoCliente = "";
				String direccionCliente = "";
				try {
					idCliente = Integer.parseInt((String) txfIdClienteAgregar
							.getText());
					nombreCliente = txfNombreClienteAgregar.getText();
					apellidoCliente = txfAoellidoClienteAgregar.getText();
					direccionCliente = txfDireccionClienteAgregar.getText();
					try {
						clientes.agregarCliente(idCliente, nombreCliente,
								apellidoCliente, direccionCliente);
						limpiar_Campos_Clientes();
					} catch (Exception e) {
						mjeExcepcion.setText(e.getMessage());
					}
					System.out.println(clientes.getClientes());
				} catch (NumberFormatException e) {
					mjeExcepcion
							.setText("<html><body>Por favor complete el campo ID (DNI) .<br> Recuerde que solo acepta numeros</body></html>");
				}

				cargarIdDeClientesEnCbox();
				actualizarCamposEditar();
			}
		});
	}

	public JTextField getTxfIdClienteAgregar() {
		return txfIdClienteAgregar;
	}

	public void setTxfIdClienteAgregar(JTextField idCliente) {
		this.txfIdClienteAgregar = idCliente;
	}

	public void setcBoxIdClienteEditar(JComboBox<String> cBoxIdClienteEditar) {
		this.cBoxIdClienteEditar = cBoxIdClienteEditar;
		
	}

	public void actualizarCamposEditar() {
		for (Cliente c : clientes.getClientes()) {
			if (getcBoxIdClientesEditar().getSelectedItem().equals(
					c.getId() + "")) {
				txfApellidoClienteEditar.setText(c.getApellido());
				txfNombreClienteEditar.setText(c.getNombre());
				txfDireccionClienteEditar.setText(c.getDireccion());
			}
		}
	}
	public JTextField getTxfNombreClienteAgregar() {
		return txfNombreClienteAgregar;
	}

	public void setTxfNombreClienteAgregar(JTextField nombreCliente) {
		this.txfNombreClienteAgregar = nombreCliente;
	}

	// public static void main(String[] args) {
	//
	// EventQueue.invokeLater(new Runnable() {
	// @Override
	// public void run() {
	// try {
	// Sistema s = new Sistema();
	// PanelClientes p = new PanelClientes(s);
	// p.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

}
