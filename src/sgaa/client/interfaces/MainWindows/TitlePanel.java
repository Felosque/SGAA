package sgaa.client.interfaces.MainWindows;

import javax.swing.JLabel;
import javax.swing.JPanel;
import sgaa.client.interfaces.Constains.Colors;
import sgaa.client.interfaces.Constains.Fonts;

public class TitlePanel extends JPanel {

	public TitlePanel() {
		
		setBackground(Colors.COLOR_BLUE1);
		
		JLabel title = new JLabel("SGAA");
		title.setForeground(Colors.COLOR_WHITE);
		title.setFont(Fonts.MAIN_FONT_TITLE);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(JLabel.CENTER);
		add(title);
		 
	}

}
