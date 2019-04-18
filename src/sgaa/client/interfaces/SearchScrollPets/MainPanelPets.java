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
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.PetDTO;

public class MainPanelPets extends JPanel implements ActionListener{

    private JScrollPane scrollPane;
    private JPanel scrollPanel, btnPanelVisual;
    private GridLayout p;
    private JButton btnAddPage;
    private JButton btnViewMore;
    private IStackArray<PetDTO> pets;

    public MainPanelPets(IStackArray<PetDTO> pInfoPagePets){
    	pets = pInfoPagePets;
    	
    	for(int i =0; i < pInfoPagePets.size(); i++)
    	{
    		pInfoPagePets.get(i).getDescription();
    	}
        setPreferredSize(new Dimension(1000, 100));
        setLayout(new BorderLayout());
        p = new GridLayout(1, 1);
        initComponents();
        Page pe = new Page(pets.get(0), Colors.COLOR_BLUE1);
        addPanel(pe);
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
			for(int i = p.getRows(); i < pets.size(); i++) {
				Page addPage = null;
				if(i%2 == 0)
				{
					addPage = new Page(pets.get(i), Colors.COLOR_BLUE1);
				}else {
					addPage = new Page(pets.get(i), Colors.COLOR_BLUE2);
				}
				addPanel(addPage);
				scrollPanel.revalidate();
			}
		}
		
		
	}
}
