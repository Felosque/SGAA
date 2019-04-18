package sgaa.client.interfaces.LogInPanel;

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

public class LogInOption extends JDialog implements ActionListener, WindowListener{

	private final JPanel contentPanel = new JPanel();

	private MainPanel mainPanel;

	/**
	 * Create the dialog.
	 */
	public LogInOption(MainPanel pMainPanel) {
		
		mainPanel = pMainPanel;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Colors.SECONDARY_COLOR);
		addWindowListener(this);
		setLocationRelativeTo(pMainPanel);
		
		JLabel lblLoginSgaa = new JLabel("LOGIN SGAA");
		lblLoginSgaa.setBounds(153, 11, 143, 24);
		lblLoginSgaa.setForeground(Colors.COLOR_WHITE);
		lblLoginSgaa.setFont(Fonts.FONT_TITLE_0);
		contentPanel.add(lblLoginSgaa);
		
		JButton btnUser = new JButton("Soy un usuario");
		btnUser.setActionCommand("USER");
		btnUser.addActionListener(this);
		btnUser.setBounds(92, 125, 255, 32);
		contentPanel.add(btnUser);
		
		JButton btnOrganization = new JButton("Soy una organizaci\u00F3n");
		btnOrganization.setBounds(92, 168, 255, 32);
		btnOrganization.setActionCommand("ORGANIZATION");
		btnOrganization.addActionListener(this);
		contentPanel.add(btnOrganization);
		
		JLabel lblcmoQuieresLoguearte = new JLabel("\u00BFC\u00F3mo quieres loguearte en SGAA?");
		lblcmoQuieresLoguearte.setBounds(70, 69, 300, 24);
		lblcmoQuieresLoguearte.setForeground(Colors.COLOR_WHITE);
		lblcmoQuieresLoguearte.setFont(Fonts.FONT_BODY_BLOD_1);
		contentPanel.add(lblcmoQuieresLoguearte);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 457, 46);
		panel.setBackground(Colors.PRIMARY_COLOR);
		contentPanel.add(panel);
	}

	public MainPanel getMainPanel()
	{
		return mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("USER"))
		{
			LogInDialog logInDialog = new LogInDialog(this, LogInDialog.USER);
			logInDialog.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("ORGANIZATION"))
		{
			LogInDialog logInDialog = new LogInDialog(this, LogInDialog.ORGANIZATION);
			logInDialog.setVisible(true);
			this.dispose();
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
		mainPanel.mainWindowsVisible(true);
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
