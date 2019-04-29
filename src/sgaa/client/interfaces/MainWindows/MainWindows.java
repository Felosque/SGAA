package sgaa.client.interfaces.MainWindows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.nio.channels.SeekableByteChannel;
import java.util.Date;

import sgaa.client.estructures.GeneralController;
import sgaa.client.estructures.InfoPagePet;
import sgaa.client.estructures.OrganizationSession;
import sgaa.client.estructures.UserSession;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.OrganizationOptions.MainPanelOrganizationOptions;
import sgaa.client.interfaces.OrganizationOptions.PanelPetsListOrganization;
import sgaa.client.interfaces.RegistrationPanel.RegistrationDialog;
import sgaa.client.interfaces.SearchScrollPets.*;
import sgaa.client.interfaces.UserOptions.MainPanelOptionsUser;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.OrganizationDTO;
import sgaa.server.dto.PetDTO;
import sgaa.server.dto.UserDTO;
import sgga.client.interfaces.SearchScrollOrganization.PanelViewOrganizations;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindows extends JFrame {

	//Paneles principales de la aplicación
	private TitlePanel titlePanel;
	
	private MainPanel mainPanel;
	
	//Paneles de las mascotas
	private PanelViewPets mainPanelPets;
	
	private MainPanelOptionsUser mainPanelOptionUser;
	
	//Paneles de organizacion
	private PanelOrganization panelOrganization;
	
	private PanelPetsListOrganization panelPetsListOrganization;
	
	private PanelViewOrganizations mainPanelOrganizations;
	
	private MainPanelOrganizationOptions mainPanelOrganizationOptions;
	
	//Sesiones de usuarios o organizaciones
	
	private UserSession userSession;
	
	private OrganizationSession orgSession;
	
	//Controlador general de la aplicación
	
	private GeneralController<GeneralController> generalController;
	
	
	public MainWindows() {
		
		generalController = new GeneralController<GeneralController>();
		setBackground(Colors.COLOR_WHITE_1);
		
		titlePanel = new TitlePanel();
		add(titlePanel, BorderLayout.NORTH);
		
		mainPanel = new MainPanel(this);
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.setVisible(true);

		
		userSession = null;
		orgSession = null;

	}
	
	public GeneralController<GeneralController> getGeneralController() {
		return generalController;
	}
	
	public UserSession getUserSession()
	{
		return userSession;
	}
	
	public OrganizationSession getOrgSession()
	{
		return orgSession;
	}
	
	public void activateSessionUser(UserSession pUserSession)
	{
		userSession = pUserSession;
		mainPanel.setVisible(false);
		
		//Se crea el array de las organizaciones a mostrar
		IStackArray<OrganizationDTO> organizations = new IStackArray<OrganizationDTO>();
		organizations = generalController.getOrganization().findAll();
		mainPanelOrganizations = new PanelViewOrganizations(organizations, this);
		add(mainPanelOrganizations, BorderLayout.CENTER);
		
		mainPanelOptionUser = new MainPanelOptionsUser(this);
		add(mainPanelOptionUser, BorderLayout.SOUTH);
		
	}
	
	public void activateSessionOrganization(OrganizationSession pOrgSession)
	{
		orgSession = pOrgSession;
		mainPanel.setVisible(false);
		
		panelPetsListOrganization = new PanelPetsListOrganization(this);
		add(panelPetsListOrganization, BorderLayout.CENTER);
		
		mainPanelOrganizationOptions = new MainPanelOrganizationOptions(this);
		add(mainPanelOrganizationOptions, BorderLayout.SOUTH);
	}
	
	public void closeSessionUser()
	{
		userSession = null;
		orgSession = null;
		mainPanelOptionUser.setVisible(false);
		mainPanelOptionUser = null;
		mainPanelOrganizations.setVisible(false);
		if(panelOrganization != null)
		{
			panelOrganization.setVisible(false);
			panelOrganization = null;
			
			mainPanelPets.setVisible(false);
			mainPanelPets = null;
		}
		mainPanel.setVisible(true);
	}
	
	public void closeSessionOrganization()
	{
		userSession = null;
		orgSession = null;
		panelPetsListOrganization.setVisible(false);
		panelPetsListOrganization = null;
		mainPanelOrganizationOptions.setVisible(false);
		mainPanelOrganizationOptions = null;
		
		this.setVisible(true);
		mainPanel.setVisible(true);
	}
	
	public void openOrganizationPage(String pOrganization)
	{
		mainPanelOrganizations.setVisible(false);
		
		panelOrganization = new PanelOrganization(this, generalController.getOrganization().findById(pOrganization));
		add(panelOrganization, BorderLayout.WEST);
		panelOrganization.setVisible(true);
		
		IStackArray<PetDTO> pets = new IStackArray<PetDTO>();
		pets = generalController.getPet().findAll(pOrganization);
		mainPanelPets = new PanelViewPets(pets);
		add(mainPanelPets, BorderLayout.CENTER);
	}
	
	public void closeOrganizationPage()
	{
		panelOrganization.setVisible(false);
		panelOrganization = null;
		mainPanelPets.setVisible(false);
		mainPanelPets = null;
		mainPanelOrganizations.setVisible(true);
	}
	
	public void repaintPetsList()
	{
		panelPetsListOrganization.setVisible(false);
		panelPetsListOrganization = null;
		panelPetsListOrganization = new PanelPetsListOrganization(this);
		add(panelPetsListOrganization, BorderLayout.CENTER);
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
