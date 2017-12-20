package InterfaceHM;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GestionAgence.RendezVous;
import GestionPersonne.EmployeeAgence;
import Outils.Adresse;

public class HMPersonnesEmployees extends javax.swing.JScrollPane{
	
	private ArrayList<EmployeeAgence> listEmployees;
    private DefaultListModel<String> modEmployees;   
	
    private JScrollPane scrollPane_2;
    private JPanel ListEmployee;
    private JLabel lEmployees;
    private JList liEmployee;
    private JButton Del;
    private JButton CreateEmployee;
    private JTable calendar;
    private JList listMeetings;	
    private JTextField textField;
    private JTextField textField_1;
    private HMPersonnesEmployees panelEmployees;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JPanel placeholder;
    private JPanel DetailsCleints;

    private JLabel lblNewLabel_1;
    private JPanel FirstName;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JPanel Email;
    private JLabel lblNewLabel_4;
    private JPanel Adress;
    private JLabel lblNewLabel_5;
    private JPanel Tel;
    private JLabel lblNewLabel_6;
    private JPanel Matricule;
    private JLabel lblNewLabel_7;

    private JPanel Calendar;
    private JLabel lblNewLabel_8;
    private JScrollPane scrollPane_6;
    
	public HMPersonnesEmployees() {
			try {
	        	loadEmployees();
	        }
	        catch (Exception e) {
	        	 final JFrame parent = new JFrame();
	        	 JOptionPane.showMessageDialog(parent, "Pas possible d ouvrir le fichier "+e.getMessage());
	        	 //System.exit(1);
	        }
	         
	        placeholder = new JPanel();
	        this.setColumnHeaderView(placeholder);
	        
	        DetailsCleints = new JPanel();
	        this.setViewportView(DetailsCleints);
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
		
		 	ListEmployee = new JPanel();
	        this.setRowHeaderView(ListEmployee);
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
}
