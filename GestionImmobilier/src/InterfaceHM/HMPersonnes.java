package InterfaceHM;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GestionAgence.RendezVous;
import GestionPersonne.Client;
import GestionPersonne.EmployeeAgence;
import Outils.Adresse;

public class HMPersonnes extends javax.swing.JScrollPane {

    private JTabbedPane tabbedPane;
    private JScrollPane panelEmployee;
    private HMPersonnesClients panelClients;

  
	
    public HMPersonnes() {  
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        this.setViewportView(tabbedPane);    
        
        //TAB EMPLOYEES            
        panelEmployee = new HMPersonnesEmployees();
        tabbedPane.addTab("Employ\u00E9es", null, panelEmployee, null);
       
        
        //TAB CLIENTS
        panelClients = new HMPersonnesClients();
        tabbedPane.addTab("Clients", null, panelClients, null);
	}              
		
}
