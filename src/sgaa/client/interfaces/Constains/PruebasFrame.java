package sgaa.client.interfaces.Constains;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import sgaa.client.interfaces.SearchScrollPets.DialogViewPet;

public class PruebasFrame extends JFrame {

	public PruebasFrame() {
		
		
		
		
	}

	public static void main(String[] args) {
		PruebasFrame ven = new PruebasFrame();
		ven.setVisible(true);
		ven.setSize(new Dimension(1000, 600));
		ven.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
