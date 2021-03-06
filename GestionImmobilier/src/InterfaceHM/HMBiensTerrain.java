package InterfaceHM;

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

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GestionBien.Terrain;
import GestionPersonne.Client;
import Outils.Adresse;

public class HMBiensTerrain extends javax.swing.JScrollPane{
	

	private ArrayList<Terrain> terrain;	
    private DefaultListModel<String> modClients;   
	
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
	
	public HMBiensTerrain() {	
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
        	loadEmployees();
        }
        catch (Exception e) {
        	 final JFrame parent = new JFrame();
        	 JOptionPane.showMessageDialog(parent, "Pas possible d ouvrir le fichier "+e.getMessage());
        	 //System.exit(1);
        }
		refreshClientsList();
		
	}
	private void actionHide() {
		//enregistrer etat
		try {
			saveClients();
		} catch (Exception e){
			final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "Pas possible de modifier le fichier "+e.getMessage());
		}
		
	}
	private  void actionAjouter(ActionEvent arg0) {
		modClients.addElement("<<Nouveau>>");
		clearEmployeeDetails();
		list_1.setSelectedIndex(list_1.getLastVisibleIndex()+1);
	}
	private void actionSupprimer(ActionEvent arg0) {
		if(list_1.getSelectedIndex()!=-1) {
			//remove from maison list
			terrain.remove(list_1.getSelectedIndex());
			//remove from swing element
			modClients.removeElementAt(list_1.getSelectedIndex());
		}
	}
	private void actionChoisirAutre(ListSelectionEvent e) {
		try {
			Terrain c = terrain.get(list_1.getSelectedIndex());
		} catch (IndexOutOfBoundsException ex){
			System.out.println("new entry");
		}		
	}
	private void actionEnregistrer(ActionEvent arg0) {
		//enregistre un nouveau employee au le modifie
		try {
			Adresse a = new Adresse(textField_10.getText().split("\\|"));
			int mat;
			try {
				//Entreprise
				mat = Integer.parseInt(tClientSiren.getText());
			} catch (Exception e) {
				//Particulier
				mat = getNewID();
				
			}
			Terrain e = null;
			if(modClients.getElementAt(list_1.getSelectedIndex()).equals("<<Nouveau>>")) {
				terrain.add(e);
				refreshClientsList();
			} else {
				terrain.set(list_1.getSelectedIndex(), e);
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
		refreshClientsList();
		
	}	
	
	private void loadEmployees() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Terrains.dat")) ) {
	    		terrain = (ArrayList<Terrain>)is.readObject();
	    } catch (IOException e) {
	    		terrain = new ArrayList<Terrain>();
	    		System.out.println("capute");
	    		throw new Exception("Terrains.dat");
	    		
	    }
	}
    private void saveClients() throws Exception{
    	try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Terrains.dat")) ) {
    		os.writeObject(terrain);
    		} catch (IOException e) {
    			throw new Exception(e.getCause());
    		}	
    }
    private void clearEmployeeDetails() {
    	textField_7.setText("");
    	textField_12.setText("");
    	textField_9.setText("");
    	textField_10.setText("");
    	tClientTel.setText("");
    	tClientSiren.setText("");
    }
    private void refreshClientsList() {
    	modClients.removeAllElements();
    	for (Terrain e: terrain)
    		modClients.addElement(e.getId()+"");


    }
    private int getNewID() {
    	int maxID = -1;
		for (Terrain c: terrain) {
			if(maxID<c.getId())
				maxID=c.getId();
		}
		return maxID+1;
	}
    
	private void initComponents() {
		ListClient = new JPanel();
        this.setRowHeaderView(ListClient);
        ListClient.setLayout(new BoxLayout(ListClient, BoxLayout.Y_AXIS));
        
        lblNewLabel_9 = new JLabel("Clients");
        lblNewLabel_9.setAlignmentX(0.5f);
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ListClient.add(lblNewLabel_9);
        

    	modClients= new DefaultListModel();
        list_1 = new JList(modClients);
    	list_1.addListSelectionListener(new ListSelectionListener() {
    		public void valueChanged(ListSelectionEvent e) {
    			actionChoisirAutre(e);
    		}
    	});
        ListClient.add(list_1);     
        btnNewButton = new JButton("Ajouter");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		actionAjouter(arg0);
        	}
        });
        btnNewButton.setAlignmentX(0.5f);
        ListClient.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Supprimer");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		actionSupprimer(e);
        	}
        });
        btnNewButton_1.setAlignmentX(0.5f);
        ListClient.add(btnNewButton_1);
        
        placeholder2 = new JPanel();
        this.setColumnHeaderView(placeholder2);
        
        DetailsClients = new JPanel();
        this.setViewportView(DetailsClients);
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
        
        lClientFirstName = new JLabel("Orientation");
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
        bClientsSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		actionEnregistrer(e);
        	}
        });
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
		
	}


}
