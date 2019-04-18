package sgaa.client.interfaces.SearchScrollPets;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sgaa.client.estructures.InfoPagePet;

class ScrollPaneDemo{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame = new JFrame("Scrollable Panel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                PanelOrganization pa = new PanelOrganization(); 

                /*Conexion con = Conexion.getInstance();
        		ResultSet re = con.qetQuery("SELECT id, id_organizacion, raza, color, nombre, descripcion, lugar_ad FROM public.mascotas;");
        		InfoPagePet[] infoPagePet = new InfoPagePet[5];
        		try {
        			int i = 0;
        			while(re.next())
        			{
        					System.out.println("Codigo: " + re.getInt(1) + "Id_Orga: " + re.getInt(2) + "Raza: " + re.getInt(3) + " Color: "+ re.getString(4) + " Nombre: "+ re.getString(5) + " Descip: "+ re.getString(6));
        					infoPagePet[i] = new InfoPagePet(re.getInt(1), re.getInt(2), re.getInt(3), re.getString(4), re.getString(5), re.getString(7), re.getString(6));
        					i++;
        			}
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}*/
                InfoPagePet[] infoPagePet = new InfoPagePet[1];
                infoPagePet[0] = new InfoPagePet(0, 0, 3, "", "Firulais", "Calle 90° A-32", "El es una severa mascota, le gusta comer y ducharse en las mañanas.");
                frame.add(pa, BorderLayout.WEST);
                frame.add(new MainPanelPets(infoPagePet), BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(true);
                frame.setSize(new Dimension(1000, 600));
            }   
        });     
    }
}
