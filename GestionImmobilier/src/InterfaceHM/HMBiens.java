package InterfaceHM;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import GestionBien.Bien;
import GestionPersonne.Client;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

public class HMBiens extends javax.swing.JScrollPane{
	private ArrayList<Bien> listBiens;	
    private JTabbedPane tabbedPane;
    private JScrollPane panelMaison;
    private JScrollPane panelAppart;
    private JScrollPane panelTerrain;
    
    
	public HMBiens() {
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        this.setViewportView(tabbedPane);    

        //TAB MAISONS           
        panelMaison = new HMBiensMaison();
        tabbedPane.addTab("Maisons", null, panelMaison, null);
       
        
        //TAB APPARTEMENT
        panelAppart = new HMBiensAppartement();
        tabbedPane.addTab("Appartements", null, panelAppart, null);
        
        //TAB TERRAIN
        panelTerrain = new HMBiensTerrain();
        tabbedPane.addTab("Terrains", null, panelTerrain, null); 
	        
	       
	}
}
