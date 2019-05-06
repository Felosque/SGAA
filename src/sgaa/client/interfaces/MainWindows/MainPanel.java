package sgaa.client.interfaces.MainWindows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.LogInPanel.LogInOption;
import sgaa.client.interfaces.RegistrationPanel.RegistrationDialog;

public class MainPanel extends JPanel implements ActionListener{

	
	private JButton btnLogUp;
	private JButton btnLogIn;
	private JButton btnCredits;
	
	private MainWindows mainWindows;
	
	private RegistrationDialog registrationDialog;
	
	private LogInOption logInOption;
	
	public MainPanel(MainWindows pWindow) {
		
		mainWindows =  pWindow;
		setLayout(new GridLayout(3, 1));
		setBackground(Colors.SECONDARY_COLOR);
		
		registrationDialog = new RegistrationDialog(this);
		logInOption = new LogInOption(this);
		
		JLabel info = new JLabel("¡Bienvenido al sistema de gestión de animales en adopción!");
		info.setFont(Fonts.MAIN_FONT_BODY);
		info.setForeground(Colors.COLOR_WHITE);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setVerticalAlignment(JLabel.CENTER);
		add(info);
		
		JPanel panelBottons01 = new JPanel();
		panelBottons01.setLayout(new GridLayout(1,3));
		panelBottons01.setBackground(Colors.SECONDARY_COLOR);
		add(panelBottons01);
		
		panelBottons01.add(new JLabel(""));
		JPanel panelBottons02 = new JPanel();
		panelBottons02.setLayout(new GridLayout(5, 1));
		panelBottons02.setBackground(Colors.SECONDARY_COLOR);
		
		btnLogUp = new JButton("Registrarse");
		btnLogUp.addActionListener(this);
		btnLogUp.setActionCommand("REGISTRATION");
		panelBottons02.add(btnLogUp);
		panelBottons02.add(new JLabel(""));
		
		btnLogIn = new JButton("Ingresar");
		btnLogIn.addActionListener(this);
		btnLogIn.setActionCommand("LOGIN");
		panelBottons02.add(btnLogIn);
		panelBottons02.add(new JLabel(""));
		
		btnCredits = new JButton("Creditos");
		btnCredits.setActionCommand("CREDITS");
		btnCredits.addActionListener(this);
		panelBottons02.add(btnCredits);
		
		panelBottons01.add(panelBottons02);	
		panelBottons01.add(new JLabel(""));
		add(new JLabel(""));
	
	}

	public void mainWindowsVisible(boolean pStatus)
	{
		if(pStatus) {
			mainWindows.setVisible(true);
		}else
		{
			mainWindows.setVisible(false);
		}
	}
	
	public MainWindows getMainWindows()
	{
		return mainWindows;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("REGISTRATION"))
		{
			mainWindowsVisible(false);
			registrationDialog.setVisible(true);
		}else if(command.equals("LOGIN"))
		{
			mainWindowsVisible(false);
			logInOption.setVisible(true);
		}else if(command.equals("CREDITS"))
		{
			JOptionPane.showMessageDialog(mainWindows,
					"\t© Sistema de Gestion de Animales en Adopción (SGAA - 2019) © \n\n"
					+"- Ezequiel Melo Bustos                          \tCodigo:\t (2220171073)\n"
					+"- Luis Felipe Londoño Medina               \tCodigo:\t (2220171044)\n"
					+"- Richard Javier Zamora Herrera            \tCodigo:\t (2220171018)\n", "CREDITOS", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
