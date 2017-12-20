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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import GestionAgence.Publicite;

public class HMAgencePubs extends javax.swing.JScrollPane {
	
	private ArrayList<Publicite> listPublicites;
		
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
	    
	public HMAgencePubs() {
		pListPubs = new JPanel();
        this.setRowHeaderView(pListPubs);
        
        pPlaceholderPubs = new JPanel();
        this.setColumnHeaderView(pPlaceholderPubs);      
        pDetails = new JPanel();
        this.setViewportView(pDetails);
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
