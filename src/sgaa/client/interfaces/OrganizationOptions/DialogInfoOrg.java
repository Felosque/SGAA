package sgaa.client.interfaces.OrganizationOptions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class DialogInfoOrg extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();

	private static final String BTN_DELETE = "Delete";
	
	private JButton btnDelete;
	
	private MainWindows mainWindows;

	/**
	 * Create the dialog.
	 */
	public DialogInfoOrg(MainWindows pMainWindows) {
		mainWindows = pMainWindows;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Colors.COLOR_BLUE1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 38);
		panel.setBackground(Colors.PRIMARY_COLOR);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblSgaa = new JLabel("SGAA");
		lblSgaa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSgaa.setFont(Fonts.FONT_TITLE_0);
		lblSgaa.setForeground(Colors.COLOR_WHITE);
		lblSgaa.setBounds(0, 0, 450, 38);
		panel.add(lblSgaa);
		
		JLabel lblDefault = new JLabel("default");
		lblDefault.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefault.setText(mainWindows.getOrgSession().getName());
		lblDefault.setForeground(Colors.COLOR_GREENBLACK);
		lblDefault.setFont(Fonts.FONT_BODY_BLOD_1);
		lblDefault.setBounds(12, 82, 426, 27);
		contentPanel.add(lblDefault);
		
		JLabel label = new JLabel("default");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText(mainWindows.getOrgSession().getHouse());
		label.setFont(Fonts.FONT_BODY_BLOD_1);
		label.setForeground(Colors.COLOR_GREENBLACK);
		label.setBounds(12, 121, 426, 27);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel(mainWindows.getOrgSession().getRegistrationDate().toString());
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(Fonts.FONT_BODY_BLOD_1);
		label_1.setForeground(Colors.COLOR_GREENBLACK);
		label_1.setBounds(12, 158, 426, 27);
		contentPanel.add(label_1);
		
		btnDelete = new JButton("Borrar Fundación");
		btnDelete.setBounds(114, 211, 220, 25);
		btnDelete.setActionCommand(BTN_DELETE);
		btnDelete.addActionListener(this);
		contentPanel.add(btnDelete);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals(BTN_DELETE)) {
			int dialogResult = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar su fundación?\nEsta opción no tiene vuelta atras.");
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				boolean status = mainWindows.getGeneralController().getOrganization().delete(mainWindows.getOrgSession().getMail());
				if(status == true)
				{
					mainWindows.closeSessionOrganization();
					JOptionPane.showMessageDialog(this, "¡Se ha eliminado tu fundación satisfactoriamente!", "ELIMINADA", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
				}else	
				{
					JOptionPane.showMessageDialog(this, "¡Ups! Hay un problema al eliminar tu fundación.\n Posiblemente aún tengas mascotas.", "ELIMINADA", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}
