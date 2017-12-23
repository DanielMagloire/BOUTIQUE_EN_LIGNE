package dan.med.eboutique.metier;

import java.util.List;

import dan.med.eboutique.entities.Categorie;
import dan.med.eboutique.entities.Client;
import dan.med.eboutique.entities.Commande;
import dan.med.eboutique.entities.Panier;
import dan.med.eboutique.entities.Produit;

public interface InternauteMetier {

	public List<Categorie> listCategories(); //Un internaute peut consulter la liste des cat�gories
	public Categorie getCategorie(Long idCat); //Un internaute peut consulter une cat�gorie
	public List<Produit> listproduits();  //Un internaute peut consulter la liste des produits
	public List<Produit> produitsParMotCle(String mc); //Un internaute peut consulter la liste des produits par mot cle (mc)
	public List<Produit> produitsParCategorie(Long idCat); //Un internaute peut consulter la liste des produits par categorie
	public List<Produit> produitsSelectionnes();  //Un internaute peut consulter la liste des produits selectionn�s
	public Produit getProduit(Long idP); //Un internaute peut consulter un produit
	public Commande enregistrerCommande(Panier p,Client c);  //Peut enregistrer une commande
}