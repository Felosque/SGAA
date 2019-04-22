package sgaa.client.interfaces.UserOptions;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;

public class MainPanelOptionsUser extends JPanel implements ActionListener{
	
	private MainWindows mainWindows;
	
	private JButton btnMyPets, btnConfig, btnChosePets, btnCloseSession, btnOpt1, btnOpt2;
	
	private static final String MY_PETS = "MyPets";
	private static final String CONFIG = "Config";
	private static final String CHOOSE_PETS = "ChosePets";
	private static final String CLOSE_SESSION = "CloseSession";
	private static final String OPT_1 = "Opt1";
	private static final String OPT_2 = "Opt2";
	
	public MainPanelOptionsUser(MainWindows pMainWindows) {
		mainWindows = pMainWindows;
		setLayout(new GridLayout(1, 2));
		TitledBorder titlePanel = new TitledBorder("Panel de usuario");
		titlePanel.setTitleColor(Colors.COLOR_WHITE);
		setBorder(titlePanel);
		setBackground(Colors.PRIMARY_COLOR);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(Colors.PRIMARY_COLOR);
		add(panelEast);
		
		panelEast.setLayout(new GridLayout(3, 2));
		
		JLabel iName = new JLabel("Nombre: ");
		iName.setHorizontalAlignment(JLabel.RIGHT);
		iName.setForeground(Colors.COLOR_WHITE);
		iName.setFont(Fonts.FONT_BODY_BLOD_1);
		panelEast.add(iName);
		
		JLabel name = new JLabel(mainWindows.getUserSession().getName());
		name.setForeground(Colors.COLOR_WHITE);
		name.setFont(Fonts.FONT_BODY_1);
		panelEast.add(name);
		
		JLabel iDirection  = new JLabel("Dirección: ");
		iDirection.setHorizontalAlignment(JLabel.RIGHT);
		iDirection.setForeground(Colors.COLOR_WHITE);
		iDirection.setFont(Fonts.FONT_BODY_BLOD_1);
		panelEast.add(iDirection);
		
		JLabel direction = new JLabel(mainWindows.getUserSession().getHouse());
		direction.setForeground(Colors.COLOR_WHITE);
		direction.setFont(Fonts.FONT_BODY_1);
		panelEast.add(direction);
		
		JLabel iBirthDay = new JLabel("Fecha de nacimiento: ");
		iBirthDay.setHorizontalAlignment(JLabel.RIGHT);
		iBirthDay.setFont(Fonts.FONT_BODY_BLOD_1);
		iBirthDay.setForeground(Colors.COLOR_WHITE);
		panelEast.add(iBirthDay);
		
		JLabel birthDate = new JLabel(mainWindows.getUserSession().getBirthDate().toString());
		birthDate.setForeground(Colors.COLOR_WHITE);
		birthDate.setFont(Fonts.FONT_BODY_1);
		panelEast.add(birthDate);
		
		JPanel panelWest = new JPanel();
		panelWest.setLayout(new GridLayout(3, 2));
		panelWest.setBackground(Colors.PRIMARY_COLOR);
		
		btnMyPets = new JButton("Mis mascotas");
		btnMyPets.setActionCommand(MY_PETS);
		btnMyPets.addActionListener(this);
		panelWest.add(btnMyPets);
		
		btnConfig = new JButton("Configuración");
		btnConfig.setActionCommand(CONFIG);
		btnConfig.addActionListener(this);
		panelWest.add(btnConfig);
		
		btnChosePets = new JButton("Buscar mascota");
		btnChosePets.setActionCommand(CHOOSE_PETS);
		btnChosePets.addActionListener(this);
		panelWest.add(btnChosePets);
		
		btnCloseSession = new JButton("Cerrar sección");
		btnCloseSession.setActionCommand(CLOSE_SESSION);
		btnCloseSession.addActionListener(this);
		panelWest.add(btnCloseSession);
		
		btnOpt1 = new JButton("Opción 1");
		btnOpt1.setActionCommand(OPT_1);
		btnOpt1.addActionListener(this);
		panelWest.add(btnOpt1);
		
		btnOpt2 = new JButton("Opción 2");
		btnOpt2.setActionCommand(OPT_2);
		btnOpt2.addActionListener(this);
		panelWest.add(btnOpt2);
		
		add(panelWest);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals(MY_PETS))
		{
			
		}else if(command.equals(CONFIG))
		{
			
		}else if(command.equals(CHOOSE_PETS))
		{
			
		}else if(command.equals(CLOSE_SESSION))
		{
			int dialogResult = JOptionPane.showConfirmDialog(mainWindows, "¿Seguro que quieres cerrar sesión?");
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				mainWindows.closeSessionUser();
			}	
		}else if(command.equals(OPT_1))
		{
			
		}else if(command.equals(OPT_2))
		{
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
