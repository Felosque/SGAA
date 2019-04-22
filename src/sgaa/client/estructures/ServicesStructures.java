package sgaa.client.estructures;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import sgaa.client.interfaces.RegistrationPanel.RegistrationUser;
import sgaa.server.dto.OrganizationDTO;
import sgaa.server.dto.PetDTO;

public class ServicesStructures {

	
	public static int getMonthNumber(String pMonth)
	{
		int month = -1;
		String[] monthStrings = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		for(int i = 0; i < monthStrings.length && month != -1; i++)
		{
			if(monthStrings[i].equals(pMonth))
			{
				month = i;
			}
		}
		return month;
	}
	
	public static String viewPassword(char[] pPassword)
	{
		String password = "";
		for(int i = 0; i < pPassword.length; i++)
		{
			password = password + pPassword[i];
		}
		return password;
	}
	
	public static boolean comparePassword(String UserPassword, String ComparePassword)
	{
		boolean result = false;
		if(UserPassword.equals(ComparePassword)) {
			result = true;
		}
		return result;
	}
	
	public static boolean isPetOrganization(PetDTO petDto, OrganizationSession orgSession)
	{
		if(petDto.getMail().equals(orgSession.getMail()))
		{
			return true;
		}
		return false;
	}
	
	/*public void registerUser(RegistrationUser pDialog)
	{
		Calendar fechaActual = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateR = new Date();
		fechaActual.set((int)spAno.getValue(), ServicesStructures.getMonthNumber(spMes.getValue().toString()), ((int)spDia.getValue() + 1));
		Date dateU = fechaActual.getTime();	
		
		//Resultado de la consulta al iniciar la seccion 
		boolean result =  registrationDialog.getMainPanel().getMainWindows().getGeneralController().getUser()
		.insert(tbxMail.getText(), ServicesStructures.viewPassword(tbxPassword.getPassword()), tbxName.getText(), tbxHouse.getText(), 
				Long.parseLong(tbxPhone.getText()), dateU, dateR);
		
		if(result == true)
		{
			JOptionPane.showMessageDialog(pDialog, "¡Se ha registrado correctamente el usuario, ya puede loguearse!");
			registrationDialog.getMainPanel().mainWindowsVisible(true);
			this.dispose();
		}else
		{
			JOptionPane.showMessageDialog(this, "¡Hubo un error al registrar el usuario!\n Posiblemente ese correo ya este registrado en la base de datos.");
		}
	}*/
	
}
