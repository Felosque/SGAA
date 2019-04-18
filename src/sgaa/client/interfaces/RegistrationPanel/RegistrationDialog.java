package sgaa.client.interfaces.RegistrationPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainPanel;

import javax.swing.JLabel;
import java.awt.Color;

public class RegistrationDialog extends JDialog implements ActionListener, WindowListener{

	private final JPanel contentPanel = new JPanel();

	private MainPanel mainPanel;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			RegistrationDialog dialog = new RegistrationDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public RegistrationDialog(MainPanel pMainPanel) {
		
		mainPanel = pMainPanel;
		addWindowListener(this);
		setBounds(100, 100, 562, 343);
		setLocationRelativeTo(pMainPanel);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Colors.SECONDARY_COLOR);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblesperaAntesDe = new JLabel("\u00A1Espera! Cómo quieres registrarte en el SGAA?");
		lblesperaAntesDe.setBounds(98, 66, 400, 69);
		lblesperaAntesDe.setForeground(Colors.COLOR_WHITE);
		lblesperaAntesDe.setFont(Fonts.FONT_BODY_BLOD_1);
		contentPanel.add(lblesperaAntesDe);
		
		JLabel lblSgaa = new JLabel("SGAA");
		lblSgaa.setBounds(227, 11, 150, 62);
		lblSgaa.setForeground(Colors.COLOR_WHITE);
		lblSgaa.setFont(Fonts.FONT_TITLE_1);
		contentPanel.add(lblSgaa);
		
		JButton btnSoyUnUsuario = new JButton("Soy un usuario y quiero adoptar una mascota");
		btnSoyUnUsuario.setBounds(40, 147, 482, 36);
		contentPanel.add(btnSoyUnUsuario);
		btnSoyUnUsuario.setActionCommand("USER");
		btnSoyUnUsuario.addActionListener(this);
		
		JButton btnSoyUnaOrganizacin = new JButton("Soy una organizaci\u00F3n y quiero poner en adopci\u00F3n mis mascotas");
		btnSoyUnaOrganizacin.setBounds(40, 194, 482, 36);
		contentPanel.add(btnSoyUnaOrganizacin);
		btnSoyUnaOrganizacin.addActionListener(this);
		btnSoyUnaOrganizacin.setActionCommand("ORGANIZATION");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 73);
		panel.setBackground(Colors.PRIMARY_COLOR);
		contentPanel.add(panel);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command  = e.getActionCommand();
		if(command.equals("USER"))
		{
			RegistrationUser registrationUser = new RegistrationUser(this);
			registrationUser.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}else
		{
			RegistrationOrganization registrationOrganization = new RegistrationOrganization(this);
			registrationOrganization.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}
	}
	
	public MainPanel getMainPanel()
	{
		return mainPanel;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		mainPanel.mainWindowsVisible(true);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
