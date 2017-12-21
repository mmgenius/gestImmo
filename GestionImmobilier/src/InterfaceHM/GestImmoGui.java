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
    /**
     * Creates new form GestImmoGui
     */
    public GestImmoGui() {
    	setResizable(false);
    	setTitle("Marvelous Immo Gestion");
        initComponents();
    }
    
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       
        desktopPane = new javax.swing.JDesktopPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        desktopPane.setLayout(new BoxLayout(desktopPane, BoxLayout.Y_AXIS));        
        
        //Agence       
        panelAgence = new HMAgence();
        jTabbedPane2.addTab("Agence", panelAgence);
       
        //Biens
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabbedPane2.addTab("Biens", jScrollPane2);
        
        //Ventes
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabbedPane2.addTab("Ventes", jScrollPane4); 

        //Personnes
        panelPersonnes = new HMPersonnes();
		jTabbedPane2.addTab("Personnes", panelPersonnes);
		desktopPane.add(jTabbedPane2);
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
            }
        });
    }
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JScrollPane panelAgence;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane panelPersonnes;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;

 
}
