package sgaa.client.interfaces.OrganizationOptions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import sgaa.client.estructures.ServicesStructures;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.BreedDTO;
import sgaa.server.dto.PetDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class DialogPetOptions extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();

	private JPanel imagePanel;
	private JLabel picture;
	private JTextField tbxName;
	private JTextField tbxColor;
	private JTextField tbxAddress;
	private JTextArea tbxDescription;
	
	private JCheckBox cbAdoption;
	
	private JButton btnAction, btnConfirm, btnBack;
	
	private JComboBox<String> cbSpecies;
	
	private JSpinner spDia, spMes, spAno;

	private MainWindows mainWindows;
	private PetDTO pet;
	private String status;

	/**
	 * Create the dialog.
	 */
	public DialogPetOptions(MainWindows pMainWindows, PetDTO pPet, String pStatus) {
		mainWindows = pMainWindows;
		pet = pPet;
		status = pStatus;
		setBounds(100, 100, 685, 513);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Colors.COLOR_GREEN1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 685, 44);
		panel.setBackground(Colors.PRIMARY_COLOR);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblMascotaId = new JLabel("MASCOTA ID: " + pet.getId());
		lblMascotaId.setBounds(0, 0, 685, 44);
		lblMascotaId.setForeground(Colors.COLOR_WHITE);
		panel.add(lblMascotaId);
		lblMascotaId.setHorizontalAlignment(SwingConstants.CENTER);
		lblMascotaId.setFont(Fonts.FONT_TITLE_0);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 142, 174, 174);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		Image img = new ImageIcon("img/pet_default.png").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		
		imagePanel = new JPanel();
		imagePanel.setBounds(45, 290, 200, 200);
		panel_1.add(imagePanel);
		picture = new JLabel();
		picture.setIcon(img2);
		imagePanel.setLayout(new FlowLayout());
		imagePanel.add(picture);	
		imagePanel.setBackground(Colors.SECONDARY_COLOR);
		
		JLabel label = new JLabel("Nombre:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Colors.COLOR_GREENBLACK);
		label.setFont(Fonts.FONT_BODY_BLOD_1);
		label.setBounds(208, 66, 190, 26);
		contentPanel.add(label);
		
		tbxName = new JTextField();
		tbxName.setEditable(false);
		tbxName.setText("default");
		tbxName.setColumns(10);
		tbxName.setBounds(416, 70, 242, 20);
		contentPanel.add(tbxName);
		
		JLabel label_1 = new JLabel("Color:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Colors.COLOR_GREENBLACK);
		label_1.setFont(Fonts.FONT_BODY_BLOD_1);
		label_1.setBounds(237, 105, 160, 26);
		contentPanel.add(label_1);
		
		tbxColor = new JTextField();
		tbxColor.setEditable(false);
		tbxColor.setText("default");
		tbxColor.setColumns(10);
		tbxColor.setBounds(416, 108, 242, 20);
		contentPanel.add(tbxColor);
		
		JLabel label_2 = new JLabel("Dirección de casa:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Colors.COLOR_GREENBLACK);
		label_2.setFont(Fonts.FONT_BODY_BLOD_1);
		label_2.setBounds(241, 142, 160, 26);
		contentPanel.add(label_2);
		
		tbxAddress = new JTextField();
		tbxAddress.setEditable(false);
		tbxAddress.setText("default");
		tbxAddress.setColumns(10);
		tbxAddress.setBounds(416, 146, 242, 20);
		contentPanel.add(tbxAddress);
		
		JLabel label_3 = new JLabel("Fecha de nacimiento:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Colors.COLOR_GREENBLACK);
		label_3.setFont(Fonts.FONT_BODY_BLOD_1);
		label_3.setBounds(195, 180, 203, 26);
		contentPanel.add(label_3);
		
		
		String[] monthStrings = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}; //get month names
		
		SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
		spMes = new JSpinner(monthModel);
		spMes.setBounds(426, 177, 101, 22);
		spMes.setEnabled(false);
		contentPanel.add(spMes);
		
		SpinnerModel day = new SpinnerNumberModel(1, 1, 31, 1);
		spDia = new JSpinner(day);
		spDia.setBounds(543, 178, 41, 20);
		spDia.setEnabled(false);
		contentPanel.add(spDia);
		
		SpinnerModel year = new SpinnerNumberModel(2019, 2019 - 100, 2019, 1);
		spAno = new JSpinner(year);
		spAno.setEnabled(false);
		spAno.setBounds(596, 178, 66, 20);
		contentPanel.add(spAno);
		
		JLabel label_4 = new JLabel("Mes");
		label_4.setBounds(448, 199, 41, 15);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("Día");
		label_5.setBounds(559, 199, 41, 15);
		contentPanel.add(label_5);
		
		JLabel label_6 = new JLabel("Año");
		label_6.setBounds(632, 199, 41, 15);
		contentPanel.add(label_6);
		
		JLabel label_7 = new JLabel("Descripción:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Colors.COLOR_GREENBLACK);
		label_7.setFont(Fonts.FONT_BODY_BLOD_1);
		label_7.setBounds(195, 274, 203, 26);
		contentPanel.add(label_7);
		
		JLabel label_8 = new JLabel("Raza y especie:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Colors.COLOR_GREENBLACK);
		label_8.setFont(Fonts.FONT_BODY_BLOD_1);
		label_8.setBounds(195, 231, 203, 26);
		contentPanel.add(label_8);
		
		IStackArray<BreedDTO> species = new IStackArray<BreedDTO>();
		species = pMainWindows.getGeneralController().getBreed().findAll();
		
		cbSpecies = new JComboBox();
		cbSpecies.setEnabled(false);
		cbSpecies.setBounds(416, 232, 246, 24);
		cbSpecies.addActionListener(this);
		cbSpecies.setActionCommand("SPECIES");
		for(int i = 0; i < species.size(); i++)
		{
			cbSpecies.addItem(species.get(i).getBreed());
		}
		contentPanel.add(cbSpecies);
		
		tbxDescription = new JTextArea();
		tbxDescription.setEnabled(false);
		tbxDescription.setLineWrap(true);
		tbxDescription.setWrapStyleWord(true);
		tbxDescription.setText("default");
		tbxDescription.setBounds(416, 274, 237, 106);
		contentPanel.add(tbxDescription);
		
		btnAction = new JButton("ACTION");
		btnAction.setBounds(195, 437, 276, 36);
		btnAction.setActionCommand("ACTION");
		btnAction.addActionListener(this);
		btnAction.setVisible(false);
		contentPanel.add(btnAction);
		
		
		btnConfirm = new JButton("Aceptar");
		btnConfirm.setBounds(337, 433, 190, 44);
		btnConfirm.setForeground(Colors.PRIMARY_COLOR);
		btnConfirm.setActionCommand("CONFIRM");
		btnConfirm.addActionListener(this);
		btnConfirm.setVisible(false);
		contentPanel.add(btnConfirm);
		
		btnBack = new JButton("Cancelar");
		btnBack.setBounds(135, 433, 190, 44);
		btnBack.setForeground(Color.RED);
		btnBack.setActionCommand("BACK");
		btnBack.addActionListener(this);
		btnBack.setVisible(false);
		contentPanel.add(btnBack);
		
		cbAdoption = new JCheckBox("Está en adopción.");
		cbAdoption.setBackground(Colors.COLOR_GREEN1);
		cbAdoption.setBounds(416, 385, 242, 23);
		
		contentPanel.add(cbAdoption);
		
		configureBottons();
		setInfoPet();
		
	}
	
	private void setInfoPet()
	{
		tbxAddress.setText(pet.getAddress());
		tbxColor.setText(pet.getColor());
		tbxDescription.setText(pet.getDescription());
		tbxName.setText(pet.getName());
		cbSpecies.setSelectedIndex(pet.getBreed());
		spMes.setValue(ServicesStructures.getMonthText(pet.getBirthdate().getMonth()));
		spDia.setValue(pet.getBirthdate().getDay());
		spAno.setValue(pet.getBirthdate().getYear() + 1900);
		cbAdoption.setSelected(pet.isState());
	}
	
	private void hideBottons(boolean state)
	{
		if(state == true)
		{
			btnBack.setVisible(false);
			btnConfirm.setVisible(false);
			btnAction.setVisible(true);
		}else
		{
			btnBack.setVisible(true);
			btnConfirm.setVisible(true);
			btnAction.setVisible(false);
		}
	}
	
	private void editPropertiesStatus(boolean status)
	{
		if(status == true)
		{
			tbxAddress.setEditable(true);
			tbxColor.setEditable(true);
			tbxName.setEditable(true);
			cbSpecies.setEnabled(true);
			tbxDescription.setEnabled(true);
			spAno.setEnabled(true);
			spDia.setEnabled(true);
			spMes.setEnabled(true);
		}else
		{
			tbxAddress.setEditable(false);
			tbxColor.setEditable(false);
			tbxName.setEditable(false);
			cbSpecies.setEnabled(false);
			tbxDescription.setEnabled(false);
			spAno.setEnabled(false);
			spDia.setEnabled(false);
			spMes.setEnabled(false);
		}
	}
	
	private void configureBottons()
	{
		if(status.equals(DialogSearchPetID.DIALOG_DELETE))
		{
			btnAction.setText("ELIMINAR MASCOTA");
			btnConfirm.setText("Confirmar Eliminar");
			btnAction.setVisible(true);
			
		}else if(status.equals(DialogSearchPetID.DIALOG_EDIT))
		{
			btnAction.setText("EDITAR MASCOTA");
			btnConfirm.setText("Confirmar Editar");
			btnAction.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("ACTION"))
		{
			hideBottons(false);
			if(status.equals(DialogSearchPetID.DIALOG_EDIT))
			{
				JOptionPane.showMessageDialog(this, "¡Ya puede comenzar a editar la mascota!\n\nLuego de editarla de a confirmar o cancelar");
				editPropertiesStatus(true);
			}
		}
		else if(command.equals("BACK"))
		{
			hideBottons(true);
			if(status.equals(DialogSearchPetID.DIALOG_EDIT))
			{
				editPropertiesStatus(false);
				setInfoPet();
			}
			
		}
		else if(command.equals("CONFIRM"))
		{
			if(status.equals(DialogSearchPetID.DIALOG_DELETE))
			{
				boolean statusSQL = mainWindows.getGeneralController().getPet().delete(pet.getId());
				if(statusSQL == true)
				{
					this.setVisible(false);
					mainWindows.repaintPetsList();
					JOptionPane.showMessageDialog(mainWindows, "¡Se ha eliminado la mascota con ID: " + pet.getId());
					this.dispose();
				}else
				{
					JOptionPane.showMessageDialog(this, "¡Hubo un error al eliminar la mascota con ID: " + pet.getId());
				}
			}
			else if(status.equals(DialogSearchPetID.DIALOG_EDIT))
			{
				Calendar fechaActual = Calendar.getInstance();
				fechaActual.set((int)spAno.getValue() +1, ServicesStructures.getMonthNumber(spMes.getValue().toString()), ((int)spDia.getValue()));
				Date dateU = fechaActual.getTime();
				
				boolean statusSQL = mainWindows.getGeneralController().getPet().
								update(pet.getId(), tbxName.getText(), tbxColor.getText(), 
								tbxAddress.getText(), dateU, cbAdoption.isSelected(), cbSpecies.getSelectedIndex(), 
								mainWindows.getOrgSession().getMail(), "Aquí va el path", tbxDescription.getText());
				
				if(statusSQL == true)
				{
					this.setVisible(false);
					mainWindows.repaintPetsList();
					JOptionPane.showMessageDialog(mainWindows, "¡Se ha modificado la mascota con ID: " + pet.getId());
					this.dispose();
				}else
				{
					JOptionPane.showMessageDialog(mainWindows, "¡Vaya! Hemos tenido un error al modificar esta mascota" + pet.getId());
				}
			}
			
		}
		
	}
}
