# gestImmo
GestImmo is a scolary project in L3 MIASHS / Information
by Gemmnius and Simon The Sorcerer.

# expliquer comment produire le logiciel (éventuellement à partir d’Eclipse)
1. clone the repository from within Eclipse (https://github.com/collab-uniba/socialcde4eclipse/wiki/How-to-import-a-GitHub-project-into-Eclipse)
2. change into "Java" mode
4. if you can't compile from source, you may need to add a Run Configuration (even though we shipped it within the repository)
5. (add a Java Application Run Configurations and use the main method in InterfaceHM.GestImmoGui.java

# expliquer comment lancer votre logiciel comme un utilisateur lambda
1. Start your computer
2. Move your mouse cursor to the fancy icon your pCA* says is called "Explorer"
3. Click it.
4. Be amazed of the wonders modern computers are capable of
5. Let your pcA take control and tell him/her you want to execute a jar Java Application from Github
6. Enjoy the expression in his/her face when (s)he's trying to grasp that you know what Github is
7. Tell him/her to download GestImmo.jar (and the .dat stuff for sample functionality) that can be found inside GestionImmobilier.
8. Listen to how you shouldn't download these kind of files to your computer from a source you don't know.
9. Tell him/her you know the guy and you'll make sure the person won't mess with you
10. Let your pCA click on the downloaded file.
11. Let our amazing implementation of the least pedagogical project ever blow your mind.

*personal Computer Assistant. Person that helps perfect noobs using electric equipment.


## Nomenclature Variables Interface Swing
- Label: 	l+Nom, Ex: lMandatSigne
- Button:	b+Nom, Ex: bSaveMandat
- Panel:	p+Nom
- Checkbox: chk+Nom
- Combobox: c+Nom
- List:		li+Nom
...

## Serialization and Deserialization
- List of Employees
- List of Clients
- List of RDV
- List of Publicites
- List of TraceDeVente
- List of PromesseVente

Every item has its own file(path)

### Order of Deserialization:
1 List of Employees
2 List of Clients (no need for biens because they are stored in Clients (no Bien without its Client)
4 List of Mandats (they have a reference to the Bien that must be loaded previously
5 List of RDV (needs references of biens and Clients)
6 List of Pubs (needs references of biens)
