package sistema;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PanelCanchas extends PanelImagen {

	private Sistema sistema;
	private JTextField idCancha;
	private JComboBox<String> cBoxNombresDeCanchas;
	private JComboBox<String> cantJugCancha;
	private JComboBox<String> cBoxNombresDeCanchasEditar;
	private JComboBox<String> cBoxCantJugEditar;
	private JTextField precioCancha;
	private JLabel mjeExcepcion, lblNumeroDeCancha, lblPrecio,
			lblCantidadDeClientes, label, label_1, label_2;
	private JLabel lblNewLabel, lblEditarCanchas, lblEliminarCanchas,
			lblNumeroDeCancha_1;
	private JButton btnAgregarCancha;
	private JButton btnEliminarCanchas;
	private JButton btnEditarCancha;
	private JTextField precioEditarCancha;
	private String[] jug_canchas = { "5", "7", "9", "11" };

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * 
	 */
	public PanelCanchas(Sistema sistema) {
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
		this.patch = "CANCHA_TRON.jpg";
		this.setLayout(null);
		lblNewLabel = new JLabel("Agregar Canchas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(98, 11, 416, 50);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 40));
		this.add(lblNewLabel);
		setIdCancha(new JTextField());
		getIdCancha().setBounds(98, 91, 86, 27);
		this.add(getIdCancha());
		getIdCancha().setToolTipText("Ingrese el numero de la cancha");
		getIdCancha().setColumns(10);
		lblNumeroDeCancha = new JLabel("Numero de cancha");
		lblNumeroDeCancha.setBounds(218, 93, 202, 29);
		this.add(lblNumeroDeCancha);
		lblNumeroDeCancha.setForeground(Color.WHITE);
		lblNumeroDeCancha.setFont(new Font("Impact", Font.PLAIN, 14));

		setPrecioCancha(new JTextField());
		getPrecioCancha().setBounds(98, 129, 86, 25);
		this.add(getPrecioCancha());
		getPrecioCancha().setToolTipText("Ingrese el numero de la cancha");
		getPrecioCancha().setColumns(10);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(218, 133, 202, 23);
		this.add(lblPrecio);
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Impact", Font.PLAIN, 14));

		setCantJugCancha(new JComboBox<String>());
		getCantJugCancha().setBounds(98, 165, 86, 22);
		this.add(getCantJugCancha());

		getCantJugCancha().setModel(
				new DefaultComboBoxModel<String>(jug_canchas));
		getCantJugCancha().setToolTipText("Elija el numero de la cancha");

		lblCantidadDeClientes = new JLabel("Cantidad de Jugadores");
		lblCantidadDeClientes.setBounds(218, 167, 128, 22);
		this.add(lblCantidadDeClientes);
		lblCantidadDeClientes.setForeground(Color.WHITE);
		lblCantidadDeClientes.setFont(new Font("Impact", Font.PLAIN, 14));

		setMjeExcepcion(new JLabel());
		getMjeExcepcion().setHorizontalAlignment(SwingConstants.CENTER);
		getMjeExcepcion().setFont(new Font("Impact", Font.PLAIN, 20));
		getMjeExcepcion().setBackground(new Color(128, 128, 128));
		getMjeExcepcion().setBounds(98, 521, 370, 65);
		this.add(getMjeExcepcion());
		getMjeExcepcion().setForeground(Color.YELLOW);
		setBtnAgregarCancha(new JButton("Agregar"));
		getBtnAgregarCancha().setBackground(Color.WHITE);
		getBtnAgregarCancha().setBounds(400, 133, 86, 25);
		this.add(getBtnAgregarCancha());
		getBtnAgregarCancha().setFont(new Font("Impact", Font.PLAIN, 12));

		setBtnEliminarCanchas(new JButton("Eliminar"));
		getBtnEliminarCanchas().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnEliminarCanchas().setBackground(Color.WHITE);
		getBtnEliminarCanchas().setBounds(400, 473, 86, 25);
		this.add(getBtnEliminarCanchas());

		setBtnEditarCancha(new JButton("Editar"));

		getBtnEditarCancha().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnEditarCancha().setBackground(Color.WHITE);
		getBtnEditarCancha().setBounds(400, 326, 86, 25);
		this.add(getBtnEditarCancha());

		lblEditarCanchas = new JLabel("Editar Canchas");
		lblEditarCanchas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarCanchas.setForeground(Color.WHITE);
		lblEditarCanchas.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEditarCanchas.setBounds(98, 215, 416, 50);
		this.add(lblEditarCanchas);

		lblEliminarCanchas = new JLabel("Eliminar Canchas");
		lblEliminarCanchas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarCanchas.setForeground(Color.WHITE);
		lblEliminarCanchas.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEliminarCanchas.setBounds(98, 401, 416, 50);
		this.add(lblEliminarCanchas);

		setcBoxNombresDeCanchas(new JComboBox<String>());
		setcBoxNombresDeCanchas_clone(new JComboBox<String>());

		getcBoxNombresDeCanchas().setBounds(98, 470, 86, 22);
		this.add(getcBoxNombresDeCanchas());
		getcBoxNombresDeCanchas_clone().setBounds(98, 289, 86, 22);
		this.add(getcBoxNombresDeCanchas_clone());

		lblNumeroDeCancha_1 = new JLabel("Numero de Cancha");
		lblNumeroDeCancha_1.setForeground(Color.WHITE);
		lblNumeroDeCancha_1.setFont(new Font("Impact", Font.PLAIN, 14));
		lblNumeroDeCancha_1.setBounds(218, 470, 128, 22);

		this.add(lblNumeroDeCancha_1);

		label = new JLabel("Numero de Cancha");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 14));
		label.setBounds(218, 289, 128, 22);
		this.add(label);

		setPrecioEditarCancha(new JTextField());
		getPrecioEditarCancha().setToolTipText("Elija el numero de la cancha");
		getPrecioEditarCancha().setColumns(10);
		getPrecioEditarCancha().setBounds(98, 323, 86, 25);
		this.add(getPrecioEditarCancha());

		setCantJugCanchaEditar(new JComboBox<String>());
		getCantJugCanchaEditar().setToolTipText("Elija el numero de la cancha");
		getCantJugCanchaEditar().setBounds(98, 359, 86, 22);
		this.add(getCantJugCanchaEditar());
		getCantJugCanchaEditar().setModel(
				new DefaultComboBoxModel<String>(jug_canchas));

		label_1 = new JLabel("Cantidad de Jugadores");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Impact", Font.PLAIN, 14));
		label_1.setBounds(218, 361, 128, 22);
		this.add(label_1);

		label_2 = new JLabel("Precio");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Impact", Font.PLAIN, 14));
		label_2.setBounds(218, 328, 202, 23);
		this.add(label_2);
		this.setVisible(false);
		cargarNombresDeCanchasEnCbox();
		actualizarCamposEditar();

	}

	public void cargarNombresDeCanchasEnCbox() {
		String[] nombres_de_canchas = new String[sistema.getCanchas().size()];
		int cont = 0;
		for (Cancha c : sistema.getCanchas()) {
			nombres_de_canchas[cont] = c.getId() + "";
			cont++;
		}
		// Cargo los nombres de las canchas en el comboBox
		this.cBoxNombresDeCanchas.setModel(new DefaultComboBoxModel<String>(
				nombres_de_canchas));
		this.cBoxNombresDeCanchasEditar
				.setModel(new DefaultComboBoxModel<String>(nombres_de_canchas));
	}

	public void actualizarCamposEditar() {
		for (Cancha c : sistema.getCanchas()) {
			if (cBoxNombresDeCanchasEditar.getSelectedItem().equals(
					c.getId() + "")) {
				precioEditarCancha.setText(c.getPrecio()+"");
				cBoxCantJugEditar.setSelectedItem(c.getCantjugadores()+""); 
			}
		}
	}

	public void limpiar_Campos_Cancha() {
		idCancha.setText("");
		precioCancha.setText("");
		precioEditarCancha.setText("");
	}

	public JButton getBtnEliminarCanchas() {
		return btnEliminarCanchas;
	}

	public JButton getBtnEditarCancha() {
		return btnEditarCancha;
	}

	public JComboBox<String> getCantJugCancha() {
		return cantJugCancha;
	}

	public void setCantJugCancha(JComboBox<String> cantJugCancha) {
		this.cantJugCancha = cantJugCancha;
	}

	public JComboBox<String> getcBoxNombresDeCanchas() {
		return cBoxNombresDeCanchas;
	}

	public void setcBoxNombresDeCanchas(JComboBox<String> cBoxNombresDeCanchas) {
		this.cBoxNombresDeCanchas = cBoxNombresDeCanchas;
	}

	public JComboBox<String> getCantJugCanchaEditar() {
		return cBoxCantJugEditar;
	}

	public void setCantJugCanchaEditar(JComboBox<String> cantJugCanchaEditar) {
		this.cBoxCantJugEditar = cantJugCanchaEditar;
	}

	public JComboBox<String> getcBoxNombresDeCanchas_clone() {
		return cBoxNombresDeCanchasEditar;
	}

	public void setcBoxNombresDeCanchas_clone(
			JComboBox<String> cBoxNombresDeCanchas_clone) {
		this.cBoxNombresDeCanchasEditar = cBoxNombresDeCanchas_clone;
		cBoxNombresDeCanchasEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCamposEditar();
			}
		});
	}

	public JTextField getPrecioEditarCancha() {
		return precioEditarCancha;
	}

	public void setPrecioEditarCancha(JTextField precioEditarCancha) {
		this.precioEditarCancha = precioEditarCancha;
	}

	public JLabel getMjeExcepcion() {
		return mjeExcepcion;
	}

	public void setMjeExcepcion(JLabel mjeExcepcion) {
		this.mjeExcepcion = mjeExcepcion;
	}

	public JButton getBtnAgregarCancha() {
		return btnAgregarCancha;
	}

	public JTextField getIdCancha() {
		return idCancha;
	}

	public void setIdCancha(JTextField idCancha) {
		this.idCancha = idCancha;
	}

	public JTextField getPrecioCancha() {
		return precioCancha;
	}

	public void setPrecioCancha(JTextField precioCancha) {
		this.precioCancha = precioCancha;
	}

	public void setBtnEliminarCanchas(JButton btnEliminarCanchas) {
		this.btnEliminarCanchas = btnEliminarCanchas;
		getBtnEliminarCanchas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer idCan = 0;
				try {
					idCan = Integer.parseInt((String) cBoxNombresDeCanchas
							.getSelectedItem());
					try {
						sistema.eliminarCancha(idCan);
						// Limpiar los campos
						limpiar_Campos_Cancha();
					} catch (Exception e) {
						mjeExcepcion.setText(e.getMessage());
					}
					System.out.println(sistema.getCanchas());
				} catch (NumberFormatException e) {
					mjeExcepcion.setEnabled(true);

					mjeExcepcion
							.setText("<html><body>No existen canchas guardadas</body></html>");
				}

				// cargo los nombres de las canchas en el combBox
				cargarNombresDeCanchasEnCbox();
				actualizarCamposEditar();			}
		});
	}

	public void setBtnAgregarCancha(JButton btnAgregarCancha) {
		this.btnAgregarCancha = btnAgregarCancha;
		btnAgregarCancha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer cantCan = 0;
				Integer idCan = 0;
				Integer precioCan = 0;
				try {
					cantCan = Integer.parseInt((String) cantJugCancha
							.getSelectedItem());
					idCan = Integer.parseInt(idCancha.getText());
					precioCan = Integer.parseInt(precioCancha.getText());
					try {
						sistema.agregarCancha(idCan, precioCan, cantCan);
						// Limpiar los campos
						limpiar_Campos_Cancha();
					} catch (Exception e) {
						mjeExcepcion.setText(e.getMessage());
					}
					System.out.println(sistema.getCanchas());
				} catch (NumberFormatException e) {
					getMjeExcepcion().setEnabled(true);

					mjeExcepcion
							.setText("<html><body>Por favor complete todos los campos.<br> Recuerde que solo se permiten numeros</body></html>");
				}

				cargarNombresDeCanchasEnCbox();
				actualizarCamposEditar();
				// for (int i = 0; i < nombres_de_canchas.length; i++)
				// System.out.println(nombres_de_canchas[i]);

			}

		});
	}

	public void setBtnEditarCancha(JButton btnEditarCancha) {
		this.btnEditarCancha = btnEditarCancha;
		btnEditarCancha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mjeExcepcion.setText("");

				Integer cantCan = 0;
				Integer idCan = 0;
				Integer precioCan = 0;

				try {
					cantCan = Integer.parseInt((String) cBoxCantJugEditar
							.getSelectedItem());
					idCan = Integer
							.parseInt((String) cBoxNombresDeCanchasEditar
									.getSelectedItem());
					precioCan = Integer.parseInt(precioEditarCancha.getText());
					try {

						cargarNombresDeCanchasEnCbox();
						sistema.editarCancha(idCan, precioCan, cantCan);
						// Limpiar los campos
						limpiar_Campos_Cancha();
					} catch (Exception e) {
						mjeExcepcion.setText(e.getMessage());
					}
				} catch (NumberFormatException e) {
					mjeExcepcion.setEnabled(true);
					mjeExcepcion
							.setText(

							"<html><body>Por favor complete todos los campos.<br> Recuerde que solo se permiten numeros</body></html>");
				}
				System.out.println(sistema.getCanchas());
			}

		});
	}

	// public static void main(String[] args) {
	//
	// EventQueue.invokeLater(new Runnable() {
	// @Override
	// public void run() {
	// try {
	// Sistema s = new Sistema();
	// PanelCanchas p = new PanelCanchas(s);
	// p.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

}
