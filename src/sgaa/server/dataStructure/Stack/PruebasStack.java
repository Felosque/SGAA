package sgaa.server.dataStructure.Stack;

import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

import sgaa.server.dao.UserDAO;
import sgaa.server.dto.UserDTO;

public class PruebasStack {

	public PruebasStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		String mail = "Felipelondono4@gmail.com";
		long phone =  3183769455L;
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.set(2019, 01-1, 8);
		Date dateR = fechaActual.getTime();
		System.out.println(dateR);
		
		UserDTO usuario1 = new UserDTO(mail, "Felosque", "Felipe", "Calle 60", 
							phone, dateR, dateR);
		
		UserDTO usuario2 = new UserDTO(mail, "Fabian", "Far", "Calle 60", 
				phone, dateR, dateR);
		
		UserDTO usuario3 = new UserDTO(mail, "Fricher", "Per", "Calle 60", 
				phone, dateR, dateR);
		
		UserDTO usuario4 = new UserDTO(mail, "Zambri", "Full", "Calle 60", 
				phone, dateR, dateR);
		
		
		IStackArray<UserDTO> stack = new IStackArray<UserDTO>();
		stack.add(usuario1);
		stack.add(usuario2);
		stack.add(usuario3);
		stack.add(usuario4);
		

		for(int i = 0; i < stack.size(); i++)
		{
			System.out.println(stack.get(i).getName());
		}
		
		//System.out.println(stack.get(0).getMail());
		

	}

}
