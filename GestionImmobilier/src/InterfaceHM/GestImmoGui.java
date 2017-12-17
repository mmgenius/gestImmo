package InterfaceHM;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

import GestionAgence.Publicite;
import GestionAgence.RendezVous;
import GestionBien.Bien;
import GestionPersonne.Client;
import GestionPersonne.EmployeeAgence;
import Outils.Adresse;

import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastian-andreas.si
 */
public class GestImmoGui extends javax.swing.JFrame {
	private ArrayList<EmployeeAgence> listEmployees;
	private ArrayList<Client> listClients;
	private ArrayList<Bien> listBiens;
	private ArrayList<Publicite> listPublicites;
	private ArrayList<RendezVous> listRendezVous;
	
	private DefaultListModel<String> modEmployees;
    /**
     * Creates new form GestImmoGui
     */
    public GestImmoGui() {

    	setResizable(false);
    	setTitle("Marvelous Immo Gestion");
        initComponents();
        try {
        	loadData();
        }
        catch (Exception e) {
        	 final JFrame parent = new JFrame();
        	 JOptionPane.showMessageDialog(parent, "Pas possible d ouvrir le fichier "+e.getMessage());
        	 //System.exit(1);
        }
    }
    
    private void loadData() throws Exception{
    	//load Employees
    	loadEmployees();
    }                
    private void loadEmployees() throws Exception{
    	try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Employees.dat")) ) {
    		listEmployees = (ArrayList<EmployeeAgence>)is.readObject();
    	} catch (IOException e) {
    		listEmployees = new ArrayList<EmployeeAgence>();
    		System.out.println("capute");
    		throw new Exception("Employees.dat");
    		
    	}
    }
    private void saveEmployees() throws Exception{
    	try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Employees.dat")) ) {
    		os.writeObject(listEmployees);
    		} catch (IOException e) {
    			throw new Exception(e.getCause());
    		}	
    }
    private void clearEmployeeDetails() {
    	textField.setText("");
    	textField_1.setText("");
    	textField_2.setText("");
    	textField_3.setText("");
    	textField_4.setText("");
    	textField_5.setText("");
    }
    private void refreshEmployeesList() {
    	modEmployees.removeAllElements();
    	for (EmployeeAgence e: listEmployees)
    		modEmployees.addElement(e.getNom()+" "+e.getPrenom());


    }
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        desktopPane.setLayout(new BoxLayout(desktopPane, BoxLayout.Y_AXIS));

        jTabbedPane2.addTab("Agence", jScrollPane1);
        
        tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
        jScrollPane1.setViewportView(tabbedPane_1);
        
        scrollPane_3 = new JScrollPane();
        tabbedPane_1.addTab("Rendez-Vous", null, scrollPane_3, null);
        
        panel_1 = new JPanel();
        scrollPane_3.setRowHeaderView(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
        
        lMeetings = new JLabel("RendezVous");
        lMeetings.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lMeetings.setAlignmentX(0.5f);
        panel_1.add(lMeetings);
        
        listMeetings = new JList();
        panel_1.add(listMeetings);
        
        bAddMeeting = new JButton("Ajouter");
        bAddMeeting.setAlignmentX(0.5f);
        panel_1.add(bAddMeeting);
        
        btnNewButton_2 = new JButton("Supprimer");
        btnNewButton_2.setAlignmentX(0.5f);
        panel_1.add(btnNewButton_2);
        
        panel_2 = new JPanel();
        scrollPane_3.setColumnHeaderView(panel_2);
        
        pDetailsMeeting = new JPanel();
        scrollPane_3.setViewportView(pDetailsMeeting);
        pDetailsMeeting.setLayout(new BoxLayout(pDetailsMeeting, BoxLayout.Y_AXIS));
        
        lblNewLabel_12 = new JLabel("Details");
        lblNewLabel_12.setAlignmentX(0.5f);
        lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pDetailsMeeting.add(lblNewLabel_12);
        
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
        
        scrollPane_4 = new JScrollPane();
        tabbedPane_1.addTab("Mandats", null, scrollPane_4, null);
        
        pListMandats = new JPanel();
        scrollPane_4.setRowHeaderView(pListMandats);
        pListMandats.setLayout(new BoxLayout(pListMandats, BoxLayout.Y_AXIS));
        
        lListMandats = new JLabel("Mandats");
        lListMandats.setAlignmentX(0.5f);
        lListMandats.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pListMandats.add(lListMandats);
        
        listMandats = new JList();
        pListMandats.add(listMandats);
        
        bAjouterMandat = new JButton("Ajouter");
        bAjouterMandat.setAlignmentX(0.5f);
        pListMandats.add(bAjouterMandat);
        
        bSupprimerMandat = new JButton("Supprimer");
        bSupprimerMandat.setAlignmentX(0.5f);
        pListMandats.add(bSupprimerMandat);
        
        pPlaceholder = new JPanel();
        scrollPane_4.setColumnHeaderView(pPlaceholder);
        
        pDetailsMandats = new JPanel();
        scrollPane_4.setViewportView(pDetailsMandats);
        pDetailsMandats.setLayout(new BoxLayout(pDetailsMandats, BoxLayout.Y_AXIS));
        
        lMandatDetails = new JLabel("Details");
        lMandatDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lMandatDetails.setAlignmentX(0.5f);
        pDetailsMandats.add(lMandatDetails);
        
        pMandatDateSignature = new JPanel();
        pDetailsMandats.add(pMandatDateSignature);
        GridBagLayout gbl_pMandatDateSignature = new GridBagLayout();
        gbl_pMandatDateSignature.columnWidths = new int[] {100, 500};
        gbl_pMandatDateSignature.rowHeights = new int[] {22};
        gbl_pMandatDateSignature.columnWeights = new double[]{1.0, 0.0};
        gbl_pMandatDateSignature.rowWeights = new double[]{0.0};
        pMandatDateSignature.setLayout(gbl_pMandatDateSignature);
        
        lDateSignatureMandat = new JLabel("Date de Signature");
        GridBagConstraints gbc_lDateSignatureMandat = new GridBagConstraints();
        gbc_lDateSignatureMandat.anchor = GridBagConstraints.WEST;
        gbc_lDateSignatureMandat.insets = new Insets(0, 0, 5, 0);
        gbc_lDateSignatureMandat.gridx = 0;
        gbc_lDateSignatureMandat.gridy = 0;
        pMandatDateSignature.add(lDateSignatureMandat, gbc_lDateSignatureMandat);
        
        tDateSignature = new JTextField();
        GridBagConstraints gbc_tDateSignature = new GridBagConstraints();
        gbc_tDateSignature.weightx = 1.0;
        gbc_tDateSignature.anchor = GridBagConstraints.WEST;
        gbc_tDateSignature.fill = GridBagConstraints.HORIZONTAL;
        gbc_tDateSignature.gridx = 1;
        gbc_tDateSignature.gridy = 0;
        pMandatDateSignature.add(tDateSignature, gbc_tDateSignature);
        tDateSignature.setColumns(10);
        
        pMandatDuree = new JPanel();
        pDetailsMandats.add(pMandatDuree);
        GridBagLayout gbl_pMandatDuree = new GridBagLayout();
        gbl_pMandatDuree.columnWidths = new int[] {100, 500};
        gbl_pMandatDuree.rowHeights = new int[] {22};
        gbl_pMandatDuree.columnWeights = new double[]{1.0, 0.0};
        gbl_pMandatDuree.rowWeights = new double[]{0.0};
        pMandatDuree.setLayout(gbl_pMandatDuree);
        
        lMandatDuree = new JLabel("New label");
        GridBagConstraints gbc_lMandatDuree = new GridBagConstraints();
        gbc_lMandatDuree.anchor = GridBagConstraints.WEST;
        gbc_lMandatDuree.insets = new Insets(0, 0, 5, 0);
        gbc_lMandatDuree.gridx = 0;
        gbc_lMandatDuree.gridy = 0;
        pMandatDuree.add(lMandatDuree, gbc_lMandatDuree);
        
        tMandatDuree = new JTextField();
        GridBagConstraints gbc_tMandatDuree = new GridBagConstraints();
        gbc_tMandatDuree.weightx = 1.0;
        gbc_tMandatDuree.fill = GridBagConstraints.HORIZONTAL;
        gbc_tMandatDuree.gridx = 1;
        gbc_tMandatDuree.gridy = 0;
        pMandatDuree.add(tMandatDuree, gbc_tMandatDuree);
        tMandatDuree.setColumns(10);
        
        pMandatSigne = new JPanel();
        pDetailsMandats.add(pMandatSigne);
        GridBagLayout gbl_pMandatSigne = new GridBagLayout();
        gbl_pMandatSigne.columnWidths = new int[] {100, 500};
        gbl_pMandatSigne.rowHeights = new int[] {22};
        gbl_pMandatSigne.columnWeights = new double[]{0.0, 0.0};
        gbl_pMandatSigne.rowWeights = new double[]{0.0};
        pMandatSigne.setLayout(gbl_pMandatSigne);
        
        lSignee = new JLabel("Sign\u00E9e?");
        GridBagConstraints gbc_lSignee = new GridBagConstraints();
        gbc_lSignee.weightx = 1.0;
        gbc_lSignee.anchor = GridBagConstraints.WEST;
        gbc_lSignee.insets = new Insets(0, 0, 5, 0);
        gbc_lSignee.gridx = 0;
        gbc_lSignee.gridy = 0;
        pMandatSigne.add(lSignee, gbc_lSignee);
        
        chkSignee = new JCheckBox("");
        GridBagConstraints gbc_chkSignee = new GridBagConstraints();
        gbc_chkSignee.anchor = GridBagConstraints.WEST;
        gbc_chkSignee.weightx = 1.0;
        gbc_chkSignee.gridx = 1;
        gbc_chkSignee.gridy = 0;
        pMandatSigne.add(chkSignee, gbc_chkSignee);
        
        pMandatBien = new JPanel();
        pDetailsMandats.add(pMandatBien);
        GridBagLayout gbl_pMandatBien = new GridBagLayout();
        gbl_pMandatBien.columnWidths = new int[] {100, 500};
        gbl_pMandatBien.rowHeights = new int[] {22};
        gbl_pMandatBien.columnWeights = new double[]{1.0, 0.0};
        gbl_pMandatBien.rowWeights = new double[]{0.0};
        pMandatBien.setLayout(gbl_pMandatBien);
        
        lMandatBien = new JLabel("Bien");
        GridBagConstraints gbc_lMandatBien = new GridBagConstraints();
        gbc_lMandatBien.weightx = 1.0;
        gbc_lMandatBien.anchor = GridBagConstraints.WEST;
        gbc_lMandatBien.insets = new Insets(0, 0, 5, 0);
        gbc_lMandatBien.gridx = 0;
        gbc_lMandatBien.gridy = 0;
        pMandatBien.add(lMandatBien, gbc_lMandatBien);
        
        cMandatBien = new JComboBox();
        GridBagConstraints gbc_cMandatBien = new GridBagConstraints();
        gbc_cMandatBien.anchor = GridBagConstraints.WEST;
        gbc_cMandatBien.weightx = 1.0;
        gbc_cMandatBien.fill = GridBagConstraints.HORIZONTAL;
        gbc_cMandatBien.gridx = 1;
        gbc_cMandatBien.gridy = 0;
        pMandatBien.add(cMandatBien, gbc_cMandatBien);
        
        pMandatClient = new JPanel();
        pDetailsMandats.add(pMandatClient);
        GridBagLayout gbl_pMandatClient = new GridBagLayout();
        gbl_pMandatClient.columnWidths = new int[] {100, 500};
        gbl_pMandatClient.rowHeights = new int[] {22};
        gbl_pMandatClient.columnWeights = new double[]{1.0, 0.0};
        gbl_pMandatClient.rowWeights = new double[]{0.0};
        pMandatClient.setLayout(gbl_pMandatClient);
        
        lClientMandat = new JLabel("Client");
        GridBagConstraints gbc_lClientMandat = new GridBagConstraints();
        gbc_lClientMandat.anchor = GridBagConstraints.WEST;
        gbc_lClientMandat.weightx = 1.0;
        gbc_lClientMandat.insets = new Insets(0, 0, 5, 0);
        gbc_lClientMandat.gridx = 0;
        gbc_lClientMandat.gridy = 0;
        pMandatClient.add(lClientMandat, gbc_lClientMandat);
        
        cClientMandat = new JComboBox();
        GridBagConstraints gbc_cClientMandat = new GridBagConstraints();
        gbc_cClientMandat.weightx = 1.0;
        gbc_cClientMandat.fill = GridBagConstraints.HORIZONTAL;
        gbc_cClientMandat.gridx = 1;
        gbc_cClientMandat.gridy = 0;
        pMandatClient.add(cClientMandat, gbc_cClientMandat);
        
        bSaveMandat = new JButton("Enregistrer");
        bSaveMandat.setAlignmentX(0.5f);
        pDetailsMandats.add(bSaveMandat);
        
        scrollPane_5 = new JScrollPane();
        tabbedPane_1.addTab("Publicit\u00E9s", null, scrollPane_5, null);
        
        pListPubs = new JPanel();
        scrollPane_5.setRowHeaderView(pListPubs);
        pListPubs.setLayout(new BoxLayout(pListPubs, BoxLayout.Y_AXIS));
        
        lPubsList = new JLabel("Publicit\u00E9s");
        lPubsList.setAlignmentX(0.5f);
        lPubsList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pListPubs.add(lPubsList);
        
        listPubs = new JList();
        pListPubs.add(listPubs);
        
        baddPub = new JButton("Ajouter");
        baddPub.setAlignmentX(0.5f);
        pListPubs.add(baddPub);
        
        bdelPub = new JButton("New button");
        bdelPub.setAlignmentX(0.5f);
        pListPubs.add(bdelPub);
        
        pPlaceholderPubs = new JPanel();
        scrollPane_5.setColumnHeaderView(pPlaceholderPubs);
        
        pDetails = new JPanel();
        scrollPane_5.setViewportView(pDetails);
        pDetails.setLayout(new BoxLayout(pDetails, BoxLayout.Y_AXIS));
        
        lDetailsPubs = new JLabel("Details");
        lDetailsPubs.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lDetailsPubs.setAlignmentX(0.5f);
        pDetails.add(lDetailsPubs);
        
        pTypePub = new JPanel();
        pDetails.add(pTypePub);
        GridBagLayout gbl_pTypePub = new GridBagLayout();
        gbl_pTypePub.columnWidths = new int[] {100, 500};
        gbl_pTypePub.rowHeights = new int[]{0, 0};
        gbl_pTypePub.columnWeights = new double[]{0.0, 1.0};
        gbl_pTypePub.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pTypePub.setLayout(gbl_pTypePub);
        
        lblNewLabel_18 = new JLabel("Type de Pub");
        GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
        gbc_lblNewLabel_18.weightx = 1.0;
        gbc_lblNewLabel_18.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_18.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_18.gridx = 0;
        gbc_lblNewLabel_18.gridy = 0;
        pTypePub.add(lblNewLabel_18, gbc_lblNewLabel_18);
        
        comboBox_5 = new JComboBox();
        GridBagConstraints gbc_comboBox_5 = new GridBagConstraints();
        gbc_comboBox_5.weightx = 1.0;
        gbc_comboBox_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_5.gridx = 1;
        gbc_comboBox_5.gridy = 0;
        pTypePub.add(comboBox_5, gbc_comboBox_5);
        
        pPublished = new JPanel();
        pDetails.add(pPublished);
        GridBagLayout gbl_pPublished = new GridBagLayout();
        gbl_pPublished.columnWidths = new int[] {100, 500};
        gbl_pPublished.rowHeights = new int[]{25, 0};
        gbl_pPublished.columnWeights = new double[]{0.0, 0.0};
        gbl_pPublished.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pPublished.setLayout(gbl_pPublished);
        
        lPublished = new JLabel("Publi\u00E9?");
        GridBagConstraints gbc_lPublished = new GridBagConstraints();
        gbc_lPublished.weightx = 1.0;
        gbc_lPublished.fill = GridBagConstraints.BOTH;
        gbc_lPublished.insets = new Insets(0, 0, 0, 5);
        gbc_lPublished.gridx = 0;
        gbc_lPublished.gridy = 0;
        pPublished.add(lPublished, gbc_lPublished);
        
        chckbxNewCheckBox_1 = new JCheckBox("");
        GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
        gbc_chckbxNewCheckBox_1.weightx = 1.0;
        gbc_chckbxNewCheckBox_1.fill = GridBagConstraints.BOTH;
        gbc_chckbxNewCheckBox_1.gridx = 1;
        gbc_chckbxNewCheckBox_1.gridy = 0;
        pPublished.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);
        
        separator_1 = new JSeparator();
        pDetails.add(separator_1);
        
        pDocs = new JPanel();
        pDetails.add(pDocs);
        GridBagLayout gbl_pDocs = new GridBagLayout();
        gbl_pDocs.columnWidths = new int[] {100, 400, 100};
        gbl_pDocs.rowHeights = new int[] {0, 22, 0};
        gbl_pDocs.columnWeights = new double[]{1.0, 0.0, 0.0};
        gbl_pDocs.rowWeights = new double[]{0.0, 1.0, 1.0};
        pDocs.setLayout(gbl_pDocs);
        
        lDocs = new JLabel("Documents associ\u00E9s");
        GridBagConstraints gbc_lDocs = new GridBagConstraints();
        gbc_lDocs.weightx = 1.0;
        gbc_lDocs.insets = new Insets(0, 0, 5, 5);
        gbc_lDocs.fill = GridBagConstraints.BOTH;
        gbc_lDocs.gridx = 0;
        gbc_lDocs.gridy = 1;
        pDocs.add(lDocs, gbc_lDocs);
        
        list_2 = new JList();
        GridBagConstraints gbc_list_2 = new GridBagConstraints();
        gbc_list_2.insets = new Insets(0, 0, 5, 5);
        gbc_list_2.weightx = 1.0;
        gbc_list_2.fill = GridBagConstraints.BOTH;
        gbc_list_2.gridx = 1;
        gbc_list_2.gridy = 1;
        pDocs.add(list_2, gbc_list_2);
        
        panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.insets = new Insets(0, 0, 5, 0);
        gbc_panel_3.gridy = 1;
        gbc_panel_3.fill = GridBagConstraints.BOTH;
        gbc_panel_3.gridx = 2;
        pDocs.add(panel_3, gbc_panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
        
        bAddDoc = new JButton("Ajouter");
        bAddDoc.setAlignmentX(0.5f);
        panel_3.add(bAddDoc);
        
        bDelDoc = new JButton("Supprimer");
        bDelDoc.setAlignmentX(0.5f);
        panel_3.add(bDelDoc);
        jTabbedPane2.addTab("Biens", jScrollPane2);
        jTabbedPane2.addTab("Ventes", jScrollPane4);

        desktopPane.add(jTabbedPane2);
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabbedPane2.addTab("Personnes", jScrollPane3);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        jScrollPane3.setViewportView(tabbedPane);
   
        
        
        //TAB EMPLOYEES     
        ScrollEmployees = new JScrollPane();
        tabbedPane.addTab("Employ\u00E9es", null, ScrollEmployees, null);
        
        ListEmployee = new JPanel();
        ScrollEmployees.setRowHeaderView(ListEmployee);
        ListEmployee.setLayout(new BoxLayout(ListEmployee, BoxLayout.Y_AXIS));
        
        lEmployees = new JLabel("Employ\u00E9es");
        lEmployees.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lEmployees.setAlignmentX(Component.CENTER_ALIGNMENT);
        lEmployees.setAlignmentY(Component.TOP_ALIGNMENT);
        ListEmployee.add(lEmployees);
		
        modEmployees= new DefaultListModel();
		liEmployee = new JList(modEmployees);
		liEmployee.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					EmployeeAgence a = listEmployees.get(liEmployee.getSelectedIndex());
					textField.setText(a.getNom());
					textField_1.setText(a.getPrenom());
					textField_2.setText(a.getEmail());
					textField_3.setText(a.getAdresse().toString());
					textField_4.setText(a.getTel());
					textField_5.setText(a.getMatricule()+"");
					ArrayList<String[]> cal = new ArrayList<>();
					DefaultTableModel t = new DefaultTableModel();
					for (RendezVous r : a.getCalendrier())
						t.addRow(r.toArray());
					calendar.setModel(t);
				} catch (IndexOutOfBoundsException ex){
					System.out.println("new entry");
				}				
			}
		});
        liEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListEmployee.add(liEmployee);
        
        CreateEmployee = new JButton("Ajouter");
        CreateEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		modEmployees.addElement("<<Nouveau>>");
        		clearEmployeeDetails();
        		liEmployee.setSelectedIndex(liEmployee.getLastVisibleIndex()+1);
        	}
        });
        CreateEmployee.setAlignmentX(Component.CENTER_ALIGNMENT);
        ListEmployee.add(CreateEmployee);
        
        Del = new JButton("Supprimer");
        Del.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(liEmployee.getSelectedIndex()!=-1) {
        			modEmployees.removeElementAt(liEmployee.getSelectedIndex());
        			listEmployees.remove(liEmployee.getSelectedIndex());
        		}
        	}
        });
        Del.setAlignmentX(Component.CENTER_ALIGNMENT);
        ListEmployee.add(Del);
        
        placeholder = new JPanel();
        ScrollEmployees.setColumnHeaderView(placeholder);
        
        DetailsCleints = new JPanel();
        ScrollEmployees.setViewportView(DetailsCleints);
        DetailsCleints.setLayout(new BoxLayout(DetailsCleints, BoxLayout.Y_AXIS));
        
        lblNewLabel_1 = new JLabel("Details");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setAlignmentX(0.5f);
        DetailsCleints.add(lblNewLabel_1);
        
        JPanel Name = new JPanel();
        DetailsCleints.add(Name);
        GridBagLayout gbl_Name = new GridBagLayout();
        gbl_Name.columnWidths = new int[] {100, 500};
        gbl_Name.rowHeights = new int[]{22, 0};
        gbl_Name.columnWeights = new double[]{0.0, 0.0};
        gbl_Name.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        Name.setLayout(gbl_Name);
        
        lblNewLabel_3 = new JLabel("Nom");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 0;
        Name.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        Name.add(textField, gbc_textField);
        textField.setColumns(10);
        
        FirstName = new JPanel();
        DetailsCleints.add(FirstName);
        GridBagLayout gbl_FirstName = new GridBagLayout();
        gbl_FirstName.columnWidths = new int[] {100, 500};
        gbl_FirstName.rowHeights = new int[]{22, 0};
        gbl_FirstName.columnWeights = new double[]{0.0, 0.0};
        gbl_FirstName.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        FirstName.setLayout(gbl_FirstName);
        
        lblNewLabel_2 = new JLabel("Prenom");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 0;
        FirstName.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.anchor = GridBagConstraints.WEST;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 0;
        FirstName.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
        Email = new JPanel();
        DetailsCleints.add(Email);
        GridBagLayout gbl_Email = new GridBagLayout();
        gbl_Email.columnWidths = new int[] {100, 500};
        gbl_Email.rowHeights = new int[]{22, 0};
        gbl_Email.columnWeights = new double[]{0.0, 0.0};
        gbl_Email.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        Email.setLayout(gbl_Email);
        
        lblNewLabel_4 = new JLabel("Email");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 0;
        Email.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.anchor = GridBagConstraints.WEST;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 0;
        Email.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
        
        Adress = new JPanel();
        DetailsCleints.add(Adress);
        GridBagLayout gbl_Adress = new GridBagLayout();
        gbl_Adress.columnWidths = new int[] {100, 500};
        gbl_Adress.rowHeights = new int[]{22, 0};
        gbl_Adress.columnWeights = new double[]{0.0, 0.0};
        gbl_Adress.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        Adress.setLayout(gbl_Adress);
        
        lblNewLabel_5 = new JLabel("Adresse");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 0;
        Adress.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textField_3 = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.anchor = GridBagConstraints.WEST;
        gbc_textField_3.gridx = 1;
        gbc_textField_3.gridy = 0;
        Adress.add(textField_3, gbc_textField_3);
        textField_3.setColumns(10);
        
        Tel = new JPanel();
        DetailsCleints.add(Tel);
        GridBagLayout gbl_Tel = new GridBagLayout();
        gbl_Tel.columnWidths = new int[] {100, 500};
        gbl_Tel.rowHeights = new int[]{22, 0};
        gbl_Tel.columnWeights = new double[]{0.0, 0.0};
        gbl_Tel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        Tel.setLayout(gbl_Tel);
        
        lblNewLabel_6 = new JLabel("T\u00E9l\u00E9lphone");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 0;
        Tel.add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textField_4 = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.anchor = GridBagConstraints.WEST;
        gbc_textField_4.gridx = 1;
        gbc_textField_4.gridy = 0;
        Tel.add(textField_4, gbc_textField_4);
        textField_4.setColumns(10);
        
        Matricule = new JPanel();
        DetailsCleints.add(Matricule);
        GridBagLayout gbl_Matricule = new GridBagLayout();
        gbl_Matricule.columnWidths = new int[] {100, 500};
        gbl_Matricule.rowHeights = new int[]{22, 0};
        gbl_Matricule.columnWeights = new double[]{0.0, 0.0};
        gbl_Matricule.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        Matricule.setLayout(gbl_Matricule);
        
        lblNewLabel_7 = new JLabel("Matricule");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 0;
        Matricule.add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        textField_5 = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.anchor = GridBagConstraints.WEST;
        gbc_textField_5.gridx = 1;
        gbc_textField_5.gridy = 0;
        Matricule.add(textField_5, gbc_textField_5);
        textField_5.setColumns(10);
        
        Calendar = new JPanel();
        DetailsCleints.add(Calendar);
        GridBagLayout gbl_Calendar = new GridBagLayout();
        gbl_Calendar.columnWidths = new int[] {100, 500};
        gbl_Calendar.rowHeights = new int[]{402, 0};
        gbl_Calendar.columnWeights = new double[]{0.0, 0.0};
        gbl_Calendar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        Calendar.setLayout(gbl_Calendar);
        
        lblNewLabel_8 = new JLabel("Rendez-Vous");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 0;
        Calendar.add(lblNewLabel_8, gbc_lblNewLabel_8);
        
        scrollPane_6 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
        gbc_scrollPane_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_scrollPane_6.anchor = GridBagConstraints.WEST;
        gbc_scrollPane_6.gridx = 1;
        gbc_scrollPane_6.gridy = 0;
        Calendar.add(scrollPane_6, gbc_scrollPane_6);
        
        calendar = new JTable();
        scrollPane_6.setViewportView(calendar);
        
        JButton Save = new JButton("Enregistrer Modifications");
        Save.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.out.println("Saving...");
        		ArrayList<RendezVous> calendrier = new ArrayList<>();
        		try {
        			Adresse a = new Adresse(textField_3.getText().split("\\."));
        			int mat = Integer.parseInt(textField_5.getText());
        			EmployeeAgence e = new EmployeeAgence(a, textField_2.getText(), textField.getText(), textField_1.getText(), textField_4.getText(), calendrier, mat);
        			System.out.println(e.getEmail());
        			listEmployees.add(e);
        		} catch (Exception e){
        			final JFrame parent = new JFrame();
        			JOptionPane.showMessageDialog(parent, e.getMessage());
        		}
        		try{
        			saveEmployees();
        			System.out.println("Saved successfully");
        		} catch (Exception e) {
               	 	final JFrame parent = new JFrame();
               	 	JOptionPane.showMessageDialog(parent, "Pas possible d'enregistrer le fichier "+e.getMessage());
        		}
        		refreshEmployeesList();
        	}
        });
        DetailsCleints.add(Save);
        Save.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        //TAB CLIENTS
        scrollClients = new JScrollPane();
        tabbedPane.addTab("Clients", null, scrollClients, null);
        
        ListClient = new JPanel();
        scrollClients.setRowHeaderView(ListClient);
        ListClient.setLayout(new BoxLayout(ListClient, BoxLayout.Y_AXIS));
        
        lblNewLabel_9 = new JLabel("Clients");
        lblNewLabel_9.setAlignmentX(0.5f);
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ListClient.add(lblNewLabel_9);
        
        list_1 = new JList();
        ListClient.add(list_1);
        
        btnNewButton = new JButton("Ajouter");
        btnNewButton.setAlignmentX(0.5f);
        ListClient.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Supprimer");
        btnNewButton_1.setAlignmentX(0.5f);
        ListClient.add(btnNewButton_1);
        
        placeholder2 = new JPanel();
        scrollClients.setColumnHeaderView(placeholder2);
        
        DetailsClients = new JPanel();
        scrollClients.setViewportView(DetailsClients);
        DetailsClients.setLayout(new BoxLayout(DetailsClients, BoxLayout.Y_AXIS));
        
        lblNewLabel_10 = new JLabel("Details");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_10.setAlignmentX(0.5f);
        DetailsClients.add(lblNewLabel_10);
        
        pClientName = new JPanel();
        DetailsClients.add(pClientName);
        GridBagLayout gbl_pClientName = new GridBagLayout();
        gbl_pClientName.columnWidths = new int[] {100, 500};
        gbl_pClientName.rowHeights = new int[] {22};
        gbl_pClientName.columnWeights = new double[]{0.0, 0.0};
        gbl_pClientName.rowWeights = new double[]{0.0};
        pClientName.setLayout(gbl_pClientName);
        
        lblNewLabel_11 = new JLabel("Nom");
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_11.gridx = 0;
        gbc_lblNewLabel_11.gridy = 0;
        pClientName.add(lblNewLabel_11, gbc_lblNewLabel_11);
        
        textField_7 = new JTextField();
        GridBagConstraints gbc_textField_7 = new GridBagConstraints();
        gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_7.gridx = 1;
        gbc_textField_7.gridy = 0;
        pClientName.add(textField_7, gbc_textField_7);
        textField_7.setColumns(10);
        
        pClientFristName = new JPanel();
        DetailsClients.add(pClientFristName);
        GridBagLayout gbl_pClientFristName = new GridBagLayout();
        gbl_pClientFristName.columnWidths = new int[] {100, 500};
        gbl_pClientFristName.rowHeights = new int[]{22, 0};
        gbl_pClientFristName.columnWeights = new double[]{0.0, 0.0};
        gbl_pClientFristName.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pClientFristName.setLayout(gbl_pClientFristName);
        
        lClientFirstName = new JLabel("Prenom");
        GridBagConstraints gbc_lClientFirstName = new GridBagConstraints();
        gbc_lClientFirstName.anchor = GridBagConstraints.WEST;
        gbc_lClientFirstName.insets = new Insets(0, 0, 0, 5);
        gbc_lClientFirstName.gridx = 0;
        gbc_lClientFirstName.gridy = 0;
        pClientFristName.add(lClientFirstName, gbc_lClientFirstName);
        
        textField_12 = new JTextField();
        GridBagConstraints gbc_textField_12 = new GridBagConstraints();
        gbc_textField_12.fill = GridBagConstraints.BOTH;
        gbc_textField_12.gridx = 1;
        gbc_textField_12.gridy = 0;
        pClientFristName.add(textField_12, gbc_textField_12);
        textField_12.setColumns(10);
        
        pClientEmail = new JPanel();
        DetailsClients.add(pClientEmail);
        GridBagLayout gbl_pClientEmail = new GridBagLayout();
        gbl_pClientEmail.columnWidths = new int[] {100, 500};
        gbl_pClientEmail.rowHeights = new int[]{22, 0};
        gbl_pClientEmail.columnWeights = new double[]{0.0, 0.0};
        gbl_pClientEmail.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pClientEmail.setLayout(gbl_pClientEmail);
        
        lClientMail = new JLabel("Email");
        GridBagConstraints gbc_lClientMail = new GridBagConstraints();
        gbc_lClientMail.anchor = GridBagConstraints.WEST;
        gbc_lClientMail.insets = new Insets(0, 0, 0, 5);
        gbc_lClientMail.gridx = 0;
        gbc_lClientMail.gridy = 0;
        pClientEmail.add(lClientMail, gbc_lClientMail);
        
        textField_9 = new JTextField();
        GridBagConstraints gbc_textField_9 = new GridBagConstraints();
        gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_9.anchor = GridBagConstraints.WEST;
        gbc_textField_9.gridx = 1;
        gbc_textField_9.gridy = 0;
        pClientEmail.add(textField_9, gbc_textField_9);
        textField_9.setColumns(10);
        
        pClientAdress = new JPanel();
        DetailsClients.add(pClientAdress);
        GridBagLayout gbl_pClientAdress = new GridBagLayout();
        gbl_pClientAdress.columnWidths = new int[] {100, 500};
        gbl_pClientAdress.rowHeights = new int[]{22, 0};
        gbl_pClientAdress.columnWeights = new double[]{0.0, 0.0};
        gbl_pClientAdress.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pClientAdress.setLayout(gbl_pClientAdress);
        
        lClientAdress = new JLabel("Adresse");
        GridBagConstraints gbc_lClientAdress = new GridBagConstraints();
        gbc_lClientAdress.anchor = GridBagConstraints.WEST;
        gbc_lClientAdress.insets = new Insets(0, 0, 0, 5);
        gbc_lClientAdress.gridx = 0;
        gbc_lClientAdress.gridy = 0;
        pClientAdress.add(lClientAdress, gbc_lClientAdress);
        
        textField_10 = new JTextField();
        GridBagConstraints gbc_textField_10 = new GridBagConstraints();
        gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_10.anchor = GridBagConstraints.WEST;
        gbc_textField_10.gridx = 1;
        gbc_textField_10.gridy = 0;
        pClientAdress.add(textField_10, gbc_textField_10);
        textField_10.setColumns(10);
        
        pClientTel = new JPanel();
        DetailsClients.add(pClientTel);
        GridBagLayout gbl_pClientTel = new GridBagLayout();
        gbl_pClientTel.columnWidths = new int[] {100, 500};
        gbl_pClientTel.rowHeights = new int[]{22, 0};
        gbl_pClientTel.columnWeights = new double[]{0.0, 0.0};
        gbl_pClientTel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pClientTel.setLayout(gbl_pClientTel);
        
        lClientTel = new JLabel("T\u00E9l\u00E9phone");
        GridBagConstraints gbc_lClientTel = new GridBagConstraints();
        gbc_lClientTel.anchor = GridBagConstraints.WEST;
        gbc_lClientTel.insets = new Insets(0, 0, 0, 5);
        gbc_lClientTel.gridx = 0;
        gbc_lClientTel.gridy = 0;
        pClientTel.add(lClientTel, gbc_lClientTel);
        
        tClientTel = new JTextField();
        GridBagConstraints gbc_tClientTel = new GridBagConstraints();
        gbc_tClientTel.fill = GridBagConstraints.HORIZONTAL;
        gbc_tClientTel.anchor = GridBagConstraints.WEST;
        gbc_tClientTel.gridx = 1;
        gbc_tClientTel.gridy = 0;
        pClientTel.add(tClientTel, gbc_tClientTel);
        tClientTel.setColumns(10);
        
        pClientSiren = new JPanel();
        DetailsClients.add(pClientSiren);
        GridBagLayout gbl_pClientSiren = new GridBagLayout();
        gbl_pClientSiren.columnWidths = new int[] {100, 500};
        gbl_pClientSiren.rowHeights = new int[]{22, 0};
        gbl_pClientSiren.columnWeights = new double[]{0.0, 0.0};
        gbl_pClientSiren.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pClientSiren.setLayout(gbl_pClientSiren);
        
        lNumSiren = new JLabel("N\u00B0 Siren");
        GridBagConstraints gbc_lNumSiren = new GridBagConstraints();
        gbc_lNumSiren.anchor = GridBagConstraints.WEST;
        gbc_lNumSiren.insets = new Insets(0, 0, 0, 5);
        gbc_lNumSiren.gridx = 0;
        gbc_lNumSiren.gridy = 0;
        pClientSiren.add(lNumSiren, gbc_lNumSiren);
        
        tClientSiren = new JTextField();
        GridBagConstraints gbc_tClientSiren = new GridBagConstraints();
        gbc_tClientSiren.fill = GridBagConstraints.HORIZONTAL;
        gbc_tClientSiren.anchor = GridBagConstraints.WEST;
        gbc_tClientSiren.gridx = 1;
        gbc_tClientSiren.gridy = 0;
        pClientSiren.add(tClientSiren, gbc_tClientSiren);
        tClientSiren.setColumns(10);
        
        bClientsSave = new JButton("Enregistrer");
        bClientsSave.setAlignmentX(0.5f);
        DetailsClients.add(bClientsSave);
        
        panel = new JPanel();
        DetailsClients.add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] {100, 500};
        gbl_panel.rowHeights = new int[] {402, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0};
        gbl_panel.rowWeights = new double[]{0.0, 1.0};
        panel.setLayout(gbl_panel);

        
        
        
        
        
        //FILE MENU
        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.exit(0);
    }                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	/*
    	 * Deserialize Existent Data:
    	 * We need: 
    	 * - A list of employees
    	 * - A list of biens
    	 * - A list of Clients
    	 * 
    	 * */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestImmoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestImmoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestImmoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestImmoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestImmoGui g = new GestImmoGui();
                g.setVisible(true);
                g.refreshEmployeesList();
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private JTabbedPane tabbedPane;
    private JScrollPane ScrollEmployees;
    private JScrollPane scrollClients;
    private JScrollPane scrollPane_2;
    private JTabbedPane tabbedPane_1;
    private JScrollPane scrollPane_3;
    private JScrollPane scrollPane_4;
    private JScrollPane scrollPane_5;
    private JPanel ListEmployee;
    private JPanel placeholder;
    private JPanel DetailsCleints;
    private JLabel lEmployees;
    private JList liEmployee;
    private JLabel lblNewLabel_1;
    private JTextField textField;
    private JPanel FirstName;
    private JLabel lblNewLabel_2;
    private JTextField textField_1;
    private JLabel lblNewLabel_3;
    private JPanel Email;
    private JLabel lblNewLabel_4;
    private JTextField textField_2;
    private JPanel Adress;
    private JLabel lblNewLabel_5;
    private JTextField textField_3;
    private JPanel Tel;
    private JLabel lblNewLabel_6;
    private JTextField textField_4;
    private JPanel Matricule;
    private JLabel lblNewLabel_7;
    private JTextField textField_5;
    private JButton Del;
    private JButton CreateEmployee;
    private JPanel Calendar;
    private JLabel lblNewLabel_8;
    private JScrollPane scrollPane_6;
    private JTable calendar;
    private JPanel ListClient;
    private JPanel placeholder2;
    private JPanel DetailsClients;
    private JLabel lblNewLabel_9;
    private JList list_1;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_10;
    private JPanel pClientName;
    private JPanel pClientEmail;
    private JPanel pClientAdress;
    private JPanel pClientTel;
    private JPanel pClientSiren;
    private JLabel lblNewLabel_11;
    private JLabel lClientMail;
    private JLabel lClientAdress;
    private JLabel lClientTel;
    private JLabel lNumSiren;
    private JTextField tClientSiren;
    private JTextField textField_7;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField tClientTel;
    private JButton bClientsSave;
    private JPanel pClientFristName;
    private JLabel lClientFirstName;
    private JTextField textField_12;
    private JPanel panel;
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
    private JPanel pListMandats;
    private JPanel pPlaceholder;
    private JPanel pDetailsMandats;
    private JLabel lListMandats;
    private JList listMandats;
    private JButton bAjouterMandat;
    private JButton bSupprimerMandat;
    private JLabel lMandatDetails;
    private JPanel pMandatDateSignature;
    private JPanel pMandatDuree;
    private JPanel pMandatSigne;
    private JPanel pMandatBien;
    private JPanel pMandatClient;
    private JLabel lDateSignatureMandat;
    private JTextField tDateSignature;
    private JLabel lMandatDuree;
    private JTextField tMandatDuree;
    private JLabel lSignee;
    private JCheckBox chkSignee;
    private JLabel lMandatBien;
    private JComboBox cMandatBien;
    private JLabel lClientMandat;
    private JComboBox cClientMandat;
    private JPanel pListPubs;
    private JPanel pPlaceholderPubs;
    private JPanel pDetails;
    private JLabel lPubsList;
    private JList listPubs;
    private JButton baddPub;
    private JButton bdelPub;
    private JLabel lDetailsPubs;
    private JPanel pTypePub;
    private JPanel pPublished;
    private JPanel pDocs;
    private JLabel lblNewLabel_18;
    private JComboBox comboBox_5;
    private JLabel lPublished;
    private JCheckBox chckbxNewCheckBox_1;
    private JLabel lDocs;
    private JList list_2;
    private JPanel panel_3;
    private JButton bDelDoc;
    private JButton bAddDoc;
    private JSeparator separator_1;
    private JButton bSaveMandat;
}
