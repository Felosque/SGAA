package sgaa.client.interfaces.OrganizationOptions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgaa.client.estructures.ServicesStructures;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;
import sgaa.server.dto.PetDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class DialogSearchPetID extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();

	private JSpinner spNum;
	private JButton btnViewPet;
	private MainWindows mainWindows;
	private String statusDialog;
	
	public static final String DIALOG_DELETE = "delete";
	public static final String DIALOG_EDIT = "edit";
	public static final String DIALOG_SEARCH = "view";
	
	/**
	 * Create the dialog.
	 */
	public DialogSearchPetID(MainWindows pMainWindows, String pStatus) {
		mainWindows = pMainWindows;
		statusDialog = pStatus;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Colors.SECONDARY_COLOR);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 53);
		panel.setBackground(Colors.PRIMARY_COLOR);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblSgaa = new JLabel("SGAA");
		lblSgaa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSgaa.setBounds(0, 12, 450, 41);
		lblSgaa.setFont(Fonts.FONT_TITLE_1);
		lblSgaa.setForeground(Colors.COLOR_WHITE);
		panel.add(lblSgaa);
		
		JLabel lblantesQueNada = new JLabel("¡Antes que nada debemos encontrar la mascota!");
		lblantesQueNada.setHorizontalAlignment(SwingConstants.CENTER);
		lblantesQueNada.setBounds(0, 77, 450, 15);
		lblantesQueNada.setForeground(Colors.COLOR_WHITE);
		lblantesQueNada.setFont(Fonts.FONT_BODY_1);
		contentPanel.add(lblantesQueNada);
		
		JLabel lblUtilizaSuId = new JLabel("Utiliza su ID para localizarlo");
		lblUtilizaSuId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtilizaSuId.setBounds(0, 104, 450, 15);
		lblUtilizaSuId.setForeground(Colors.COLOR_WHITE);
		lblUtilizaSuId.setFont(Fonts.FONT_BODY_1);
		contentPanel.add(lblUtilizaSuId);
		
		SpinnerModel numbers = new SpinnerNumberModel(0, 0, 1000000000, 1);
		spNum = new JSpinner(numbers);
		spNum.setBounds(200, 158, 103, 20);
		contentPanel.add(spNum);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(165, 160, 36, 15);
		lblId.setFont(Fonts.FONT_BODY_BLOD_1);
		lblId.setForeground(Colors.COLOR_WHITE);
		contentPanel.add(lblId);
		
		btnViewPet = new JButton("Buscar Mascota");
		btnViewPet.setBounds(127, 208, 206, 33);
		btnViewPet.setActionCommand("VIEWPET");
		btnViewPet.addActionListener(this);
		contentPanel.add(btnViewPet);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("VIEWPET"))
		{
			int id = Integer.parseInt(spNum.getValue().toString());
			System.out.println(id);
			PetDTO pet = mainWindows.getGeneralController().getPet().findById(id);
			if(pet != null)
			{
				if(ServicesStructures.isPetOrganization(pet, mainWindows.getOrgSession()))
				{
					if(statusDialog.equals(DIALOG_EDIT)) 
					{
						JOptionPane.showMessageDialog(this, "Entro a editar");
					}else if(statusDialog.equals(DIALOG_DELETE)) 
					{
						JOptionPane.showMessageDialog(this, "Entro a eliminar");
					}else if(statusDialog.equals(DIALOG_SEARCH)) 
					{
						JOptionPane.showMessageDialog(this, "Entro a buscar");
					}
				}else
				{
					JOptionPane.showMessageDialog(this, "¡Ops! No hay ninguna mascota con esa id que sea de tu fundación.");
				}
			}else
			{
				JOptionPane.showMessageDialog(this, "¡Vaya! Al parecer la mascota no se encuentra en la base de datos.");
			}
		}
		
	}
}
