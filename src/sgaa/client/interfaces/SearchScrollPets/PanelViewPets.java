package sgaa.client.interfaces.SearchScrollPets;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sgaa.client.estructures.InfoPagePet;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;
import sgaa.client.interfaces.MainWindows.MainWindows;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.PetDTO;

public class PanelViewPets extends JPanel implements ActionListener{

    private JScrollPane scrollPane;
    private MainWindows mainWindows;
    private JPanel scrollPanel, btnPanelVisual;
    private GridLayout p;
    private JButton btnAddPage;
    private JButton btnViewMore;
    private IStackArray<PetDTO> pets;

    public PanelViewPets(IStackArray<PetDTO> pInfoPagePets, MainWindows pMainWindows){
    	
    	mainWindows = pMainWindows;
    	pets = pInfoPagePets;
        setPreferredSize(new Dimension(1000, 100));
        setLayout(new BorderLayout());
        p = new GridLayout(1, 1);
        initComponents();
        if(pInfoPagePets.size() > 0)
        {
        	for(int i = 0; i < pInfoPagePets.size(); i++)
        	{
	        	if(pInfoPagePets.get(i).isState())
	        	{
			        Page pe = new Page(pets.get(0), Colors.COLOR_BLUE1, this);
			        addPanel(pe);
			        break;
	        	}
        	}
        }else
        {
        	setBackground(Colors.SECONDARY_COLOR);
        	JLabel info = new JLabel("UPS, LA FUNDACIÓN NO TIENE MASCOTAS EN ADOPCIÓN...");
        	info.setFont(Fonts.FONT_BODY_BLOD_1);
        	info.setForeground(Colors.COLOR_GREENBLACK);
        	info.setHorizontalAlignment(JLabel.CENTER);
        	add(info);
        }
    }

    private void initComponents(){
        scrollPanel = new JPanel();
        scrollPanel.setLayout(p);
        scrollPanel.setSize(new Dimension(500, 100));
          
        scrollPane = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  //Let all scrollPanel has scroll bars
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        btnPanelVisual = new JPanel();
        btnPanelVisual.setLayout(new GridLayout(3, 3));
        JPanel btnPanelVisual2 = new JPanel();
        btnPanelVisual2.setLayout(new GridLayout(3, 1));
        btnPanelVisual2.setBackground(Colors.SECONDARY_COLOR);
        
        btnViewMore = new JButton("Ver más mascotas...");
        btnPanelVisual.add(new JLabel(""));
        btnPanelVisual.add(new JLabel(""));
        btnPanelVisual.add(new JLabel(""));
        btnPanelVisual.add(new JLabel(""));
        btnPanelVisual2.add(new JLabel(""));
        btnPanelVisual2.add(btnViewMore);
        btnPanelVisual2.add(new JLabel(""));
        btnPanelVisual.add(btnPanelVisual2);
        btnPanelVisual.add(new JLabel(""));
        btnPanelVisual.add(new JLabel(""));
        btnPanelVisual.add(new JLabel(""));
        btnPanelVisual.add(new JLabel(""));
        btnViewMore.addActionListener(this);
        btnViewMore.setActionCommand("Poner");
        btnPanelVisual.setBackground(Colors.SECONDARY_COLOR);
        
        btnAddPage = new JButton("Add New Page");
        btnAddPage.addActionListener(this);
        btnAddPage.setActionCommand("Poner");

        add(scrollPane, BorderLayout.CENTER);
		scrollPanel.revalidate();
    }

    public MainWindows getMainWindows()
    {
    	return mainWindows;
    }
    
    public void addPanel(JPanel pnl){
    	this.p.setRows(p.getRows() + 1);
        scrollPanel.add(pnl);
        scrollPanel.remove(btnPanelVisual);
        scrollPanel.add(btnPanelVisual);
        scrollPanel.revalidate();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Poner")) {
			for(int i = 0; i < 4; i++) {
				Page addPage = null;
				if(p.getRows() - 1 < pets.size())
				{
					if(pets.get(p.getRows() - 1).isState())
					{
						if(i%2 == 0)
						{
							addPage = new Page(pets.get(p.getRows() - 1), Colors.COLOR_BLUE2, this);
						}else {
							addPage = new Page(pets.get(p.getRows() - 1), Colors.COLOR_BLUE1, this);
						}
						addPanel(addPage);
						scrollPanel.revalidate();
					}
				}else
				{
					btnViewMore.setText("¡Ups! No hay más mascotas.");
					btnViewMore.setEnabled(false);
					break;
				}
			}
		}
		
		
	}
}
