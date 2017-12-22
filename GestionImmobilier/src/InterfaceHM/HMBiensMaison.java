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
import java.util.GregorianCalendar;

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

import GestionBien.Maison;
import Outils.Adresse;
import Outils.Date;

public class HMBiensMaison extends javax.swing.JScrollPane{
	private ArrayList<Maison> listMaisons;	
    private DefaultListModel<String> modMaisons;   
	
    private JPanel ListMaison;
    private JPanel placeholder2;
    private JPanel DetailsMaisons;
    private JLabel lblNewLabel_9;
    private JList list_1;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_10;
    private JPanel pMaisonName;
    private JPanel pMaisonEmail;
    private JPanel pMaisonAdress;
    private JPanel pMaisonTel;
    private JPanel pMaisonSiren;
    private JLabel lblNewLabel_11;
    private JLabel lMaisonMail;
    private JLabel lMaisonAdress;
    private JLabel lMaisonTel;
    private JLabel lNumSiren;
    private JTextField tMaisonSiren;
    private JTextField textField_7;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField tMaisonTel;
    private JButton bMaisonsSave;
    private JPanel pMaisonFristName;
    private JLabel lMaisonFirstName;
    private JTextField textField_12;
    private JPanel panel;
    private JPanel pMaisonDateDispo;
    private JPanel pMaisonDateVente;
    private JPanel pMaisonOrientation;
    private JPanel pMaisonPrix;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
	
