package InterfaceHM;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HMAgenceMandats extends javax.swing.JScrollPane {
	
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
        pListMandats = new JPanel();
        this.setRowHeaderView(pListMandats);
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
	}
}
