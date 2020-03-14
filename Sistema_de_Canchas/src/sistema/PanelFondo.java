package sistema;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class PanelFondo extends PanelImagen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sistema sistema;

	/**
	 * Create the panel.
	 */
	public PanelFondo(Sistema sistema) {
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
	}
}