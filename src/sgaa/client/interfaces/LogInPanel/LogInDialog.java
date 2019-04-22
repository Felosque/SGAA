package sgaa.client.interfaces.LogInPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgaa.client.estructures.OrganizationSession;
import sgaa.client.estructures.ServicesStructures;
import sgaa.client.estructures.UserSession;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainPanel;
import sgaa.server.dto.OrganizationDTO;
import sgaa.server.dto.UserDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LogInDialog extends JDialog implements ActionListener, WindowListener{
	private JTextField tbxCorreo;
	private JPasswordField tbxContrasena;
	
	public static final String USER = "usuario";
	public static final String ORGANIZATION = "organizacion";

	private LogInOption logInOption;
	private String statusLogin;

	/**
	 * Create the dialog.
	 */
	public LogInDialog(LogInOption pMainPanel, String pEstado) {
		statusLogin  = pEstado;
		logInOption = pMainPanel;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Colors.SECONDARY_COLOR);
		addWindowListener(this);
		setLocationRelativeTo(pMainPanel);
		
		JLabel lblLoguearseEnSgaa = new JLabel("Loguearse en SGAA");
		lblLoguearseEnSgaa.setBounds(116, 11, 200, 22);
		lblLoguearseEnSgaa.setForeground(Colors.COLOR_WHITE);
		lblLoguearseEnSgaa.setFont(Fonts.FONT_TITLE_0);
		getContentPane().add(lblLoguearseEnSgaa);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Arial", Font.BOLD, 15));
		lblCorreo.setBounds(-11, 87, 160, 26);
		getContentPane().add(lblCorreo);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		lblContrasea.setBounds(-11, 124, 160, 26);
		getContentPane().add(lblContrasea);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(167, 186, 105, 38);
		btnEntrar.setActionCommand("ENTRAR");
		btnEntrar.addActionListener(this);
		getContentPane().add(btnEntrar);
		
		tbxCorreo = new JTextField();
		tbxCorreo.setColumns(10);
		tbxCorreo.setBounds(159, 91, 208, 20);
		getContentPane().add(tbxCorreo);
		
		tbxContrasena = new JPasswordField();
		tbxContrasena.setBounds(159, 128, 208, 20);
		getContentPane().add(tbxContrasena);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 46);
		panel.setBackground(Colors.PRIMARY_COLOR);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Nota: est\u00E1s accediendo a nuestra aplicaci\u00F3n como " + pEstado);
		lblNewLabel.setBounds(0, 247, 434, 14);
		getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("ENTRAR")) {
			
			
			if(statusLogin.equals(USER))
			{
				UserDTO userDto = logInOption.getMainPanel().getMainWindows().getGeneralController().getUser()
									.findById(tbxCorreo.getText());
				if(userDto != null)
				{
					if(ServicesStructures.comparePassword(userDto.getPassword(), ServicesStructures.viewPassword(tbxContrasena.getPassword()))) {
						UserSession session = new UserSession(userDto);
						logInOption.getMainPanel().getMainWindows().activateSessionUser(session);
						logInOption.getMainPanel().mainWindowsVisible(true);
						this.dispose();
					}else
					{
						JOptionPane.showMessageDialog(this, "Usuario o contraseña no encontrado en la base de datos.");
					}
				}else
				{
					JOptionPane.showMessageDialog(this, "\t\t¡Ese correo no existe en nuestra base de datos!\n¡Recuerda que nunca es tarde para registrarse!");
				}
			}else if (statusLogin.equals(ORGANIZATION))
			{
				OrganizationDTO orgDto = logInOption.getMainPanel().getMainWindows().getGeneralController().getOrganization()
										.findById(tbxCorreo.getText());
				if(ServicesStructures.comparePassword(orgDto.getPassword(), ServicesStructures.viewPassword(tbxContrasena.getPassword()))) {
					OrganizationSession session = new OrganizationSession(orgDto);
					logInOption.getMainPanel().getMainWindows().activateSessionOrganization(session);
					logInOption.getMainPanel().mainWindowsVisible(true);
					this.dispose();
				}else
				{
					JOptionPane.showMessageDialog(this, "Usuario o contraseña no encontrado en la base de datos.");
				}
			}
			
		}
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		logInOption.getMainPanel().mainWindowsVisible(true);
		this.dispose();
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
