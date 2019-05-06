package sgaa.client.interfaces.UserOptions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgaa.client.interfaces.MainWindows.MainWindows;

public class DialogMyPets extends JDialog {

	 	
	public DialogMyPets(MainWindows pMainWindows) {
		
		setAlwaysOnTop(true);
		PanelPetListUser panelPetListUser = new PanelPetListUser(pMainWindows);
		add(panelPetListUser);
		setBounds(0, 0, 700, 600);
	}

}
