package sgaa.client.interfaces.OrganizationOptions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import sgaa.client.estructures.ServicesStructures;
import sgaa.client.exceptions.FormException;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.BreedDTO;
import sgaa.server.dto.PetDTO;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class DialogAddPet extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField tbxName;
	private JTextField tbxColor;
	private JTextField tbxAdress;
	private JTextArea tbxDescription;
	
	private JSpinner spDia, spMes, spAno;
	
	private MainWindows mainWindows;
	
	private JLabel picture;
	private JPanel imagePanel;
	
	private JComboBox<String> cbSpecies;

	/**
	 * Create the dialog.
	 */
	public DialogAddPet(MainWindows pMainWindows) {
		mainWindows = pMainWindows;
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setAlwaysOnTop(true);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			setBounds(100, 100, 560, 750);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			contentPanel.setBackground(Colors.PRIMARY_COLOR);
			
			JLabel lblCorreo = new JLabel("Color:");
			lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCorreo.setForeground(Color.WHITE);
			lblCorreo.setFont(new Font("Arial", Font.BOLD, 15));
			lblCorreo.setBounds(54, 143, 160, 26);
			contentPanel.add(lblCorreo);
	        Image img = new ImageIcon("img/org.png").getImage();
	        ImageIcon img2=new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
			
			JPanel panel = new JPanel();
			panel.setBounds(25, 54, 490, 615);
			panel.setBackground(Colors.SECONDARY_COLOR);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JButton btnSubirImagen = new JButton("Subir Imagen");
			btnSubirImagen.setBounds(262, 442, 130, 35);
			panel.add(btnSubirImagen);
			btnSubirImagen.addActionListener(this);
			btnSubirImagen.setActionCommand("SUBIR");
			
			imagePanel = new JPanel();
			imagePanel.setBounds(67, 375, 160, 161);
			panel.add(imagePanel);
			picture = new JLabel();
			picture.setIcon(img2);
			imagePanel.setLayout(new FlowLayout());
			imagePanel.add(picture);	
			imagePanel.setBackground(Colors.SECONDARY_COLOR);
			
			JLabel lblNombre = new JLabel("Nombre:");
			panel.add(lblNombre);
			lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombre.setBounds(0, 50, 190, 26);
			lblNombre.setForeground(Colors.COLOR_WHITE);
			lblNombre.setFont(Fonts.FONT_BODY_BLOD_1);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n de casa:");
			panel.add(lblDireccin);
			lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDireccin.setForeground(Color.WHITE);
			lblDireccin.setFont(new Font("Arial", Font.BOLD, 15));
			lblDireccin.setBounds(33, 126, 160, 26);
			
			tbxAdress = new JTextField();
			panel.add(tbxAdress);
			tbxAdress.setColumns(10);
			tbxAdress.setBounds(208, 130, 242, 20);
			
			JLabel label = new JLabel("Fecha de nacimiento:");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Dialog", Font.BOLD, 15));
			label.setBounds(-13, 164, 203, 26);
			panel.add(label);
			
			String[] monthStrings = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
					"Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}; //get month names
			
			SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
			spMes = new JSpinner(monthModel);
			spMes.setBounds(218, 162, 101, 22);
			panel.add(spMes);
			
			SpinnerModel day = new SpinnerNumberModel(1, 1, 31, 1);
			spDia = new JSpinner(day);
			spDia.setBounds(330, 162, 41, 20);
			panel.add(spDia);
			
			SpinnerModel year = new SpinnerNumberModel(2019, 2019 - 100, 2019, 1);
			spAno = new JSpinner(year);
			spAno.setBounds(388, 162, 66, 20);
			panel.add(spAno);
			
			JLabel label_1 = new JLabel("Mes");
			label_1.setBounds(240, 183, 41, 15);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("Día");
			label_2.setBounds(351, 183, 41, 15);
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("Año");
			label_3.setBounds(424, 183, 41, 15);
			panel.add(label_3);
			
			tbxColor = new JTextField();
			panel.add(tbxColor);
			tbxColor.setColumns(10);
			tbxColor.setBounds(208, 92, 242, 20);
			
			tbxName = new JTextField();
			panel.add(tbxName);
			tbxName.setBounds(208, 54, 242, 20);
			tbxName.setColumns(10);
			
			JLabel lblDescripcin = new JLabel("Descripción:");
			lblDescripcin.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDescripcin.setForeground(Color.WHITE);
			lblDescripcin.setFont(new Font("Dialog", Font.BOLD, 15));
			lblDescripcin.setBounds(-13, 276, 203, 26);
			panel.add(lblDescripcin);
			
			tbxDescription = new JTextArea();
			tbxDescription.setBounds(208, 282, 246, 81);
			tbxDescription.setLineWrap(true);
			tbxDescription.setWrapStyleWord(true);
			panel.add(tbxDescription);
			
			JLabel lblRazaYEspecie = new JLabel("Raza y especie:");
			lblRazaYEspecie.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRazaYEspecie.setForeground(Color.WHITE);
			lblRazaYEspecie.setFont(new Font("Dialog", Font.BOLD, 15));
			lblRazaYEspecie.setBounds(-13, 215, 203, 26);
			panel.add(lblRazaYEspecie);
			
			JButton btnRegistrarme = new JButton("Agregar Mascota");
			btnRegistrarme.setActionCommand("ANADIR");
			btnRegistrarme.addActionListener(this);
			panel.add(btnRegistrarme);
			btnRegistrarme.setBounds(153, 561, 166, 35);
			
			
			IStackArray<BreedDTO> species = new IStackArray<BreedDTO>();
			species = mainWindows.getGeneralController().getBreed().findAll();
			
			cbSpecies = new JComboBox();
			cbSpecies.setBounds(208, 216, 246, 24);
			cbSpecies.addActionListener(this);
			cbSpecies.setActionCommand("SPECIES");
			for(int i = 0; i < species.size(); i++)
			{
				cbSpecies.addItem(species.get(i).getBreed());
			}
			
			panel.add(cbSpecies);
			
			JComboBox cbBreed = new JComboBox();
			cbBreed.setBounds(208, 246, 247, 24);
			panel.add(cbBreed);
			
			JLabel lblRegistroParaFundaciones = new JLabel("REGISTRAR NUEVA MASCOTA");
			lblRegistroParaFundaciones.setHorizontalAlignment(SwingConstants.LEFT);
			lblRegistroParaFundaciones.setBounds(115, 22, 400, 22);
			contentPanel.add(lblRegistroParaFundaciones);
			lblRegistroParaFundaciones.setFont(Fonts.FONT_TITLE_0);
			lblRegistroParaFundaciones.setForeground(Colors.COLOR_WHITE);
		}
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
			file.showOpenDialog(this);
			file.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
			file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			File img = file.getSelectedFile();
			System.out.println(img.getPath());
			refrescarImagen(img);
		}
		else if(e.getActionCommand().equals("ANADIR"))
		{
			//Fecha de nacimiento
			try
			{
				ServicesStructures.viewFormPet(tbxName.getText(), tbxColor.getText(), tbxAdress.getText());
				Calendar fechaActual = Calendar.getInstance();
				fechaActual.set((int)spAno.getValue() +1, ServicesStructures.getMonthNumber(spMes.getValue().toString()), ((int)spDia.getValue()));
				Date dateU = fechaActual.getTime();	
				
				boolean action = mainWindows.getGeneralController().getPet().insert(-1, tbxName.getText(), tbxColor.getText(), tbxAdress.getText(),
						dateU, true, cbSpecies.getSelectedIndex(), mainWindows.getOrgSession().getMail(), null, tbxDescription.getText());
				if(action)
				{
					JOptionPane.showMessageDialog(this, "Se ha registrado la mascota correctamente, felicitaciones");
					mainWindows.repaintPetsList();
					this.dispose();
				}else
				{
					JOptionPane.showMessageDialog(this, "¡Ups! Hubo un error al registrar la mascota");
				}
			}catch (FormException er) {
				JOptionPane.showMessageDialog(this, er.getMessage());
			}
		}
		
	}
}
