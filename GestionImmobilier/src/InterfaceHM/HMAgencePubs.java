package InterfaceHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import GestionAgence.Document;
import GestionAgence.Publicite;
import GestionAgence.RendezVous;
import Outils.Adresse;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class HMAgencePubs extends javax.swing.JScrollPane {
	
	private ArrayList<Publicite> listPublicites;
	private ArrayList<Document> listTempDocs;
	private DefaultListModel<String> modPubs; 
	private DefaultListModel<String> modTempDocs; 
		
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
    private JPanel pTitle;
    private JLabel lblNewLabel;
    private JTextField textField;
    private JButton bEnregistrer;
	    
	public HMAgencePubs() {
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
		listPublicites = new ArrayList<Publicite>();
		listTempDocs = new ArrayList<Document>();
		initComponents();
		//set Pub Types
		for (Publicite.TypePub t: Publicite.TypePub.values())
			comboBox_5.addItem(t);
			

	}
	
	private void actionVisible() {
		//charger etat
		try {
        	loadPubs();
        }
        catch (Exception e) {
        	 final JFrame parent = new JFrame();
        	 JOptionPane.showMessageDialog(parent, "Pas possible d ouvrir le fichier "+e.getMessage());
        	 //System.exit(1);
        }
		refreshPubsList();
		
	}
	private void actionHide() {
		//enregistrer etat
		try {
			savePubs();
		} catch (Exception e){
			final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "Pas possible de modifier le fichier "+e.getMessage());
		}
		
	}

	private  void actionAjouter(ActionEvent arg0) {
		modPubs.addElement("<<Nouveau>>");
		clearPubDetails();
		listPubs.setSelectedIndex(listPubs.getLastVisibleIndex()+1);
	}
	private void actionSupprimer(ActionEvent arg0) {
		if(listPubs.getSelectedIndex()!=-1) {
			//remove from Pubs list
			listPublicites.remove(listPubs.getSelectedIndex());
			//remove from swing element
			modPubs.removeElementAt(listPubs.getSelectedIndex());
		}
	}
	private void actionChoisirAutre(ListSelectionEvent e) {
		try {
			Publicite p = listPublicites.get(listPubs.getSelectedIndex());
			textField.setText(p.getTitre());
			//set comboBox:
			comboBox_5.setSelectedItem(p.getType());
			chckbxNewCheckBox_1.setSelected(p.isPublie());
			modTempDocs.removeAllElements();
			for (Document doc: p.getDocs())
				modTempDocs.addElement(doc.getContenu());
		} catch (IndexOutOfBoundsException ex){
			System.out.println("new entry");
		}		
	}
	private void actionEnregistrer(ActionEvent arg0) {
		
		//enregistre une nouvelle Pub au le modifie
		if(listPubs.getSelectedIndex()!=-1) {			
			try {
				Publicite p = new Publicite((Publicite.TypePub)comboBox_5.getSelectedItem(),listTempDocs,textField.getText());
				if(modPubs.getElementAt(listPubs.getSelectedIndex()).equals("<<Nouveau>>")) {
					listPublicites.add(p);
					refreshPubsList();
				} else {
					listPublicites.set(listPubs.getSelectedIndex(), p);
				}
				
			} catch (Exception e){
				final JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, e.getMessage());
			}
			try{
			} catch (Exception e) {
	       	 	final JFrame parent = new JFrame();
	       	 	JOptionPane.showMessageDialog(parent, "Pas possible d'enregistrer le fichier "+e.getMessage());
			}
			refreshPubsList();
		} else {
			final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "Ca ne marche pas comme ca ici.Ajouter d'abord, ou choisir un a modifier.Bordel");
		}
		
	}	
	
	private void loadPubs() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Pubs.dat")) ) {
	    		listPublicites = (ArrayList<Publicite>)is.readObject();
	    } catch (IOException e) {
	    		listPublicites = new ArrayList<Publicite>();
	    		System.out.println("capute");
	    		throw new Exception("Pubs.dat");
	    		
	    }
	}
    private void savePubs() throws Exception{
    	try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Pubs.dat")) ) {
    		System.out.println(listPublicites.size()+"");
    		os.writeObject(listPublicites);
    		} catch (IOException e) {
    			throw new Exception(e.getCause());
    		}	
    }
    private void clearPubDetails() {
    	textField.setText("");
    	chckbxNewCheckBox_1.setSelected(false);
    	modTempDocs.removeAllElements();
    }
    private void refreshPubsList() {
    	modPubs.removeAllElements();
    	for (Publicite e: listPublicites)
    		modPubs.addElement(e.getTitre());


    }
	
	private void actionAjouterFichier() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String extension = "";

			int i = selectedFile.getPath().lastIndexOf('.');
			if (i > 0) {
			    extension = selectedFile.getPath().substring(i+1);
			}
			Document d = new Document(selectedFile.getAbsolutePath(), extension);
			listTempDocs.add(d);
			modTempDocs.addElement(d.toString());
			
		}
	}

	private void initComponents() {
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
        
        modPubs = new DefaultListModel();
        listPubs = new JList(modPubs);
        pListPubs.add(listPubs);
        
        baddPub = new JButton("Ajouter");
        baddPub.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		actionAjouter(arg0);
        	}
        });
        baddPub.setAlignmentX(0.5f);
        pListPubs.add(baddPub);
        
        bdelPub = new JButton("Supprimer");
        bdelPub.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		actionSupprimer(e);
        	}
        });
        bdelPub.setAlignmentX(0.5f);
        pListPubs.add(bdelPub);
        
        pDetails.setLayout(new BoxLayout(pDetails, BoxLayout.Y_AXIS));
        
        lDetailsPubs = new JLabel("Details");
        lDetailsPubs.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lDetailsPubs.setAlignmentX(0.5f);
        pDetails.add(lDetailsPubs);
        
        pTitle = new JPanel();
        pTitle.setAlignmentY(0.0f);
        pDetails.add(pTitle);
        GridBagLayout gbl_pTitle = new GridBagLayout();
        gbl_pTitle.columnWidths = new int[] {100, 500};
        gbl_pTitle.rowHeights = new int[] {0, 0};
        gbl_pTitle.columnWeights = new double[]{0.0, 1.0};
        gbl_pTitle.rowWeights = new double[]{0.0};
        pTitle.setLayout(gbl_pTitle);
        
        lblNewLabel = new JLabel("Titre");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.weightx = 1.0;
        gbc_lblNewLabel.ipadx = 1;
        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        pTitle.add(lblNewLabel, gbc_lblNewLabel);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.anchor = GridBagConstraints.WEST;
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        pTitle.add(textField, gbc_textField);
        textField.setColumns(10);
        
        pTypePub = new JPanel();
        pDetails.add(pTypePub);
        GridBagLayout gbl_pTypePub = new GridBagLayout();
        gbl_pTypePub.columnWidths = new int[] {100, 500};
        gbl_pTypePub.rowHeights = new int[] {22};
        gbl_pTypePub.columnWeights = new double[]{0.0, 1.0};
        gbl_pTypePub.rowWeights = new double[]{0.0};
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
        gbl_pPublished.rowHeights = new int[] {22};
        gbl_pPublished.columnWeights = new double[]{0.0, 0.0};
        gbl_pPublished.rowWeights = new double[]{0.0};
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
        gbl_pDocs.rowHeights = new int[] {22};
        gbl_pDocs.columnWeights = new double[]{1.0, 0.0, 0.0};
        gbl_pDocs.rowWeights = new double[]{0.0};
        pDocs.setLayout(gbl_pDocs);
        
        lDocs = new JLabel("Documents associ\u00E9s");
        GridBagConstraints gbc_lDocs = new GridBagConstraints();
        gbc_lDocs.weightx = 1.0;
        gbc_lDocs.insets = new Insets(0, 0, 5, 5);
        gbc_lDocs.fill = GridBagConstraints.BOTH;
        gbc_lDocs.gridx = 0;
        gbc_lDocs.gridy = 0;
        pDocs.add(lDocs, gbc_lDocs);
        
        modTempDocs = new DefaultListModel();
        list_2 = new JList(modTempDocs);
        GridBagConstraints gbc_list_2 = new GridBagConstraints();
        gbc_list_2.insets = new Insets(0, 0, 5, 5);
        gbc_list_2.weightx = 1.0;
        gbc_list_2.fill = GridBagConstraints.BOTH;
        gbc_list_2.gridx = 1;
        gbc_list_2.gridy = 0;
        pDocs.add(list_2, gbc_list_2);
        
        panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.insets = new Insets(0, 0, 5, 0);
        gbc_panel_3.gridy = 0;
        gbc_panel_3.fill = GridBagConstraints.BOTH;
        gbc_panel_3.gridx = 2;
        pDocs.add(panel_3, gbc_panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
        
        bAddDoc = new JButton("Ajouter");
        bAddDoc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		actionAjouterFichier();
        	}
        });
        bAddDoc.setAlignmentX(0.5f);
        panel_3.add(bAddDoc);
        
        bDelDoc = new JButton("Supprimer");
        bDelDoc.setAlignmentX(0.5f);
        panel_3.add(bDelDoc);
        
        bEnregistrer = new JButton("Enregistrer les modifications");
        bEnregistrer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		actionEnregistrer(e);
        	}
        });
        bEnregistrer.setAlignmentX(0.5f);
        pDetails.add(bEnregistrer);
		
	}
}
