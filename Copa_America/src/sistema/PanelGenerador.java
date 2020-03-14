package sistema;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;

public class PanelGenerador extends PanelImagen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Instancia instancia;
	private JLabel lblEquipoIdeal;
	private JButton btnGenerarEquipo;
	private JList<String> txfEquipoIdeal;
	private JLabel lblAmarillas;
	private JTextField txfPuntos;
	private JTextField txfRojas;
	private JLabel lblRojas;
	private JLabel lblPuntos;
	private JTextField txfAmarillas;

	/**
	 * Create the panel.
	 */
	public PanelGenerador(Sistema sistema) {
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

		instancia = new Instancia(1, 4, 3, 3, 2, 1);
		this.setBounds(308, 0, 580, 597);
		this.patch = "copa_america6.jpg";
		this.setLayout(null);

		setBtnGenerar(new JButton("Generar"));
		getBtnGenerar().setFont(new Font("Impact", Font.PLAIN, 12));
		getBtnGenerar().setBackground(Color.WHITE);
		getBtnGenerar().setBounds(95, 95, 117, 36);
		this.add(getBtnGenerar());
		
		lblEquipoIdeal = new JLabel("Generador de Equipo ideal");
		lblEquipoIdeal.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipoIdeal.setForeground(Color.LIGHT_GRAY);
		lblEquipoIdeal.setFont(new Font("Impact", Font.PLAIN, 40));
		lblEquipoIdeal.setBounds(56, 33, 482, 50);
		this.add(lblEquipoIdeal);
		
		lblAmarillas = new JLabel("Amarillas");
		lblAmarillas.setForeground(Color.ORANGE);
		lblAmarillas.setFont(new Font("Impact", Font.PLAIN, 14));
		lblAmarillas.setBounds(230, 141, 202, 29);
		add(lblAmarillas);
		
	
		txfEquipoIdeal = new JList<String>();
		txfEquipoIdeal.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txfEquipoIdeal.setBackground(Color.LIGHT_GRAY);
		txfEquipoIdeal.setBounds(12, 264, 556, 320);
		add(txfEquipoIdeal);
	
		txfPuntos = new JTextField();
		txfPuntos.setBackground(Color.LIGHT_GRAY);
		txfPuntos.setEditable(false);
		txfPuntos.setColumns(10);
		txfPuntos.setBounds(342, 102, 117, 27);
		add(txfPuntos);
	
	
		txfRojas = new JTextField();
		txfRojas.setBackground(Color.LIGHT_GRAY);
		txfRojas.setEditable(false);
		txfRojas.setColumns(10);
		txfRojas.setBounds(342, 141, 117, 27);
		add(txfRojas);
	
	
		lblRojas = new JLabel("Rojas");
		lblRojas.setForeground(Color.ORANGE);
		lblRojas.setFont(new Font("Impact", Font.PLAIN, 14));
		lblRojas.setBounds(477, 139, 202, 29);
		add(lblRojas);
	
	
		lblPuntos = new JLabel("Puntos");
		lblPuntos.setForeground(Color.ORANGE);
		lblPuntos.setFont(new Font("Impact", Font.PLAIN, 14));
		lblPuntos.setBounds(477, 100, 202, 29);
		add(lblPuntos);
	
	
		txfAmarillas = new JTextField();
		txfAmarillas.setBackground(Color.LIGHT_GRAY);
		txfAmarillas.setEditable(false);
		txfAmarillas.setColumns(10);
		txfAmarillas.setBounds(95, 143, 117, 27);
		add(txfAmarillas);
		
	}

	public JButton getBtnGenerar() {
		return btnGenerarEquipo;
	}

	public void setBtnGenerar(JButton btnGenerar) {
		this.btnGenerarEquipo = btnGenerar;

		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema alg = new Sistema(instancia);
				ListadoJugadores equipoIdeal = alg.resolver();
				imprimirEquipo(equipoIdeal);
			}			
		});
	}
	public void imprimirEquipo(ListadoJugadores equipoIdeal) {

			String[] aux= new String [equipoIdeal.cantJugadores()];
			for (int i=0; i<equipoIdeal.cantJugadores();i++) 
			{
				aux[i]=equipoIdeal.dameJugador(i)+"";
			}
			
			txfEquipoIdeal.setModel(new DefaultComboBoxModel<String>(aux));
			txfAmarillas.setText(equipoIdeal.cantJugAmarillas()+"");
			txfRojas.setText(equipoIdeal.cantJugRojas()+"");
			txfPuntos.setText(equipoIdeal.puntaje()+"");
			}
}
