package sgaa.client.interfaces.OrganizationOptions;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.MainWindows.MainWindows;

public class MainPanelOrganizationOptions extends JPanel implements ActionListener {

	private MainWindows mainWindows;
	
	private JButton btnEditPet, btnDeletePet, btnAddPet, btnChosePet, btnInfoOrg, btnConfig;
	
	private static String EDIT_PET = "EditPet";
	private static String DELETE_PET = "DeltePet";
	private static String ADD_PET = "AddPet";
	private static String CHOSE_PET = "ChosePet";
	private static String INFO_ORG = "Infoorg";
	private static String CONFIG = "Config";
	
	public MainPanelOrganizationOptions(MainWindows pMainWindows)
	{
		mainWindows = pMainWindows;
		setLayout(new GridLayout(3, 2));
		TitledBorder titlePanel = new TitledBorder("Opciones de administración");
		titlePanel.setTitleColor(Colors.COLOR_WHITE);
		setBorder(titlePanel);
		setBackground(Colors.PRIMARY_COLOR);
		
		btnEditPet = new JButton("Editar Mascota");
		btnEditPet.addActionListener(this);
		btnEditPet.setActionCommand(EDIT_PET);
		add(btnEditPet);
		
		btnDeletePet = new JButton("Eliminar Mascota");
		btnDeletePet.addActionListener(this);
		btnDeletePet.setActionCommand(DELETE_PET);
		add(btnDeletePet);
		
		btnAddPet = new JButton("Añadir Mascota");
		btnAddPet.setActionCommand(ADD_PET);
		btnAddPet.addActionListener(this);
		add(btnAddPet);
		
		btnChosePet = new JButton("Buscar Mascota");
		btnChosePet.setActionCommand(CHOSE_PET);
		add(btnChosePet);
		
		btnInfoOrg = new JButton("Información de la fundación");
		btnInfoOrg.setActionCommand(INFO_ORG);
		btnInfoOrg.addActionListener(this);
		add(btnInfoOrg);
		
		btnConfig = new JButton("Configuración");
		btnConfig.setActionCommand(CONFIG);
		btnConfig.addActionListener(this);
		add(btnConfig);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals(EDIT_PET))
		{
			
		}else if(command.equals(DELETE_PET))
		{
			
		}else if(command.equals(ADD_PET))
		{
			DialogAddPet dialogAddPet = new DialogAddPet(mainWindows);
			dialogAddPet.setVisible(true);
			dialogAddPet.setModal(true);
			
		}else if(command.equals(CHOSE_PET))
		{
			
		}else if(command.equals(INFO_ORG))
		{
			
		}else if(command.equals(CONFIG))
		{
			int dialogResult = JOptionPane.showConfirmDialog(mainWindows, "¿Seguro que quieres cerrar sesión?");
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				mainWindows.closeSessionOrganization();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
