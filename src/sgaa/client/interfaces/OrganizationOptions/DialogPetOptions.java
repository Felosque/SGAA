package sgaa.client.interfaces.OrganizationOptions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;

public class DialogPetOptions extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();

	private JPanel imagePanel;
	private JLabel picture;
	private JTextField tbxName;
	private JTextField tbxColor;
	private JTextField tbxAddress;
	
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
		
		JLabel lblMascotaId = new JLabel("MASCOTA ID: ");
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
		tbxName.setText(pet.getName());
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
		tbxColor.setText(pet.getColor());
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
		tbxAddress.setText(pet.getAddress());
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
		spMes.setValue(ServicesStructures.getMonthText(pet.getBirthdate().getMonth()));
		spMes.setBounds(426, 177, 101, 22);
		contentPanel.add(spMes);
		
		SpinnerModel day = new SpinnerNumberModel(1, 1, 31, 1);
		spDia = new JSpinner(day);
		spDia.setValue(pet.getBirthdate().getDay());
		spDia.setBounds(543, 178, 41, 20);
		contentPanel.add(spDia);
		
		SpinnerModel year = new SpinnerNumberModel(2019, 2019 - 100, 2019, 1);
		spAno = new JSpinner(year);
		spAno.setValue(pet.getBirthdate().getYear());
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
		label_7.setBounds(195, 292, 203, 26);
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
		cbSpecies.setSelectedIndex(pet.getBreed());
		contentPanel.add(cbSpecies);
		
		JTextArea tbxDescription = new JTextArea();
		tbxDescription.setEnabled(false);
		tbxDescription.setText("description");
		tbxDescription.setBounds(425, 298, 237, 106);
		contentPanel.add(tbxDescription);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
