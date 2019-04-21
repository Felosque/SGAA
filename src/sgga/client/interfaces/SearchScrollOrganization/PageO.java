package sgga.client.interfaces.SearchScrollOrganization;

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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import sgaa.client.estructures.InfoPagePet;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.server.dto.OrganizationDTO;
import sgaa.server.dto.PetDTO;

public class PageO extends JPanel implements ActionListener
{
    private JButton btnViewMore;
    private OrganizationDTO infoPageOrganization;
    private PanelViewOrganizations mainPanelOrganizations;
	
    public PageO(OrganizationDTO pInfoPageOrganization, PanelViewOrganizations pMainPanelOrganizations, Color pColor){
    	mainPanelOrganizations = pMainPanelOrganizations;
    	infoPageOrganization = pInfoPageOrganization;
        setPreferredSize(new Dimension(600, 400));
        setLayout(new GridLayout(1, 1));
        if(pColor == Colors.COLOR_GREEN1)
        {
        	Border line = new LineBorder(Colors.COLOR_GREEN2,5,true);
        	setBorder(line);
        }else
        {
        	Border line = new LineBorder(Colors.COLOR_GREEN1,5,true);
        	setBorder(line);
        }
        
        
        //Content of image and description
        JPanel generalPanel = new JPanel();
        generalPanel.setLayout(new GridLayout(2, 1));
        
        //Content of image
        JPanel imagePanel = new JPanel();
        Image img = new ImageIcon("img/org.png").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(300, 290, Image.SCALE_SMOOTH));
        JLabel picture = new JLabel();
        picture.setIcon(img2);
        imagePanel.setLayout(new FlowLayout());
        imagePanel.add(picture);
        imagePanel.setBackground(pColor);
            
        //Content of description
        JPanel descriptionPanel = new JPanel();
        //Border descriptionPanelBorder = new TitledBorder("Caracteristicas de la mascota");
        //descriptionPanel.setBorder(descriptionPanelBorder); 
        
        descriptionPanel.setLayout(new GridLayout(10, 1));
        //JLabel("<html> Mi label de <b>prueba</b> </html>");
        JLabel name = new JLabel("<html><b>Nombre: </b>" + pInfoPageOrganization.getName() + "</html>");
        name.setFont(Fonts.FONT_BODY_1);
        name.setHorizontalAlignment(JLabel.CENTER);
        descriptionPanel.add(name);
        
        JLabel mail = new JLabel("<html><b>Correo: </b>" + pInfoPageOrganization.getMail() + "</html>");
        mail.setFont(Fonts.FONT_BODY_1);
        mail.setHorizontalAlignment(JLabel.CENTER);
        descriptionPanel.add(new JLabel(""));
        descriptionPanel.add(mail);
        
        JLabel address = new JLabel("<html><b>Dirección: </b>" + pInfoPageOrganization.getAddress()+ "</html>");
        address.setFont(Fonts.FONT_BODY_1);
        address.setHorizontalAlignment(JLabel.CENTER);
        descriptionPanel.add(new JLabel(""));
        descriptionPanel.add(address);
        
        JLabel registration = new JLabel("<html><b>Día de registro: </b>" + pInfoPageOrganization.getRegistrationDate()+ "</html>");
        registration.setFont(Fonts.FONT_BODY_1);
        registration.setHorizontalAlignment(JLabel.CENTER);
        descriptionPanel.add(new JLabel(""));
        descriptionPanel.add(registration);
        
        descriptionPanel.add(new JLabel(""));
        descriptionPanel.setBackground(pColor);

       
        JPanel panelBotton = new JPanel();
        panelBotton.setLayout(null);
        panelBotton.setBackground(pColor);
        
        btnViewMore = new JButton("Ver mascotas en adopción");
        btnViewMore.addActionListener(this);
        btnViewMore.setActionCommand("VIEW");
        btnViewMore.setBounds(this.getWidth() - (this.getWidth() - 150), 0, 300, 22);

        panelBotton.add(btnViewMore);
        
        descriptionPanel.add(panelBotton);
        
        //add description and image of general panel
        generalPanel.add(imagePanel);
        generalPanel.add(descriptionPanel);
        add(generalPanel);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("VIEW")) {
			mainPanelOrganizations.getMainWindows().openOrganizationPage(infoPageOrganization.getMail());
		}
	}
}



























