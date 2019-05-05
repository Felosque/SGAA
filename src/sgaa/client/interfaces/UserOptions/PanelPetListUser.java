package sgaa.client.interfaces.UserOptions;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.AdoptionDTO;
import sgaa.server.dto.PetDTO;

public class PanelPetListUser extends JPanel{

	private MainWindows mainWindows;
	
	private JTable table;
	
	private JScrollPane panelScroll;
	
	public PanelPetListUser(MainWindows pMainWindows) {
		
		mainWindows = pMainWindows;
		
		setLayout(null);
		setBackground(Colors.SECONDARY_COLOR);    
		
		JLabel info = new JLabel("MIS MASCOTAS");
		info.setForeground(Colors.COLOR_GREENBLACK);
		info.setFont(Fonts.FONT_TITLE_0);
		info.setBounds(270, -10, 300, 70);
		add(info);
		
		repaintList();
	}
	
	public void repaintList()
	{
		IStackArray<AdoptionDTO> adoptions = new IStackArray<AdoptionDTO>();
		adoptions = mainWindows.getGeneralController().getAdoption().findAll(mainWindows.getUserSession().getMail());
		
		if(adoptions.size() > 0)
		{
			IStackArray<PetDTO> pets = new IStackArray<PetDTO>();
			for(int i = 0; i < adoptions.size(); i++)
			{
				pets.add(mainWindows.getGeneralController().getPet().findById(adoptions.get(i).getIdPet()));
			}
					
			Object[][] datas = new Object[pets.size()][6];	
			for(int i = 0; i < pets.size(); i++)
			{
				datas[i][0] = pets.get(i).getId(); 
				datas[i][1] = pets.get(i).getName(); 
				datas[i][2] = pets.get(i).getColor(); 
				datas[i][3] = pets.get(i).getBirthdate().toString(); 
				datas[i][4] = mainWindows.getGeneralController().getBreed().findById(pets.get(i).getBreed()).getBreed(); 
				datas[i][5] = pets.get(i).getDescription();
			}
			
			String[] columns = new String[] {
		            "Id", "Nombre", "Color", "Día de nacimiento", "Raza", "Descipción"
			};
			
			 //create table with data
	        table = new JTable(datas, columns);
	        table.setRowHeight(30);
	        table.setBounds(0, 0, 700, 500);
	      
	        panelScroll = new JScrollPane(table);
	        panelScroll.setBounds(0, 50, 700, 500);
	        panelScroll.setBackground(Colors.COLOR_GREENBLACK);

	        this.add(panelScroll);
		}
		
	}

}
