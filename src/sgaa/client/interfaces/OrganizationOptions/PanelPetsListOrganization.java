package sgaa.client.interfaces.OrganizationOptions;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.PetDTO;

public class PanelPetsListOrganization extends JPanel {

	
	private MainWindows mainWindows;
	
	private JTable table;
	
	private JScrollPane panelScroll;
	
	public PanelPetsListOrganization(MainWindows pMainWindows) {
		
		mainWindows = pMainWindows;
		
		setLayout(null);
		setBackground(Colors.SECONDARY_COLOR);    
		
		JLabel info = new JLabel("MASCOTAS DE TU FUNDACIÓN");
		info.setForeground(Colors.COLOR_GREENBLACK);
		info.setFont(Fonts.FONT_TITLE_0);
		info.setBounds(350, -10, 500, 70);
		add(info);
		
		repaintList();
	         
	}
	
	public void repaintList()
	{
		IStackArray<PetDTO> pets = new IStackArray<PetDTO>();
		pets = mainWindows.getGeneralController().getPet().findAll(mainWindows.getOrgSession().getMail());
		
		String[] columns = new String[] {
	            "Id", "Nombre", "Color", "Dirección", "Día de nacimiento", "En Adopción", "Raza", "Descipción"
		};
		
		Object[][] datas = new Object[pets.size()][8];	
		for(int i = 0; i < pets.size(); i++)
		{
			datas[i][0] = pets.get(i).getId(); 
			datas[i][1] = pets.get(i).getName(); 
			datas[i][2] = pets.get(i).getColor(); 
			datas[i][3] = pets.get(i).getAddress(); 
			datas[i][4] = pets.get(i).getBirthdate().toString(); 
			datas[i][5] = pets.get(i).isState(); 
			datas[i][6] = mainWindows.getGeneralController().getBreed().findById(pets.get(i).getBreed()).getBreed(); 
			datas[i][7] = pets.get(i).getDescription(); 
		}
		
		 //create table with data
        table = new JTable(datas, columns);
        table.setRowHeight(30);
        table.setBounds(0, 0, 1000, 400);
      
        panelScroll = new JScrollPane(table);
        panelScroll.setBounds(0, 50, 1000, 413);
        panelScroll.setBackground(Colors.COLOR_GREENBLACK);

        
        this.add(panelScroll);
	}


}
