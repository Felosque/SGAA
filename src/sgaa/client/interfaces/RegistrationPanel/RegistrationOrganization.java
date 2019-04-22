package sgaa.client.interfaces.RegistrationPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import sgaa.client.estructures.ServicesStructures;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class RegistrationOrganization extends JDialog implements ActionListener, WindowListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField tbxName;
	private JTextField tbxMail;
	private JPasswordField tbxPassword;
	private JPasswordField tbxPasswordR;
	private JTextField tbxHouse;
	private JFormattedTextField tbxPhone;
	
	private JLabel picture;
	private JPanel imagePanel;

	private RegistrationDialog registrationDialog;

	/**
	 * Create the dialog.
	 */
	public RegistrationOrganization(RegistrationDialog pDialog) {
		
		registrationDialog = pDialog;
		addWindowListener(this);
		setBounds(100, 100, 534, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(pDialog);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Colors.PRIMARY_COLOR);
		
		JLabel lblNombre = new JLabel("Nombre Organizaci\u00F3n:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(30, 106, 190, 26);
		lblNombre.setForeground(Colors.COLOR_WHITE);
		lblNombre.setFont(Fonts.FONT_BODY_BLOD_1);
		contentPanel.add(lblNombre);
		
		tbxName = new JTextField();
		tbxName.setBounds(224, 110, 242, 20);
		contentPanel.add(tbxName);
		tbxName.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Arial", Font.BOLD, 15));
		lblCorreo.setBounds(54, 143, 160, 26);
		contentPanel.add(lblCorreo);
		
		tbxMail = new JTextField();
		tbxMail.setColumns(10);
		tbxMail.setBounds(224, 147, 242, 20);
		contentPanel.add(tbxMail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		lblContrasea.setBounds(54, 180, 160, 26);
		contentPanel.add(lblContrasea);
		
		tbxPassword = new JPasswordField();
		tbxPassword.setBounds(224, 184, 242, 20);
		contentPanel.add(tbxPassword);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirContrasea.setForeground(Color.WHITE);
		lblRepetirContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		lblRepetirContrasea.setBounds(36, 217, 180, 26);
		contentPanel.add(lblRepetirContrasea);
		
		tbxPasswordR = new JPasswordField();
		tbxPasswordR.setBounds(224, 221, 242, 20);
		contentPanel.add(tbxPasswordR);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 15));
		lblTelefono.setBounds(54, 254, 160, 26);
		contentPanel.add(lblTelefono);
		
		tbxPhone = new JFormattedTextField();
		tbxPhone.setBounds(224, 258, 242, 20);
		contentPanel.add(tbxPhone);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n de casa:");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Arial", Font.BOLD, 15));
		lblDireccin.setBounds(54, 291, 160, 26);
		contentPanel.add(lblDireccin);
		
		tbxHouse = new JTextField();
		tbxHouse.setColumns(10);
		tbxHouse.setBounds(224, 295, 242, 20);
		contentPanel.add(tbxHouse);
        Image img = new ImageIcon("img/org.png").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		
		JButton btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.setActionCommand("REGISTRAR");
		btnRegistrarme.addActionListener(this);
		btnRegistrarme.setBounds(167, 580, 166, 48);
		contentPanel.add(btnRegistrarme);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 54, 466, 596);
		panel.setBackground(Colors.SECONDARY_COLOR);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnSubirImagen = new JButton("Subir Imagen");
		btnSubirImagen.setBounds(270, 373, 130, 35);
		panel.add(btnSubirImagen);
		btnSubirImagen.addActionListener(this);
		btnSubirImagen.setActionCommand("SUBIR");
		
		imagePanel = new JPanel();
		imagePanel.setBounds(45, 290, 200, 200);
		panel.add(imagePanel);
		picture = new JLabel();
		picture.setIcon(img2);
		imagePanel.setLayout(new FlowLayout());
		imagePanel.add(picture);	
		imagePanel.setBackground(Colors.SECONDARY_COLOR);
		
		JLabel lblRegistroParaFundaciones = new JLabel("REGISTRO PARA FUNDACIONES");
		lblRegistroParaFundaciones.setBounds(115, 22, 400, 22);
		contentPanel.add(lblRegistroParaFundaciones);
		lblRegistroParaFundaciones.setFont(Fonts.FONT_TITLE_0);
		lblRegistroParaFundaciones.setForeground(Colors.COLOR_WHITE);
		
		
	}
	
	public void refrescarImagen(File pImagen)
	{
		Image img = new ImageIcon(pImagen.getAbsolutePath()).getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        picture.setIcon(img2);
        imagePanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("SUBIR"))
		{
			JFileChooser file=new JFileChooser();
			file.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
			file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			file.showOpenDialog(this);
			File img = file.getSelectedFile();
			refrescarImagen(img);
		}else if(e.getActionCommand().equals("REGISTRAR"))
		{
			
			boolean result =  registrationDialog.getMainPanel().getMainWindows().getGeneralController().getOrganization()
					.insert(tbxMail.getText(), ServicesStructures.viewPassword(tbxPassword.getPassword()), tbxName.getText(), tbxHouse.getText(), 
							Long.parseLong(tbxPhone.getText()), new Date());
				
				if(result == true)
				{
					JOptionPane.showMessageDialog(this, "¡Se ha registrado correctamente la fundación, ya puede loguearse!");
					registrationDialog.getMainPanel().mainWindowsVisible(true);
					this.dispose();
				}else
				{
					JOptionPane.showMessageDialog(this, "¡Hubo un error al registrar la fundación!\n Posiblemente ese correo ya este registrado en la base de datos.");
				}
		}
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.dispose();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stu
		registrationDialog.getMainPanel().mainWindowsVisible(true);
		this.dispose();
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
