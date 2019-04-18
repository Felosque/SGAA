package sgaa.client.interfaces.RegistrationPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import sgaa.client.estructures.GeneralController;
import sgaa.client.estructures.ServicesStructures;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import javax.swing.JSpinner;

public class RegistrationUser extends JDialog implements ActionListener, WindowListener {

	private final JPanel contentPanel = new JPanel();

	private JTextField tbxName;
	private JTextField tbxMail;
	private JPasswordField tbxPassword;
	private JPasswordField tbxPasswordR;
	private JTextField tbxHouse;
	private JFormattedTextField tbxPhone;
	private JSpinner spDia, spAno, spMes;
	
	private RegistrationDialog registrationDialog;
	

	/**
	 * Create the dialog.
	 */
	public RegistrationUser(RegistrationDialog pDialog) {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(pDialog.getMainPanel());
		
		registrationDialog = pDialog;
		addWindowListener(this);
		setBounds(100, 100, 534, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Colors.PRIMARY_COLOR);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(54, 106, 160, 26);
		lblNombre.setForeground(Colors.COLOR_WHITE);
		lblNombre.setFont(Fonts.FONT_BODY_BLOD_1);
		contentPanel.add(lblNombre);
		
		tbxName = new JTextField();
		tbxName.setBounds(224, 110, 252, 20);
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
		tbxMail.setBounds(224, 147, 252, 20);
		contentPanel.add(tbxMail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		lblContrasea.setBounds(54, 180, 160, 26);
		contentPanel.add(lblContrasea);
		
		tbxPassword = new JPasswordField();
		tbxPassword.setBounds(224, 184, 252, 20);
		contentPanel.add(tbxPassword);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirContrasea.setForeground(Color.WHITE);
		lblRepetirContrasea.setFont(new Font("Arial", Font.BOLD, 15));
		lblRepetirContrasea.setBounds(50, 217, 170, 26);
		contentPanel.add(lblRepetirContrasea);
		
		tbxPasswordR = new JPasswordField();
		tbxPasswordR.setBounds(224, 221, 252, 20);
		contentPanel.add(tbxPasswordR);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 15));
		lblTelefono.setBounds(54, 254, 160, 26);
		contentPanel.add(lblTelefono);
		
		tbxPhone = new JFormattedTextField();
		tbxPhone.setBounds(224, 258, 252, 20);
		contentPanel.add(tbxPhone);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n de casa:");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Arial", Font.BOLD, 15));
		lblDireccin.setBounds(54, 291, 160, 26);
		contentPanel.add(lblDireccin);
		
		tbxHouse = new JTextField();
		tbxHouse.setColumns(10);
		tbxHouse.setBounds(224, 295, 252, 20);
		contentPanel.add(tbxHouse);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 54, 466, 402);
		panel.setBackground(Colors.SECONDARY_COLOR);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.addActionListener(this);
		btnRegistrarme.setActionCommand("REGISTRAR");
		panel.add(btnRegistrarme);
		btnRegistrarme.setBounds(153, 342, 166, 48);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setFont(new Font("Dialog", Font.BOLD, 15));
		lblFechaDeNacimiento.setBounds(-11, 280, 203, 26);
		panel.add(lblFechaDeNacimiento);
		
		
		String[] monthStrings = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
								"Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}; //get month names
		SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
		spMes = new JSpinner(monthModel);
		spMes.setBounds(202, 284, 117, 22);
		panel.add(spMes);
		
		spDia = new JSpinner();
		spDia.setBounds(330, 284, 41, 20);
		panel.add(spDia);

		SpinnerModel year = new SpinnerNumberModel(2019, 2019 - 100, 2019, 1);
		spAno = new JSpinner(year);
		spAno.setBounds(388, 284, 66, 20);
		panel.add(spAno);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(229, 305, 41, 15);
		panel.add(lblMes);
		
		JLabel lblDa = new JLabel("Día");
		lblDa.setBounds(340, 305, 41, 15);
		panel.add(lblDa);
		
		JLabel lblAo = new JLabel("Año");
		lblAo.setBounds(413, 305, 41, 15);
		panel.add(lblAo);
		
		JLabel lblRegistroParaFundaciones = new JLabel("REGISTRO PARA USUARIOS");
		lblRegistroParaFundaciones.setBounds(133, 21, 287, 22);
		contentPanel.add(lblRegistroParaFundaciones);
		lblRegistroParaFundaciones.setFont(Fonts.FONT_TITLE_0);
		lblRegistroParaFundaciones.setForeground(Colors.COLOR_WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("REGISTRAR"))
		{
			Calendar fechaActual = Calendar.getInstance();
			fechaActual.set(2019, 01-1, 8);
			Date dateR = fechaActual.getTime();	
			fechaActual.set((int)spAno.getValue(), ServicesStructures.getMonthNumber(spMes.getValue().toString()), (int)spDia.getValue());
			Date dateU = fechaActual.getTime();	
			boolean result =  registrationDialog.getMainPanel().getMainWindows().getGeneralController().getUser()
			.insert(tbxMail.getText(), ServicesStructures.viewPassword(tbxPassword.getPassword()), tbxName.getText(), tbxHouse.getText(), 
					Long.parseLong(tbxPhone.getText()), dateU, dateR);
			if(result == true)
			{
				JOptionPane.showMessageDialog(this, "¡Se ha registrado correctamente el usuario, ya puede loguearse!");
			}else
			{
				JOptionPane.showMessageDialog(this, "¡Hubo un error al registrar el usuario!\n Posiblemente ese correo ya este registrado en la base de datos.");
			}
			//this.dispose();
		}
	}
	

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
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
