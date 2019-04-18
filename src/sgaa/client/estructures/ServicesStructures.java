package sgaa.client.estructures;

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
	
}
