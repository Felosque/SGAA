package sgaa.client.interfaces.SearchScrollPets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import sgaa.client.estructures.InfoPagePet;
import sgaa.server.dto.PetDTO;

public class Page extends JPanel implements ActionListener
{
    private JButton btnViewMore;
    private PetDTO infoPagePet;
	
    public Page(PetDTO pInfoPagePet, Color pColor){
    		
    	infoPagePet = pInfoPagePet;
        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(1, 1));
        
        //Content of image and description
        JPanel generalPanel = new JPanel();
        generalPanel.setLayout(new GridLayout(1, 2));
        
        //Content of image
        JPanel imagePanel = new JPanel();
        Image img = new ImageIcon("img/dog.jpg").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(300, 290, Image.SCALE_SMOOTH));
        JLabel picture = new JLabel();
        picture.setIcon(img2);
        imagePanel.setLayout(new FlowLayout());
        imagePanel.add(picture);
        imagePanel.setBackground(pColor);
            
        //Content of description
        JPanel descriptionPanel = new JPanel();
        Border descriptionPanelBorder = new TitledBorder("Caracteristicas de la mascota");
        
        descriptionPanel.setLayout(new GridLayout(10, 1)); 
        descriptionPanel.add(new JLabel("Nombre: " + pInfoPagePet.getName()));
        descriptionPanel.add(new JLabel(""));
        descriptionPanel.add(new JLabel("Color: " + pInfoPagePet.getColor()));
        descriptionPanel.add(new JLabel(""));
        descriptionPanel.add(new JLabel("Nacimiento: " + pInfoPagePet.getBirthdate()));
        descriptionPanel.add(new JLabel(""));
        descriptionPanel.add(new JLabel("Descipción: " + pInfoPagePet.getDescription()));
        descriptionPanel.add(new JLabel(""));
        descriptionPanel.setBackground(pColor);
        descriptionPanel.setBorder(descriptionPanelBorder); 
        
        JPanel bottonPanel = new JPanel();
        bottonPanel.setLayout(new GridLayout(1, 3));
        bottonPanel.add(new JLabel(""));
        
        btnViewMore = new JButton("Ver más...");
        btnViewMore.addActionListener(this);
        btnViewMore.setActionCommand("VIEW");
  
        bottonPanel.add(btnViewMore);
        bottonPanel.add(new JLabel(""));
        bottonPanel.setBackground(pColor);
        
        descriptionPanel.add(bottonPanel);
        
        //add description and image of general panel
        generalPanel.add(imagePanel);
        generalPanel.add(descriptionPanel);
        add(generalPanel);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("VIEW")) {
			DialogViewPet dialogViewPet = new DialogViewPet(infoPagePet);
			dialogViewPet.setVisible(true);
		}
	}
}



























