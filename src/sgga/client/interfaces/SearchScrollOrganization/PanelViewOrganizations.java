package sgga.client.interfaces.SearchScrollOrganization;

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
import sgaa.client.interfaces.SearchScrollPets.Page;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.OrganizationDTO;
import sgaa.server.dto.PetDTO;

public class PanelViewOrganizations extends JPanel implements ActionListener{

    private JScrollPane scrollPane;
    private JPanel scrollPanel, btnPanelVisual;
    private GridLayout p;
    private JButton btnViewMore;
    private MainWindows mainWindows;
    private IStackArray<OrganizationDTO> organizations;

    public PanelViewOrganizations(IStackArray<OrganizationDTO> pInfoPageOrganizations, MainWindows pMainWindows){
    	mainWindows = pMainWindows;
    	organizations = pInfoPageOrganizations;
        setPreferredSize(new Dimension(300, 400));
        setLayout(new BorderLayout());
        p = new GridLayout(1, 1);
        initComponents();
        
        
        if(pInfoPageOrganizations.size() > 0)
        {
    		PageO pe = new PageO(pInfoPageOrganizations.get(0), this, Colors.COLOR_GREEN1);
            addPanel(pe);
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
          
        scrollPane = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  //Let all scrollPanel has scroll bars
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);

        btnPanelVisual = new JPanel();
        btnPanelVisual.setLayout(new GridLayout(3, 3));
        JPanel btnPanelVisual2 = new JPanel();
        btnPanelVisual2.setLayout(new GridLayout(3, 1));
        btnPanelVisual2.setBackground(Colors.SECONDARY_COLOR);
        
        btnViewMore = new JButton("Ver más fundaciones");
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

        add(scrollPane, BorderLayout.CENTER);
		scrollPanel.revalidate();
    }

    public void addPanel(JPanel pnl){
    	this.p.setColumns(p.getColumns() + 1);
        scrollPanel.add(pnl);
        scrollPanel.remove(btnPanelVisual);
        scrollPanel.add(btnPanelVisual);
        scrollPanel.revalidate();
    }
    
    public MainWindows getMainWindows() {
		return mainWindows;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Poner")) {
			for(int i = 0; i < 5; i++) {
				PageO addPage = null;
				if(p.getColumns() - 1  < organizations.size())
				{
					if(i%2 == 0)
					{
						addPage = new PageO(organizations.get(p.getColumns() - 1), this, Colors.COLOR_GREEN2);
					}else {
						addPage = new PageO(organizations.get(p.getColumns() - 1), this,  Colors.COLOR_GREEN1);
					}
					addPanel(addPage);
					scrollPanel.revalidate();
				}else
				{
					btnViewMore.setText("¡Ups! No hay más fundaciones.");
					btnViewMore.setEnabled(false);
					p.setColumns(p.getColumns() -1);
					break;
				}
			}
		}
		
		
	}
}
