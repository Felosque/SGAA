package sgaa.client.interfaces.MainWindows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.nio.channels.SeekableByteChannel;

import sgaa.client.estructures.GeneralController;
import sgaa.client.estructures.InfoPagePet;
import sgaa.client.estructures.UserSession;
import sgaa.client.interfaces.RegistrationPanel.RegistrationDialog;
import sgaa.client.interfaces.SearchScrollPets.*;
import sgaa.client.interfaces.UserOptions.MainPanelOptionsUser;

import javax.swing.JFrame;

public class MainWindows extends JFrame {

	private TitlePanel titlePanel;
	
	private MainPanel mainPanel;
	
	private MainPanelPets mainPanelPets;
	
	private PanelOrganization panelOrganization;
	
	private UserSession userSession;
	
	private GeneralController<GeneralController> generalController = new GeneralController<GeneralController>();
	
	public MainWindows() {
		
		titlePanel = new TitlePanel();
		add(titlePanel, BorderLayout.NORTH);
		
		
		panelOrganization = new PanelOrganization();
		add(panelOrganization, BorderLayout.WEST);
		panelOrganization.setVisible(false);
		
		mainPanel = new MainPanel(this);
		add(mainPanel, BorderLayout.CENTER);
		
		userSession = null;
	
	}
	
	public GeneralController<GeneralController> getGeneralController() {
		return generalController;
	}
	
	public UserSession getUserSession()
	{
		return userSession;
	}
	
	public void activateSessionUser(UserSession pUserSession)
	{
		userSession = pUserSession;
		
		InfoPagePet[]  fe = new InfoPagePet[1];
		fe[0] = new InfoPagePet(3, 3, 3, "Rojo", "Firulais", "Calle 9-1", "Es un perrito");
		mainPanelPets = new MainPanelPets(fe);
		add(mainPanelPets, BorderLayout.CENTER);
		
		MainPanelOptionsUser er = new MainPanelOptionsUser(this);
		add(er, BorderLayout.SOUTH);
		
		panelOrganization.setVisible(true);
		mainPanel.setVisible(false);
	}
	
	public static void main(String[] args) {
		
		MainWindows ven = new MainWindows();
		ven.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ven.setLocationRelativeTo(null);
		ven.setVisible(true);
		ven.setResizable(false);
		ven.setSize(new Dimension(1000, 700));

	}

}