	public HMBiensMaison() {	
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
        	loadMaisons();
        }
        catch (Exception e) {
        	 final JFrame parent = new JFrame();
        	 JOptionPane.showMessageDialog(parent, "Pas possible d ouvrir le fichier "+e.getMessage());
        	 //System.exit(1);
        }
		refreshMaisonsList();
		
	}
	private void actionHide() {
		//enregistrer etat
		try {
			saveMaisons();
		} catch (Exception e){
			final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "Pas possible de modifier le fichier "+e.getMessage());
		}
		
	}
	private  void actionAjouter(ActionEvent arg0) {
		modMaisons.addElement("<<Nouveau>>");
		clearMaisonsDetails();
		list_1.setSelectedIndex(list_1.getLastVisibleIndex()+1);
	}
	private void actionSupprimer(ActionEvent arg0) {
		if(list_1.getSelectedIndex()!=-1) {
			//remove from employees list
			listMaisons.remove(list_1.getSelectedIndex());
			//remove from swing element
			modMaisons.removeElementAt(list_1.getSelectedIndex());
		}
	}
	private void actionChoisirAutre(ListSelectionEvent e) {
		try {
			Maison c = listMaisons.get(list_1.getSelectedIndex());
			//set all fields with data from c
		} catch (IndexOutOfBoundsException ex){
			System.out.println("new entry");
		}		
	}
	private void actionEnregistrer(ActionEvent arg0) throws Exception{
		//enregistre une nouvelle maison  ou la modifie
		if(list_1.getSelectedIndex()!=-1) {
			Adresse a = null;
			try {
				a = new Adresse(textField_10.getText().split("\\|"));
			} catch (Exception e) {
				throw new Exception("Adresse doit etre du format Numero|Rue|CodePostale|Pays");
			}
			int mat = getNewID();	
			String orientation = textField_2.getText();
			String chauffage = textField_12.getText();
			String titre = textField_7.getText();
			float price = 0.0f;
			try {
				price = Float.parseFloat(textField_1.getText());
			} catch (Exception e) {
				throw new Exception("Prix doit etre du format EE.CC");
			}
			float surface = 0.0f;
			try {
				surface = Float.parseFloat(tMaisonSiren.getText());
			} catch (Exception e) {
				throw new Exception("Surface doit etre du format m.cm");
			}
			int nP = 0;
			try {
				nP = Integer.parseInt(tMaisonTel.getText());
			} catch (Exception e) {
				throw new Exception("Le nombre des pieces doit etre un entier.");
			}	
			int nE = 0;
			try {
				nE = Integer.parseInt(textField_9.getText());
			} catch (Exception e) {
				throw new Exception("Le nombre des étages doit etre un entier.");
			}	
			GregorianCalendar dateDispo = Date.StringToCalendar(textField_3.getText());
			GregorianCalendar dateVente = Date.StringToCalendar(textField.getText());
			Maison m = new Maison(getNewID(), price,a,orientation,dateDispo, dateVente, surface,nE, nP, chauffage, titre);

			if(modMaisons.getElementAt(list_1.getSelectedIndex()).equals("<<Nouveau>>")) {
				listMaisons.add(m);
				refreshMaisonsList();
			} else {
				listMaisons.set(list_1.getSelectedIndex(), m);
			}
			refreshMaisonsList();
		} else {
			final JFrame parent = new JFrame();
       	 	JOptionPane.showMessageDialog(parent, "D'abord ajouter tu dois. Ou de nouveau creer avec la force donnée");
		}
	}	
	
	private void loadMaisons() throws Exception{
	    try ( ObjectInputStream is = new ObjectInputStream(new FileInputStream("Maisons.dat")) ) {
	    		listMaisons = (ArrayList<Maison>)is.readObject();
	    } catch (IOException e) {
	    		listMaisons = new ArrayList<Maison>();
	    		System.out.println("capute");
	    		throw new Exception("Maisons.dat");
	    		
	    }
	}
    private void saveMaisons() throws Exception{
    	try ( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Maisons.dat")) ) {
    		os.writeObject(listMaisons);
    		} catch (IOException e) {
    			throw new Exception(e.getCause());
    		}	
    }
    private void clearMaisonsDetails() {
    	textField_7.setText("");
    	textField_12.setText("");
    	textField_9.setText("");
    	textField_10.setText("");
    	tMaisonTel.setText("");
    	tMaisonSiren.setText("");
    }
    private void refreshMaisonsList() {
    	modMaisons.removeAllElements();
    	for (Maison e: listMaisons)
    		modMaisons.addElement(e.getTitre());
    }
    private int getNewID() {
    	int maxID = -1;
		for (Maison c: listMaisons) {
			if(maxID<c.getId())
				maxID=c.getId();
		}
		return maxID+1;
	}
    
	private void initComponents() {
		ListMaison = new JPanel();
        this.setRowHeaderView(ListMaison);
        ListMaison.setLayout(new BoxLayout(ListMaison, BoxLayout.Y_AXIS));
        
        lblNewLabel_9 = new JLabel("Maisons");
        lblNewLabel_9.setAlignmentX(0.5f);
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ListMaison.add(lblNewLabel_9);
        

    	modMaisons= new DefaultListModel();
        list_1 = new JList(modMaisons);
    	list_1.addListSelectionListener(new ListSelectionListener() {
    		public void valueChanged(ListSelectionEvent e) {
    			actionChoisirAutre(e);
    		}
    	});
        ListMaison.add(list_1);     
        btnNewButton = new JButton("Ajouter");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		actionAjouter(arg0);
        	}
        });
        btnNewButton.setAlignmentX(0.5f);
        ListMaison.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Supprimer");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		actionSupprimer(e);
        	}
        });
        btnNewButton_1.setAlignmentX(0.5f);
        ListMaison.add(btnNewButton_1);
        
        placeholder2 = new JPanel();
        this.setColumnHeaderView(placeholder2);
        
        DetailsMaisons = new JPanel();
        this.setViewportView(DetailsMaisons);
        DetailsMaisons.setLayout(new BoxLayout(DetailsMaisons, BoxLayout.Y_AXIS));
        
        lblNewLabel_10 = new JLabel("Details");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_10.setAlignmentX(0.5f);
        DetailsMaisons.add(lblNewLabel_10);
        
        pMaisonName = new JPanel();
        DetailsMaisons.add(pMaisonName);
        GridBagLayout gbl_pMaisonName = new GridBagLayout();
        gbl_pMaisonName.columnWidths = new int[] {150, 450};
        gbl_pMaisonName.rowHeights = new int[] {22};
        gbl_pMaisonName.columnWeights = new double[]{0.0, 0.0};
        gbl_pMaisonName.rowWeights = new double[]{0.0};
        pMaisonName.setLayout(gbl_pMaisonName);
        
        lblNewLabel_11 = new JLabel("Titre");
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        gbc_lblNewLabel_11.weightx = 1.0;
        gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_11.gridx = 0;
        gbc_lblNewLabel_11.gridy = 0;
        pMaisonName.add(lblNewLabel_11, gbc_lblNewLabel_11);
        
        textField_7 = new JTextField();
        GridBagConstraints gbc_textField_7 = new GridBagConstraints();
        gbc_textField_7.weightx = 1.0;
        gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_7.gridx = 1;
        gbc_textField_7.gridy = 0;
        pMaisonName.add(textField_7, gbc_textField_7);
        textField_7.setColumns(10);
        
        pMaisonFristName = new JPanel();
        DetailsMaisons.add(pMaisonFristName);
        GridBagLayout gbl_pMaisonFristName = new GridBagLayout();
        gbl_pMaisonFristName.columnWidths = new int[] {150, 450};
        gbl_pMaisonFristName.rowHeights = new int[] {22};
        gbl_pMaisonFristName.columnWeights = new double[]{0.0, 0.0};
        gbl_pMaisonFristName.rowWeights = new double[]{0.0};
        pMaisonFristName.setLayout(gbl_pMaisonFristName);
        
        lMaisonFirstName = new JLabel("moyenChauffage");
        GridBagConstraints gbc_lMaisonFirstName = new GridBagConstraints();
        gbc_lMaisonFirstName.weightx = 1.0;
        gbc_lMaisonFirstName.anchor = GridBagConstraints.WEST;
        gbc_lMaisonFirstName.insets = new Insets(0, 0, 0, 5);
        gbc_lMaisonFirstName.gridx = 0;
        gbc_lMaisonFirstName.gridy = 0;
        pMaisonFristName.add(lMaisonFirstName, gbc_lMaisonFirstName);
        
        textField_12 = new JTextField();
        GridBagConstraints gbc_textField_12 = new GridBagConstraints();
        gbc_textField_12.weightx = 1.0;
        gbc_textField_12.fill = GridBagConstraints.BOTH;
        gbc_textField_12.gridx = 1;
        gbc_textField_12.gridy = 0;
        pMaisonFristName.add(textField_12, gbc_textField_12);
        textField_12.setColumns(10);
        
        pMaisonEmail = new JPanel();
        DetailsMaisons.add(pMaisonEmail);
        GridBagLayout gbl_pMaisonEmail = new GridBagLayout();
        gbl_pMaisonEmail.columnWidths = new int[] {150, 450};
        gbl_pMaisonEmail.rowHeights = new int[] {22};
        gbl_pMaisonEmail.columnWeights = new double[]{0.0, 0.0};
        gbl_pMaisonEmail.rowWeights = new double[]{0.0};
        pMaisonEmail.setLayout(gbl_pMaisonEmail);
        
        lMaisonMail = new JLabel("nombre d'\u00E9tages");
        GridBagConstraints gbc_lMaisonMail = new GridBagConstraints();
        gbc_lMaisonMail.weightx = 1.0;
        gbc_lMaisonMail.anchor = GridBagConstraints.WEST;
        gbc_lMaisonMail.insets = new Insets(0, 0, 0, 5);
        gbc_lMaisonMail.gridx = 0;
        gbc_lMaisonMail.gridy = 0;
        pMaisonEmail.add(lMaisonMail, gbc_lMaisonMail);
        
        textField_9 = new JTextField();
        GridBagConstraints gbc_textField_9 = new GridBagConstraints();
        gbc_textField_9.weightx = 1.0;
        gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_9.anchor = GridBagConstraints.WEST;
        gbc_textField_9.gridx = 1;
        gbc_textField_9.gridy = 0;
        pMaisonEmail.add(textField_9, gbc_textField_9);
        textField_9.setColumns(10);
        
        pMaisonAdress = new JPanel();
        DetailsMaisons.add(pMaisonAdress);
        GridBagLayout gbl_pMaisonAdress = new GridBagLayout();
        gbl_pMaisonAdress.columnWidths = new int[] {150, 450};
        gbl_pMaisonAdress.rowHeights = new int[]{22, 0};
        gbl_pMaisonAdress.columnWeights = new double[]{0.0, 0.0};
        gbl_pMaisonAdress.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pMaisonAdress.setLayout(gbl_pMaisonAdress);
        
        lMaisonAdress = new JLabel("Adresse");
        GridBagConstraints gbc_lMaisonAdress = new GridBagConstraints();
        gbc_lMaisonAdress.weightx = 1.0;
        gbc_lMaisonAdress.anchor = GridBagConstraints.WEST;
        gbc_lMaisonAdress.insets = new Insets(0, 0, 0, 5);
        gbc_lMaisonAdress.gridx = 0;
        gbc_lMaisonAdress.gridy = 0;
        pMaisonAdress.add(lMaisonAdress, gbc_lMaisonAdress);
        
        textField_10 = new JTextField();
        GridBagConstraints gbc_textField_10 = new GridBagConstraints();
        gbc_textField_10.weightx = 1.0;
        gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_10.anchor = GridBagConstraints.WEST;
        gbc_textField_10.gridx = 1;
        gbc_textField_10.gridy = 0;
        pMaisonAdress.add(textField_10, gbc_textField_10);
        textField_10.setColumns(10);
        
        pMaisonTel = new JPanel();
        DetailsMaisons.add(pMaisonTel);
        GridBagLayout gbl_pMaisonTel = new GridBagLayout();
        gbl_pMaisonTel.columnWidths = new int[] {150, 450};
        gbl_pMaisonTel.rowHeights = new int[]{22, 0};
        gbl_pMaisonTel.columnWeights = new double[]{0.0, 0.0};
        gbl_pMaisonTel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pMaisonTel.setLayout(gbl_pMaisonTel);
        
        lMaisonTel = new JLabel("nombre de pi\u00E8ces");
        GridBagConstraints gbc_lMaisonTel = new GridBagConstraints();
        gbc_lMaisonTel.weightx = 1.0;
        gbc_lMaisonTel.anchor = GridBagConstraints.NORTHWEST;
        gbc_lMaisonTel.insets = new Insets(0, 0, 0, 5);
        gbc_lMaisonTel.gridx = 0;
        gbc_lMaisonTel.gridy = 0;
        pMaisonTel.add(lMaisonTel, gbc_lMaisonTel);
        
        tMaisonTel = new JTextField();
        GridBagConstraints gbc_tMaisonTel = new GridBagConstraints();
        gbc_tMaisonTel.weightx = 1.0;
        gbc_tMaisonTel.fill = GridBagConstraints.HORIZONTAL;
        gbc_tMaisonTel.anchor = GridBagConstraints.WEST;
        gbc_tMaisonTel.gridx = 1;
        gbc_tMaisonTel.gridy = 0;
        pMaisonTel.add(tMaisonTel, gbc_tMaisonTel);
        tMaisonTel.setColumns(10);
        
        pMaisonSiren = new JPanel();
        DetailsMaisons.add(pMaisonSiren);
        GridBagLayout gbl_pMaisonSiren = new GridBagLayout();
        gbl_pMaisonSiren.columnWidths = new int[] {150, 450};
        gbl_pMaisonSiren.rowHeights = new int[]{22, 0};
        gbl_pMaisonSiren.columnWeights = new double[]{0.0, 0.0};
        gbl_pMaisonSiren.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pMaisonSiren.setLayout(gbl_pMaisonSiren);
        
        lNumSiren = new JLabel("surface habitable");
        GridBagConstraints gbc_lNumSiren = new GridBagConstraints();
        gbc_lNumSiren.weightx = 1.0;
        gbc_lNumSiren.fill = GridBagConstraints.HORIZONTAL;
        gbc_lNumSiren.anchor = GridBagConstraints.WEST;
        gbc_lNumSiren.insets = new Insets(0, 0, 0, 5);
        gbc_lNumSiren.gridx = 0;
        gbc_lNumSiren.gridy = 0;
        pMaisonSiren.add(lNumSiren, gbc_lNumSiren);
        
        tMaisonSiren = new JTextField();
        GridBagConstraints gbc_tMaisonSiren = new GridBagConstraints();
        gbc_tMaisonSiren.weightx = 1.0;
        gbc_tMaisonSiren.fill = GridBagConstraints.HORIZONTAL;
        gbc_tMaisonSiren.anchor = GridBagConstraints.WEST;
        gbc_tMaisonSiren.gridx = 1;
        gbc_tMaisonSiren.gridy = 0;
        pMaisonSiren.add(tMaisonSiren, gbc_tMaisonSiren);
        tMaisonSiren.setColumns(10);
        
        bMaisonsSave = new JButton("Enregistrer");
        bMaisonsSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			actionEnregistrer(e);
        		} catch (Exception s) {
        			final JFrame parent = new JFrame();
               	 	JOptionPane.showMessageDialog(parent, s.getMessage());
        		}
        	}
        });
        
        pMaisonDateDispo = new JPanel();
        DetailsMaisons.add(pMaisonDateDispo);
        GridBagLayout gbl_pMaisonDateDispo = new GridBagLayout();
        gbl_pMaisonDateDispo.columnWidths = new int[] {150, 450};
        gbl_pMaisonDateDispo.rowHeights = new int[] {22};
        gbl_pMaisonDateDispo.columnWeights = new double[]{1.0, 0.0};
        gbl_pMaisonDateDispo.rowWeights = new double[]{0.0};
        pMaisonDateDispo.setLayout(gbl_pMaisonDateDispo);
        
        lblNewLabel = new JLabel("Date de disponibilit\u00E9");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.weightx = 1.0;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        pMaisonDateDispo.add(lblNewLabel, gbc_lblNewLabel);
        
        textField_3 = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.weightx = 1.0;
        gbc_textField_3.anchor = GridBagConstraints.WEST;
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 1;
        gbc_textField_3.gridy = 0;
        pMaisonDateDispo.add(textField_3, gbc_textField_3);
        textField_3.setColumns(10);
        
        pMaisonDateVente = new JPanel();
        DetailsMaisons.add(pMaisonDateVente);
        GridBagLayout gbl_pMaisonDateVente = new GridBagLayout();
        gbl_pMaisonDateVente.columnWidths = new int[] {150, 450};
        gbl_pMaisonDateVente.rowHeights = new int[] {22};
        gbl_pMaisonDateVente.columnWeights = new double[]{1.0, 0.0};
        gbl_pMaisonDateVente.rowWeights = new double[]{0.0};
        pMaisonDateVente.setLayout(gbl_pMaisonDateVente);
        
        lblNewLabel_1 = new JLabel("Date de Vente");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 0;
        pMaisonDateVente.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.weightx = 1.0;
        gbc_textField.anchor = GridBagConstraints.WEST;
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        pMaisonDateVente.add(textField, gbc_textField);
        textField.setColumns(10);
        
        pMaisonOrientation = new JPanel();
        DetailsMaisons.add(pMaisonOrientation);
        GridBagLayout gbl_pMaisonOrientation = new GridBagLayout();
        gbl_pMaisonOrientation.columnWidths = new int[] {150, 450};
        gbl_pMaisonOrientation.rowHeights = new int[] {22};
        gbl_pMaisonOrientation.columnWeights = new double[]{1.0, 0.0};
        gbl_pMaisonOrientation.rowWeights = new double[]{0.0};
        pMaisonOrientation.setLayout(gbl_pMaisonOrientation);
        
        lblNewLabel_2 = new JLabel("Orientation");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.weightx = 1.0;
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 0;
        pMaisonOrientation.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.weightx = 1.0;
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 0;
        pMaisonOrientation.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
        
        pMaisonPrix = new JPanel();
        DetailsMaisons.add(pMaisonPrix);
        GridBagLayout gbl_pMaisonPrix = new GridBagLayout();
        gbl_pMaisonPrix.columnWidths = new int[] {150, 450};
        gbl_pMaisonPrix.rowHeights = new int[] {22};
        gbl_pMaisonPrix.columnWeights = new double[]{1.0, 0.0};
        gbl_pMaisonPrix.rowWeights = new double[]{0.0};
        pMaisonPrix.setLayout(gbl_pMaisonPrix);
        
        lblNewLabel_3 = new JLabel("Prix de la maison");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_3.weightx = 1.0;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 0;
        pMaisonPrix.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.anchor = GridBagConstraints.WEST;
        gbc_textField_1.weightx = 1.0;
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 0;
        pMaisonPrix.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        bMaisonsSave.setAlignmentX(0.5f);
        DetailsMaisons.add(bMaisonsSave);
        
        panel = new JPanel();
        DetailsMaisons.add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] {100, 500};
        gbl_panel.rowHeights = new int[] {402, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0};
        gbl_panel.rowWeights = new double[]{0.0, 1.0};
        panel.setLayout(gbl_panel);
		
	}
}