# gestImmo
GestImmo is a scolary project in L3 MIASHS / Information
de Gemmnius and Simon The Sorcerer.

## Repartition du travail
- Packages GestionAgence and GestionPersonne: Simon the Sorcerer
- Packages GestionPersonne and GestionBien: Gemnius

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
