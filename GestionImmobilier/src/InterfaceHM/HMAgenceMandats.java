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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;

import GestionAgence.Mandat;
import GestionAgence.Publicite;
import GestionAgence.RendezVous;
import GestionBien.Bien;
import GestionPersonne.Client;
import GestionPersonne.EmployeeAgence;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionListener;

public class HMAgenceMandats extends javax.swing.JScrollPane {
	
	private ArrayList<Mandat> mandats;	
	
	private ArrayList<Bien> biens;	
	private ArrayList<Client> clients;	
	
	private DefaultListModel<String> modMandats;  
	
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
    private JButton bSaveMandat;
	
	public HMAgenceMandats() {
		modMandats = new DefaultListModel<String>();
		initComponents();
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
		mandats = new ArrayList<Mandat>();
	}
	private void actionVisible() {
		//charger etat
		try {
        	loadMandats();
        }
        catch (Exception e) {
        	 final JFrame parent = new JFrame();
        	 JOptionPane.showMessageDialog(parent, "Pas possible d ouvrir le fichier "+e.getMessage());
        	 //System.exit(1);
        }
		reloadClients();
		reloadBiens();
		
		refreshMandatList();
		
	}	
	private void actionHide() {
		//enregistrer etat
		try {
			saveMandats();
		} catch (Exception e){
			final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "Pas possible de modifier le fichier "+e.getMessage());
		}
		
	}
	private  void actionAjouter(ActionEvent arg0) {
		modMandats.addElement("<<Nouveau>>");
		clearMandatDetails();
		listMandats.setSelectedIndex(listMandats.getLastVisibleIndex()+1);
	}
	private void actionSupprimer(ActionEvent arg0) {
		if(listMandats.getSelectedIndex()!=-1) {
			//remove from employees list
			mandats.remove(listMandats.getSelectedIndex());
			//remove from swing element
			modMandats.removeElementAt(listMandats.getSelectedIndex());
		}
	}
	private void actionChoisirAutre(ListSelectionEvent e) {
		try {
			Mandat m = mandats.get(listMandats.getSelectedIndex());
			tDateSignature.setText(m.getDateSignature().YEAR+"/"+m.getDateSignature().MONTH+"/"+m.getDateSignature().MONTH+","+m.getDateSignature().HOUR_OF_DAY+"h"+m.getDateSignature().MINUTE);
			tMandatDuree.setText(m.getDureeJours()+"");
			chkSignee.setSelected(m.isSigne());
			cMandatBien.setSelectedItem(m.getBien());
			cClientMandat.setSelectedItem(m.getClient());
		} catch (IndexOutOfBoundsException ex){
			System.out.println("new entry");
		}		
	}
	private void reloadBiens() {
		// load data, delete items, add all items in reloaded list
		try {
			loadBiens();
		} catch (Exception e) {
			System.out.println("couldnt load any biens");
			e.printStackTrace();			
		}
		cMandatBien.removeAllItems();
		for(Bien b: biens)
			cMandatBien.addItem(b);
	}

	private void reloadClients() {
		try {
			loadClients();
		} catch (Exception e) {
			System.out.println("couldnt load any clients");
			e.printStackTrace();
		}
		cClientMandat.removeAllItems();
		for(Client c: clients)
			cClientMandat.addItem(c.getPrenom()+", "+c.getNom());
		
	}

	private void actionEnregistrer(ActionEvent arg0) {
		//enregistre un nouveau rdv ou le modifie
		GregorianCalendar gc = null;
		Bien b = null;
		Client c = null;
		try {
			String[] daymonth = tDateSignature.getText().split("\\/");
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
		int duree = -1;
		try {
			duree = Integer.parseInt(tMandatDuree.getText());
		} catch (Exception e) {
			//TODO Throw exception
		}
		
		boolean signe = chkSignee.isSelected();
		try {
			//Bien
			b = biens.get(cMandatBien.getSelectedIndex());
		} catch (Exception a) {
			System.out.println("pas de bien");	
		}
		try {
			c = clients.get(cClientMandat.getSelectedIndex());
		} catch (Exception s) {
			System.out.println("pas de client");
		}
		Mandat m = new Mandat(gc, duree,signe, duree, b, c);
		
		if(modMandats.getElementAt(listMandats.getSelectedIndex()).equals("<<Nouveau>>")) {
			mandats.add(m);
			refreshMandatList();
		} else {
				mandats.set(listMandats.getSelectedIndex(), m);
			}
		try{
			saveMandats();
		} catch (Exception u) {
       	 	final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "Pas possible d'enregistrer le fichier "+u.getMessage());
		}
		refreshMandatList();
		
	}	
	
	private void loadMandats() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Mandats.dat")) ) {
	    		mandats = (ArrayList<Mandat>)is.readObject();
	    } catch (IOException e) {
	    		mandats = new ArrayList<Mandat>();
	    		System.out.println("failed Mandats");
	    		throw new Exception("Mandats.dat");
	    		
	    }
	}
    private void saveMandats() throws Exception{
    	try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Mandats.dat")) ) {
    		os.writeObject(mandats);
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
	    
	private void loadBiens() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Biens.dat")) ) {
    		biens = (ArrayList<Bien>)is.readObject();
	    } catch (IOException e) {
	    		biens = new ArrayList<Bien>();
	    		throw new Exception("Biens.dat");	
	    }	    
	}
    private void clearMandatDetails() {
    	//TODO
    }
    private void refreshMandatList() {
    	modMandats.removeAllElements();
    	for (Mandat m: mandats)
    		modMandats.addElement(m.getBien().getId()+"_"+m.getClient().getNom());
    }

	private void initComponents() {
        pListMandats = new JPanel();
        this.setRowHeaderView(pListMandats);
        pListMandats.setLayout(new BoxLayout(pListMandats, BoxLayout.Y_AXIS));
        
        lListMandats = new JLabel("Mandats");
        lListMandats.setAlignmentX(0.5f);
        lListMandats.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pListMandats.add(lListMandats);
        
        listMandats = new JList();
        listMandats.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent arg0) {
        		actionChoisirAutre(arg0);
        	}
        });
        pListMandats.add(listMandats);
        
        bAjouterMandat = new JButton("Ajouter");
        bAjouterMandat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		actionAjouter(arg0);
        	}
        });
        bAjouterMandat.setAlignmentX(0.5f);
        pListMandats.add(bAjouterMandat);
        
        bSupprimerMandat = new JButton("Supprimer");
        bSupprimerMandat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		actionSupprimer(e);
        	}
        });
        bSupprimerMandat.setAlignmentX(0.5f);
        pListMandats.add(bSupprimerMandat);
        
        pPlaceholder = new JPanel();
        this.setColumnHeaderView(pPlaceholder);
        
        pDetailsMandats = new JPanel();
        this.setViewportView(pDetailsMandats);
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
        
        lMandatDuree = new JLabel("Dur\u00E9e en mois");
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
        
        bSaveMandat = new JButton("Enregistrer modifications");
        bSaveMandat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		actionEnregistrer(e);
        	}
        });
        bSaveMandat.setAlignmentX(0.5f);
        pDetailsMandats.add(bSaveMandat);
	}
}
