package sgaa.client.interfaces.MainWindows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.nio.channels.SeekableByteChannel;
import java.util.Date;

import sgaa.client.estructures.GeneralController;
import sgaa.client.estructures.InfoPagePet;
import sgaa.client.estructures.UserSession;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.RegistrationPanel.RegistrationDialog;
import sgaa.client.interfaces.SearchScrollPets.*;
import sgaa.client.interfaces.UserOptions.MainPanelOptionsUser;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.OrganizationDTO;
import sgaa.server.dto.PetDTO;
import sgaa.server.dto.UserDTO;
import sgga.client.interfaces.SearchScrollOrganization.MainPanelOrganizations;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindows extends JFrame {

	private TitlePanel titlePanel;
	
	private MainPanel mainPanel;
	
	private MainPanelPets mainPanelPets;
	
	private PanelOrganization panelOrganization;
	
	private UserSession userSession;
	
	private MainPanelOrganizations mainPanelOrganizations;
	
	private GeneralController<GeneralController> generalController = new GeneralController<GeneralController>();
	
	public MainWindows() {
		
		setBackground(Colors.COLOR_WHITE_1);
		
		titlePanel = new TitlePanel();
		add(titlePanel, BorderLayout.NORTH);

		panelOrganization = new PanelOrganization();
		add(panelOrganization, BorderLayout.WEST);
		panelOrganization.setVisible(false);
		
		mainPanel = new MainPanel(this);
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.setVisible(true);
		
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
		mainPanel.setVisible(false);
		
		//Se crea el array de las organizaciones a mostrar
		IStackArray<OrganizationDTO> organizations = new IStackArray<OrganizationDTO>();
		organizations = generalController.getOrganization().findAll();
		mainPanelOrganizations = new MainPanelOrganizations(organizations, this);
		add(mainPanelOrganizations, BorderLayout.CENTER);
		
		MainPanelOptionsUser mainPanelOptionUser = new MainPanelOptionsUser(this);
		add(mainPanelOptionUser, BorderLayout.SOUTH);
		
	}
	
	public void openOrganizationPage(String pOrganization)
	{
		mainPanelOrganizations.setVisible(false);
		
		panelOrganization.setVisible(true);	
		IStackArray<PetDTO> pets = new IStackArray<PetDTO>();
		pets = generalController.getPet().findAll(pOrganization);
		
		mainPanelPets = new MainPanelPets(pets);
		add(mainPanelPets, BorderLayout.CENTER);
	}
	
	public void closeOrganizationPage()
	{
		
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
