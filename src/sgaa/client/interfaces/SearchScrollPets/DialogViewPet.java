package sgaa.client.interfaces.SearchScrollPets;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import sgaa.client.estructures.InfoPagePet;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;
import sgaa.server.dto.PetDTO;

import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.SwingConstants;
import java.awt.Color;

public class DialogViewPet extends JDialog implements ActionListener {

	/**
	 * Create the dialog.
	 */
	
	private JButton btnExit, btnAdopt;
	private PetDTO pet;
	private MainWindows mainWindows;
	
	private final static String BTN_EXIT = "Exit";
	private final static String BTN_ADOPT = "Adopt";
	
	public DialogViewPet( PetDTO pInfoPagePet, Color pColor, MainWindows pMainWindows) {
		
		mainWindows = pMainWindows;
		pet = pInfoPagePet;
		getContentPane().setBackground(pColor);
		setBounds(100, 100, 747, 511);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setText(pInfoPagePet.getDescription());
		txtDescription.setBackground(pColor);
		txtDescription.setEditable(false);
		txtDescription.setBounds(484, 206, 207, 130);
		getContentPane().add(txtDescription);
		
		JLabel lblRaza = new JLabel("Raza: ");
		lblRaza.setFont(Fonts.FONT_BODY_BLOD_1);
		lblRaza.setForeground(Colors.COLOR_WHITE);
		lblRaza.setBounds(286, 102, 183, 20);
		getContentPane().add(lblRaza);
		
		TextField txtRaza = new TextField();
		txtRaza.setText( mainWindows.getGeneralController().getBreed().findById(pInfoPagePet.getBreed()).getBreed() );
		txtRaza.setEditable(false);
		txtRaza.setBounds(484, 102, 207, 20);
		getContentPane().add(txtRaza);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setFont(Fonts.FONT_BODY_BLOD_1);
		lblColor.setForeground(Colors.COLOR_WHITE);
		lblColor.setBounds(286, 128, 183, 20);
		getContentPane().add(lblColor);
		
		TextField txtColor = new TextField();
		txtColor.setText( pInfoPagePet.getColor());
		txtColor.setEditable(false);
		txtColor.setBounds(484, 128, 207, 20);
		getContentPane().add(txtColor);
		
		JLabel lblLugarDeAdquisicin = new JLabel("Lugar de adquisici\u00F3n:");
		lblLugarDeAdquisicin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLugarDeAdquisicin.setFont(Fonts.FONT_BODY_BLOD_1);
		lblLugarDeAdquisicin.setForeground(Colors.COLOR_WHITE);
		lblLugarDeAdquisicin.setBounds(286, 154, 183, 20);
		getContentPane().add(lblLugarDeAdquisicin);
		
		TextField txtPlace = new TextField();
		txtPlace.setText( pInfoPagePet.getAddress() );
		txtPlace.setEditable(false);
		txtPlace.setBounds(484, 154, 207, 20);
		getContentPane().add(txtPlace);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcin.setFont(Fonts.FONT_BODY_BLOD_1);
		lblDescripcin.setForeground(Colors.COLOR_WHITE);
		lblDescripcin.setBounds(286, 207, 180, 20);
		getContentPane().add(lblDescripcin);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaNacimiento.setFont(Fonts.FONT_BODY_BLOD_1);
		lblFechaNacimiento.setForeground(Colors.COLOR_WHITE);
		lblFechaNacimiento.setBounds(286, 180, 183, 20);
		getContentPane().add(lblFechaNacimiento);
		
		TextField txtDateBirday = new TextField();
		txtDateBirday.setText( pInfoPagePet.getBirthdate().toString() );
		txtDateBirday.setEditable(false);
		txtDateBirday.setBounds(484, 180, 207, 20);
		getContentPane().add(txtDateBirday);
		
		JLabel lblImg = new JLabel("IMG");
		lblImg.setBackground(Colors.COLOR_WHITE);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(40, 102, 178, 169);
		getContentPane().add(lblImg);
		
		JLabel lblDescripcinDeLa = new JLabel("DESCRIPCI\u00D3N DE LA MASCOTA");
		lblDescripcinDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcinDeLa.setFont(Fonts.FONT_TITLE_1);
		lblDescripcinDeLa.setForeground(Colors.COLOR_WHITE);
		lblDescripcinDeLa.setBounds(0, 11, 764, 37);
		getContentPane().add(lblDescripcinDeLa);
		
		btnExit = new JButton("Salir");
		btnExit.setActionCommand(BTN_EXIT);
		btnExit.addActionListener(this);
		btnExit.setBounds(168, 401, 166, 36);
		getContentPane().add(btnExit);
		
		btnAdopt = new JButton("Adoptar");
		btnAdopt.setActionCommand(BTN_ADOPT);
		btnAdopt.addActionListener(this);
		btnAdopt.setBounds(388, 401, 166, 36);
		getContentPane().add(btnAdopt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals(BTN_EXIT))
		{
			this.dispose();
		}
		else if(command.equals(BTN_ADOPT))
		{
			Date fecha = new Date();
			mainWindows.getGeneralController().getAdoption().insert(mainWindows.getUserSession().getMail(),
																	pet.getId(), fecha);
			
			mainWindows.getGeneralController().getPet().update(pet.getId(),
					pet.getName(), pet.getColor(), pet.getAddress(), pet.getBirthdate(), false, 
					pet.getBreed(), pet.getMail(), pet.getPathImage(), pet.getDescription());
		}
		
	}
	
	
	
	
	
	
	
	
}