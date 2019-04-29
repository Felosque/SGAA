package sgaa.client.estructures;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import sgaa.client.exceptions.FormException;
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
	
	public static String getMonthText(int id)
	{
		String month = null;
		String[] monthStrings = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
				"Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		month = monthStrings[id];
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
	
	public static void viewFormUser(String pName, String pMail, String pPassWord, String pRPassword, long pPhone, String pAddress, int pYear) throws FormException
	{
		if(pName.equals("") || pMail.equals(""))
		{
			throw new FormException("¡Usuario o emal incorrectos para registrarse en SGAA!");
		}
		if(comparePassword(pPassWord, pRPassword) == false)
		{
			throw new FormException("¡Las contraseñas no coinciden!");
		}
		if(pPhone < 2000000)
		{
			throw new FormException("¡El telefono debe ser un numero valido!");
		}
		if(pAddress.equals(""))
		{
			throw new FormException("¡Debes poner una dirección de casa valida!");
		}
		if(pYear > 2003)
		{
			throw new FormException("¡Debes tener al menos 16 años para poder registrarte en SGAA!");
		}
	}
	
	public static void viewFormOrg(String pName, String pMail, String pPassword, String pRPassword, long pPhone, String pAddress) throws FormException
	{
		if(pName.equals("") || pMail.equals(""))
		{
			throw new FormException("¡Usuario o emal incorrectos para registrarse en SGAA!");
		}
		if(comparePassword(pPassword, pRPassword) == false)
		{
			throw new FormException("¡Las contraseñas no coinciden!");
		}
		if(pPhone < 2000000)
		{
			throw new FormException("¡El telefono debe ser un numero valido!");
		}
		if(pAddress.equals(""))
		{
			throw new FormException("¡Debes poner una dirección de casa valida!");
		}
	}
	
	public static void viewFormPet(String pName, String pColor, String pAddress) throws FormException
	{
		if(pName.equals("") || pColor.equals("") || pAddress.equals(""))
		{
			throw new FormException("¡La mascota debe tener al menos un nombre, color y dirección de casa!");
		}
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
