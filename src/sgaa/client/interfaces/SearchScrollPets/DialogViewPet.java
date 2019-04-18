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
import sgaa.server.dto.PetDTO;

import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class DialogViewPet extends JDialog {

	/**
	 * Create the dialog.
	 */
	public DialogViewPet( PetDTO pInfoPagePet) {
		getContentPane().setBackground(Colors.COLOR_BLUE1);
		setBounds(100, 100, 747, 511);
		getContentPane().setLayout(null);
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setLineWrap(true);
		txtDescription.setText(pInfoPagePet.getDescription());
		txtDescription.setBackground(Colors.COLOR_BLUE1);
		txtDescription.setEditable(false);
		txtDescription.setBounds(484, 206, 166, 108);
		getContentPane().add(txtDescription);
		
		JLabel lblRaza = new JLabel("Raza: ");
		lblRaza.setFont(Fonts.FONT_BODY_BLOD_1);
		lblRaza.setForeground(Colors.COLOR_WHITE);
		lblRaza.setBounds(303, 102, 133, 20);
		getContentPane().add(lblRaza);
		
		TextField txtRaza = new TextField();
		txtRaza.setText( String.valueOf(pInfoPagePet.getBreed()));
		txtRaza.setEditable(false);
		txtRaza.setBounds(484, 102, 167, 20);
		getContentPane().add(txtRaza);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setFont(Fonts.FONT_BODY_1);
		lblColor.setBounds(303, 128, 133, 20);
		getContentPane().add(lblColor);
		
		TextField txtColor = new TextField();
		txtColor.setText( pInfoPagePet.getColor());
		txtColor.setEditable(false);
		txtColor.setBounds(484, 128, 167, 20);
		getContentPane().add(txtColor);
		
		JLabel lblLugarDeAdquisicin = new JLabel("Lugar de adquisici\u00F3n:");
		lblLugarDeAdquisicin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLugarDeAdquisicin.setFont(Fonts.FONT_BODY_1);
		lblLugarDeAdquisicin.setBounds(303, 154, 154, 20);
		getContentPane().add(lblLugarDeAdquisicin);
		
		TextField txtPlace = new TextField();
		txtPlace.setText( pInfoPagePet.getAddress());
		txtPlace.setEditable(false);
		txtPlace.setBounds(484, 154, 167, 20);
		getContentPane().add(txtPlace);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcin.setFont(Fonts.FONT_BODY_1);
		lblDescripcin.setBounds(303, 207, 133, 20);
		getContentPane().add(lblDescripcin);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaNacimiento.setFont(Fonts.FONT_BODY_1);
		lblFechaNacimiento.setBounds(303, 180, 133, 20);
		getContentPane().add(lblFechaNacimiento);
		
		TextField txtDateBirday = new TextField();
		txtPlace.setText( "22/231/312" );
		txtDateBirday.setEditable(false);
		txtDateBirday.setBounds(484, 180, 167, 20);
		getContentPane().add(txtDateBirday);
		
		JLabel lblImg = new JLabel("IMG");
		lblImg.setBackground(Colors.COLOR_WHITE);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(40, 102, 178, 169);
		getContentPane().add(lblImg);
		
		JLabel lblDescripcinDeLa = new JLabel("DESCRIPCI\u00D3N DE LA MASCOTA");
		lblDescripcinDeLa.setFont(Fonts.FONT_TITLE_1);
		lblDescripcinDeLa.setForeground(Colors.COLOR_WHITE);
		lblDescripcinDeLa.setBounds(125, 11, 482, 37);
		getContentPane().add(lblDescripcinDeLa);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(168, 401, 166, 36);
		getContentPane().add(btnSalir);
		
		JButton btnAdoptar = new JButton("Adoptar");
		btnAdoptar.setBounds(388, 401, 166, 36);
		getContentPane().add(btnAdoptar);
	}
}
