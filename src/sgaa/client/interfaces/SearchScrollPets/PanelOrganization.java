package sgaa.client.interfaces.SearchScrollPets;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;

public class PanelOrganization extends JPanel {
	
	
	public PanelOrganization() {
	
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
		
	}


}
