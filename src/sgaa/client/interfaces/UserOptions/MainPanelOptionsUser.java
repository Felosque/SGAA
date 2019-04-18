package sgaa.client.interfaces.UserOptions;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import sgaa.client.estructures.UserSession;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;

public class MainPanelOptionsUser extends JPanel {
	
	private MainWindows mainWindows;
	
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
		
		panelWest.add(new JButton("Mis mascotas"));
		panelWest.add(new JButton("Configuración"));
		panelWest.add(new JButton("Buscar mascota"));
		panelWest.add(new JButton("Cerrar sección"));
		panelWest.add(new JButton("Opción 1"));
		panelWest.add(new JButton("Opción 2"));
		
		add(panelWest);
		
		
		
	}
	
}
