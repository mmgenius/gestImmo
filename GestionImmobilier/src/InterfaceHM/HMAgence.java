package InterfaceHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GestionAgence.Publicite;
import GestionAgence.RendezVous;

public class HMAgence extends javax.swing.JScrollPane {
	

	private ArrayList<RendezVous> listRendezVous;

    private JTabbedPane tabbedPane_1;
    private HMAgenceRendezVous panelRDV;
    private HMAgenceMandats panelMandats;
    private HMAgencePubs panelPub;
	
	public HMAgence() {
	        tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	        this.setViewportView(tabbedPane_1);
	        
	        panelRDV = new HMAgenceRendezVous();
	        tabbedPane_1.addTab("Rendez-Vous", null, panelRDV, null);
	        
	        panelMandats = new HMAgenceMandats();
	        tabbedPane_1.addTab("Mandats", null, panelMandats, null);
	        
	        //Pubs
	        panelPub = new HMAgencePubs();
	        tabbedPane_1.addTab("Publicit\u00E9s", null, panelPub, null);
	}

}
