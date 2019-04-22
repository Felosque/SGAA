package sgaa.client.interfaces.SearchScrollPets;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;

public class PanelOrganization extends JPanel implements ActionListener{
	
	private JButton btnExit;
	private MainWindows mainWindows;
	
	public PanelOrganization(MainWindows pMainWindows) {
		mainWindows = pMainWindows;
		setLayout(new GridLayout(3, 1));
		setBackground(Colors.COLOR_WHITE_1);
		
		//Content of image
        JPanel imagePanel = new JPanel();
        Image img = new ImageIcon("img/fun1.jpg").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(190, 190, Image.SCALE_SMOOTH));
        JLabel picture = new JLabel();
        picture.setIcon(img2);
        imagePanel.setLayout(new FlowLayout());
        imagePanel.add(picture);
        imagePanel.setBackground(Colors.COLOR_WHITE);
        imagePanel.setBackground(Colors.COLOR_WHITE_1);
        add(imagePanel);
        
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(3,1));
        namePanel.setBackground(Colors.COLOR_WHITE_1);
        
        namePanel.add(new JLabel(""));
        JTextArea txtName = new JTextArea();
        txtName.setFont(Fonts.FONT_BODY_BLOD_1);
        txtName.setBackground(Colors.COLOR_WHITE_1);
        namePanel.add(txtName);
        namePanel.add(new JLabel(""));
        add(namePanel);
        
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(3, 1));
        btnPanel.setBackground(Colors.COLOR_WHITE_1);
        
        btnPanel.add(new JLabel(""));
        
        btnExit = new JButton("Volver");
        btnExit.addActionListener(this);
        btnExit.setActionCommand("VOLVER");
        btnPanel.add(btnExit);
        
        btnPanel.add(new JLabel(""));
        add(btnPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("VOLVER"))
		{
			mainWindows.closeOrganizationPage();
		}
	}


}
