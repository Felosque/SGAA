package sgaa.client.interfaces.UserOptions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.BreedDTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DialogSearchPets extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();

	private JComboBox<String> cbSpecies;
	
	private static final String BTN_ACTION = "action";
	
	private JButton btnAction;
	
	private MainWindows mainWindows;
	
	/**
	 * Create the dialog.
	 */
	public DialogSearchPets(MainWindows pMainWindows) {
		
		mainWindows = pMainWindows;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Colors.COLOR_GREEN2);
		setAlwaysOnTop(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 42);
		panel.setBackground(Colors.PRIMARY_COLOR);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblInfo = new JLabel("SGAA");
		lblInfo.setForeground(Colors.COLOR_WHITE);
		lblInfo.setFont(Fonts.FONT_TITLE_0);
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(0, 0, 450, 42);
		panel.add(lblInfo);
		
		
		IStackArray<BreedDTO> species = new IStackArray<BreedDTO>();
		species = mainWindows.getGeneralController().getBreed().findAll();
		
		cbSpecies = new JComboBox();
		cbSpecies.setBounds(94, 138, 246, 24);
		cbSpecies.addActionListener(this);
		cbSpecies.setActionCommand("SPECIES");
		for(int i = 0; i < species.size(); i++)
		{
			cbSpecies.addItem(species.get(i).getBreed());
		}
		contentPanel.add(cbSpecies);
		
		JLabel lblSelect = new JLabel("Selecciona la especie del animal que quieres adoptar:");
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setFont(Fonts.FONT_BODY_1);
		lblSelect.setBounds(0, 81, 428, 32);
		contentPanel.add(lblSelect);
		
		btnAction = new JButton("Buscar Mascotas");
		btnAction.setActionCommand(BTN_ACTION);
		btnAction.addActionListener(this);
		btnAction.setBounds(126, 198, 194, 32);
		contentPanel.add(btnAction);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals(BTN_ACTION))
		{
			mainWindows.openSearchPets(cbSpecies.getSelectedIndex());
			this.dispose();
		}
	}
	
	
	
	
	
	
	
	
	
}
