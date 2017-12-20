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
	
	private ArrayList<Publicite> listPublicites;
	private ArrayList<RendezVous> listRendezVous;
	
    private JTabbedPane tabbedPane;
    private JTabbedPane tabbedPane_1;
    private JScrollPane scrollPane_3;
    private JScrollPane scrollPane_4;
    private JScrollPane scrollPane_5;
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
	
	public HMAgence() {
	        tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	        this.setViewportView(tabbedPane_1);
	        
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
	}

}
