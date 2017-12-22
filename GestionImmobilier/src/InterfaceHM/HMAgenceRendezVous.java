package InterfaceHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;

import GestionPersonne.Client;
import GestionPersonne.EmployeeAgence;
import Outils.Adresse;
import javax.swing.event.ListSelectionListener;

import GestionAgence.RendezVous;
import GestionBien.Bien;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class HMAgenceRendezVous extends javax.swing.JScrollPane {
	private ArrayList<RendezVous> listRendezVous;	
	private ArrayList<Bien> biens;	
	private ArrayList<Client> clients;	
	private ArrayList<EmployeeAgence> employeesAgence;	
	
	private DefaultListModel<String> modRDVs;  
	
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel pDetailsMeeting;
    private JLabel lMeetings;
    private JList listMeetings;
    private JButton bAddMeeting;
    private JButton btnNewButton_2;
    private JLabel lblNewLabel_12;
    private JPanel pMeetingDate;
    private JLabel lblNewLabel_13;
    private JFormattedTextField formattedTextField;
    private JPanel pEmployee;
    private JLabel lEmployee;
    private JComboBox comboBox;
    private JPanel pDescription;
    private JLabel lDescriptionMeeting;
    private JTextArea textArea;
    private JPanel pClient;
    private JLabel lClient;
    private JComboBox comboBox_1;
    private JPanel pPropertyMeeting;
    private JLabel lPropertyMeeting;
    private JComboBox comboBox_2;
    private JButton bEnregistrerRDV;
    private JPanel pTitle;
    private JLabel lTitle;
    private JTextField textField;
	
	public HMAgenceRendezVous() {
		
		modRDVs = new DefaultListModel<String>();
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				actionVisible();
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
				actionHide();
			}
		});
		initComponents();	
	}
	
	private void actionVisible() {
		//charger etat
		try {
        	loadRDVs();
        }
        catch (Exception e) {
        	 final JFrame parent = new JFrame();
        	 JOptionPane.showMessageDialog(parent, "Pas possible d ouvrir le fichier "+e.getMessage());
        	 //System.exit(1);
        }
    	
    	reloadClients();
    	reloadEmployees();
		refreshRDVList();
		reloadBiens();
		
	}
	private void actionHide() {
		//enregistrer etat
		try {
			saveRDVs();
		} catch (Exception e){
			final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "Pas possible de modifier le fichier "+e.getMessage());
		}
		
	}
	private  void actionAjouter(ActionEvent arg0) {
		modRDVs.addElement("<<Nouveau>>");
		clearRDVDetails();
		listMeetings.setSelectedIndex(listMeetings.getLastVisibleIndex()+1);
	}
	private void actionSupprimer(ActionEvent arg0) {
		if(listMeetings.getSelectedIndex()!=-1) {
			//remove from employees list
			listRendezVous.remove(listMeetings.getSelectedIndex());
			//remove from swing element
			modRDVs.removeElementAt(listMeetings.getSelectedIndex());
		}
	}
	private void actionChoisirAutre(ListSelectionEvent e) {
		try {
			RendezVous rdv = listRendezVous.get(listMeetings.getSelectedIndex());
			formattedTextField.setText(rdv.getDate().toString());
			reloadEmployees();
			reloadClients();
			reloadBiens();
			textArea.setText(rdv.getDescription());
		} catch (IndexOutOfBoundsException ex){
			System.out.println("new entry");
		}		
	}
	private void reloadBiens() {
		// TODO load data, delete items, add all items in reloaded list
	}

	private void reloadClients() {
		try {
			loadClients();
		} catch (Exception e) {
			System.out.println("couldnt load any clients");
			e.printStackTrace();
		}
		comboBox_1.removeAllItems();
		for(Client c: clients)
			comboBox_1.addItem(c.getPrenom()+", "+c.getNom());
		
	}

	private void reloadEmployees() {
		try {
			loadEmployees();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox.removeAllItems();
		for(EmployeeAgence e: employeesAgence)
			comboBox.addItem(e.getNom() +", "+e.getPrenom());
		
	}

	private void actionEnregistrer(ActionEvent arg0) {
		//enregistre un nouveau rdv ou le modifie
		GregorianCalendar gc = null;
		EmployeeAgence e = null;
		Bien b = null;
		Client c = null;
		try {
			String[] daymonth = formattedTextField.getText().split("\\/");
			String[] yeartime = daymonth[2].split(",");
			String[] time = yeartime[1].split("h");
			
			int day = Integer.parseInt(daymonth[0]);
			int month = Integer.parseInt(daymonth[1]);
			int year = Integer.parseInt(yeartime[0]);
			int hour = Integer.parseInt(time[0]);
			int minute = Integer.parseInt(time[1]);
			
			 gc = new GregorianCalendar(year, month, day, hour, minute);
		} catch (Exception z){
			final JFrame parent = new JFrame();
			JOptionPane.showMessageDialog(parent, "Date Format must be: dd/mm/yyyy,hhhmm");
		}
		
		String titre = textField.getText();
		String description = textArea.getText();
		try {
			//employee
			e = employeesAgence.get(comboBox.getSelectedIndex());
		} catch (Exception a) {
			System.out.println("pas d'employee");	
		}
		try {
			//Bien
			b = biens.get(comboBox_2.getSelectedIndex());
		} catch (Exception a) {
			System.out.println("pas de bien");	
		}
		try {
			c = clients.get(comboBox_1.getSelectedIndex());
		} catch (Exception s) {
			System.out.println("pas de client");
		}
		RendezVous rdv = new RendezVous(gc, description, titre, e, c, b);
		
		if(modRDVs.getElementAt(listMeetings.getSelectedIndex()).equals("<<Nouveau>>")) {
			listRendezVous.add(rdv);
			refreshRDVList();
		} else {
				listRendezVous.set(listMeetings.getSelectedIndex(), rdv);
			}
		try{
			saveRDVs();
		} catch (Exception u) {
       	 	final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "Pas possible d'enregistrer le fichier "+u.getMessage());
		}
		refreshRDVList();
		
	}	
	
	private void loadRDVs() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("RDVs.dat")) ) {
	    		listRendezVous = (ArrayList<RendezVous>)is.readObject();
	    } catch (IOException e) {
	    		listRendezVous = new ArrayList<RendezVous>();
	    		System.out.println("failed RDVs");
	    		throw new Exception("RDVs.dat");
	    		
	    }
	}
    private void saveRDVs() throws Exception{
    	try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("RDVs.dat")) ) {
    		os.writeObject(listRendezVous);
    		} catch (IOException e) {
    			throw new Exception(e.getCause());
    		}	
    }
    
	private void loadClients() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Clients.dat")) ) {
	    		clients = (ArrayList<Client>)is.readObject();
	    } catch (IOException e) {
	    		clients = new ArrayList<Client>();
	    		throw new Exception("Clients.dat");
	    		
	    }
	}	
	
	private void loadEmployees() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Employees.dat")) ) {
    		employeesAgence = (ArrayList<EmployeeAgence>)is.readObject();
	    } catch (IOException e) {
	    		employeesAgence = new ArrayList<EmployeeAgence>();
	    		throw new Exception("Employees.dat");	
	    }
	}
	    
	private void loadBiens() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Biens.dat")) ) {
    		biens = (ArrayList<Bien>)is.readObject();
	    } catch (IOException e) {
	    		biens = new ArrayList<Bien>();
	    		throw new Exception("Biens.dat");	
	    }	    
	}
    private void clearRDVDetails() {
    	formattedTextField.setText("");
    	textArea.setText("");
    	textField.setText("");
    }
    private void refreshRDVList() {
    	modRDVs.removeAllElements();
    	for (RendezVous e: listRendezVous)
    		modRDVs.addElement(e.getTitle());
    }
	

	private void initComponents() {
		panel_1 = new JPanel();
        
		this.setRowHeaderView(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
  
        panel_2 = new JPanel();
        this.setColumnHeaderView(panel_2);

        pDetailsMeeting = new JPanel();
        this.setViewportView(pDetailsMeeting);
        pDetailsMeeting.setLayout(new BoxLayout(pDetailsMeeting, BoxLayout.Y_AXIS));
        
        lMeetings = new JLabel("RendezVous");
        lMeetings.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lMeetings.setAlignmentX(0.5f);
        panel_1.add(lMeetings);
        
        listMeetings = new JList();
        listMeetings.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent arg0) {
        		actionChoisirAutre(arg0);
        	}
        });
        panel_1.add(listMeetings);
        
        bAddMeeting = new JButton("Ajouter");
        bAddMeeting.setAlignmentX(0.5f);
        panel_1.add(bAddMeeting);
        
        btnNewButton_2 = new JButton("Supprimer");
        btnNewButton_2.setAlignmentX(0.5f);
        panel_1.add(btnNewButton_2);
        
        lblNewLabel_12 = new JLabel("Details");
        lblNewLabel_12.setAlignmentX(0.5f);
        lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pDetailsMeeting.add(lblNewLabel_12);
        
        pTitle = new JPanel();
        pDetailsMeeting.add(pTitle);
        GridBagLayout gbl_pTitle = new GridBagLayout();
        gbl_pTitle.columnWidths = new int[] {100, 500};
        gbl_pTitle.rowHeights = new int[] {22};
        gbl_pTitle.columnWeights = new double[]{0.0, 0.0};
        gbl_pTitle.rowWeights = new double[]{0.0};
        pTitle.setLayout(gbl_pTitle);
        
        lTitle = new JLabel("Titre");
        lTitle.setAlignmentX(0.5f);
        GridBagConstraints gbc_lTitle = new GridBagConstraints();
        gbc_lTitle.anchor = GridBagConstraints.WEST;
        gbc_lTitle.insets = new Insets(0, 0, 0, 5);
        gbc_lTitle.gridx = 0;
        gbc_lTitle.gridy = 0;
        pTitle.add(lTitle, gbc_lTitle);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.anchor = GridBagConstraints.WEST;
        gbc_textField.gridheight = 0;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        pTitle.add(textField, gbc_textField);
        textField.setColumns(10);
        
        pMeetingDate = new JPanel();
        pDetailsMeeting.add(pMeetingDate);
        GridBagLayout gbl_pMeetingDate = new GridBagLayout();
        gbl_pMeetingDate.columnWidths = new int[] {100, 500};
        gbl_pMeetingDate.rowHeights = new int[] {22};
        gbl_pMeetingDate.columnWeights = new double[]{1.0, 0.0};
        gbl_pMeetingDate.rowWeights = new double[]{0.0};
        pMeetingDate.setLayout(gbl_pMeetingDate);
        
        lblNewLabel_13 = new JLabel("Date et Heure");
        GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
        gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_13.gridx = 0;
        gbc_lblNewLabel_13.gridy = 0;
        pMeetingDate.add(lblNewLabel_13, gbc_lblNewLabel_13);
        
        formattedTextField = new JFormattedTextField();
        GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
        gbc_formattedTextField.weightx = 1.0;
        gbc_formattedTextField.anchor = GridBagConstraints.WEST;
        gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_formattedTextField.gridx = 1;
        gbc_formattedTextField.gridy = 0;
        pMeetingDate.add(formattedTextField, gbc_formattedTextField);
        
        pEmployee = new JPanel();
        pDetailsMeeting.add(pEmployee);
        GridBagLayout gbl_pEmployee = new GridBagLayout();
        gbl_pEmployee.columnWidths = new int[] {100, 500};
        gbl_pEmployee.rowHeights = new int[] {22};
        gbl_pEmployee.columnWeights = new double[]{0.0, 1.0};
        gbl_pEmployee.rowWeights = new double[]{0.0};
        pEmployee.setLayout(gbl_pEmployee);
        
        lEmployee = new JLabel("Employ\u00E9e participant");
        GridBagConstraints gbc_lEmployee = new GridBagConstraints();
        gbc_lEmployee.anchor = GridBagConstraints.WEST;
        gbc_lEmployee.insets = new Insets(0, 0, 0, 5);
        gbc_lEmployee.gridx = 0;
        gbc_lEmployee.gridy = 0;
        pEmployee.add(lEmployee, gbc_lEmployee);
        
        comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.weightx = 1.0;
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.anchor = GridBagConstraints.WEST;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 0;
        pEmployee.add(comboBox, gbc_comboBox);
        
        pDescription = new JPanel();
        pDetailsMeeting.add(pDescription);
        GridBagLayout gbl_pDescription = new GridBagLayout();
        gbl_pDescription.columnWidths = new int[] {100, 500};
        gbl_pDescription.rowHeights = new int[]{22, 0, 0};
        gbl_pDescription.columnWeights = new double[]{1.0, 0.0};
        gbl_pDescription.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        pDescription.setLayout(gbl_pDescription);
        
        lDescriptionMeeting = new JLabel("Description");
        GridBagConstraints gbc_lDescriptionMeeting = new GridBagConstraints();
        gbc_lDescriptionMeeting.weightx = 1.0;
        gbc_lDescriptionMeeting.anchor = GridBagConstraints.WEST;
        gbc_lDescriptionMeeting.insets = new Insets(0, 0, 5, 5);
        gbc_lDescriptionMeeting.gridx = 0;
        gbc_lDescriptionMeeting.gridy = 0;
        pDescription.add(lDescriptionMeeting, gbc_lDescriptionMeeting);
        
        textArea = new JTextArea();
        GridBagConstraints gbc_textArea = new GridBagConstraints();
        gbc_textArea.weightx = 1.0;
        gbc_textArea.anchor = GridBagConstraints.WEST;
        gbc_textArea.insets = new Insets(0, 0, 0, 5);
        gbc_textArea.fill = GridBagConstraints.HORIZONTAL;
        gbc_textArea.gridx = 1;
        gbc_textArea.gridy = 0;
        pDescription.add(textArea, gbc_textArea);
        
        pClient = new JPanel();
        pDetailsMeeting.add(pClient);
        GridBagLayout gbl_pClient = new GridBagLayout();
        gbl_pClient.columnWidths = new int[] {100, 500};
        gbl_pClient.rowHeights = new int[] {22};
        gbl_pClient.columnWeights = new double[]{1.0, 0.0};
        gbl_pClient.rowWeights = new double[]{0.0};
        pClient.setLayout(gbl_pClient);
        
        lClient = new JLabel("Client participant");
        GridBagConstraints gbc_lClient = new GridBagConstraints();
        gbc_lClient.anchor = GridBagConstraints.WEST;
        gbc_lClient.insets = new Insets(0, 0, 5, 0);
        gbc_lClient.gridx = 0;
        gbc_lClient.gridy = 0;
        pClient.add(lClient, gbc_lClient);
        
        comboBox_1 = new JComboBox();
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.weightx = 1.0;
        gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1.gridx = 1;
        gbc_comboBox_1.gridy = 0;
        pClient.add(comboBox_1, gbc_comboBox_1);
        
        pPropertyMeeting = new JPanel();
        pDetailsMeeting.add(pPropertyMeeting);
        GridBagLayout gbl_pPropertyMeeting = new GridBagLayout();
        gbl_pPropertyMeeting.columnWidths = new int[] {100, 500};
        gbl_pPropertyMeeting.rowHeights = new int[] {22};
        gbl_pPropertyMeeting.columnWeights = new double[]{1.0, 0.0};
        gbl_pPropertyMeeting.rowWeights = new double[]{0.0};
        pPropertyMeeting.setLayout(gbl_pPropertyMeeting);
        
        lPropertyMeeting = new JLabel("Bien associ\u00E9");
        GridBagConstraints gbc_lPropertyMeeting = new GridBagConstraints();
        gbc_lPropertyMeeting.weightx = 1.0;
        gbc_lPropertyMeeting.insets = new Insets(0, 0, 5, 0);
        gbc_lPropertyMeeting.anchor = GridBagConstraints.NORTHWEST;
        gbc_lPropertyMeeting.gridx = 0;
        gbc_lPropertyMeeting.gridy = 0;
        pPropertyMeeting.add(lPropertyMeeting, gbc_lPropertyMeeting);
        
        comboBox_2 = new JComboBox();
        GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
        gbc_comboBox_2.weightx = 1.0;
        gbc_comboBox_2.anchor = GridBagConstraints.WEST;
        gbc_comboBox_2.insets = new Insets(0, 0, 0, 5);
        gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_2.gridx = 1;
        gbc_comboBox_2.gridy = 0;
        pPropertyMeeting.add(comboBox_2, gbc_comboBox_2);
        
        bEnregistrerRDV = new JButton("Enregistrer");
        bEnregistrerRDV.setAlignmentX(0.5f);
        pDetailsMeeting.add(bEnregistrerRDV);
		
	}
}
